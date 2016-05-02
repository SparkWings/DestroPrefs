package org.jbltd.destro.prefs.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.jbltd.destro.prefs.Main;
import org.jbltd.destro.prefs.util.PreferenceManager;

public class Forcefield {

    private static Main main;

    public Forcefield(Main plugin) {
	main = plugin;
	startForcefields();
    }

    public static ArrayList<UUID> Forcefield = new ArrayList<>();

    public static void startForcefields() {

	int range = Main.getConfiguration().getInt("forcefield.radius");

	Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
	    public void run() {

		for (Player player : Bukkit.getOnlinePlayers()) {
		    if (PreferenceManager.getPlayerPrefs(player).getForcefieldPreference() == true) {
			if (!Forcefield.contains(player.getUniqueId())) {
			    Forcefield.add(player.getUniqueId());
			    continue;
			}

		    }
		    if (PreferenceManager.getPlayerPrefs(player).getForcefieldPreference() == false) {

			if (Forcefield.contains(player.getUniqueId())) {
			    Forcefield.remove(player.getUniqueId());
			    continue;
			}
		    }
		}

		for (int i = 0; i < Forcefield.size(); i++) {
		    Player p = (Player) Bukkit.getPlayer(Forcefield.get(i));

		    List<Entity> Entitys = p.getNearbyEntities(range, range, range);
		    for (int i2 = 0; i2 < Entitys.size(); i2++) {
			Entity e = (Entity) Entitys.get(i2);

			if(!(e instanceof Player))
			{
			    continue;
			}
			
			Player p2 = (Player) Entitys.get(i2);
			
			if(p2.hasPermission("prefs.forcefield.bypass"))
			{
			    continue;
			}
			
			Vector unitVector = e.getLocation().toVector().subtract(p.getLocation().toVector()).normalize();
			e.setVelocity(unitVector.multiply(0.5).setY(0.0));

		    }
		}
	    }
	}, 20L, 1L);
    }

}
