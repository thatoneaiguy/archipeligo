package com.thatoneaiguy.archipelago.particle;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.render.Camera;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Quaternion;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3f;

import java.util.function.Consumer;

public class VaseBreakParticle extends ExplosionLargeParticle {
	public VaseBreakParticle(ClientWorld world, double x, double y, double z, double d, SpriteProvider spriteProvider) {
		super(world, x, y, z, d, spriteProvider);
		this.maxAge = 24;
		this.scale = 20.0F;
		this.gravityStrength = 0.0F;
		this.velocityX = 0.0;
		this.velocityY = 0.0;
		this.velocityZ = 0.0;
		this.colorRed = 1.0F;
		this.colorGreen = 1.0F;
		this.colorBlue = 1.0F;
		this.setSpriteForAge(spriteProvider);
	}

	public float getSize(float tickDelta) {
		float d = ((float)this.age + tickDelta) / (float)this.maxAge;
		return this.scale * MathHelper.clamp(d, 0.0F, 1.0F);
	}

	public void buildGeometry(VertexConsumer vertexConsumer, Camera camera, float tickDelta) {
		this.colorAlpha = MathHelper.clamp(-2.0F * (((float)this.age + tickDelta) / (float)this.maxAge) + 2.0F, 0.0F, 1.0F);
		float pi = 3.1415927F;
		this.buildGeometry(vertexConsumer, camera, tickDelta, (quaternion) -> {
			quaternion.hamiltonProduct(Vec3f.POSITIVE_Y.getRadialQuaternion(0.0F));
			quaternion.hamiltonProduct(Vec3f.POSITIVE_X.getRadialQuaternion(pi * -0.5F));
		});
		this.buildGeometry(vertexConsumer, camera, tickDelta, (quaternion) -> {
			quaternion.hamiltonProduct(Vec3f.POSITIVE_Y.getRadialQuaternion(-pi));
			quaternion.hamiltonProduct(Vec3f.POSITIVE_X.getRadialQuaternion(pi * 0.5F));
		});
	}

	public void tick() {
		super.tick();
	}

	private void buildGeometry(VertexConsumer vertexConsumer, Camera camera, float tickDelta, Consumer<Quaternion> rotator) {
		Vec3d vec3d = camera.getPos();
		float f = (float)(MathHelper.lerp((double)tickDelta, this.prevPosX, this.x) - vec3d.getX());
		float g = (float)(MathHelper.lerp((double)tickDelta, this.prevPosY, this.y) - vec3d.getY());
		float h = (float)(MathHelper.lerp((double)tickDelta, this.prevPosZ, this.z) - vec3d.getZ());
		Quaternion quaternion = new Quaternion((Vec3f) Util.make(new Vec3f(1.0F, 1.0F, 1.0F), Vec3f::normalize), 0.0F, true);
		rotator.accept(quaternion);
		Vec3f[] vec3fs = new Vec3f[]{new Vec3f(-1.0F, -1.0F, 0.0F), new Vec3f(-1.0F, 1.0F, 0.0F), new Vec3f(1.0F, 1.0F, 0.0F), new Vec3f(1.0F, -1.0F, 0.0F)};
		float size = this.getSize(tickDelta);

		int brightness;
		for(brightness = 0; brightness < 4; ++brightness) {
			Vec3f vec3f = vec3fs[brightness];
			vec3f.rotate(quaternion);
			vec3f.scale(size);
			vec3f.add(f, g, h);
		}

		brightness = this.getBrightness(tickDelta);
		this.vertex(vertexConsumer, vec3fs[0], this.getMaxU(), this.getMaxV(), brightness);
		this.vertex(vertexConsumer, vec3fs[1], this.getMaxU(), this.getMinV(), brightness);
		this.vertex(vertexConsumer, vec3fs[2], this.getMinU(), this.getMinV(), brightness);
		this.vertex(vertexConsumer, vec3fs[3], this.getMinU(), this.getMaxV(), brightness);
	}

	private void vertex(VertexConsumer vertexConsumer, Vec3f pos, float u, float v, int light) {
		vertexConsumer.vertex((double)pos.getX(), (double)pos.getY(), (double)pos.getZ()).uv(u, v).color(this.colorRed, this.colorGreen, this.colorBlue, this.colorAlpha).light(light).next();
	}

	public int getBrightness(float tint) {
		return 240;
	}

	public ParticleTextureSheet getType() {
		return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
	}

	@Environment(EnvType.CLIENT)
	public static class Factory implements ParticleFactory<DefaultParticleType> {
		private final SpriteProvider spriteProvider;

		public Factory(SpriteProvider spriteProvider) {
			this.spriteProvider = spriteProvider;
		}

		public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
			return new VaseBreakParticle(clientWorld, d, e, f, g, this.spriteProvider);
		}
	}
}
