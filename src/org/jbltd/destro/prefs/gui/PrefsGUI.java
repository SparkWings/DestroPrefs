package org.jbltd.destro.prefs.gui;



import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jbltd.destro.prefs.util.PreferenceManager;

public class PrefsGUI implements Listener {

    public static String format = ChatColor.BLUE + "" + ChatColor.BOLD + "";

    public static String[] defaultDesign = new String[] 
	    {
		    "","h","","p","","b","","","",
		    "","1","","2","","3","","","",
		    "","","","","","","","","",
		    "","","","","","","","","",
		    "","","","","","","","","",
		    "","","","","","","","",""
	    };
    
    public static String[] youtubeDesign = new String[] 
	    {
		    "","h","","p","","b","","s","",
		    "","1","","2","","3","","4","",
		    "","","d","","e","","","","",
		    "","","5","","6","","","","",
		    "","","","","","","","","",
		    "","","","","","","","",""
	    };
    
    
    public static String[] adminDesign = new String[] 
	    {
		    "","h","","p","","b","","s","",
		    "","1","","2","","3","","4","",
		    "","","d","","e","","c","","",
		    "","","5","","6","","7","","",
		    "","","","","","","","","",
		    "","","","","","","","",""
	    };
    
    public static void open(Player player) {
	   
	
	if (player.hasPermission("prefs.default")) {
	    System.out.println("Player has default permissions.");
	    openDefaultGUI(player);
	} else if (player.hasPermission("prefs.youtube")) {
	    System.out.println("Player has youtube permissions.");
	    openYoutubeGUI(player);
	}
	else if (player.hasPermission("prefs.admin")) {
	    System.out.println("Player has admin permissions.");
	    openAdminGUI(player);
	} else {
	    System.out.println("Player has no permissions.");
	}

    }

    private static void openDefaultGUI(Player player) {
	Inventory inv = Bukkit.createInventory(player, 54,
		ChatColor.BLUE + "" + ChatColor.UNDERLINE + "User Preferences");

	ItemStack g = new ItemStack(Material.INK_SACK, 1, (byte) 10);
	ItemMeta gm = g.getItemMeta();
	gm.setDisplayName(ChatColor.GREEN+"Click the above item to toggle");
	g.setItemMeta(gm);
	ItemStack gr = new ItemStack(Material.INK_SACK, 1, (byte) 8);
	ItemMeta grm = gr.getItemMeta();
	grm.setDisplayName(ChatColor.GREEN+"Click the above item to toggle");
	gr.setItemMeta(grm);
	
	
	for (int i = 0; i < defaultDesign.length; i++) {
	    String current = defaultDesign[i];

	    switch (current) {

	    case "h":
		ItemStack stack = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(format + "Player Visibility");
		stack.setItemMeta(meta);

		inv.setItem(i, stack);
		continue;
	    case "p":
		ItemStack map = new ItemStack(Material.EMPTY_MAP);
		ItemMeta mapm = map.getItemMeta();
		mapm.setDisplayName(format + "Private Messaging");
		map.setItemMeta(mapm);

		inv.setItem(i, map);

		continue;
	    case "b":
		ItemStack book = new ItemStack(Material.BOOK);
		ItemMeta bookm = book.getItemMeta();

		bookm.setDisplayName(format + "Chat Visibility");
		book.setItemMeta(bookm);
		inv.setItem(i, book);
		continue;
	    case "1":
		if (PreferenceManager.getPlayerPrefs(player).getPlayerVisibilityPreference() == true) {
		    inv.setItem(i, g);
		} else {
		    inv.setItem(i, gr);
		}
		continue;
	    case "2":
		if (PreferenceManager.getPlayerPrefs(player).getMessagePreference() == true) {
		    inv.setItem(i, g);
		} else {
		    inv.setItem(i, gr);
		}
		continue;
	    case "3":
		if (PreferenceManager.getPlayerPrefs(player).getChatPreference() == true) {
		    inv.setItem(i, g);
		} else {
		    inv.setItem(i, gr);
		}
		continue;
	    default:
		continue;

	    }

	}
	player.openInventory(inv);
	
    }

