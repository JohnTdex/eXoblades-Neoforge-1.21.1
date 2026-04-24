package net.johntdex.exoblades.item;

import net.johntdex.exoblades.ExoBlades;
import net.johntdex.exoblades.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExoBlades.MODID);

    public static  final Supplier<CreativeModeTab> EXOBLADES_ITEMS_TAB = CREATIVE_MODE_TAB.register("exoblade_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAW_EXORIUM.get()))
                    .title(Component.translatable("creativetab.exoblades.exoblade_items_tab"))
                    .displayItems((parameters, output) -> {
                       output.accept(ModItems.RAW_EXORIUM);
                       output.accept(ModItems.STEEL_INGOT);
                       output.accept(ModItems.STEEL_ROD);
                       output.accept(ModItems.REINFORCED_STICK);

                    }) .build());

 public static  final Supplier<CreativeModeTab> EXOBLADES_BLOCK_TAB = CREATIVE_MODE_TAB.register("exoblade_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.EXORIUM_ORE))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ExoBlades.MODID, "exoblade_items_tab"))
                    .title(Component.translatable("creativetab.exoblades.exoblade_blocks_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.EXORIUM_ORE);

                    }) .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
