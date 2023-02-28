package org.LSN.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatsCMD implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		p.sendMessage("�b�l------------------------------");
		p.sendMessage("");
		p.sendMessage("Karma: ");
		p.sendMessage("Rank: ");
		p.sendMessage("Gewonnene Runden: ");
		p.sendMessage("Verlorene Runden: ");
		p.sendMessage("Kills: ");
		p.sendMessage("Falsche Kills: ");
		p.sendMessage("");
		p.sendMessage("�b�l------------------------------");

		return false;
	}

}
