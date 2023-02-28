package org.LSN.GameHandler;

import org.LSN.Main.Main;
import org.LSN.Settings.General;
import org.LSN.Settings.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Material.*;

public class InGame implements Listener {

	@EventHandler
	public void interact(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		Entity ent = e.getRightClicked();
		if (ent instanceof Villager) {
			if (General.Cop.contains(p)) {
				p.sendMessage(Main.npc + "Bitte sage mir den Namen der Person die du verd�chtigst!");
				Inventory Inv = Bukkit.createInventory((InventoryHolder) p, 45, "�eVerd�chdigungsmen�");
				Inv.setItem(0, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(1, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(2, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(3, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(4, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(5, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(6, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(7, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(8, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(9, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(10, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(11, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(12, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(13, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(14, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(15, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(16, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(17, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(18, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(19, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(20, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(21, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(23, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(24, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(25, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(26, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(27, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(28, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(29, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(30, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(31, Utils.createItem(Material.ARROW, 1, 0, "�4Check"));
				Inv.setItem(32, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(33, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(34, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(35, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(36, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(37, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(38, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(39, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(40, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(41, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(42, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(43, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				Inv.setItem(44, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 0, " "));
				new Thread(new Runnable() {

					public void run() {
						// message
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						e.getPlayer().openInventory(Inv);
						// message
					}

				}).start();

			} else {
				p.sendMessage(Main.nocop);
			}
		}
	}

	@EventHandler
	public void onMoveItemInventory(InventoryMoveItemEvent e) {
		if (e.getItem().getType() == Material.PAPER) {
			e.setCancelled(true);

		} else {
			return;
		}
	}

	@EventHandler
	public void onDamage(PlayerDeathEvent e) {
		Player p = e.getEntity();
		e.setDeathMessage(null);
		p.getKiller().getInventory().addItem(Utils.createItem(Material.PAPER, 1, 0, p.getDisplayName()));
	}

	@EventHandler
	public void on(InventoryOpenEvent e) {
		Player p = (Player) e.getPlayer();
		if (e.getInventory().getType() == InventoryType.MERCHANT) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void check(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().contains("�eVerd�chdigungsmen�")) {
			if(e.getCurrentItem().getItemMeta().getDisplayName().contains("�4Check")){
				//if(p.getInventory().getItem(22).getItemMeta().getDisplayName().contains(General.Crim.toString())){
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("hahalol")){
					GameEnd.onGameEnd();
				}
				p.closeInventory();
		}}

	}

	@EventHandler
	public void onMove(InventoryMoveItemEvent e){
		if (e.getDestination().getTitle().contains("Verd�chdigungsmen�")) {
			if(e.getItem().getData().getItemType() != PAPER) {
			e.setCancelled(true);
			}
		}
	}
}
