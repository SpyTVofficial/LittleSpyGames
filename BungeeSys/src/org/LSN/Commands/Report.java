package org.LSN.Commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import org.LSN.Main.Utils;
import org.LSN.MySQL.MySQL_Connect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import static org.LSN.MySQL.MySQL_Connect.query;

public class Report extends Command {

    public Report() {
        super("report");
    }

    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer) sender;
        if (args.length == 0) {
            p.sendMessage(Utils.rpprefix + "§cBenutzung: /report <Spieler> <Grund>");
        } else if (args.length == 1) {
            if (p.hasPermission("System.Reports"))
                if (args[0].equalsIgnoreCase("login")) {
                    if (!Utils.report_logged_in.contains(p)) {
                        p.sendMessage(Utils.rpprefix + "§aErfolgreich eingeloggt!");
                                Utils.report_logged_in.add(p);
                    } else {
                        p.sendMessage(Utils.rpprefix + "§cDu bist bereits eingeloggt!");
                    }
                } else if (args[0].equalsIgnoreCase("logout")) {
                    if (Utils.report_logged_in.contains(p)) {
                        p.sendMessage(Utils.rpprefix + "§cErfolgreich ausgeloggt!");
                        Utils.report_logged_in.remove(p);
                    } else {
                        p.sendMessage(Utils.rpprefix + "§cDu musst du zuerst eingeloggt sein!");
                    }
                } else {
                    p.sendMessage(Utils.noperms);
                }
        } else if (args.length == 2) {
            String target = args[0];
            String reason = args[1];
            if (ProxyServer.getInstance().getPlayer(target) != null) {
                if (sender.getName() != target) {
                    for (ProxiedPlayer team : ProxyServer.getInstance().getPlayers()) {
                        if (Utils.report_logged_in.contains(team)) {
                            team.sendMessage("");
                            team.sendMessage("§cNeuer Report");
                            team.sendMessage("§7von: §a" + p.getDisplayName());
                            team.sendMessage("§7Spieler: §a" + target.toString());
                            team.sendMessage("§7Grund: §a" + reason);
                            TextComponent gotoreport = new TextComponent("§7Klicke um zum Spieler teleporteren");
                            gotoreport.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/goto " + target));
                            team.sendMessage((BaseComponent) gotoreport);
                            team.sendMessage("");
                        }
                    }
                    p.sendMessage(Utils.rpprefix + "§7Danke für deine Hilfe! Dein Report wurde erfolgreich ans Team gesendet!");
                    try {
                        query = MessageFormat.format("INSERT INTO reports(von, spieler, grund) VALUES (\"{0}\" ,\"{1}\", \"{2}\");", p.getDisplayName(), target, reason);
                        MySQL_Connect.con.createStatement().executeUpdate(query);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    sender.sendMessage(Utils.rpprefix + "§cDu kannst dich nicht selber reporten!");
                }
            } else {
                p.sendMessage(Utils.rpprefix + "§cSpieler ist nicht online!");
            }
        }
    }
}
