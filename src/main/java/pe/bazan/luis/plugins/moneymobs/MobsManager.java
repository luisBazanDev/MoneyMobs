package pe.bazan.luis.plugins.moneymobs;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.EntityType;

import javax.security.auth.login.Configuration;
import java.awt.*;
import java.util.HashMap;

public class MobsManager {
  private static HashMap<EntityType, Dropper> mobs = new HashMap();
  private MoneyMobs plugin;

  public MobsManager(MoneyMobs moneyMobs) {
    this.plugin = moneyMobs;
    registerMobs();
  }

  public void registerMobs() {
    plugin.getLogger().info("Register mobs in the config...");
    ConfigurationSection section = plugin.getConfig().getConfigurationSection("money-mobs");
    section.getKeys(false).forEach((mob) -> {
      int min = section.getInt(mob + ".min");
      int max = section.getInt(mob + ".max");
      plugin.getLogger().info(String.format("+ Mob register: %s, min: %s$, max: %s$", mob, min, max));
      mobs.put(EntityType.valueOf(mob), new Dropper(min, max));
    });
    plugin.getLogger().info("Mobs registered!");
  }

  public static Dropper getMobDrop(EntityType type) {
    return mobs.get(type);
  }

  public class Dropper {
    int min = 0;
    int max = 0;

    public Dropper(int min, int max) {
      this.min = min;
      this.max = max;
    }

    public double randomizerDouble() {
      return Math.random() * (max - min) + min;
    }

    public int randomizerInt() {
      return (int) Math.floor(Math.random() * (max - min) + min);
    }

    public int getMin() {
      return min;
    }

    public int getMax() {
      return max;
    }
  }

  public static HashMap<EntityType, Dropper> getMobs() {
    return mobs;
  }
}
