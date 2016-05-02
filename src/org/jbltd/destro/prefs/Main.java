package org.jbltd.destro.prefs;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jbltd.destro.prefs.commands.ChatslowCommand;
import org.jbltd.destro.prefs.commands.GadgetCommand;
import org.jbltd.destro.prefs.commands.MessageCommand;
import org.jbltd.destro.prefs.commands.PrefsCommand;
import org.jbltd.destro.prefs.commands.ReplyCommand;
import org.jbltd.destro.prefs.commands.SilenceCommand;
import org.jbltd.destro.prefs.gui.PrefsGUI;
import org.jbltd.destro.prefs.listeners.ChatListener;
import org.jbltd.destro.prefs.listeners.Forcefield;
import org.jbltd.destro.prefs.listeners.JoinListener;
import org.jbltd.destro.prefs.listeners.KnockbackListener;

public class Main extends JavaPlugin {

    public static FileConfiguration config;

    public static HashMap<UUID, UUID> _lastMessage = new HashMap<>();
    
    public void onEnable() {
	
	config = getConfig();
	
	config.addDefault("forcefield.radius", 5);
	config.options().copyDefaults(true);
	saveConfig();
	
	registerListeners();
	registerCommands();
	new Forcefield(this);
	
	System.out.println("Enabled.");
    }

    public void onDisable() {
	saveDefaultConfig();
    }

    private void registerListeners() {
	getServer().getPluginManager().registerEvents(new ChatListener(this), this);
	getServer().getPluginManager().registerEvents(new JoinListener(), this);
	getServer().getPluginManager().registerEvents(new KnockbackListener(), this);
	getServer().getPluginManager().registerEvents(new PrefsGUI(), this);
	getServer().getPluginManager().registerEvents(new GadgetCommand(), this);
	
    }

    private void registerCommands() {

	getCommand("silence").setExecutor(new SilenceCommand());
	getCommand("preferences").setExecutor(new PrefsCommand());
	getCommand("message").setExecutor(new MessageCommand());
	getCommand("reply").setExecutor(new ReplyCommand());
	getCommand("chatslow").setExecutor(new ChatslowCommand());
	getCommand("gadget").setExecutor(new GadgetCommand());

    }

    public static FileConfiguration getConfiguration()
    {
	
	return config;
	
    }
    
}
