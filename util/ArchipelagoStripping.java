package com.thatoneaiguy.archipelago.util;

import com.thatoneaiguy.archipelago.init.ArchipelagoBlocks;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ArchipelagoStripping {

    public static void register() {
        StrippableBlockRegistry.register(ArchipelagoBlocks.CRYSTAL_LOG, ArchipelagoBlocks.STRIPPED_CRYSTAL_LOG);
        StrippableBlockRegistry.register(ArchipelagoBlocks.CRYSTAL_WOOD, ArchipelagoBlocks.STRIPPED_CRYSTAL_WOOD);
    }
}
