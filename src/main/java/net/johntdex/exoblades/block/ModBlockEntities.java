package net.johntdex.exoblades.block;

import net.johntdex.exoblades.block.entity.CarbonatorBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, "exoblades");

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CarbonatorBlockEntity>> CARBONATOR =
            BLOCK_ENTITIES.register("carbonator", () -> BlockEntityType.Builder.of(
                    CarbonatorBlockEntity::new, ModBlocks.CARBONATOR.get()
            ).build(null));
}
