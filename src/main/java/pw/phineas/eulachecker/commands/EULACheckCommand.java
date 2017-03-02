package pw.phineas.eulachecker.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pw.phineas.eulachecker.utils.BlocklistChecker;
import pw.phineas.eulachecker.utils.HashConverter;

/**
 * Created by Phineas (phineas.pw) on 04/05/2016.
 */
public class EULACheckCommand implements CommandExecutor {

    String prefix = ChatColor.RED + "Blocklist Check> ";

    public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String args[]) {
        if(sender.hasPermission("eulachecker.check")) {
            if(args.length == 0) {
                sender.sendMessage(prefix + ChatColor.GRAY + "Please specify a server to check! Example: /eulacheck <serverip>");
            } else {
                String blockList = null;

                String serverToCheck = args[0];
                String hashedIP = HashConverter.convertToSHA(serverToCheck);
                sender.sendMessage(prefix + ChatColor.GRAY + "Checking server " + ChatColor.YELLOW + serverToCheck + ChatColor.GRAY + " (with hash " + ChatColor.DARK_RED + hashedIP + ChatColor.GRAY + ") against EULA blacklist...");

                try {
                    blockList = BlocklistChecker.getBlockList("https://sessionserver.mojang.com/blockedservers");
                } catch (Exception e) {
                    sender.sendMessage(prefix + ChatColor.GRAY + "The Mojang session servers are currently down so we can't get the block list!");
                    e.printStackTrace();
                    return false;
                }

                if(blockList.contains(hashedIP)) {
                    sender.sendMessage(prefix + ChatColor.GRAY + "Server " + ChatColor.YELLOW + serverToCheck + ChatColor.GRAY + " is in the Mojang EULA blacklist!");
                } else {
                    sender.sendMessage(prefix + ChatColor.GRAY + "Server " + ChatColor.YELLOW + serverToCheck + ChatColor.GRAY + " is not in the Mojang EULA blacklist!");
                }
            }
        } else {
            sender.sendMessage(prefix + ChatColor.GRAY + "You do not have permission to execute this command!");
        }
        return false;
    }
}
