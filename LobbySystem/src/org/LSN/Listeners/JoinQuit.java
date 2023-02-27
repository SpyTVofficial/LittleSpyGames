package org.LSN.Listeners;

import org.LSN.Scoreboard.SetScoreboard;
import org.LSN.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;

public class JoinQuit implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        e.setJoinMessage(null);
        Player p = e.getPlayer();
        SetScoreboard.setBoard(p);
        Location loc = new Location(Bukkit.getWorld("world"), 0.5D, 51.0D, 0.5D);
        p.teleport(loc);
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 0.0F);
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);
        p.getInventory().setItem(3, Utils.createItem(Material.COMPASS, 1, 0, "§a§lNavigator"));
        p.getInventory().setItem(4, Utils.createItem(Material.BLAZE_ROD, 1, 0, "§a§lSpieler Anzeigen"));
        p.getInventory().setItem(5, Utils.createItem(Material.CHEST, 1, 0, "§a§lGadgets"));
    }

    @EventHandler
    public void onDisable(PlayerQuitEvent e){
        e.setQuitMessage(null);
    }

}
