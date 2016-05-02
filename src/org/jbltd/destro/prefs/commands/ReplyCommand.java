package org.jbltd.destro.prefs.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jbltd.destro.prefs.Main;
import org.jbltd.destro.prefs.util.PreferenceManager;

public class ReplyCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

	if (!(sender instanceof Player))
	    return true;

	Player player = (Player) sender;

	if (cmd.getName().equalsIgnoreCase("reply")) {

	    if (Main._lastMessage.isEmpty()) {
		System.out.println("True");
	    }

	    if (!Main._lastMessage.containsKey(player.getUniqueId())) {
		player.sendMessage(ChatColor.RED+"You have not messaged someone recently.");
		return true;
	    }

	    if (args.length < 1) {

		player.sendMessage(ChatColor.RED+"You must provide a message.");
		return true;

	    }

	    Player target = Bukkit.getPlayer(Main._lastMessage.get(player.getUniqueId()));

	    if (!target.isOnline()) {
		player.sendMessage(ChatColor.RED+target.getName() + " is no longer online.");
	    }

	    if(PreferenceManager.getPlayerPrefs(target).getMessagePreference() == false)
	    {
		player.sendMessage(ChatColor.RED+"That player has private messaging disabled.");
		return true;
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < args.length; i++) {
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
