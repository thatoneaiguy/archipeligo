package com.thatoneaiguy.archipelago.init;

import com.thatoneaiguy.archipelago.Archipelago;
import com.thatoneaiguy.archipelago.particle.VaseBreakParticle;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ArchipelagoParticles {
    public static final DefaultParticleType VASE_BREAK_PARTICLE = FabricParticleTypes.simple();

    static void registerFactories() {

        ParticleFactoryRegistry.getInstance().register(VASE_BREAK_PARTICLE, VaseBreakParticle.Factory::new);
    }

    public static void register() {
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(Archipelago.MODID, "vase_break_particle"),
                VASE_BREAK_PARTICLE);
    }
}

