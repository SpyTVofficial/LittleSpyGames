package org.LSN.AdminCommands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import org.LSN.Main.Utils;
import org.LSN.MySQL.MySQL_Connect;

import java.sql.SQLException;
import java.text.MessageFormat;

public class Ban extends Command {

    public Ban() {
        super("ban");
    }

    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission("System.Ban")) {
            String targetname = args[0];
            ProxiedPlayer target = ProxyServer.getInstance().getPlayer(targetname);
            if (sender.getName() != target.getName()) {
                if (args.length == 1) {
                    if (!MySQL_Connect.isBanned(targetname)) {
                        String noreason = "none";
                        if (args[0].equalsIgnoreCase(target.getDisplayName())) {
                            target.disconnect((BaseComponent) new TextComponent("§b§lLittle§f§lSpy§c§lGames§r\n\n§cDu wurdest vom Netzwerk gebannt! \n\n von " + sender.getName()));
                            sender.sendMessage(Utils.prefix + "§a " + target.getDisplayName() + "§cwurde vom Netzwerk gebannt!");
                            try {
                                String sql = MessageFormat.format("INSERT INTO banned (name, admin, reason) VALUES (\"{0}\", \"{1}\", \"{2}\");", target.getDisplayName().toString(), sender.getName(), noreason);
                                MySQL_Connect.con.createStatement().executeUpdate(sql);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        } else {
                            sender.sendMessage(Utils.prefix + "§cSpieler existiert nicht, oder ist nicht online!");
                        }
                    } else {
                        sender.sendMessage(Utils.prefix + "§cSpieler ist schon gebannt!");
                    }
                } else if (args.length == 1) {
                    sender.sendMessage("§cBenutzung: /ban <Spieler> (<Grund>)");
                } else if (args.length >= 1) {
                    if (!MySQL_Connect.isBanned(targetname)) {
                        try {
                            String reason = "";
                            for (int i = 1; i < args.length; i++)
                                reason = reason + args[i] + " ";
                            String sql = MessageFormat.format("INSERT INTO banned (name, admin, reason) VALUES (\"{0}\", \"{1}\", \"{2}\");", sender.getName(), target.getDisplayName().toString(), reason);
                            target.disconnect((BaseComponent) new TextComponent("§b§lLittle§f§lSpy§c§lGames§r\n\n§cDu wurdest vom Netzwerk gebannt! \n\n §cvon §f" + sender.getName() + "\n\n §cGrund: §f" + reason));
                            sender.sendMessage("§a" + target.getDisplayName() + " §cwurde vom Netzwerk gebannt!");
                            MySQL_Connect.con.createStatement().executeUpdate(sql);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } else {
                        sender.sendMessage(Utils.prefix + "§cSpieler ist schon gebannt!");
                    }
                }
            } else {
                sender.sendMessage(Utils.prefix + "§cDu kannst dich nicht selber bannen!");
            }
        } else {
            sender.sendMessage(Utils.noperms);
        }
    }
}
