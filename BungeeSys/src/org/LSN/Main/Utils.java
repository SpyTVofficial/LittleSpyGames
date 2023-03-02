package org.LSN.Main;

import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.ArrayList;

public class Utils {

    public static String prefix = "§8[§cSystem§8] ";
    public static String rpprefix = "§8[§4§lReports§r§8] ";
    public static String tcprefix = "§8[§b§lTeamChat§r§8] ";
    public static String acprefix = "§8[§4§lAdminChat§r§8] ";
    public static String noperms = "§8[§cSystem§8] §cKeine Rechte!";

    public static boolean maintenance = false;

    public static ArrayList<ProxiedPlayer> report_logged_in = new ArrayList<>();
    public static ArrayList<ProxiedPlayer> teamchat_logged_in = new ArrayList<>();
    public static ArrayList<ProxiedPlayer> admins = new ArrayList<>();
    public static ArrayList<ProxiedPlayer> socialspy = new ArrayList<>();
}
