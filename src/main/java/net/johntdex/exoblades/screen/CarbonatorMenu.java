package net.johntdex.exoblades.screen;

import net.johntdex.exoblades.ModRecipes;
import net.johntdex.exoblades.menu.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.inventory.SimpleContainerData;
import net.johntdex.exoblades.recipe.CarbonatorRecipe;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;

public class CarbonatorMenu extends AbstractFurnaceMenu {
    // // The constructor used by the Client // //
    public CarbonatorMenu(int pContainerId, Inventory pPlayerInventory, FriendlyByteBuf buf) {
        this(pContainerId, pPlayerInventory, new SimpleContainerData(4));
    }

    // // The constructor used by the Server // //
    public CarbonatorMenu(int pContainerId, Inventory pPlayerInventory, ContainerData pData) {
        // We add 'new SimpleContainer(3)' as the 6th argument
        super(ModMenuTypes.CARBONATOR_MENU.get(),
                ModRecipes.CARBONATING_TYPE.get(),
                RecipeBookType.FURNACE,
                pContainerId,
                pPlayerInventory,
                new SimpleContainer(3), // The 'Container' argument that was missing
                pData);
    }
}