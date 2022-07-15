package pe.bazan.luis.plugins.moneymobs;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class MoneyMobs extends JavaPlugin {
  private Economy econ = null;
  private MobsManager mobsManager;

  @Override
  public void onEnable() {
    // Plugin startup logic
    saveDefaultConfig();
    this.mobsManager = new MobsManager(this);
    new MobKilledByPlayer(this);
    setupEconomy();
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }

  private boolean setupEconomy() {
    if (getServer().getPluginManager().getPlugin("Vault") == null) {
      return false;
    }
    RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
    if (rsp == null) {
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
}
