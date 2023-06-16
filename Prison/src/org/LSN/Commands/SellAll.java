package org.LSN.Commands;

import org.LSN.Utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SellAll implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player p = (Player) sender;
        if(args.length == 0){
            p.sendMessage(Utils.prefix + "§bDu hast §aerfolgreich §balles verkauft!");
        }
        return false;
    }
}
