package org.LSN.Main;

import org.LSN.Gadgets.Enterhaken;
import org.LSN.Inventories.Gadgets;
import org.LSN.Inventories.PlayerHider;
import org.LSN.Listeners.JoinQuit;
import org.LSN.Utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable(){
        Bukkit.getPluginManager().registerEvents(new Utils(), this);
        Bukkit.getPluginManager().registerEvents(new JoinQuit(), this);
        Bukkit.getPluginManager().registerEvents(new Gadgets(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerHider(), this);
        Bukkit.getPluginManager().registerEvents(new Enterhaken(), this);
    }

    public void onDisable(){

    }
}
