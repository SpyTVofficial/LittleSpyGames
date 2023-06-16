package org.LSN.Commands;

import org.LSN.Utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoSell implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player p = (Player) sender;
        if(args.length == 0) {
            if (!Utils.autosell.contains(p)) {
                p.sendMessage(Utils.prefix + "§bAutoSell ist §cdeaktiviert!");
            } else {
                p.sendMessage(Utils.prefix + "§bAutoSell ist §aaktiviert!");
            }
        } else if(args.length == 1){
            if (args[0].equalsIgnoreCase("an")){
                if(!Utils.autosell.contains(p)){
                    Utils.autosell.add(p);
                    p.sendMessage(Utils.prefix + "§bAutoSell ist nun §aaktiviert!");
                } else {
                    p.sendMessage(Utils.prefix + "§bAUtoSell ist bereits §aaktiviert!");
                }
            } else if(args[0].equalsIgnoreCase("aus")){
                if(Utils.autosell.contains(p)){
                    if(!Utils.autosell.contains(p)){
                        Utils.autosell.remove(p);
                        p.sendMessage(Utils.prefix + "§bAutoSell ist nun §cdeaktiviert!");
                    } else {
                        p.sendMessage(Utils.prefix + "§bAUtoSell ist bereits §cdeaktiviert!");
                    }
                }
            }
        }
        return false;
    }
}