    private static void openYoutubeGUI(Player player) {

	Inventory inv = Bukkit.createInventory(player, 54,
		ChatColor.BLUE + "" + ChatColor.UNDERLINE + "User Preferences");

	ItemStack g = new ItemStack(Material.INK_SACK, 1, (byte) 10);
	ItemMeta gm = g.getItemMeta();
	gm.setDisplayName(ChatColor.GREEN+"Click the above item to toggle");
	g.setItemMeta(gm);
	ItemStack gr = new ItemStack(Material.INK_SACK, 1, (byte) 8);
	ItemMeta grm = gr.getItemMeta();
	grm.setDisplayName(ChatColor.GREEN+"Click the above item to toggle");
	gr.setItemMeta(grm);

	for (int i = 0; i < youtubeDesign.length; i++) {
	    String current = youtubeDesign[i];

	    switch (current) {

	    case "h":
		ItemStack stack = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(format + "Player Visibility");
		stack.setItemMeta(meta);

		inv.setItem(i, stack);
		continue;
	    case "p":
		ItemStack map = new ItemStack(Material.EMPTY_MAP);
		ItemMeta mapm = map.getItemMeta();
		mapm.setDisplayName(format + "Private Messaging");
		map.setItemMeta(mapm);

		inv.setItem(i, map);

		continue;
	    case "b":
		ItemStack book = new ItemStack(Material.BOOK);
		ItemMeta bookm = book.getItemMeta();
		bookm.setDisplayName(format + "Chat Visibility");
		book.setItemMeta(bookm);

		inv.setItem(i, book);
		continue;
	    case "s":
		ItemStack star = new ItemStack(Material.NETHER_STAR);
		ItemMeta starm = star.getItemMeta();

		starm.setDisplayName(format + "Flight");
		star.setItemMeta(starm);
		inv.setItem(i, star);
		continue;
	    case "d":
		ItemStack saddle = new ItemStack(Material.SADDLE);
		ItemMeta saddlem = saddle.getItemMeta();

		saddlem.setDisplayName(format + "Ignore Velocity");
		saddle.setItemMeta(saddlem);
		inv.setItem(i, saddle);
		continue;
	    case "e":
		ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
		ItemMeta pearlm = pearl.getItemMeta();

		pearlm.setDisplayName(format + "Forcefield");
		pearl.setItemMeta(pearlm);
		inv.setItem(i, pearl);
		continue;

	    case "1":
		if (PreferenceManager.getPlayerPrefs(player).getPlayerVisibilityPreference() == true) {
		    inv.setItem(i, g);
		} else {
		    inv.setItem(i, gr);
		}
		continue;
	    case "2":
		if (PreferenceManager.getPlayerPrefs(player).getMessagePreference() == true) {
		    inv.setItem(i, g);
		} else {
		    inv.setItem(i, gr);
		}
		continue;
	    case "3":
		if (PreferenceManager.getPlayerPrefs(player).getChatPreference() == true) {
		    inv.setItem(i, g);
		} else {
		    inv.setItem(i, gr);
		}
		continue;
	    case "4":
		if (PreferenceManager.getPlayerPrefs(player).getFlightPreference() == true) {
		    inv.setItem(i, g);
		} else {
		    inv.setItem(i, gr);
		}
		continue;
	    case "5":
		if (PreferenceManager.getPlayerPrefs(player).getKnockbackPreference() == true) {
		    inv.setItem(i, g);
		} else {
		    inv.setItem(i, gr);
		}
		continue;
	    case "6":
		if (PreferenceManager.getPlayerPrefs(player).getForcefieldPreference() == true) {
		    inv.setItem(i, g);
		} else {
		    inv.setItem(i, gr);
		}
		continue;
	    default:
		continue;

	    }

	}
	
	player.openInventory(inv);
	
    }

