package pe.bazan.luis.plugins.moneymobs.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.ChatColor;

public class MsgFormat {
    public static String format(String txt) {
        return ChatColor.translateAlternateColorCodes('&', txt);
    }

    public static String error(String txt) {
        return Component.text(txt).color(TextColor.color(0xFF0000)).content();
    }
}
