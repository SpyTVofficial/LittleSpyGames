package org.LSN.Commands;

import org.LSN.Utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoSmelt implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player p = (Player) sender;
        if(args.length == 0) {
            if (!Utils.autosmelt.contains(p)) {
                p.sendMessage(Utils.prefix + "§bAutoSmelt ist §cdeaktiviert!");
            } else {
                p.sendMessage(Utils.prefix + "§bAutoSmelt ist §aaktiviert!");
            }
        } else if(args.length == 1){
            if (args[0].equalsIgnoreCase("an")){
                if(!Utils.autosmelt.contains(p)){
                    Utils.autosmelt.add(p);
                    p.sendMessage(Utils.prefix + "§bAutoSmelt ist nun §aaktiviert!");
                } else {
                    p.sendMessage(Utils.prefix + "§bAutoSmelt ist bereits §aaktiviert!");
                }
            } else if(args[0].equalsIgnoreCase("aus")){
                if(Utils.autosmelt.contains(p)){
                    if(!Utils.autosmelt.contains(p)){
                        Utils.autosmelt.remove(p);
                        p.sendMessage(Utils.prefix + "§bAutoSmelt ist nun §cdeaktiviert!");
                    } else {
                        p.sendMessage(Utils.prefix + "§bAutoSmelt ist bereits §cdeaktiviert!");
                    }
                }
            }
        }
        return false;
    }
}
