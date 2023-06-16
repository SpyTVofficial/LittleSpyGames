package org.LSN.Listeners;

import org.LSN.MySQL.MySQL;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.UUID;

public class JoinQuit implements Listener {

    private String query;
    private String query1;

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        String uuid = p.getUniqueId().toString();
        UUID uniqueId = p.getUniqueId();
        String name = p.getDisplayName().toString();
        e.setJoinMessage("§8[§a+§8] §7" + p.getDisplayName());
        if(!MySQL.ifPlayerExist(uuid)) {
            query = MessageFormat.format("INSERT INTO users(coins, name, UUID) VALUES ('15000' ,\"{0}\", \"{1}\");", name, uuid);
            try {
                MySQL.con.createStatement().executeUpdate(query);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.setQuitMessage("§8[§c-§8] §7" + p.getDisplayName());
    }

}
