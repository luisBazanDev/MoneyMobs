package pe.bazan.luis.plugins.moneymobs.commands;

import org.bukkit.command.CommandSender;
import pe.bazan.luis.plugins.moneymobs.MoneyMobs;
import pe.bazan.luis.plugins.moneymobs.utils.MsgFormat;

public class ReloadCommand {
    public static void run(CommandSender sender, String[] args) {
        sender.sendMessage(MsgFormat.format("&aReloading..."));
        MoneyMobs.getInstance().reloadConfig();
        MoneyMobs.getInstance().getMobsManager().registerMobs();
        sender.sendMessage(MsgFormat.format("&aReload successfully."));
    }
}
