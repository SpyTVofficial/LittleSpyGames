package org.LSN.AdminCommands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import org.LSN.Main.Utils;
import org.LSN.MySQL.MySQL_Connect;

import java.sql.SQLException;
import java.text.MessageFormat;

public class Mute extends Command implements Listener {

    public Mute() {
        super("mute");
    }

    @EventHandler
    public void onPlayerChat(ChatEvent event) {
        ProxiedPlayer p = (ProxiedPlayer) event.getSender();
        String targetname = p.getDisplayName();
        if (MySQL_Connect.isMuted(targetname) && !event.getMessage().startsWith("/")) {
            event.setCancelled(true);
            p.sendMessage(Utils.prefix + "§cDu bist aktuell gemuted!");
        }
    }


    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission("System.Mute")) {
            String targetname = args[0];
            ProxiedPlayer target = ProxyServer.getInstance().getPlayer(targetname);
            if (args.length == 1) {
                if (!MySQL_Connect.isMuted(targetname)) {
                    try {
                        String noreason = "none";
                        String sql = MessageFormat.format("INSERT INTO muted (name, admin, reason) VALUES (\"{0}\", \"{1}\", \"{2}\");", target.getDisplayName().toString(), sender.getName(), noreason);
                        MySQL_Connect.con.createStatement().executeUpdate(sql);
                        sender.sendMessage(Utils.prefix + "§aSpieler erfolgreich gemuted!");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    sender.sendMessage(Utils.prefix + "§cSpieler ist bereits gemuted!");
                }
            } else if(args.length == 2){
                if (!MySQL_Connect.isMuted(targetname)) {
                    try {
                        String reason = "";
                        for (int i = 1; i < args.length; i++)
                            reason = reason + args[i] + " ";
                        String sql = MessageFormat.format("INSERT INTO muted (name, admin, reason) VALUES (\"{0}\", \"{1}\", \"{2}\");", target.getDisplayName().toString(), sender.getName(), reason);
                        MySQL_Connect.con.createStatement().executeUpdate(sql);
                        sender.sendMessage(Utils.prefix + "§aSpieler erfolgreich gemuted!");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    sender.sendMessage(Utils.prefix + "§cSpieler ist bereits gemuted!");
                }
            } else {
                sender.sendMessage("§cBenutzung: /mute <Spieler> (<Grund>)");
            }
        }
        sender.sendMessage(Utils.noperms);
    }
}
