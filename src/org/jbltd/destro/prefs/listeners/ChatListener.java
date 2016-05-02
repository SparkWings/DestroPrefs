package org.jbltd.destro.prefs.listeners;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.jbltd.destro.prefs.Main;
import org.jbltd.destro.prefs.commands.ChatslowCommand;
import org.jbltd.destro.prefs.util.PreferenceManager;


public class ChatListener implements Listener {

    public static boolean isSilenced = false;

    private Main main;

    private ArrayList<UUID> disallowed = new ArrayList<>();

    public ChatListener(Main plugin) {
	this.main = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
	e.setCancelled(true);

	
	if (isSilenced) {
	   if(!e.getPlayer().hasPermission("prefs.silence.bypass"))
	    {
	       e.getPlayer().sendMessage(ChatColor.RED+"Chat is currently silenced.");
	       return;
	    }
	}
	if(disallowed.contains(e.getPlayer().getUniqueId()))
	{
	    e.getPlayer().sendMessage(ChatColor.RED+"A chatslow is currently enabled. You may not speak until your cooldown has expired.");
	    return;
	}
	
	for (Player player : Bukkit.getOnlinePlayers()) {
	    if (PreferenceManager.getPlayerPrefs(player).getChatPreference() == true) {
		player.sendMessage(e.getPlayer().getDisplayName() + ChatColor.GRAY + " > " + e.getMessage());

		if (ChatslowCommand.isSlow == true) {
		    
		    if(!player.hasPermission("prefs.chatslow.bypass"))
		    {
			disallowed.add(e.getPlayer().getUniqueId());
		    }

		    Bukkit.getScheduler().scheduleSyncDelayedTask(main, new Runnable() {

			@Override
			public void run() {

			    disallowed.remove(e.getPlayer().getUniqueId());
			}
		    }, 20 * ChatslowCommand.slowTime);
		}
	    }
	}

    }

}
