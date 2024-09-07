package com.thatoneaiguy.archipelago.world.feature.tree;

import com.thatoneaiguy.archipelago.world.feature.ArchipelagoConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class CrystalSaplingGenerator extends SaplingGenerator {

    @Nullable
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return ArchipelagoConfiguredFeatures.CRYSTAL_TREE;
    }
}
