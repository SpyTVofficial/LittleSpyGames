package org.LSN.Commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import org.LSN.Main.Utils;

public class Hub extends Command {

    public Hub() {
        super("hub");
    }

    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer) sender;
        p.sendMessage(Utils.prefix + "§aTeleportiere zur Lobby...");
        p.connect(ProxyServer.getInstance().getServerInfo("Lobby"));
    }

}
