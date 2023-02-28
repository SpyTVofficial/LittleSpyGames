package org.LSN.Commands;

import org.LSN.GameHandler.GameEnd;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DebugSTOPCMD implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		GameEnd.stopGame();
		return false;
	}

}
