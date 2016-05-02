package org.jbltd.destro.prefs.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jbltd.destro.prefs.Main;
import org.jbltd.destro.prefs.util.PreferenceManager;

public class MessageCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

	if (!(sender instanceof Player))
	    return true;

	Player player = (Player) sender;

	if (cmd.getName().equalsIgnoreCase("message")) {

	    if (args.length < 2) {
		player.sendMessage(ChatColor.RED+"Not enough arguments!");
		return true;
	    }

	    Player target = Bukkit.getPlayer(args[0]);

	    if (target == null) {
		return true;
	    }

	    if (!target.isOnline()) {
		player.sendMessage(ChatColor.RED+"That player is not online.");
		return true;
	    }

	    if (!target.hasPlayedBefore()) {
		player.sendMessage(ChatColor.RED+"That player has never played before!");
		return true;
	    }

	    if(PreferenceManager.getPlayerPrefs(target).getMessagePreference() == false)
	    {
		player.sendMessage(ChatColor.RED+"That player has private messaging disabled.");
		return true;
	    }
	    
	    Main._lastMessage.put(player.getUniqueId(), target.getUniqueId());

	    StringBuilder sb = new StringBuilder();
	    for (int i = 1; i < args.length; i++) {
		sb.append(args[i] + " ");
	    }

	    String message = sb.toString().trim();

	    player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "YOU > " + target.getName().toUpperCase()
		    + ChatColor.WHITE + "" + ChatColor.BOLD + " " + message);
	    target.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + player.getName().toUpperCase() + " > ME"
		    + ChatColor.WHITE + "" + ChatColor.BOLD + " " + message);

	    return false;

	}
	return false;

    }

}
