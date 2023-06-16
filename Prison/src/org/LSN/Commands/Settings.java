package org.LSN.Commands;

import org.LSN.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Settings implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player p = (Player) sender;
        if(args.length == 0){
            Inventory settingsinv = Bukkit.createInventory(p, 36, "§aEinstellungen");
            if(Utils.autosell.contains(p)){
                settingsinv.setItem(10, Utils.createItem(Material.EMERALD,1, 0, "§aAutoSell"));
            } else {
                settingsinv.setItem(10, Utils.createItem(Material.EMERALD, 1, 0, "§cAutoSell"));
            }
            if(Utils.autopickup.contains(p)){
                settingsinv.setItem(11, Utils.createItem(Material.FEATHER,1, 0, "§aAutoPickup"));
            } else {
                settingsinv.setItem(11, Utils.createItem(Material.FEATHER, 1, 0, "§cAutoPickup"));
            }
            if(Utils.autosmelt.contains(p)){
                settingsinv.setItem(12, Utils.createItem(Material.FURNACE,1, 0, "§aAutoSmelt"));
            } else {
                settingsinv.setItem(12, Utils.createItem(Material.FURNACE, 1, 0, "§cAutoSmelt"));
            }
            settingsinv.setItem(31, Utils.createItem(Material.BARRIER, 1, 0, "§cInventar schließen"));
            p.openInventory(settingsinv);
        } else {
            p.sendMessage(Utils.prefix + "§cBenutzung: /settings");
        }
        return false;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();
        if(e.getInventory().getTitle().equalsIgnoreCase("§aEinstellungen")){
            if (item != null) {
                if (item.getItemMeta().getDisplayName().contains("§aAutoSell")) {
                    p.sendMessage(Utils.prefix + "§bAutoSell §cdeaktiviert!");
                    p.getInventory().setItem(10, Utils.createItem(Material.EMERALD, 1, 0, "§cAutoSell"));
                    Utils.autosell.remove(p);
                }
                if (item.getItemMeta().getDisplayName().contains("§cAutoSell")) {
                    p.sendMessage(Utils.prefix + "§bAutoSell §aaktiviert!");
                    p.getInventory().setItem(10, Utils.createItem(Material.EMERALD, 1, 0, "§aAutoSell"));
                    Utils.autosell.add(p);
                }
                if (item.getItemMeta().getDisplayName().contains("§aAutoPickup")) {
                    p.sendMessage(Utils.prefix + "§bAutoPickup §cdeaktiviert!");
                    p.getInventory().setItem(11, Utils.createItem(Material.FEATHER, 1, 0, "§cAutoPickup"));
                    Utils.autopickup.remove(p);
                }
                if (item.getItemMeta().getDisplayName().contains("§cAutoPickup")) {
                    p.sendMessage(Utils.prefix + "§bAutoPickup §aaktiviert!");
                    p.getInventory().setItem(11, Utils.createItem(Material.FEATHER, 1, 0, "§aAutoPickup"));
                    Utils.autopickup.add(p);
                }
                if (item.getItemMeta().getDisplayName().contains("§aAutoSmelt")) {
                    p.sendMessage(Utils.prefix + "§bAutoSmelt §cdeaktiviert!");
                    p.getInventory().setItem(12, Utils.createItem(Material.FURNACE, 1, 0, "§aAutoSmelt"));
                    Utils.autosmelt.remove(p);
                }
                if (item.getItemMeta().getDisplayName().contains("§cAutoSmelt")) {
                    p.sendMessage(Utils.prefix + "§bAutoSmelt §aaktiviert!");
                    p.getInventory().setItem(12, Utils.createItem(Material.FURNACE, 1, 0, "§aAutoSmelt"));
                    Utils.autosmelt.add(p);
                }
                if (item.getItemMeta().getDisplayName().equals("§cInventar schließen")) {
                    p.closeInventory();
                }
            }
        }
    }
}
