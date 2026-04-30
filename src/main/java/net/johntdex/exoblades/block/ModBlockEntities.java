package net.johntdex.exoblades.block;

import net.johntdex.exoblades.ExoBlades;
import net.johntdex.exoblades.block.entity.CarbonatorBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, ExoBlades.MODID);

    public static final Supplier<BlockEntityType<CarbonatorBlockEntity>> CARBONATOR_BLOCK_ENTITY =
            BLOCK_ENTITY_TYPES.register("carbonator_be",
                    () -> BlockEntityType.Builder.of(CarbonatorBlockEntity::new, ModBlocks.CARBONATOR_BLOCK.get()).build(null));
 }
