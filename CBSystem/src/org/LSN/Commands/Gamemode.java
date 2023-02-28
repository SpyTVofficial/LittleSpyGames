package org.LSN.Commands;

import org.LSN.Main.Utils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(p.hasPermission("System.Gamemode")){
            if(args.length == 0){
                p.sendMessage("§cBenutzung: /gm <0/1/2/3> (<Spieler>)");
            } else if(args.length == 1){
                if(args[0].equals("0")){
                    p.sendMessage("§bSpielmodus zu §aSurvival §bgewechselt!");
                    p.setGameMode(GameMode.SURVIVAL);
                } else if(args[0].equals("1")){
                    p.sendMessage("§bSpielmodus zu §aCreative §bgewechselt!");
                    p.setGameMode(GameMode.CREATIVE);
                } else if(args[0].equals("2")){
                    p.sendMessage("§bSpielmodus zu §aAdventure §bgewechselt!");
                    p.setGameMode(GameMode.ADVENTURE);
                } else if(args[0].equals("3")){
                    p.sendMessage("§bSpielmodsu zu §aSpectator §bgewechselt!");
                    p.setGameMode(GameMode.SPECTATOR);
                }
            } else if(args.length == 2){
                if(p.hasPermission("System.Gamemode.Others")) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        if (args[0].equals("0")) {
                            p.sendMessage("§bSpielmodus von §a" + target.toString() + " zu §aSurvival §bgewechselt!");
                            target.sendMessage("§bDein Spielmodus wurde von §a" + p.getDisplayName() + " §b zu §aSurvival §bgewechselt!");
                            target.setGameMode(GameMode.SURVIVAL);
                        } else if (args[0].equals("1")) {
                            p.sendMessage("§bSpielmodus von §a" + target.toString() + "  zu §aCreative §bgewechselt!");
                            target.sendMessage("§bDein Spielmodus wurde von §a" + p.getDisplayName() + " §b zu §aCreative §bgewechselt!");
                            target.setGameMode(GameMode.CREATIVE);
                        } else if (args[0].equals("2")) {
                            p.sendMessage("§bSpielmodus von §a" + target.toString() + "  zu §aAdventure §bgewechselt!");
                            target.sendMessage("§bDein Spielmodus wurde von §a" + p.getDisplayName() + " §b zu §aAdventure §bgewechselt!");
                            target.setGameMode(GameMode.ADVENTURE);
                        } else if (args[0].equals("3")) {
                            p.sendMessage("§bSpielmodsu von §a" + target.toString() + "  zu §aSpectator §bgewechselt!");
                            target.sendMessage("§bDein Spielmodus wurde von §a" + p.getDisplayName() + " §b zu §aSpectator §bgewechselt!");
                            target.setGameMode(GameMode.SPECTATOR);
                        }
                    }
                } else {
                    p.sendMessage(Utils.noperms);
                }
            }
        } else {
            p.sendMessage(Utils.noperms);
        }
        return false;
    }
}
