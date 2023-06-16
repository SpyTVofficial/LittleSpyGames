package org.LSN.AdminCommands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import org.LSN.Main.Utils;

public class Send extends Command {

    public Send() {
        super("send");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer) sender;
        if(p.hasPermission("System.Send")){
            if(args.length == 2){
                String targetname = args[0];
                ProxiedPlayer target = ProxyServer.getInstance().getPlayer(targetname);
                if(target != null){
                    p.sendMessage(Utils.prefix + "§bDu hast den Spieler §a" + target.getName() + " §bzu Server §a" + args[1] + " §bgesendet!");
                    target.connect(ProxyServer.getInstance().getServerInfo(args[1]));
                    target.sendMessage(Utils.prefix + "§bDu wurdest von §a" + p.getName() + "§b zu Server §a" + args[1] + " §bgesendet!" );
                } else {
                    p.sendMessage(Utils.prefix + "§aDer Spieler §a" + args[0] + " §cist nicht online!");
                }
            } else {
                p.sendMessage(Utils.prefix + "§cBenutzung: /send <Spieler> <Server>");
            }
        } else {
            p.sendMessage(Utils.noperms);
        }
    }
}
