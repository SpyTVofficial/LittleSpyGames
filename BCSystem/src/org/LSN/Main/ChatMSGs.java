package org.LSN.Main;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ChatMSGs {

    public static void run() {
        for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
            p.sendMessage("§bBesuche doch mal unseren Partner: §e§lByte-Hosting.eu");
        }
    }

}