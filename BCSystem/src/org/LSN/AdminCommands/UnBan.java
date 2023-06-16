package org.LSN.AdminCommands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import org.LSN.Main.Utils;
import org.LSN.MySQL.MySQL_Connect;

import java.sql.SQLException;
import java.text.MessageFormat;

public class UnBan extends Command {

    public UnBan() {
        super("unban");
    }

    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission("System.UnBan")) {
            String targetname = args[0];
            ProxiedPlayer target = ProxyServer.getInstance().getPlayer(targetname);
            if (args.length == 1) {
                if (MySQL_Connect.isBanned(targetname)) {
                    MySQL_Connect.unban(targetname);
                    sender.sendMessage(Utils.prefix + "§aSpieler erfolgreich entbannt!");
                } else {
                    sender.sendMessage(Utils.prefix + "§cSpieler ist nicht gebannt!");
                }
            } else {
                sender.sendMessage("§cBenutzung: /unban <Spieler>");
            }
        }
        sender.sendMessage(Utils.noperms);
    }
}
