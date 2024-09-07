package com.thatoneaiguy.archipelago.init;

import com.thatoneaiguy.archipelago.Archipelago;
import com.thatoneaiguy.archipelago.item.FortniteEventItem;
import com.thatoneaiguy.archipelago.item.Starweaver;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ArchipelagoItems {

    public static final Item STARWEAVER = registerItem("starweaver", new Starweaver(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof()));

    public static final Item FORTNITE_EVENT_ITEM = registerItem("fortnite_event_item", new FortniteEventItem(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof()));
    public static final Item RUPTURE_EVENT_ITEM = registerItem("rupture_event_item", new FortniteEventItem(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof()));

    public static final Item ENIGMA_SHARD = registerItem("enigma_shard", new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof()));

    public static final Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Archipelago.MODID, name), item);
    }

    public static void register() {}
}
