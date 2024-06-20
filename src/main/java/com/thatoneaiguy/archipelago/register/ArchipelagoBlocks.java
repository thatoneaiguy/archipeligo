package com.thatoneaiguy.archipelago.register;

import com.thatoneaiguy.archipelago.Archipelago;
import com.thatoneaiguy.archipelago.block.AstralVase;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ArchipelagoBlocks {

	public static final Block ASTRAL_VASE = registerBlock("astral_vase",
	new AstralVase(QuiltBlockSettings.of(Material.METAL).requiresTool().strength(50.0F, 1200.0F).sounds(BlockSoundGroup.NETHERITE)), ArchipelagoItems.ARCHIPELAGO_GROUP);

	private static Block registerBlock(String name, Block block, ItemGroup tab) {
		registerBlockItem(name, block, tab);
		return Registry.register(Registry.BLOCK, new Identifier(Archipelago.MODID, name), block);
	}

	private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
		return Registry.register(Registry.ITEM, new Identifier(Archipelago.MODID, name),
			new BlockItem(block, new QuiltItemSettings().group(tab)));
	}

	public static void register() {
	}

}

