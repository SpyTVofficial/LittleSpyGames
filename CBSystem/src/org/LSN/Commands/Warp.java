package org.LSN.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Warp implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(args.length == 1){
            if(args[0].toString().equalsIgnoreCase("spawn")){
                Location spawn = new Location(Bukkit.getWorld("world"), 0.5D, 60D, 0.5D);
                p.teleport(spawn);
                p.sendMessage("§bTeleportiere zu §aSpawn§b...");
            } else if(args[0].toString().equalsIgnoreCase("")){
                Location idk2 = new Location(Bukkit.getWorld("world"), 0.5D, 60D, 0.5D);
            }
        } else {
            p.sendMessage("§cBenutzung: /warp <Spawn/.../...>");
        }
        return false;
    }

}
