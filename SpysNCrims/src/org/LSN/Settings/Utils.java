package org.LSN.Settings;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Utils implements Listener {

	public static String host = "localhost";
	public static int port = 3306;
	public static String database = "SNC";
	public static String username = "ian";
	public static String password = "29112005";

	public static ItemStack createItem(Material mat, int anzahl, int shortid, String Name) {
		short s = (short) shortid;
		ItemStack i = new ItemStack(mat, anzahl, s);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Name);
		i.setItemMeta(meta);
		return i;

	}
	
	@EventHandler
	public void onFood(FoodLevelChangeEvent e) {
		e.setCancelled(true);
		e.setFoodLevel(20);
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onBreak(BlockPlaceEvent e) {
		e.setCancelled(true);
	}
}
