package com.thatoneaiguy.archipelago;

import com.thatoneaiguy.archipelago.entity.GooberEntity;
import com.thatoneaiguy.archipelago.init.*;
import com.thatoneaiguy.archipelago.util.ArchipelagoStripping;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class Archipelago implements ModInitializer {

	public static final String MODID = "archipelago";

	public static final Logger LOGGER = LoggerFactory.getLogger("Astray Archipelago");

    @Override
	public void onInitialize() {
		LOGGER.info("Look at the stars...");

		ArchipelagoItems.register();
		ArchipelagoItemGroup.register();
		ArchipelagoBlocks.registerAll();
		ArchipelagoParticles.register();
		ArchipelagoDamageSources.register();
		ArchipelagoStripping.register();

		GeckoLib.initialize();
		//FabricDefaultAttributeRegistry.register(ArchipelagoEntities.GOOBER_ENTITY_TYPE, GooberEntity.setAttributes());
	}
}