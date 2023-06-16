package org.LSN.Listeners;

import org.LSN.Utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;

public class AutoPickupListener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Collection<ItemStack> drops = e.getBlock().getDrops();
        if(Utils.autopickup.contains(p)) {
            for (ItemStack item : drops) {
                if (!Utils.autosmelt.contains(p)) {
                    p.getInventory().addItem(item);
                } else {
                    if(e.getBlock().getType().equals(Material.IRON_ORE)) {
                        p.getInventory().addItem();
                    }
                }
            }
            if (!p.getCanPickupItems()) {
                p.sendMessage("§c§lYour inventory is full!");
                e.setCancelled(false);
            }
        }
    }
}
