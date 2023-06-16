package org.LSN.Commands;

import org.LSN.Main.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPA implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        Player t = Bukkit.getPlayer(args[0]);
        if(args.length != 1){
            p.sendMessage("§cBenutzung: /tpa <Spieler>");
        } else {
            if(t != null){
                t.sendMessage("§aSpieler §b" + p.getDisplayName() + "§a möchte sich zu dir telportieren!");
                t.sendMessage("§aNimm die Anfrage mit §b/tpaaccept §aan,");
                t.sendMessage("§aOder lehne sie mit §b/tpadeny §aab!");
                p.sendMessage("§aTeleport-Anfrage an §b" + t.getDisplayName() + "§a gesendet!");
            } else {
                p.sendMessage(Utils.prefix + "§cSpieler existiert nicht oder ist nicht online!");
            }
        }
        return false;
    }
}
