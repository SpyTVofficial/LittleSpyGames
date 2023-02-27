package org.LSN.AdminCommands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import org.LSN.Main.Utils;
import org.LSN.MySQL.MySQL_Connect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import static org.LSN.MySQL.MySQL_Connect.query;

public class  SetCoins extends Command {

    public SetCoins() {
        super("setcoins");
    }

    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer)sender;
//        ProxiedPlayer t = ProxyServer.getInstance().getPlayer(args[0]);
        String targetname = args[0].toString();
        ProxiedPlayer t = ProxyServer.getInstance().getPlayer(targetname);
        String amount = args[1];
        if (args.length == 2) {
            if (p.hasPermission("System.SetCoins")) {
                if(ProxyServer.getInstance().getPlayer(t.getUniqueId()).isConnected()) {
                    try {
                        String sql1 = MessageFormat.format("SELECT COINS FROM users WHERE name= \"{0}\"", t.getDisplayName().toString());
                        ResultSet r1 = MySQL_Connect.query(sql1);
                        if(r1 != null && r1.next()){
                            int coinsamount = r1.getInt("coins");
                            try {
                                String sql = MessageFormat.format("UPDATE 'users' SET 'coins' = \"{0}\" WHERE 'users'.'name'=\"{1}\"", amount, t.getDisplayName().toString());
                                ResultSet r = MySQL_Connect.update(sql);
                                String sql2 = MessageFormat.format("INSERT INTO setcoinslog (admin, spieler, oldcoins, newcoins) VALUES (\"{0}\" ,\"{1}\", {2}, {3});", p.getDisplayName(), t.getDisplayName().toString(), r1.getInt("coins"), amount);
                                try{
                                    MySQL_Connect.con.createStatement().executeUpdate(sql2);
                                    p.sendMessage("§bDu hast den Kontostand von §a" + t.getDisplayName().toString() + " §bauf §a" + amount + " §bCoins gesetzt!");
                                    t.sendMessage("§bDein Kontostand wurde von §a" + p.getDisplayName() + "§b auf §a" + amount + "§b gesetzt!");
                                } catch (SQLException e2){
                                    e2.printStackTrace();
                                }
                            } catch (SQLException e1){
                                e1.printStackTrace();
                            }
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    p.sendMessage(Utils.prefix + "§cSpieler ist nicht online!");
                }
            } else {
                p.sendMessage(Utils.noperms);
            }
        } else {
            p.sendMessage(Utils.prefix + "§cBenutzung: /setcoins <Spieler> <Anzahl>");
        }
    }
}
