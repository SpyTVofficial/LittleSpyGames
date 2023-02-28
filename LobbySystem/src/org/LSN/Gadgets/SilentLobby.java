package org.LSN.Gadgets;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class SilentLobby implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(p.hasPermission("System.SilentLobby")) {
            if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5§lSilent-Lobby") && e.getItem().getData().getItemType().equals(Material.TNT)) {
                p.performCommand("silentlobby");
            } else {
                e.setCancelled(true);
            }
        }
    }
}
