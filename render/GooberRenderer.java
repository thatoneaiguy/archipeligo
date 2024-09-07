package com.thatoneaiguy.archipelago.render;

import com.thatoneaiguy.archipelago.Archipelago;
import com.thatoneaiguy.archipelago.entity.GooberEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

/*
public class GooberRenderer extends GeoEntityRenderer<GooberEntity> {
    public GooberRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new GooberModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public Identifier getTextureResource(GooberEntity instance) {
        return new Identifier(Archipelago.MODID, "");
    }

    @Override
    public RenderLayer getRenderType(GooberEntity animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
*/
