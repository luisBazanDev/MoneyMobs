package pe.bazan.luis.plugins.moneymobs;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class MobKilledByPlayer implements Listener {
  private MobsManager mobsManager;
  private MoneyMobs plugin;

  public MobKilledByPlayer(MoneyMobs plugin) {
    this.plugin = plugin;
    this.mobsManager = plugin.getMobsManager();
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

  @EventHandler
  public void onPlayerKillMob(EntityDeathEvent e) {
    if(!(e.getEntity().getKiller() instanceof Player))return;
    MobsManager.Dropper drop = MobsManager.getMobDrop(e.getEntityType());
    if(drop == null) return;
    LivingEntity entity = e.getEntity();
    final Player player = entity.getKiller();
    final double amount = drop.randomizerDouble();
    plugin.getEcon().withdrawPlayer(player, amount);
    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
            plugin.getConfig().getString("prefix") +
                    plugin.getConfig().getString("msg").replace("%money%", String.valueOf(amount))
            ));
  }
}
