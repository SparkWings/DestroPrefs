package org.jbltd.destro.prefs.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jbltd.destro.prefs.gui.PrefsGUI;

public class PrefsCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

	if (cmd.getName().equalsIgnoreCase("preferences")) {
	    if (!(sender instanceof Player))
		return true;

	    Player player = (Player) sender;

	    PrefsGUI.open(player);
	    return false;

	}

	return false;

    }

}
