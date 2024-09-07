package com.thatoneaiguy.archipelago.init;

import net.minecraft.entity.damage.DamageSource;

public class ArchipelagoDamageSources extends DamageSource {
    public static final DamageSource COMPRESSION = new ArchipelagoDamageSources("compression").setBypassesArmor().setUnblockable();

    public ArchipelagoDamageSources(String name) { super(name); }

    public static void register() {}
}
