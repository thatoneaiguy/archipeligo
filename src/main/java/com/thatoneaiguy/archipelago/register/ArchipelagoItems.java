package com.thatoneaiguy.archipelago.register;

import com.thatoneaiguy.archipelago.Archipelago;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ArchipelagoItems {

	public static final ItemGroup ARCHIPELAGO_GROUP = FabricItemGroupBuilder.build(
		new Identifier(Archipelago.MODID, "archipelago_group"), () -> new ItemStack(ArchipelagoBlocks.ASTRAL_VASE));

	public static final Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(Archipelago.MODID, name), item);
	}

	public static void register() {}
}
