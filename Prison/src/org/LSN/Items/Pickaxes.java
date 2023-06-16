package org.LSN.Items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Pickaxes implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if(e.getPlayer().getItemInHand().getType().equals(Material.DIAMOND_PICKAXE)){
            if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals("§8[§4§lSpecial§r§8] §4Pickaxe")) {

            }
        }
    }

}
