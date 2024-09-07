package com.thatoneaiguy.archipelago.init;

import com.thatoneaiguy.archipelago.Archipelago;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ArchipelagoItemGroup {
    public static final ItemGroup ARCHIPELAGO_MAIN_ITEM_GROUP = FabricItemGroupBuilder.create(
                    new Identifier(Archipelago.MODID, "archipelagomain"))
            .icon(() -> new ItemStack(ArchipelagoItems.STARWEAVER))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(ArchipelagoItems.STARWEAVER));
                stacks.add(new ItemStack(ArchipelagoBlocks.ASTRAL_VASE));
                //stacks.add(new ItemStack(ArchipelagoItems.GOOBER_SPAWN_EGG));
            })
            .build();

    public static void register() {
    }
}
