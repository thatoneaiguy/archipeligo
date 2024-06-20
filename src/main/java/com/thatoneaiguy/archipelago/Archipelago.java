package com.thatoneaiguy.archipelago;

import com.thatoneaiguy.archipelago.packet.VaseBreakPacket;
import com.thatoneaiguy.archipelago.register.ArchipelagoBlocks;
import com.thatoneaiguy.archipelago.register.ArchipelagoItems;
import com.thatoneaiguy.archipelago.register.ArchipelagoParticles;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.Vec3d;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.networking.api.client.ClientPlayNetworking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archipelago implements ModInitializer {

	public static final String MODID = "archipelago";

	public static final Logger LOGGER = LoggerFactory.getLogger("Astray Archipelago");

	@Override
	public void onInitialize(ModContainer mod) {

		ArchipelagoItems.register();

		ArchipelagoBlocks.register();

		ArchipelagoParticles.register();

		LOGGER.info("Look at the stars...");
	}
}
