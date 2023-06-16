package org.LSN.Commands;

import org.LSN.Utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoPickup implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player p = (Player) sender;
        if(args.length == 0) {
            if (!Utils.autopickup.contains(p)) {
                p.sendMessage(Utils.prefix + "§bAutoPickup ist §cdeaktiviert!");
            } else {
                p.sendMessage(Utils.prefix + "§bAutoPickup ist §aaktiviert!");
            }
        } else if(args.length == 1){
            if (args[0].equalsIgnoreCase("an")){
                if(!Utils.autopickup.contains(p)){
                    Utils.autopickup.add(p);
                    p.sendMessage(Utils.prefix + "§bAutoPickup ist nun §aaktiviert!");
                } else {
                    p.sendMessage(Utils.prefix + "§bAutoPickup ist bereits §aaktiviert!");
                }
            } else if(args[0].equalsIgnoreCase("aus")){
                if(Utils.autopickup.contains(p)){
                    Utils.autopickup.remove(p);
                    p.sendMessage(Utils.prefix + "§bAutoPickup ist nun §cdeaktiviert!");
                } else {
                    p.sendMessage(Utils.prefix + "§bAutoPickup ist bereits §cdeaktiviert!");
                }
            }
        }
        return true;
    }
}
