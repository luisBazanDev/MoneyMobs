package pe.bazan.luis.plugins.moneymobs;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import pe.bazan.luis.plugins.moneymobs.commands.BaseCommand;
import pe.bazan.luis.plugins.moneymobs.utils.MsgFormat;

public final class MoneyMobs extends JavaPlugin {
  private Economy econ;
  private MobsManager mobsManager;
  private static MoneyMobs instance;

  @Override
  public void onEnable() {
    // Plugin startup logic
    getLogger().info("Enabling plugin...");
    saveDefaultConfig();
    this.mobsManager = new MobsManager(this);
    new MobKilledByPlayer(this);
    if (!setupEconomy()) {
      getLogger().info(MsgFormat.error("You don't have a economy provider, please install a economy plugin and retry :)"));
      getServer().getPluginManager().disablePlugin(this);
      return;
    }
    loadCommand();
    getLogger().info("Plugin Enabled");
    instance = this;
  }

  @Override
  public void onDisable() {
    getLogger().info(MsgFormat.error("Plugin disabled."));
  }

  private void loadCommand() {
    getCommand("moneymobs").setExecutor(new BaseCommand());
  }

  private boolean setupEconomy() {
    if (getServer().getPluginManager().getPlugin("Vault") == null) {
      return false;
    }
    RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
    if (rsp == null) {
      getLogger().info("Don't have a economy provider");
      return false;
    }
    econ = rsp.getProvider();
    return econ != null;
  }

  public MobsManager getMobsManager() {
    return mobsManager;
  }

  public Economy getEcon() {
    return econ;
  }

  public static MoneyMobs getInstance() {
    return instance;
  }
}
