package org.LSN.Commands;

import org.LSN.Main.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChat implements CommandExecutor {

       public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
            Player p = (Player) sender;
            if (p.hasPermission("System.ClearChat")) {
                if(args.length == 0){
                    for (Player players : Bukkit.getOnlinePlayers()){
                        for (int i = 0 ; i < 200; i++){
                            players.sendMessage(" ");
                        }
                        players.sendMessage("§bDer Chat wurde von §a" + p.getDisplayName() + "§b geleert!");
                    }
                } else {
                    p.sendMessage("§cBenutzung: /clearchat");
                }
            } else {
                p.sendMessage(Utils.noperms);
            }
        return false;
        }
}
