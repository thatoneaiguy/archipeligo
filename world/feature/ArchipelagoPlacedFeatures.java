package com.thatoneaiguy.archipelago.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class ArchipelagoPlacedFeatures {
    public static final RegistryEntry<PlacedFeature> DOGWOOD_PLACED = PlacedFeatures.register("crystal_placed",
            ArchipelagoConfiguredFeatures.CRYSTAL_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));

}
