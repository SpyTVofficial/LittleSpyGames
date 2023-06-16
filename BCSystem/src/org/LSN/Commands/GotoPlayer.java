package org.LSN.Commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class GotoPlayer extends Command {

    public GotoPlayer() {
        super("goto5734893745");
    }

    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            String server = args[0];
            ProxiedPlayer p = (ProxiedPlayer)sender;
            ServerInfo info = ProxyServer.getInstance().getServerInfo(server);
            p.connect(info);
        }
    }
}
