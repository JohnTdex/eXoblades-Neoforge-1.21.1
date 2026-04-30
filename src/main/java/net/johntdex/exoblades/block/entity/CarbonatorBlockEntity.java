package net.johntdex.exoblades.block.entity;

import net.johntdex.exoblades.ModRecipes;
import net.johntdex.exoblades.block.ModBlockEntities;
import net.johntdex.exoblades.recipe.CarbonatorRecipe;
import net.johntdex.exoblades.screen.CarbonatorMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;

public class CarbonatorBlockEntity extends AbstractFurnaceBlockEntity {
    private Map<Item, Integer> BURN_DURATION =
            Map.of(Items.COAL, 1200,
                    Items.CHARCOAL, 1200,
                    Items.COAL_BLOCK, 900);


    public CarbonatorBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.CARBONATOR_BLOCK_ENTITY.get(), pPos, pBlockState, (RecipeType<? extends AbstractCookingRecipe>)(Object)ModRecipes.CARBONATING_TYPE.get());
    }

    @Override
    protected AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory) {
        // This tells the server to open the specific Menu logic we wrote earlier
        return new CarbonatorMenu(pContainerId, pPlayerInventory, this.dataAccess);
    }

    @Override
    protected Component getDefaultName() {
        return Component.literal("Carbonator");
    }

    public static void tick(Level level, BlockPos pos, BlockState state, CarbonatorBlockEntity blockEntity) {
        AbstractFurnaceBlockEntity.serverTick(level, pos, state, blockEntity);
    }


}
