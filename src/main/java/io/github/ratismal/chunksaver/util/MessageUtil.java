package io.github.ratismal.chunksaver.util;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageUtil {

    public static void sendMessageToAllPlayers(String message) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage(getMessage(message));
        }
    }

    public static void sendMessageToAllPlayers(String message, String permission) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.hasPermission(permission)) {
                p.sendMessage(getMessage(message));
            }
        }
    }

    public static void sendMessage(CommandSender sender, String message) {
        if (null != sender) {
            sender.sendMessage(getMessage(message));
        }
    }

    public static String getMessage(String message) {
        return new StringBuilder().append("\247a[\247bChunkSaver\247a]\247d ").append(message).toString();
    }
}
