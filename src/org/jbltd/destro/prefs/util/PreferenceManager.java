package org.jbltd.destro.prefs.util;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

public class PreferenceManager {

    public static HashMap<UUID, Preference> playerPrefs = new HashMap<>();

    public static Preference getPlayerPrefs(Player player) {
	return playerPrefs.get(player.getUniqueId());
    }

    public static void addPlayer(Player player) {

	playerPrefs.put(player.getUniqueId(), new Preference(true, true, true, false, false, false, false));

    }

    public static void removePlayer(Player player) {
	playerPrefs.remove(player.getUniqueId());
    }

}
