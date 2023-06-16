package org.LSN.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class AutoSmeltListener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if(e.getBlock().getType().isBurnable()){
            Material smolten = e.getBlock().getType();
        }
    }

    public static void giveSmoltenItem(Material mat){
        Player p;

    }

}
