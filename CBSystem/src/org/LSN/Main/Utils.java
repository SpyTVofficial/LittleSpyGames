package org.LSN.Main;


import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Utils {

    public static ItemStack createItem(Material mat, int anzahl, int shortid, String Name) {
        short s = (short) shortid;
        ItemStack i = new ItemStack(mat, anzahl, s);
        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(Name);
        i.setItemMeta(meta);
        return i;
    }

    public static String noperms = "§8[§cSystem§8] §cKeine Rechte!";

    public static String prefix = "§8[§cSystem§8] ";


}
