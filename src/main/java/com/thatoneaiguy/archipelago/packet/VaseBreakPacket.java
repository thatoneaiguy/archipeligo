package com.thatoneaiguy.archipelago.packet;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public record VaseBreakPacket(Vec3d position) implements Packet<ClientPlayPacketListener> {
	public static final Identifier ID = new Identifier("archipelago", "vase_break");

	public VaseBreakPacket(Vec3d position) {
		this.position = position;
	}

	public void write(PacketByteBuf buf) {
		buf.writeDouble(this.position.x);
		buf.writeDouble(this.position.y);
		buf.writeDouble(this.position.z);
	}

	public void apply(ClientPlayPacketListener listener) {
	}

	public Vec3d position() {
		return this.position;
	}
}
