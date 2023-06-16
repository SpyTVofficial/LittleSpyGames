package org.LSN.AdminCommands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import org.LSN.Main.Utils;

public class TeamChat extends Command {

    public TeamChat() {
        super("tc");
    }

    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer)sender;
        if (p.hasPermission("System.Teamchat")) {
            if (args.length == 0) {
                p.sendMessage(Utils.prefix + "§cBenutzung: /tc <login|logout> | <Nachricht>");
            } else if(args.length >= 1) {
                StringBuilder message = new StringBuilder();
                for (int i = 0; i < args.length; i++) {
                    message.append(args[i]).append(" ");
                }
                if(args.length == 1){
                    if (args[0].equalsIgnoreCase("login")) {
                        if (!Utils.teamchat_logged_in.contains(p)) {
                            p.sendMessage(Utils.tcprefix + "§aErfolgreich eingeloggt!");
                            Utils.teamchat_logged_in.add(p);
                            for (ProxiedPlayer team : ProxyServer.getInstance().getPlayers()) {
                                if (Utils.teamchat_logged_in.contains(team)) {
                                    team.sendMessage(Utils.tcprefix + "§b" + p.getDisplayName() + "§b ist nun §aonline§b!");
                                }
                            }
                        } else {
                            p.sendMessage(Utils.tcprefix + "§cDu bist bereits eingeloggt!");
                        }
                    } else if (args[0].equalsIgnoreCase("logout")) {
                        if (Utils.teamchat_logged_in.contains(p)) {
                            p.sendMessage(Utils.tcprefix + "§cErfolgreich ausgeloggt!");
                            Utils.teamchat_logged_in.remove(p);
                            for (ProxiedPlayer team : ProxyServer.getInstance().getPlayers()) {
                                if (Utils.teamchat_logged_in.contains(team)) {
                                    team.sendMessage(Utils.tcprefix + "§b" + p.getDisplayName() + "§b ist nun §boffline§b!");
                                }
                            }
                        } else {
                            p.sendMessage(Utils.tcprefix + "§cDu musst du zuerst eingeloggt sein!");
                        }
                    }
                }
                if (Utils.teamchat_logged_in.contains(p)) {
                    for (ProxiedPlayer team : ProxyServer.getInstance().getPlayers()) {
                        if (Utils.teamchat_logged_in.contains(team)) {
                            if (args[0].equalsIgnoreCase("login")) {
                                break;
                            }
                            team.sendMessage(Utils.tcprefix + "§b" + p.getDisplayName() + "§b: " + message.toString());
                        }
                    }
                } else {
                    p.sendMessage(Utils.tcprefix + "§cDazu musst du eingeloggt sein!");
                }
            }
        } else {
            p.sendMessage(Utils.noperms);
        }
    }
}
