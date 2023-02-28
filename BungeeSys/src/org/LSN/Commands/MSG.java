package org.LSN.Commands;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import org.LSN.Main.Utils;

public class MSG extends Command {

    public MSG() {
        super("msg");
    }

    public void execute(CommandSender sender, String[] args) {
        if (args.length >= 2) {
            ProxiedPlayer target = BungeeCord.getInstance().getPlayer(args[0]);
            if (target != null) {
                StringBuilder message = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    message.append(args[i]).append(" ");
                }
                TextComponent messageComponent = new TextComponent("§8[§6Du -> " + target.getName() + "§8]: §6 " + message.toString());
                sender.sendMessage(new TextComponent("§8[§6Du -> " + target.getName() + "§8]: §6" + message.toString()));
                target.sendMessage(new TextComponent("§8[§6" + sender.getName() + " -> Dir§8]: §6" + message.toString()));
                for (ProxiedPlayer team : ProxyServer.getInstance().getPlayers()) {
                    if(Utils.socialspy.contains(team)){
                        team.sendMessage("§8[§cSocialSpy§8] §a" + sender.getName() + "§6 -> §a" + target.getName() + " §6: " + message.toString());
                    }
                }
            } else {
                sender.sendMessage(new TextComponent(Utils.prefix + "§cSpieler nicht gefunden!"));
            }
        } else {
            sender.sendMessage(new TextComponent(Utils.prefix + "§cBenutzung: /msg <Spieler> <Nachricht>"));
        }
    }
}
