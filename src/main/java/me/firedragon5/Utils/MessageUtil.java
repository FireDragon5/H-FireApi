package me.firedragon5.Utils;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.io.PacketHandler;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.util.EventTitleUtil;
import com.hypixel.hytale.server.core.util.NotificationUtil;

import javax.annotation.Nonnull;
import java.awt.*;

public class MessageUtil {

    public static void sendMessage(PlayerRef player, String message) {
        player.sendMessage(Message.raw(message));
    }

    public static void sendMessage(PlayerRef player, String message, Color colour) {
        player.sendMessage(Message.raw(message).color(colour));
    }

    public static void chatFormatter(@Nonnull PlayerRef player,
                              @Nonnull String playerName,
                              @Nonnull String message,
                              @Nonnull String prefix,
                              @Nonnull String suffix) {


       Message joinMessage = Message.join(
                Message.raw(prefix),
                Message.raw(playerName),
                Message.raw(suffix),
                Message.raw(" : " + message)
        );

        player.sendMessage(joinMessage);
    }

    public static void showTitleToPlayer(PlayerRef player,
                                  String mainMessage,
                                  String subMessage, Boolean isMajor) {

        EventTitleUtil.showEventTitleToPlayer(player,
                Message.raw(mainMessage),
                Message.raw(subMessage),
                isMajor);
    }

    public static void showNotification(PlayerRef player, String message, String subMessage, String icon){

        PacketHandler packetHandler = player.getPacketHandler();

        NotificationUtil.sendNotification(
                packetHandler,
                Message.raw(message),
                Message.raw(subMessage),
                icon);
    }
}
