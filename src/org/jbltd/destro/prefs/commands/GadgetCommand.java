package org.jbltd.destro.prefs.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class GadgetCommand implements CommandExecutor, Listener {

    public boolean disabled = false;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

	if (!(sender instanceof Player))
	    return true;

	Player player = (Player) sender;

	if (cmd.getName().equalsIgnoreCase("gadget")) {
	    if (!player.hasPermission("prefs.gadget")) {
		player.sendMessage(ChatColor.RED + "You don't have permission to do this.");
		return true;
	    }

	    for (Player all : Bukkit.getOnlinePlayers()) {
		all.performCommand("uc gadgets");
		if (!disabled) {
		    disabled = true;
		    Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "Gadgets have been disabled.");
		} else {
		    disabled = false;
		    Bukkit.broadcastMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Gadgets have been enabled.");
		}
		return false;
	    }

	}

	return false;

    }

    @EventHandler
    public void handle(PlayerInteractEvent e) {
	// && e.getItem().getItemMeta().getDisplayName()
	// .equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Cosmetic
	// Menu")
	if(e.getItem() == null)
	    return;
	
	if(!(e.getItem().getType() == Material.CHEST))
	    return;
	
	if (e.getItem().getType() == Material.CHEST) {
	    if (disabled == true) {
		e.setCancelled(true);
	    } else
		return;
	}

    }

}
