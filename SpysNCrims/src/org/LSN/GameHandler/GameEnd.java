package org.LSN.GameHandler;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

import org.LSN.Main.Main;

public class GameEnd implements Listener {
	
	public static void stopGame() {
		onGameEnd();
	}
	
	public static void onGameEnd() {
		for (Player players : Bukkit.getOnlinePlayers())
			players.sendMessage(Main.prefix + " �cServer startet in 30 Sekunden neu!");
		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(30000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
				for (Player players : Bukkit.getOnlinePlayers())
					players.sendMessage(Main.prefix + " §cServer stoppt...");
				Bukkit.dispatchCommand(console, "stop");
			}

		}).start();
	}

}
