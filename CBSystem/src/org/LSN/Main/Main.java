package org.LSN.Main;

import org.LSN.Commands.Gamemode;
import org.LSN.Listeners.JoinQuit;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable(){
        getCommand("gm").setExecutor(new Gamemode());
        Bukkit.getPluginManager().registerEvents(new JoinQuit(), this);
    }

}
