package org.LSN.GameHandler;

import org.LSN.Settings.General;
import org.LSN.Settings.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class LobbyState implements Listener {

	@EventHandler
	public static void onGameStart(Player p) {
		Location spawn = new Location(Bukkit.getWorld("mapp"), -324D, 68D, 231D);
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = board.registerNewObjective("abcd", "abcd");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR) ;
		obj.setDisplayName("�f�lLittleSpyGames");
		obj.getScore(" ").setScore(3);
		obj.getScore("�aDeine Rolle:").setScore(2);
		p.getInventory().setItem(0, Utils.createItem(Material.STICK, 1, 0, "�aStock"));
		obj.getScore("�aInnocent").setScore(1);
		for (Player players : Bukkit.getServer().getOnlinePlayers())
			players.teleport(spawn);
		if(General.Cop.contains(p)){

		for(Player player : General.Cop)
				p.getInventory().setItem(0, Utils.createItem(Material.IRON_SWORD, 1, 0, "�bSchwert"));
		obj.getScore("�bCop").setScore(1);
		}
		if (General.Crim.contains(p)) {
			p.getInventory().setItem(0, Utils.createItem(Material.IRON_SWORD, 1, 0, "�4Schwert"));
			obj.getScore("�4Crminial").setScore(1);
		}

		p.setScoreboard(board);
		
	}

}
