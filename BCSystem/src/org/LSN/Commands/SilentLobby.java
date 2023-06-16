package org.LSN.Commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import org.LSN.Main.Utils;

public class SilentLobby extends Command {

    public SilentLobby() {
        super("silentlobby");
    }

    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer) sender;
        if(p.hasPermission("System.SilentLobby")){
            p.sendMessage(Utils.prefix + "§aTeleportiere zur §5Silent-Lobby§a...");
            p.connect(ProxyServer.getInstance().getServerInfo("SilentLobby"));
        }
    }
}
