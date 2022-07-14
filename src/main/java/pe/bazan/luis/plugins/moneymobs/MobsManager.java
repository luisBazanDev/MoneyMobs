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
  }

  public void registerMobs() {
    ConfigurationSection section = plugin.getConfig().getConfigurationSection("money-mobs");
    section.getKeys(false).forEach((mob) -> {
      mobs.put(EntityType.valueOf(mob), new Dropper(section.getInt(mob + ".min"), section.getInt(mob + ".max")));
    });
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
}
