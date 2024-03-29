package org.LSN.Main;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import org.LSN.AdminCommands.*;
import org.LSN.Commands.*;
import org.LSN.Listener.OnPing;
import org.LSN.Listener.PostLogin;
import org.LSN.MySQL.MySQL_Connect;

import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main extends Plugin {

    public void onEnable(){
        init();
    }

    public void onDisable(){
        for (ProxiedPlayer onlineplayers : BungeeCord.getInstance().getPlayers()){
            try {
                String query1 = MessageFormat.format("DELETE FROM loggedin WHERE name= \"{0}\";", onlineplayers.getDisplayName().toString());
                MySQL_Connect.con.createStatement().executeUpdate(query1);
            } catch (SQLException ex1){
                ex1.printStackTrace();
            }
        }
        System.out.println("Disabling BungeeSystem...");
    }

    private void init() {
        System.out.println("Loading BungeeSystem...");
        //Listener
        getProxy().getPluginManager().registerListener(this, new Mute());
        getProxy().getPluginManager().registerListener(this, new OnPing());
        getProxy().getPluginManager().registerListener(this, new PostLogin());
        //Commands
        getProxy().getPluginManager().registerCommand(this, new AdminChat());
        getProxy().getPluginManager().registerCommand(this, new Ban());
        getProxy().getPluginManager().registerCommand(this, new Broadcast());
        getProxy().getPluginManager().registerCommand(this, new Coins());
        getProxy().getPluginManager().registerCommand(this, new Goto());
        getProxy().getPluginManager().registerCommand(this, new GotoPlayer());
        getProxy().getPluginManager().registerCommand(this, new Hub());
        getProxy().getPluginManager().registerCommand(this, new JoinMe());
        getProxy().getPluginManager().registerCommand(this, new Kick());
        getProxy().getPluginManager().registerCommand(this, new MSG());
        getProxy().getPluginManager().registerCommand(this, new Mute());
        getProxy().getPluginManager().registerCommand(this, new MySQL_Reload());
        getProxy().getPluginManager().registerCommand(this, new Pay());
        getProxy().getPluginManager().registerCommand(this, new Ping());
        getProxy().getPluginManager().registerCommand(this, new Report());
        getProxy().getPluginManager().registerCommand(this, new Send());
        getProxy().getPluginManager().registerCommand(this, new SetCoins());
        getProxy().getPluginManager().registerCommand(this, new SilentLobby());
        getProxy().getPluginManager().registerCommand(this, new SocialSpy());
        getProxy().getPluginManager().registerCommand(this, new TeamChat());
        getProxy().getPluginManager().registerCommand(this, new UnBan());
        getProxy().getPluginManager().registerCommand(this, new UnMute());
        getProxy().getPluginManager().registerCommand(this, new Warn());
        getProxy().getPluginManager().registerCommand(this, new Wartung());
        //MySQL
        MySQL_Connect.connect();
        MySQL_Connect.createTable();
        ScheduledExecutorService executorService;
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(ChatMSGs::run, 120, 1200, TimeUnit.SECONDS);
    }

}
