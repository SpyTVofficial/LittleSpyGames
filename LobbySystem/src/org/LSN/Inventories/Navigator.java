package org.LSN.Inventories;

import org.LSN.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class Navigator implements Listener {

    @EventHandler
    public void interact(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) &&
                p.getItemInHand().getType().equals(Material.BLAZE_ROD) &&
                p.getItemInHand().getItemMeta().getDisplayName().contains("§a§lNavigator")) {
            Inventory Inv = Bukkit.createInventory(p, 45, "§6§lNavigator");
            for (int i = 0; i < Inv.getSize(); i++)
                Inv.setItem(i, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 15, " "));
            Inv.setItem(12, Utils.createItem(Material.IRON_PICKAXE, 1, 5, "§bCityBuild"));
            Inv.setItem(13, Utils.createItem(Material.GOLDEN_APPLE, 1, 10, "§6Spawn"));
            Inv.setItem(14, Utils.createItem(Material.GRASS, 1, 14, "§aFreeBuild"));
            Inv.setItem(22, Utils.createItem(Material.BARRIER, 1, 0, "§cInventar schließen"));
            p.openInventory(Inv);
        }
    }
    @EventHandler
    public void clickEvent(InventoryClickEvent e) {
        Player p = null;
        if (e.getWhoClicked() instanceof Player)
            p = (Player)e.getWhoClicked();
        if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§cInventar schließen")) {
            p.getOpenInventory().close();
        }
        if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§6Spawn")){
            Location spawn = new Location(Bukkit.getWorld("world"), 0.5D, 51D, 0.5D);
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 1);
            p.teleport(spawn);
            p.getOpenInventory().close();
        }
        if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§bCityBuild")){
            Location cb = new Location(Bukkit.getWorld("world"), 0.5D, 50D, 34.5D);
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 1);
            p.teleport(cb);
            p.getOpenInventory().close();
        }
        if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§aFreeBuild")){
            Location fb = new Location(Bukkit.getWorld("world"), 0.5D, 50D, 34.5D);
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 1);
            p.teleport(fb);
            p.getOpenInventory().close();
        }
    }
}
