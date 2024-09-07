package com.thatoneaiguy.archipelago.init;

import com.thatoneaiguy.archipelago.Archipelago;
import com.thatoneaiguy.archipelago.entity.GooberEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ArchipelagoEntities {
    /*public static final EntityType<GooberEntity> GOOBER_ENTITY_TYPE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(Archipelago.MODID, "goober"),
            FabricEntityTypeBuilder.<GooberEntity>create(SpawnGroup.MISC, GooberEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5F, 0.5F))
                    .fireImmune()
                    .build());*/

    public static void register() {}
}
