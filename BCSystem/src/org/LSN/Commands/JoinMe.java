package org.LSN.Commands;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import org.LSN.Main.Utils;


public class JoinMe extends Command {
    public JoinMe(){
        super("joinme");
    }
    public void execute(CommandSender sender, String[] args){
        ProxiedPlayer p = (ProxiedPlayer) sender;
        if(p.hasPermission("System.JoinMe")){
            if(args.length == 0){
                TextComponent msg = new TextComponent(String.valueOf("§bKlicke hier zum Joinen"));
                msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder("§bKlicke um den Server zu Joinen")).create()));
                msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "goto5734893745 " + p.getServer().getInfo().getName()));
                BungeeCord.getInstance().broadcast("§8====================================");
                BungeeCord.getInstance().broadcast("");
                BungeeCord.getInstance().broadcast("§bSpieler §a" + ((ProxiedPlayer) sender).getDisplayName() + " §bspielt auf Server §a " + p.getServer().getInfo().getName());
                BungeeCord.getInstance().broadcast("");
                BungeeCord.getInstance().broadcast((BaseComponent) msg);
                BungeeCord.getInstance().broadcast("");
                BungeeCord.getInstance().broadcast("§8====================================");
            } else {
                p.sendMessage(Utils.prefix + "§cBenutzung: §c/joinme");
            }
        } else {
            p.sendMessage(Utils.noperms);
        }
    }
}
