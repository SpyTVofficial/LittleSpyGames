package org.LSN.Utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Utils {

    public static ArrayList<Player> autosell = new ArrayList<>();
    public static ArrayList<Player> autopickup = new ArrayList<>();
    public static ArrayList<Player> autosmelt = new ArrayList<>();


    public static String prefix = "§8[§c§lPrison§r§8] ";
    public static String noperms = "§8[§cSystem§8] §cKeine Rechte!";

    public static ItemStack createItem(Material mat, int anzahl, int shortid, String Name) {
        short s = (short) shortid;
        ItemStack i = new ItemStack(mat, anzahl, s);
        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(Name);
        i.setItemMeta(meta);
        return i;
    }

    // Worlds

    public static String world1 = "XXX";
    public static String world2 = "XXX";
    public static String world3 = "XXX";
    public static String world4 = "XXX";
    public static String world5 = "XXX";
    public static String world6 = "XXX";

    // Zones



}
