package org.LSN.Listener;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import org.LSN.Main.Utils;
import org.LSN.MySQL.MySQL_Connect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.UUID;

public class PostLogin implements Listener {

    private String query;
    private String query1;

    @EventHandler
    public void onConnect(PostLoginEvent e) {
        ProxiedPlayer p = e.getPlayer();
        if (Utils.maintenance && !p.hasPermission("System.Wartung.Bypass"))
            p.disconnect("§b§lLittle§f§lSpy§c§lGames§r\n\n§cDer Server befindet sich aktuell im Wartungsmodus!");
        String uuid = p.getUUID().toString();
        UUID uniqueId = p.getUniqueId();
        String name = p.getDisplayName().toString();
        if(MySQL_Connect.isBanned(name)){
            p.disconnect("§b§lLittle§f§lSpy§c§lGames§r\n\n§cDu bist aktuell vom Netzwerk gebannt!");
        }
        if(!MySQL_Connect.ifPlayerExist(uuid)) {
            query = MessageFormat.format("INSERT INTO users(coins, name, UUID) VALUES ('15000' ,\"{0}\", \"{1}\");", name, uuid);
            try {
                MySQL_Connect.con.createStatement().executeUpdate(query);
                try {
                    String sql1 = MessageFormat.format("SELECT id FROM users WHERE name= \"{0}\"", p.getDisplayName().toString());
                    ResultSet r1 = MySQL_Connect.query(sql1);
                    if (r1 != null && r1.next()) {
                        int id = r1.getInt("id");
                        query1 = MessageFormat.format("INSERT INTO loggedin(id, name, UUID) VALUES (\"{0}\" ,\"{1}\", \"{2}\");", id, p.getDisplayName().toString(), uuid.toString());
                        MySQL_Connect.con.createStatement().executeUpdate(query1);
                    }
                } catch (SQLException ex1){
                    ex1.printStackTrace();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if(MySQL_Connect.ifPlayerExist(uuid)) {
            try {
                String sql1 = MessageFormat.format("SELECT id FROM users WHERE name= \"{0}\"", p.getDisplayName().toString());
                ResultSet r1 = MySQL_Connect.query(sql1);
                if (r1 != null && r1.next()) {
                    int id = r1.getInt("id");
                    query1 = MessageFormat.format("INSERT INTO loggedin(id, name, UUID) VALUES (\"{0}\" ,\"{1}\", \"{2}\");", id, p.getDisplayName().toString(), uuid.toString());
                    MySQL_Connect.con.createStatement().executeUpdate(query1);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (Utils.maintenance == true) {
            if (!p.hasPermission("System.Wartung.Bypass")) {
                p.disconnect("§b§lLittle§f§lSpy§c§lNetwork§r\n\n§cDer Server befindet sich aktuell im Wartungsmodus!");
            }
        }
        p.setTabHeader(new TextComponent("§c§lLittle§f§lSpy§b§lGames\n§e§lAlpha Netzwerk"),
                new TextComponent("§aSpieler Online: §a" + BungeeCord.getInstance().getOnlineCount() + "§a/100 \n§bAktueller Server: 3a" + p.getServer().toString()));
    }

    @EventHandler
    public void onQuit(PlayerDisconnectEvent e){
        ProxiedPlayer p = e.getPlayer();
        try {
            String sql1 = MessageFormat.format("SELECT id FROM users WHERE name= \"{0}\";", p.getDisplayName().toString());
            ResultSet r1 = MySQL_Connect.query(sql1);
            if (r1 != null && r1.next()) {
                int id = r1.getInt("id");
                query1 = MessageFormat.format("DELETE FROM loggedin WHERE name= \"{0}\";", p.getDisplayName().toString());
                MySQL_Connect.con.createStatement().executeUpdate(query1);
            }
        } catch (SQLException ex1){
            ex1.printStackTrace();
        }
    }
}
