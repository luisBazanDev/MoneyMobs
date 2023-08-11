package pe.bazan.luis.plugins.moneymobs.commands;

import org.bukkit.command.CommandSender;
import pe.bazan.luis.plugins.moneymobs.MoneyMobs;
import pe.bazan.luis.plugins.moneymobs.utils.MsgFormat;

public class CreditsCommand {
    public static void run(CommandSender sender, String[] args) {
        sender.sendMessage(MsgFormat.format("&f&m=================&6&l Money Mobs &f&m================="));
        sender.sendMessage(MsgFormat.format(String.format("&f&lVersion: %s", MoneyMobs.getInstance().getDescription().getVersion())));
        sender.sendMessage(MsgFormat.format(String.format("&f&lAuthors: %s", MoneyMobs.getInstance().getDescription().getAuthors())));
        sender.sendMessage(MsgFormat.format("&0&lGit&f&lHub&7: https://github.com/luisBazanDev/MoneyMobs"));
        sender.sendMessage(MsgFormat.format("&f&m=============================================="));
    }
}
