package org.jbltd.destro.prefs.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatslowCommand implements CommandExecutor {

    public static boolean isSlow;

    public static int slowTime = 0;
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

	if (cmd.getName().equalsIgnoreCase("chatslow")) {

	    if (!(sender instanceof Player)) {
		return true;
	    }

	    Player player = (Player) sender;

	    if (args.length < 1) {
		player.sendMessage(ChatColor.RED + "You must specify an amount of time for the chatslow.");
		return true;
	    }

	    if (!player.hasPermission("prefs.chatslow")) {
		player.sendMessage(ChatColor.RED + "You don't have permission to do this.");
		return true;
	    }

	    isSlow = true;
	    slowTime = Integer.parseInt(args[0]);
	    
	    Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD
		    + "Chatslow has been enabled with a cooldown of " + args[0] + " seconds");
	    return false;
	}
	return false;

    }

}
