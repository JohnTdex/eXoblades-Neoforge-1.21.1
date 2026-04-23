package net.johntdex.exoblades.item;

import net.johntdex.exoblades.ExoBlades;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExoBlades.MODID);

    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> STEEL_ROD = ITEMS.register("steel_rod",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> REINFORCED_STICK = ITEMS.register("reinforced_stick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_EXORIUM = ITEMS.register("raw_exorium",
            () -> new Item(new Item.Properties()));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
