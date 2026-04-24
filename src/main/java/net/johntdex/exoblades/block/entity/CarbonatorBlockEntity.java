package net.johntdex.exoblades.block.entity;

import net.johntdex.exoblades.block.ModBlockEntities;
import net.johntdex.exoblades.registry.ModRecipes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CarbonatorBlockEntity extends AbstractFurnaceBlockEntity {

    public CarbonatorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CARBONATOR.get(), pos, state, ModRecipes.CARBONATING_TYPE.get());
    }

    @Override
    protected boolean isFuel(ItemStack stack) {
        return stack.is(Items.COAL)
                || stack.is(Items.COAL_BLOCK)
                || stack.is(Items.CHARCOAL)
                || stack.is(ItemTags.LOGS)
                || stack.is(ItemTags.PLANKS);
    }

    @Override
    protected RecipeType<?> getRecipeType() {
        return ModRecipes.CARBONATING_TYPE.get();
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Carbonator");
    }
}
