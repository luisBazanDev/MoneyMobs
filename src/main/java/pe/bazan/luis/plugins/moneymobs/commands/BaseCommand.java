package pe.bazan.luis.plugins.moneymobs.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pe.bazan.luis.plugins.moneymobs.MobsManager;
import pe.bazan.luis.plugins.moneymobs.utils.MsgFormat;

import java.util.ArrayList;
import java.util.List;

public class BaseCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) {
            baseCommand(sender, args);
            return false;
        }
        switch (args[0].toLowerCase()) {
            case "about":
                if (!sender.hasPermission("moneymobs.command.moneymobs.about"))
                    return noPermissions(sender);
                CreditsCommand.run(sender, args);
                break;
            case "reload":
                if (!sender.hasPermission("moneymobs.command.moneymobs.reload"))
                    return noPermissions(sender);
                ReloadCommand.run(sender, args);
                break;
            case "info":
                if (!sender.hasPermission("moneymobs.command.moneymobs.info"))
                    return noPermissions(sender);
                baseCommand(sender, args);
                break;
            default:
                baseCommand(sender, args);
                break;
        }
        return false;
    }

    private boolean noPermissions(CommandSender sender) {
        sender.sendMessage(MsgFormat.format("You don't have permissions."));
        return false;
    }

    private boolean baseCommand(CommandSender sender, String[] args) {
        sender.sendMessage(MsgFormat.format("&m=================&6&l Money Mobs &f&m================="));
        MobsManager.getMobs().forEach((k, v) -> {
            sender.sendMessage(MsgFormat.format(String.format(
                    "&e%s: &cmin: %s$ &amax: %s$",
                    k,
                    v.getMin(),
                    v.getMax()
            )));
        });
        sender.sendMessage(MsgFormat.format("&m=============================================="));
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> result = new ArrayList<>();
        if (args.length == 1) {
            String search = args[0];
            String[] commands = new String[]{"about", "reload", "info"};
            for (String cmd : commands) {
                if (cmd.startsWith(search)) {
                    result.add(cmd);
                }
            }
        }
        return result;
    }
}
