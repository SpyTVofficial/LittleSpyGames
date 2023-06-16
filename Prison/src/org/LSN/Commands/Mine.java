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

public class Mine implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(args.length == 0){
            Inventory mineinv = Bukkit.createInventory(p, 54, "§aMinen");
            mineinv.setItem(10, Utils.createItem(Material.COBBLESTONE, 1, 0, "§aMine 1"));
            mineinv.setItem(49, Utils.createItem(Material.BARRIER, 1, 0, "§cInventar schließen"));
            p.openInventory(mineinv);
        } else {
            p.sendMessage("§cBenutzung: /mine");
        }
        return false;
    }

    @EventHandler
    public void onClickItem(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getInventory().getTitle().equalsIgnoreCase("§aMinen")){
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cInventar schließen")){
                p.closeInventory();
            }
        }
    }

}
