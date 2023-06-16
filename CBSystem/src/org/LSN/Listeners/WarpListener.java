package org.LSN.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class WarpListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player p = null;
        Location spawn = new Location(Bukkit.getWorld("world"), 0.5D, 50D, 34.5D);
        if (e.getWhoClicked() instanceof Player)
            p = (Player)e.getWhoClicked();
        if(e.getInventory().getTitle().equalsIgnoreCase("§6Warps")){
            ;
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lSpawn")){
                p.teleport(spawn);
                p.sendMessage("§bTeleportiere zum §aSpawn§b...");
            } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cInventar schließen")){
                p.getOpenInventory().close();
            }
        }
    }

}
