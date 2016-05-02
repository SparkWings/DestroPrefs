package org.jbltd.destro.prefs.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jbltd.destro.prefs.util.PreferenceManager;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
	PreferenceManager.addPlayer(e.getPlayer());
	//MSGS
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
	PreferenceManager.removePlayer(e.getPlayer());
    }

}
