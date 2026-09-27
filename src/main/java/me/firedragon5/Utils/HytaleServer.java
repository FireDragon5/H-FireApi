package me.firedragon5.Utils;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.math.vector.Transform;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.modules.entity.teleport.Teleport;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

import java.util.ArrayList;
import java.util.List;

public class HytaleServer {

    public final List<Player> players = new ArrayList<>();
    
    public static void teleportPlayer(Ref<EntityStore> ref, Store<EntityStore> store, World targetWorld, double x, double y, double z) {
        Transform transform = new Transform(x, y, z);
        Teleport teleport = Teleport.createForPlayer(targetWorld, transform);
        store.addComponent(ref, Teleport.getComponentType(), teleport);
    }
}

