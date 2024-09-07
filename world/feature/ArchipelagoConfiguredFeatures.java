package com.thatoneaiguy.archipelago.world.feature;

import com.thatoneaiguy.archipelago.Archipelago;
import com.thatoneaiguy.archipelago.init.ArchipelagoBlocks;
import net.minecraft.block.sapling.AzaleaSaplingGenerator;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ArchipelagoConfiguredFeatures {

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> CRYSTAL_TREE =
            ConfiguredFeatures.register("crystal_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ArchipelagoBlocks.CRYSTAL_LOG),
                    new StraightTrunkPlacer(4, 2, 3),
                    BlockStateProvider.of(ArchipelagoBlocks.CRYSTAL_LEAVES),
                    new AcaciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final RegistryEntry<PlacedFeature> CRYSTAL_CHECKED = PlacedFeatures.register("crystal_checked",
            ArchipelagoConfiguredFeatures.CRYSTAL_TREE, List.of(PlacedFeatures.wouldSurvive(ArchipelagoBlocks.CRYSTAL_SAPLING)));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> CRYSTAL_SPAWN =
            ConfiguredFeatures.register("crystal_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(CRYSTAL_CHECKED, 0.5f)),
                            CRYSTAL_CHECKED));

    public static void register() {}
}