    private static void openAdminGUI(Player player) {
	Inventory inv = Bukkit.createInventory(player, 54,
		ChatColor.BLUE + "" + ChatColor.UNDERLINE + "User Preferences");

	ItemStack g = new ItemStack(Material.INK_SACK, 1, (byte) 10);
	ItemMeta gm = g.getItemMeta();
	gm.setDisplayName(ChatColor.GREEN+"Click the above item to toggle");
	g.setItemMeta(gm);
	ItemStack gr = new ItemStack(Material.INK_SACK, 1, (byte) 8);
	ItemMeta grm = gr.getItemMeta();
	grm.setDisplayName(ChatColor.GREEN+"Click the above item to toggle");
	gr.setItemMeta(grm);

	for (int i = 0; i < adminDesign.length; i++) {
	    String current = adminDesign[i];

	    switch (current) {

	    case "h":
		ItemStack stack = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(format + "Player Visibility");
		stack.setItemMeta(meta);

		inv.setItem(i, stack);
		continue;
	    case "p":
		ItemStack map = new ItemStack(Material.EMPTY_MAP);
		ItemMeta mapm = map.getItemMeta();
		mapm.setDisplayName(format + "Private Messaging");
		map.setItemMeta(mapm);


		inv.setItem(i, map);
		continue;
	    case "b":
		ItemStack book = new ItemStack(Material.BOOK);
		ItemMeta bookm = book.getItemMeta();
		bookm.setDisplayName(format + "Chat Visibility");
		book.setItemMeta(bookm);

		inv.setItem(i, book);
		continue;
	    case "s":
		ItemStack star = new ItemStack(Material.NETHER_STAR);
		ItemMeta starm = star.getItemMeta();

		starm.setDisplayName(format + "Flight");
		star.setItemMeta(starm);
		inv.setItem(i, star);
		continue;
	    case "d":
		ItemStack saddle = new ItemStack(Material.SADDLE);
		ItemMeta saddlem = saddle.getItemMeta();

		saddlem.setDisplayName(format + "Ignore Velocity");
		saddle.setItemMeta(saddlem);
		inv.setItem(i, saddle);
		continue;
	    case "e":
		ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
		ItemMeta pearlm = pearl.getItemMeta();

		pearlm.setDisplayName(format + "Forcefield");
		pearl.setItemMeta(pearlm);
		inv.setItem(i, pearl);
		continue;
	    case "c":
		ItemStack ncp = new ItemStack(Material.BOOK_AND_QUILL);
		ItemMeta ncpm = ncp.getItemMeta();
		ncpm.setDisplayName(format + "NCP Notifications");
		ncpm.addEnchant(Enchantment.DURABILITY, 1, false);
		ncp.setItemMeta(ncpm);
		inv.setItem(i, ncp);
		continue;

	    case "1":
		if (PreferenceManager.getPlayerPrefs(player).getPlayerVisibilityPreference() == true) {
		    inv.setItem(i, g);
		} else {
		    inv.setItem(i, gr);
		}
		continue;
	    case "2":
		if (PreferenceManager.getPlayerPrefs(player).getMessagePreference() == true) {
		    inv.setItem(i, g);
		} else {
		    inv.setItem(i, gr);
		}
		continue;
	    case "3":
		if (PreferenceManager.getPlayerPrefs(player).getChatPreference() == true) {
		    inv.setItem(i, g);
		} else {
		    inv.setItem(i, gr);
		}
		continue;
	    case "4":
		if (PreferenceManager.getPlayerPrefs(player).getFlightPreference() == true) {
		    inv.setItem(i, g);
		} else {
		    inv.setItem(i, gr);
		}
		continue;
	    case "5":
		if (PreferenceManager.getPlayerPrefs(player).getKnockbackPreference() == true) {
		    inv.setItem(i, g);
		} else {
		    inv.setItem(i, gr);
		}
		continue;
	    case "6":
		if (PreferenceManager.getPlayerPrefs(player).getForcefieldPreference() == true) {
		    inv.setItem(i, g);
		} else {
		    inv.setItem(i, gr);
		}
		continue;
	    case "7":
		if (PreferenceManager.getPlayerPrefs(player).getNoCheatPreference() == true) {
		    inv.setItem(i, g);
		} else {
		    inv.setItem(i, gr);
		}
		continue;
	    default:
		continue;

	    }

	}

	player.openInventory(inv);
    }

    
    @EventHandler
    public void handle(InventoryClickEvent e)
    {
	
	if(!e.getClickedInventory().getName().equalsIgnoreCase(ChatColor.BLUE + "" + ChatColor.UNDERLINE + "User Preferences"))
	    return;
	
	if (e.getClickedInventory().getName().equalsIgnoreCase(ChatColor.BLUE + "" + ChatColor.UNDERLINE + "User Preferences"))
	{

	    e.setCancelled(true);
		
	    Player player = (Player) e.getWhoClicked();
	    ItemStack i = e.getCurrentItem();
	    
	    Material m = i.getType();
	    
	    
	    if(m == Material.SKULL_ITEM)
	    {
		if(PreferenceManager.getPlayerPrefs(player).getPlayerVisibilityPreference() == true)
		{
		    PreferenceManager.getPlayerPrefs(player).setPlayerVisibilityPreference(false);
		    for(Player p : Bukkit.getOnlinePlayers())
		    {
			if(p != player)
			{
			    player.hidePlayer(p);
			}
		    }
		}
		else
		{
		    PreferenceManager.getPlayerPrefs(player).setPlayerVisibilityPreference(true); 
		    for(Player p : Bukkit.getOnlinePlayers())
		    {
			if(p != player)
			{
			    player.showPlayer(p);
			}
		    }
		}
	    }
	    if(m == Material.EMPTY_MAP)
	    {
		if(PreferenceManager.getPlayerPrefs(player).getMessagePreference() == true)
		{
		    PreferenceManager.getPlayerPrefs(player).setPlayerMessagePreference(false);
		    
		}
		else
		{
		    PreferenceManager.getPlayerPrefs(player).setPlayerMessagePreference(true); 
		}
	    }
	    if(m == Material.BOOK)
	    {
		if(PreferenceManager.getPlayerPrefs(player).getChatPreference() == true)
		{
		    PreferenceManager.getPlayerPrefs(player).setPlayerChatPreference(false);
		    
		}
		else
		{
		    PreferenceManager.getPlayerPrefs(player).setPlayerChatPreference(true); 
		}
	    }
	    if(m == Material.NETHER_STAR)
	    {
		if(PreferenceManager.getPlayerPrefs(player).getFlightPreference() == true)
		{
		    PreferenceManager.getPlayerPrefs(player).setPlayerFlightPreference(false);
		    player.setAllowFlight(false);
		}
		else
		{
		    PreferenceManager.getPlayerPrefs(player).setPlayerFlightPreference(true);
		    player.setAllowFlight(true); 
		}
	    }
	    if(m == Material.ENDER_PEARL)
	    {
		if(PreferenceManager.getPlayerPrefs(player).getForcefieldPreference() == true)
		{
		    PreferenceManager.getPlayerPrefs(player).setPlayerForcefieldPreference(false);
		    
		}
		else
		{
		    PreferenceManager.getPlayerPrefs(player).setPlayerForcefieldPreference(true); 
		}
	    }
	    if(m == Material.SADDLE)
	    {
		if(PreferenceManager.getPlayerPrefs(player).getKnockbackPreference() == true)
		{
		    PreferenceManager.getPlayerPrefs(player).setPlayerKnockbackPreference(false);
		    
		}
		else
		{
		    PreferenceManager.getPlayerPrefs(player).setPlayerKnockbackPreference(true);
		}
	    }
	    if(m == Material.BOOK_AND_QUILL)
	    {
		if(PreferenceManager.getPlayerPrefs(player).getNoCheatPreference() == true)
		{
		    PreferenceManager.getPlayerPrefs(player).setPlayerNCPPreference(false);
		    player.performCommand("ncp notify off");
		}
		else
		{
		    PreferenceManager.getPlayerPrefs(player).setPlayerNCPPreference(true);
		    player.performCommand("ncp notify on");
		}
	    }
	    
	    
	    open(player);
	}
	
    }
    
}
