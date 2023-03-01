package org.LSN.Main;

import com.mysql.jdbc.Connection;
import org.LSN.Commands.*;
import org.LSN.GameHandler.GameEnd;
import org.LSN.Settings.General;
import org.LSN.Settings.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import org.LSN.GameHandler.InGame;
import org.LSN.GameHandler.PlayerDead;
import org.LSN.Listener.ChatListener;
import org.LSN.Listener.JoinQuit;

import java.sql.*;

public class Main extends JavaPlugin implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e){

	}

	public Connection connection;
	public String host, database, username, password;
	public int port;
	public static String prefix = "§8[§b§lCopsAndCrims§r§8]";
	public static String noperms = prefix + " §cKeine Rechte!";
	public static String nocop = prefix + " §cDu bist kein Polizist!";
	public static String npc = "§e[NPC] ";
	public static String version = "0.8";
	public static String cop = "§b§l[Cop] ";

	public void onEnable() {
		Player p = null;
		System.out.println("Spys And Crims Plugin erfolgreich aktiviert!");
		System.out.println("Plugin von itsSpyTV geplant und entwickelt!");
		System.out.println("Version: " + version);

		init();
	}

	public void onDisable() {
		System.out.println("Spys And Crims Plugin erfolgreich deaktiviert!");
	}

	private void init() {
		// TODO Auto-generated method stub

		Bukkit.getPluginManager().registerEvents(new JoinQuit(), this);
		Bukkit.getPluginManager().registerEvents(new InGame(), this);
		Bukkit.getPluginManager().registerEvents(new General(), this);
		Bukkit.getPluginManager().registerEvents(new Utils(), this);
		Bukkit.getPluginManager().registerEvents(new GameEnd(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerDead(), this);
		Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
	    getCommand("stats").setExecutor(new StatsCMD());
	    getCommand("start").setExecutor(new StartCMD());
	    getCommand("cc").setExecutor(new CrimeChatCMD());
	    getCommand("debugstop").setExecutor(new DebugSTOPCMD());
	    getCommand("dubassdommxd").setExecutor(new DebugCOPCMD());
	}


}
