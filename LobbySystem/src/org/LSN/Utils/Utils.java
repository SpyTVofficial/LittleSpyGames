package org.LSN.Utils;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Utils implements Listener {

    public static String prefix = "§8[§cLobby§8] ";


    public static ItemStack createItem(Material mat, int anzahl, int shortid, String Name) {
        short s = (short) shortid;
        ItemStack i = new ItemStack(mat, anzahl, s);
        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(Name);
        i.setItemMeta(meta);
        return i;
    }

    public void onHealth(EntityDamageEvent e){
        e.setCancelled(true);
    }

    public void onHunger(FoodLevelChangeEvent e){
        e.setCancelled(true);
        e.setFoodLevel(20);
    }

    public void onBreak(BlockBreakEvent e){
        e.setCancelled(true);
    }

    public void onPlace(BlockPlaceEvent e){
        e.setCancelled(true);
    }

    public void onWeather(WeatherChangeEvent e){
        e.setCancelled(true);
    }

}
