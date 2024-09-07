package com.thatoneaiguy.archipelago.mixin;

import com.mojang.authlib.GameProfile;
import com.thatoneaiguy.archipelago.render.IAstrayAnimatedPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.encryption.PlayerPublicKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractClientPlayerEntity.class)
public class ClientPlayerEntityMixin implements IAstrayAnimatedPlayer {

    @Unique
    private final ModifierLayer<IAnimation> astrayAnimationContainer = new ModifierLayer<>();

    @Inject( method = "<init>", at = @At(value = "RETURN") )
    private void init(ClientWorld world, GameProfile profile, PlayerPublicKey publicKey, CallbackInfo ci) {
        PlayerAnimationAccess.getPlayerAnimLayer((AbstractClientPlayerEntity) (Object)this).addAnimLayer(1000, astrayAnimationContainer);
    }

    @Override
    public ModifierLayer<IAnimation> archipelago_getModAnimation() {
        return astrayAnimationContainer;
    }
}
