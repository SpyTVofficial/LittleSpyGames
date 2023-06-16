package org.LSN.Inventories;

import org.LSN.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

public class Gadgets implements Listener {

    public static ArrayList<Player> eh = new ArrayList<>();
    public static ArrayList<Player> speed = new ArrayList<>();
    public static ArrayList<Player> fly = new ArrayList<>();
    public static ArrayList<Player> jp = new ArrayList<>();
    public static ArrayList<Player> dj = new ArrayList<>();

    @EventHandler
    public void interact(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) &&
                p.getItemInHand().getType().equals(Material.CHEST) &&
                p.getItemInHand().getItemMeta().getDisplayName().contains("§a§lGadgets")) {
            Inventory Inv = Bukkit.createInventory(p, 27, "§6§lGadgets");
            for (int i = 0; i < Inv.getSize(); i++)
                Inv.setItem(i, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 15, " "));
            Inv.setItem(1, Utils.createItem(Material.FEATHER, 1, 0, "§b§lSpeed"));
            Inv.setItem(12, Utils.createItem(Material.FISHING_ROD, 1, 0, "§5§lEnterhaken"));
            Inv.setItem(13, Utils.createItem(Material.FEATHER, 1, 0, "§b§lFliegen"));
            Inv.setItem(14, Utils.createItem(Material.IRON_PLATE, 1, 0, "§a§lJumpPads"));
            Inv.setItem(22, Utils.createItem(Material.BARRIER, 1, 0, "§cInventar schließen"));

            p.openInventory(Inv);
        }
    }

    @EventHandler
    public void clickEvent(InventoryClickEvent e) {
        Player p = null;
        if (e.getWhoClicked() instanceof Player)
            p = (Player) e.getWhoClicked();
        if (e.getClickedInventory().getName().equalsIgnoreCase("§6§lGadgets")) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cInventar schließen")) {
                p.getOpenInventory().close();
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§5§lEnterhaken")) {
                if (eh.contains(p)) {
                    p.sendMessage(Utils.prefix + "§5Enterhaken §cdeaktiviert");
                    eh.remove(p);
                    p.getInventory().clear();
                    p.getInventory().setArmorContents(null);
                    p.getInventory().setItem(3, Utils.createItem(Material.COMPASS, 1, 0, "§a§lNavigator"));
                    p.getInventory().setItem(4, Utils.createItem(Material.BLAZE_ROD, 1, 0, "§a§lSpieler Anzeigen"));
                    p.getInventory().setItem(5, Utils.createItem(Material.CHEST, 1, 0, "§a§lGadgets"));
                    p.closeInventory();
                } else {
                    eh.add(p);
                    p.sendMessage(Utils.prefix + "§5Enterhaken §aaktiviert");
                    p.getInventory().setItem(2, Utils.createItem(Material.FISHING_ROD, 1, 0, "§5§lEnterhaken"));
                    p.closeInventory();
                }
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§b§lFliegen")) {
                if (fly.contains(p)) {
                    p.setAllowFlight(false);
                    p.setFlying(false);
                    fly.remove(p);
                    p.sendMessage(Utils.prefix + "§bFliegen §cdeaktiviert");
                    p.closeInventory();
                } else {
                    p.setAllowFlight(true);
                    p.setFlying(true);
                    fly.add(p);
                    p.sendMessage(Utils.prefix + "§bFliegen §aaktiviert");
                    p.closeInventory();
                }
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lJumpPads")) {
                if (jp.contains(p)) {
                    jp.remove(p);
                    p.closeInventory();
                    p.sendMessage(Utils.prefix + "§aJumpPads §cdeaktiviert");
                } else {
                    jp.add(p);
                    p.closeInventory();
                    p.sendMessage(Utils.prefix + "§aJumpPads §aaktiviert");
                }
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lDoubleJump")) {
                if (dj.contains(p)) {
                    dj.remove(p);
                    p.closeInventory();
                    p.sendMessage(Utils.prefix + "§aDoubleJump §cdeaktiviert!");
                } else {
                    dj.add(p);
                    p.closeInventory();
                    p.sendMessage(Utils.prefix + "§aDoubleJump §aaktiviert!");
                }
            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§b§lSpeed")) {
                if (speed.contains(p)) {
                    p.closeInventory();
                    p.setWalkSpeed(0.2f);
                    p.setFlySpeed(0.2f);
                    p.sendMessage(Utils.prefix + "§bSpeed §cdeaktiviert!");
                } else {
                    p.closeInventory();
                    p.setWalkSpeed(20);
                    p.setFlySpeed(20);
                    p.sendMessage(Utils.prefix + "§bSpeed §aaktiviert!");
                }
            }
            e.setCancelled(true);
        }
    }

}
