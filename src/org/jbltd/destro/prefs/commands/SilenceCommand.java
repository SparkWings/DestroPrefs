package org.jbltd.destro.prefs.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jbltd.destro.prefs.listeners.ChatListener;

public class SilenceCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

	if (cmd.getName().equalsIgnoreCase("silence")) {

	    if (!(sender instanceof Player))
		return true;

	    Player player = (Player) sender;

	    if (!player.hasPermission("prefs.silencecommand"))
	    {
		player.sendMessage(ChatColor.RED+"You don't have permission to do this.");
		return true;
	    }

	    if (ChatListener.isSilenced) {
		ChatListener.isSilenced = false;
		Bukkit.broadcastMessage(ChatColor.GREEN+""+ChatColor.BOLD+"CHAT HAS BEEN UNSILENCED");
		return false;
	    } else {
		ChatListener.isSilenced = true;
		Bukkit.broadcastMessage(ChatColor.RED+""+ChatColor.BOLD+"CHAT HAS BEEN SILENCED");
		return false;
	    }

	}

	return false;
    }

}
