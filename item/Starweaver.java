package com.thatoneaiguy.archipelago.item;

import com.thatoneaiguy.archipelago.init.ArchipelagoDamageSources;
import com.thatoneaiguy.archipelago.init.ArchipelagoItems;
import com.thatoneaiguy.archipelago.init.ArchipelagoParticles;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.enchantment.FireAspectEnchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.world.World;

import java.awt.*;

public class Starweaver extends SwordItem {
    public Starweaver(FabricItemSettings settings) {
        super(ToolMaterials.NETHERITE, 3, -2.4F, settings);
    }

    public static final Color STAR = new Color(0xED8EF9);

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setOnFireFor(8);
        return super.postHit(stack, target, attacker);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        if ( entity.getHandItems().equals(ArchipelagoItems.STARWEAVER) ) {
            if ( !entity.getUuidAsString().equals("") && !entity.isInvulnerable() ) {
                entity.damage(ArchipelagoDamageSources.COMPRESSION, 10000000);
                
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
