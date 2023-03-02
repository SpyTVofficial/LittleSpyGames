package org.LSN.AdminCommands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import org.LSN.Main.Utils;

public class AdminChat extends Command {

    public AdminChat() {
        super("ac");
    }

    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer)sender;
        if (p.hasPermission("System.AdminChat")) {
            if (args.length == 0) {
                p.sendMessage(Utils.prefix + "§cBenutzung: /ac <Nachricht>");
            } else if(args.length >= 1) {
                StringBuilder message = new StringBuilder();
                for (int i = 0; i < args.length; i++) {
                    message.append(args[i]).append(" ");
                }
                for (ProxiedPlayer team : ProxyServer.getInstance().getPlayers()) {
                    if (team.hasPermission("System.AdminChat")) {
                        team.sendMessage(Utils.acprefix + "§b" + p.getDisplayName() + "§b: " + message.toString());
                    }
                }
            }
        } else {
            p.sendMessage(Utils.noperms);
        }
    }
}
