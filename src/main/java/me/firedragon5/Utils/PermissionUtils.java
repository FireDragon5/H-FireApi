package me.firedragon5.Utils;

import com.hypixel.hytale.server.core.permissions.PermissionsModule;
import com.hypixel.hytale.server.core.universe.PlayerRef;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PermissionUtils {

    /**
     * Checks if a player has a specific permission node.
     */
    public static boolean hasPermission(@Nonnull PlayerRef playerRef, @Nonnull String permission) {
        UUID uuid = playerRef.getUuid();

        return PermissionsModule.get().hasPermission(uuid, permission);
    }

    /**
     * Adds a Set of permissions to a player.
     */
    public static void addPlayerPermission(@Nonnull PlayerRef playerRef, @Nonnull Set<String> permissions) {
        UUID uuid = playerRef.getUuid();

        PermissionsModule.get().addUserPermission(uuid, permissions);
    }

    public static void addPlayerPermission(@Nonnull PlayerRef playerRef, String... permissions) {
        addPlayerPermission(playerRef, new HashSet<>(Arrays.asList(permissions)));
    }

    /**
     * Adds a Set of permissions and sends a success message to a specific target.
     *
     * @param target The person receiving the success message (e.g., the Admin who ran the command)
     * @param targetPlayer The person receiving the permissions
     * @param permissions The permissions to add
     * @param message Optional custom message. Leave null for default.
     */
    public static void addPlayerPermissionAndNotify(@Nonnull PlayerRef target,
                                                    @Nonnull PlayerRef targetPlayer,
                                                    @Nonnull Set<String> permissions,
                                                    @Nullable String message) {

        addPlayerPermission(targetPlayer, permissions);

        if (message == null || message.trim().isEmpty()) {
            message = "&aPermissions added to " + targetPlayer.getUsername();
        }

        MessageUtil.sendMessage(target, message);
    }
}
