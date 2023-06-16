package org.LSN.Main;

import org.LSN.Administration.Manage;
import org.LSN.Commands.*;
import org.LSN.Events.BlockBreak;
import org.LSN.Listeners.AutoPickupListener;
import org.LSN.Listeners.InventoryMoveListener;
import org.LSN.Listeners.JoinQuit;
import org.LSN.MySQL.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable(){
        init();
        MySQL.connect();
        System.out.println("Prison system activated!");
    }

    public void onDisable(){
        System.out.println("Prison system deactivated");
    }

    private void init() {
        Bukkit.getPluginManager().registerEvents(new AutoPickupListener(), this);
        Bukkit.getPluginManager().registerEvents(new BlockBreak(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryMoveListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinQuit(), this);
        Bukkit.getPluginManager().registerEvents(new Manage(), this);
//        Bukkit.getPluginManager().registerEvents(new Pickaxes(), this);
        Bukkit.getPluginManager().registerEvents(new Settings(), this);

        getCommand("autopickup").setExecutor(new AutoPickup());
        getCommand("autosell").setExecutor(new AutoSell());
        getCommand("autosmelt").setExecutor(new AutoSmelt());
        getCommand("mine").setExecutor(new Mine());
        getCommand("sellall").setExecutor(new SellAll());
        getCommand("settings").setExecutor(new Settings());
        getCommand("spawn").setExecutor(new Spawn());

        getCommand("manage").setExecutor(new Manage());
    }

}
