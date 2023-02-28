package org.LSN.Listener;

import com.mysql.jdbc.MySQLConnection;
import org.LSN.GameHandler.LobbyState;
import org.LSN.Main.Main;
import org.LSN.Settings.General;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuit implements Listener {



	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		String UUID = p.getUniqueId().toString();
		p.getInventory().clear();
		p.setFoodLevel(20);
		Bukkit.getWorld("Hub").setPVP(false);
		Bukkit.getWorld("mapp").setPVP(true);
		e.setJoinMessage(Main.prefix + " �a" + p.getDisplayName() + " �ahat das Spiel betreten (" + General.Joined.size() + "/12)");
		General.Joined.add(p);
		Location hub = new Location(Bukkit.getWorld("Hub"), -20.5D, 14D, 63.5D);
		p.teleport(hub);
		Bukkit.getServer().getPlayer(p.getName()).getUniqueId();
		if(General.Joined.size() == 7) {

	        for (Player players : Bukkit.getOnlinePlayers())
	            players.sendMessage(Main.prefix + " �7Spiel beginnt in �460 �7Sekunden!");
	        LobbyState.onGameStart(p);
		}
	}

	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		General.Joined.remove(p);
		if(General.Crim.contains(p) || General.Cop.contains(p)) {
			General.Crim.remove(p);
			General.Cop.remove(p);
		}
		e.setQuitMessage(Main.prefix + " �c" + p.getDisplayName() + " �chat das Spiel verlassen");
	}

}
