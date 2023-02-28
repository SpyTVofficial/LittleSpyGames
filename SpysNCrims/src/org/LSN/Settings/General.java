package org.LSN.Settings;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.conversations.PlayerNamePrompt;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class General implements Listener {


		public void Board(Player p) {
			Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
			Objective obj = board.registerNewObjective("aaa", "dummy");
			obj.setDisplayName("�f�lLittleSpyGames");
			obj.setDisplaySlot(DisplaySlot.SIDEBAR);

			obj.getScore("�aLobby Phase").setScore(3);
			obj.getScore("").setScore(2);
			obj.getScore("�f�lLittleSpyGames").setScore(1);

			p.setScoreboard(board);
		}

	public static ArrayList<Player> Cop = new ArrayList<Player>();
	public static ArrayList<Player> Crim = new ArrayList<Player>();
	public static ArrayList<Player> Joined = new ArrayList<Player>();
	public static ArrayList<Player> Spec = new ArrayList<Player>();
	public static ArrayList<Player> CrimeChat = new ArrayList<Player>();

	public void checkIfRoleIsEmpty() {
		if (Joined.size() == 8) {
			if (General.Cop.isEmpty()) {
				Player p = Bukkit.getOnlinePlayers().stream().findAny().get();
				Cop.add(p);
			} else if(Crim.isEmpty()) {
				Player p = Bukkit.getOnlinePlayers().stream().findAny().get();
				Crim.add(p);
			}
		}
	}

	public void onDamage(EntityDamageEvent e){
		if(e instanceof Villager){
			e.setCancelled(true);
		}
	}
}
