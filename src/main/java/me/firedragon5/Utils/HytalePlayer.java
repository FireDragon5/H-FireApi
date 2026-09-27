package me.firedragon5.Utils;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.modules.entitystats.EntityStatMap;
import com.hypixel.hytale.server.core.modules.entitystats.asset.DefaultEntityStatTypes;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class HytalePlayer {

    private final Store<EntityStore> store;
    private final Ref<EntityStore> ref;
    private final PlayerRef playerRef;

    public UUID getUUID() {
        return playerRef.getUuid();
    }

    public String getPlayerUsername() {
        return playerRef.getUsername();
    }

    public void setHealth(float amount) {
        EntityStatMap stats = store.getComponent(ref, EntityStatMap.getComponentType());
        if (stats != null) {
            stats.addStatValue(DefaultEntityStatTypes.getHealth(), amount);
        }
    }

    public float getHealth() {
        EntityStatMap stats = store.getComponent(ref, EntityStatMap.getComponentType());
        return stats != null ? Objects.requireNonNull(stats.get(DefaultEntityStatTypes.getHealth())).get() : 0f;
    }

    public void setStamina(float amount) {
        EntityStatMap stats = store.getComponent(ref, EntityStatMap.getComponentType());
        if (stats != null) {
            stats.addStatValue(DefaultEntityStatTypes.getStamina(), amount);
        }
    }

    public float getStamina() {
        EntityStatMap stats = store.getComponent(ref, EntityStatMap.getComponentType());
        return stats != null ? Objects.requireNonNull(stats.get(DefaultEntityStatTypes.getStamina())).get() : 0f;
    }
}
