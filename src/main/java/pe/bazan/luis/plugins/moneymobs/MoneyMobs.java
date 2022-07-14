package pe.bazan.luis.plugins.moneymobs;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class MoneyMobs extends JavaPlugin {
  private static Economy econ = null;

  @Override
  public void onEnable() {
    // Plugin startup logic
    saveDefaultConfig();
    if(!setupEconomy()) getServer().getPluginManager().disablePlugin(this);
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
}
