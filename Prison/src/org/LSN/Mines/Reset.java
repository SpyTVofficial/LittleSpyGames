package org.LSN.Mines;

import org.LSN.Utils.Utils;
import org.bukkit.entity.Player;

public class Reset {

    public static void reset(){
        Player p = null;
        p.sendMessage(Utils.prefix + "§aAlle Minen werden resettet...");
    }

    public static void resetAll(){
        Player p = null;
        p.sendMessage(Utils.prefix + "§aMine " + null + " wird resettet...");
    }
}
