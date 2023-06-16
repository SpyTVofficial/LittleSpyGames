package org.LSN.Minions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class Minions implements Listener{

    @EventHandler
    public void onMinionClick(){
        Player p = null;
        Inventory minionInv = Bukkit.createInventory(p, 54, "§aMinions");

        p.openInventory(minionInv);
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e){
        Player p = null;

    }

}
