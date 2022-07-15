package pe.bazan.luis.plugins.moneymobs;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.text.DecimalFormat;

public class MobKilledByPlayer implements Listener {
  private MobsManager mobsManager;
  private MoneyMobs plugin;
  private DecimalFormat decimalFormat;

  public MobKilledByPlayer(MoneyMobs plugin) {
    this.plugin = plugin;
    this.decimalFormat = new DecimalFormat(plugin.getConfig().getString("format"));
    this.mobsManager = plugin.getMobsManager();
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

  @EventHandler
  public void onPlayerKillMob(EntityDeathEvent e) {
    if(!(e.getEntity().getKiller() instanceof Player)) return;
    MobsManager.Dropper drop = MobsManager.getMobDrop(e.getEntityType());
    if(drop == null) return;
    LivingEntity entity = e.getEntity();
    final Player player = entity.getKiller();
    if(!player.hasPermission("moneymobs.drops")) return;
    final double amount = drop.randomizerDouble();
    plugin.getEcon().depositPlayer(player, amount);
    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
            plugin.getConfig().getString("prefix") +
                    plugin.getConfig().getString("msg")
                            .replace("%money%", decimalFormat.format(amount))
            ));
    if(plugin.getConfig().getBoolean("sound.enable")) {
      player.playSound(
              player.getLocation(),
              Sound.valueOf(plugin.getConfig().getString("sound.sound")),
              (float) plugin.getConfig().getDouble("sound.volume"),
              (float) plugin.getConfig().getDouble("sound.pitch")
      );
    }
  }
}
