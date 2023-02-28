package org.LSN.Listener;

import org.LSN.Main.Main;
import org.LSN.Settings.General;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class ChatListener implements Listener {
	
	@EventHandler
	public static void onChat(PlayerChatEvent e) {
		Player p = e.getPlayer();
		if(General.Cop.contains(p)) {
			e.setFormat(Main.cop + p.getDisplayName() + ": " + e.getMessage());
		} else {
			e.setFormat("§a" + p.getDisplayName() + ": " + e.getMessage());
		}
		if(General.CrimeChat.contains(p)){
			p.sendMessage(e.getMessage());
		}
	}

}
