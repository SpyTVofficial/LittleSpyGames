package org.LSN.Main;

import org.LSN.Commands.ClearChat;
import org.LSN.Commands.EnderChest;
import org.LSN.Commands.Gamemode;
import org.LSN.Commands.Warp;
import org.LSN.Listeners.JoinQuit;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable(){
        getCommand("gm").setExecutor(new Gamemode());
        getCommand("ec").setExecutor(new EnderChest());
        getCommand("cc").setExecutor(new ClearChat());
        getCommand("warp").setExecutor(new Warp());
        Bukkit.getPluginManager().registerEvents(new JoinQuit(), this);
    }

}
