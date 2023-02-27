package org.LSN.AdminCommands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import org.LSN.Main.Utils;
import org.LSN.MySQL.MySQL_Connect;

public class UnMute extends Command {

    public UnMute() {
        super("unmute");
    }

    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission("System.UnMute")) {
            String targetname = args[0];
            ProxiedPlayer target = ProxyServer.getInstance().getPlayer(targetname);
            if (target.getDisplayName() != sender.getName()) {
                if (args.length == 1) {
                    if (MySQL_Connect.isMuted(targetname)) {
                        MySQL_Connect.unmute(targetname);
                        sender.sendMessage(Utils.prefix + "§aSpieler erfolgreich entmuted!");
                    } else {
                        sender.sendMessage(Utils.prefix + "§cSpieler ist nicht entmuted!");
                    }
                } else {
                    sender.sendMessage("§cBenutzung: /unban <Spieler>");
                }
            } else {
                sender.sendMessage(Utils.prefix + "§cDu kannst dich nicht selber muten!");
            }
        } else {
            sender.sendMessage(Utils.noperms);
        }
    }
}
