package org.LSN.Listeners;

import org.LSN.Inventories.Gadgets;
import org.LSN.Scoreboard.SetScoreboard;
import org.LSN.Utils.Utils;
import org.bukkit.*;
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
        p.setHealth(20);
        p.setFoodLevel(20);
        p.setGameMode(GameMode.ADVENTURE);
        SetScoreboard.setBoard(p);
        Location loc = new Location(Bukkit.getWorld("world"), 0.5D, 51.0D, 0.5D);
        p.teleport(loc);
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 0.0F);
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);
        if(p.hasPermission("System.SilentLobby")){
            p.getInventory().setItem(2, Utils.createItem(Material.TNT, 1, 0, "5§lSilent-Lobby"));
        }
        p.getInventory().setItem(3, Utils.createItem(Material.COMPASS, 1, 0, "§a§lNavigator"));
        p.getInventory().setItem(4, Utils.createItem(Material.BLAZE_ROD, 1, 0, "§a§lSpieler Anzeigen"));
        p.getInventory().setItem(5, Utils.createItem(Material.CHEST, 1, 0, "§a§lGadgets"));
        Gadgets.fly.add(p);
    }

    @EventHandler
    public void onDisable(PlayerQuitEvent e){
        e.setQuitMessage(null);
    }

}
