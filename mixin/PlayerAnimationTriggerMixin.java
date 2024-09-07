package com.thatoneaiguy.archipelago.mixin;

import com.thatoneaiguy.archipelago.init.ArchipelagoItems;
import com.thatoneaiguy.archipelago.render.IAstrayAnimatedPlayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.core.data.KeyframeAnimation;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class PlayerAnimationTriggerMixin {

    @Inject( method = "use", at = @At("HEAD") )
    private void playAnimation(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult> cir) {
        if ( world.isClient ) {
            var itemStack = user.getStackInHand(hand);

            if ( itemStack.getItem().equals(ArchipelagoItems.FORTNITE_EVENT_ITEM) ) {
                var animationContainer = ((IAstrayAnimatedPlayer)user).archipelago_getModAnimation();

                KeyframeAnimation anim = PlayerAnimationRegistry.getAnimation(new Identifier("archipelago", "stab"));

                animationContainer.setAnimation(new KeyframeAnimationPlayer(anim));
            }
        }
    }
}
