package org.LSN.Commands;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import org.LSN.MySQL.MySQL_Connect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

public class Pay extends Command {

    public Pay() {
        super("pay");
    }

    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer) sender;
        if (args.length == 2) {
            ProxiedPlayer t = BungeeCord.getInstance().getPlayer(args[0]);
            int amount = Integer.parseInt(args[1]);
            if (t != null) {
                if(p.getDisplayName() != t.getDisplayName()) {
                    try {
                        String sql = MessageFormat.format("SELECT coins FROM users WHERE name=\"{0}\"", p.getDisplayName());
                        ResultSet r = MySQL_Connect.query(sql);
                        if (r.next()) {
                            int coinsamount = r.getInt("coins");
                            if (coinsamount >= amount) {
                                String sql1 = MessageFormat.format("UPDATE 'users' SET 'coins' = \"{0}\" WHERE 'users'.'name'=\"{1}\"", coinsamount - amount, p.getDisplayName());
                                ResultSet r1 = MySQL_Connect.update(sql1);
                                String sql2 = MessageFormat.format("UPDATE 'users' SET 'coins' = \"{0}\" WHERE 'users'.'name'=\"{1}\"", coinsamount + amount, t.getDisplayName());
                                ResultSet r2 = MySQL_Connect.update(sql2);
                                String sql3 = MessageFormat.format("INSERT INTO paylog (player, target, amount) VALUES (\"{0}\" ,\"{1}\", {2});", p.getDisplayName(), t.getDisplayName().toString(), amount);
                                try {
                                    MySQL_Connect.con.createStatement().executeUpdate(sql3);
                                    p.sendMessage("§bDu hast Spieler §a" + t.getDisplayName() + " " + amount + " §bCoins gezahlt!");
                                    t.sendMessage("§bDu hast von §a" + p.getDisplayName() + " " + amount + " §berhalten!");
                                } catch (SQLException e2) {
                                    e2.printStackTrace();
                                }
                            } else {
                                p.sendMessage("§cDu hast nicht genügend Coins!");
                            }
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    p.sendMessage("§cDu kannst dir kein Geld überweisen!");
                }
            } else {
                p.sendMessage("§cSpieler ist nicht online!");
            }
        } else {
            p.sendMessage("§cBenutzung: /pay <Spieler> <Anzahl>");
        }
    }
}
