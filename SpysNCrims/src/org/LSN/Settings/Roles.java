package org.LSN.Settings;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import org.LSN.Main.Main;

public class Roles implements Listener {
	
	@SuppressWarnings("null")
	@EventHandler
	public void onDamage(PlayerDeathEvent e) {
		Player p = e.getEntity();
		if(General.Cop.contains(p)) {
			General.Cop.remove(p);
			General.Joined.remove(p);
			General.Spec.add(p);
            for (Player players : Bukkit.getOnlinePlayers())
                players.sendMessage(Main.prefix + " §cDer Polizist wurde umgebracht! Der Kriminelle gewinnt!");
		} else if(General.Crim.contains(p)) {
			General.Joined.remove(p);
			General.Crim.remove(p);
			General.Spec.add(p);
            for (Player players : Bukkit.getOnlinePlayers())
                players.sendMessage(Main.prefix + " §aDer Kriminelle wurde erfolgreich geschnappt!");
		}
	}
}
