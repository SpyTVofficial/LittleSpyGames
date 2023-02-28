package org.LSN.Commands;

import org.LSN.Main.Main;
import org.LSN.Settings.General;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CrimeChatCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(General.Crim.contains(p)) {
            if(General.CrimeChat.contains(p)) {
               General.CrimeChat.remove(p);
            } else {
                General.CrimeChat.add(p);
            }
        } else {
            p.sendMessage(Main.prefix + "§cDu musst ein Crime sein!");
        }
        return false;
    }



}
