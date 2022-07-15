package pe.bazan.luis.plugins.moneymobs.commands;

import dev.jorel.commandapi.CommandAPICommand;
import org.bukkit.ChatColor;
import pe.bazan.luis.plugins.moneymobs.MobsManager;
import pe.bazan.luis.plugins.moneymobs.MoneyMobs;

import java.util.concurrent.atomic.AtomicReference;

public class MoneyMobsCmd {
  private MoneyMobs plugin;
  private  CommandAPICommand info = new CommandAPICommand("info")
          .executesPlayer((sender, args) -> {
            sender.sendMessage(format("&m====================&6&l Money Mobs &m===================="));
            MobsManager.getMobs().forEach((k, v) -> {
              sender.sendMessage(format(String.format(
                      "&e- %s: &cmin: %s$ &amax: %s$",
                      k,
                      v.getMin(),
                      v.getMax()
              )));
            });
            sender.sendMessage(format("&m===================================================="));
          });

  private  CommandAPICommand reload = new CommandAPICommand("info")
          .executesPlayer((sender, args) -> {
            sender.sendMessage(format("&aReloading..."));
            plugin.reloadConfig();
            plugin.getMobsManager().registerMobs();
            sender.sendMessage(format("&aReload successfully."));
          });

  private CommandAPICommand moneyMobs = new CommandAPICommand("moneymobs")
          .withAliases("moneym")
          .withPermission("moneymobs.command.moneymobs")
          .withSubcommand(info)
          .withSubcommand(reload)
          .executesPlayer((sender, args) -> {
            AtomicReference<String> loadedMobs = new AtomicReference<>("");
            MobsManager.getMobs().forEach((k, v) -> loadedMobs.set(loadedMobs.get() + k.toString() + ";"));
            sender.sendMessage(format("&m====================&6&l Money Mobs &m===================="));
            sender.sendMessage(format("&f&l&nLoaded mobs:"));
            sender.sendMessage(format(loadedMobs.get()));
            sender.sendMessage(format("&0&lGit&f&lHub&7: https://github.com/luisBazanDev/MoneyMobs"));
            sender.sendMessage(format("&m===================================================="));
          });

  public MoneyMobsCmd(MoneyMobs plugin) {
    this.plugin = plugin;
    this.moneyMobs.register();
  }

  private String format(String msg) {
    return ChatColor.translateAlternateColorCodes('&', msg);
  }
}