package org.LSN.Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.w3c.dom.ranges.Range;

public class SetScoreboard implements Listener {

    public static void setBoard(Player p){
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("aaa", "bbb");

        obj.setDisplayName("§c§lLittle§f§lSpy§b§lGames");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score server = obj.getScore("§7Server:");
        Score pServer = obj.getScore("§6» Lobby");
        Score spacer01 = obj.getScore("");

        Score rang = obj.getScore("§7Rang:");
        if(p.hasPermission("Rang.Leitung")){
            Score getRang = obj.getScore("§8» §4§lLeitung");
            getRang.setScore(7);
        } else if(p.hasPermission("Rang.Admin")){
            Score getRang = obj.getScore("§8» §4§lAdministrator");
            getRang.setScore(7);
        } else if(p.hasPermission("Rang.Moderator")){
            Score getRang = obj.getScore("§8» §2§lModerator");
            getRang.setScore(7);
        } else if(p.hasPermission("Rang.Supporter")){
            Score getRang = obj.getScore("§8» §bSuppoter");
            getRang.setScore(7);
        } else if(p.hasPermission("Rang.Spion")){
            Score getRang = obj.getScore("§8» §bSpion");
            getRang.setScore(7);
        } else if(p.hasPermission("Rang.MVP")){
            Score getRang = obj.getScore("§8» §5MVP");
            getRang.setScore(7);
        } else if(p.hasPermission("Rang.VIP")){
            Score getRang = obj.getScore("§8» §6VIP");
            getRang.setScore(7);
        } else {
            Score getRang = obj.getScore("§8» §7Spieler");
            getRang.setScore(7);
        }

        Score spacer02 = obj.getScore("");
        Score dc = obj.getScore("§7Discord:");
        Score dclink = obj.getScore("§6» discord.littlespynetwork.tk");
        Score spacer03 = obj.getScore("");
        Score name = obj.getScore("§7Name:");
        Score pname = obj.getScore("§6» " + p.getDisplayName());


        server.setScore(11);
        pServer.setScore(10);
        spacer01.setScore(9);
        rang.setScore(8);
        spacer02.setScore(6);
        dc.setScore(5);
        dclink.setScore(4);
        spacer03.setScore(3);
        name.setScore(2);
        pname.setScore(1);

        p.setScoreboard(board);
    }

}
