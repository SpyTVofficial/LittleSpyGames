package org.LSN.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;

public class InventoryMoveListener implements Listener {

    @EventHandler
    public void onMoveItem(InventoryMoveItemEvent e){
        if(e.getSource().getHolder().getInventory().getName().equals("§aEinstellungen")) {
            e.setCancelled(true);
        }
    }

}
