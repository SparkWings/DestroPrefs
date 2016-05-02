package org.jbltd.destro.prefs.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.util.Vector;
import org.jbltd.destro.prefs.util.PreferenceManager;

public class KnockbackListener implements Listener {

    @EventHandler
    public void onVelo(PlayerVelocityEvent e) {
	
	if (PreferenceManager.getPlayerPrefs(e.getPlayer()).getKnockbackPreference() == true) {
	    e.setVelocity(new Vector(0, 0, 0));
	    e.setCancelled(true);
	}
    }

}
