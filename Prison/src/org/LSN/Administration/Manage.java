package org.LSN.Administration;

import org.LSN.Mines.Reset;
import org.LSN.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Manage implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player p = (Player) sender;
        if(p.hasPermission("Prison.Manage")){
            Inventory manage = Bukkit.createInventory(p, 45, "§4Prison Management");
            manage.setItem(10, Utils.createItem(Material.IRON_PICKAXE, 1, 0, "§cAlle Minen resetten"));
            manage.setItem(11, Utils.createItem(Material.IRON_AXE, 1, 0, "§aMine auswählen"));
            manage.setItem(12, Utils.createItem(Material.DIAMOND, 1, 0, "§6Admin-Items"));
            manage.setItem(40, Utils.createItem(Material.BARRIER, 1, 0, "§cInventar schließen"));
            p.openInventory(manage);
        } else {
            p.sendMessage(Utils.noperms);
        }
        return false;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();
        if(e.getInventory().getTitle().equalsIgnoreCase("§4Prison Management")){
            if(item != null) {
                if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§cALle Minen resetten")) {
                    Inventory resetConfirm = Bukkit.createInventory(p, 27, "§aBestätigen");
                    resetConfirm.setItem(21, Utils.createItem(Material.SLIME_BALL, 1, 0, "§aBestätigen"));
                    resetConfirm.setItem(23, Utils.createItem(Material.MAGMA_CREAM, 1, 0, "§aAbbrechen"));
                    p.openInventory(resetConfirm);
                    if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§aBestätigen")) {
                        Reset.resetAll();
                    } else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§cAbbrechen")) {
                        p.closeInventory();
                    }
                } else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§6Admin-Items")) {
                    Inventory adminItems = Bukkit.createInventory(p, 45, "§6Admin-Items");
                    adminItems.setItem(10, Utils.createItem(Material.DIAMOND_PICKAXE, 1, 0, "§4§lAdmin Pickaxe"));
                    adminItems.setItem(40, Utils.createItem(Material.ARROW, 1, 0, "§aZurück"));
                    p.openInventory(adminItems);
                    if (e.getInventory().getTitle().equalsIgnoreCase("§aZurück")) {
                        p.closeInventory();
                    }

                    } else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Mine auswählen")) {
                    Inventory selmine = Bukkit.createInventory(p, 45, "§aMine auswählen");
                    selmine.setItem(41, Utils.createItem(Material.ARROW, 1, 0, "§cZurück"));
                    p.openInventory(selmine);
                } else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§cInventar schließen")) {
                    p.closeInventory();
                }
            }
        }
    }
    @EventHandler
    public void onClickAdmin(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();
        if (e.getInventory().getTitle().equalsIgnoreCase("§6Admin-Items")) {
            if (item != null) {
                if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§4§lAdmin Pickaxe")) {
                    ItemStack adminPickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
                    ItemMeta adminPickaxeMeta = adminPickaxe.getItemMeta();
                    adminPickaxe.addEnchantment(Enchantment.DIG_SPEED, 512);
                    adminPickaxe.addEnchantment(Enchantment.LUCK, 512);
                    ArrayList<String> adminPickaxeLore = new ArrayList<String>();
                    adminPickaxeLore.add("§4§lOVERPOWERED PICKAXE");
                    adminPickaxeLore.add("§4von " + p.getDisplayName());
                    adminPickaxeMeta.setLore(adminPickaxeLore);
                    adminPickaxe.setItemMeta(adminPickaxeMeta);
                    p.getInventory().addItem(adminPickaxe);
                    p.closeInventory();
                }
            }
        }
    }
}
