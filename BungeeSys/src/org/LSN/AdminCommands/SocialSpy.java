package org.LSN.AdminCommands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import org.LSN.Main.Utils;

public class SocialSpy extends Command {

    public SocialSpy() {
        super("socialspy");
    }

    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer) sender;
        if(p.hasPermission("System.SocialSpy")){
            if(args[0].equalsIgnoreCase("an")){
                if(!Utils.socialspy.contains(p)){
                    Utils.socialspy.add(p);
                    p.sendMessage(Utils.prefix + "§aDu liest nun alle Nachrichten der Spieler mit!");
                } else {
                    p.sendMessage(Utils.prefix + "§cSocialSpy ist bereits aktiviert!");
                }
            } else if(args[0].equalsIgnoreCase("aus")){
                if(Utils.socialspy.contains(p)){
                    Utils.socialspy.remove(p);
                    p.sendMessage(Utils.prefix + "§cDu liest die Nachrichten nun nicht mehr mit!");
                }
            } else {
                p.sendMessage(Utils.prefix + "§cBenutzung: /socialspy <an/aus>");
            }
        } else {
            p.sendMessage(Utils.noperms);
        }
    }

}
