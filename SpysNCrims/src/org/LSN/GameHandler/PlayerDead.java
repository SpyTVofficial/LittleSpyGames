package org.LSN.GameHandler;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class PlayerDead implements Listener {

	@EventHandler
	public void onPlayerDamage(PlayerDeathEvent e) {
		Player p = e.getEntity();
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = board.registerNewObjective("abcd", "abcd");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName("�f�lLittleSpyGames");
		obj.getScore(" ").setScore(3);
		obj.getScore("�aDeine Rolle:").setScore(2);
		p.setScoreboard(board);
		Location death = p.getLocation();
		death.setY(death.getY() + 1);
		if (e.getEntity() instanceof Player) {
			p.setGameMode(GameMode.SPECTATOR);
			p.spigot().respawn();
			p.teleport(death);
			obj.getScore("�8Zuschauer").setScore(1);
		}
	}

}
