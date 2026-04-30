package net.johntdex.exoblades.screen;

import net.johntdex.exoblades.menu.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.johntdex.exoblades.recipe.CarbonatorRecipe;
import net.minecraft.world.inventory.*;

public class CarbonatorMenu extends AbstractFurnaceMenu {
    // // The constructor used by the Client // //
    public CarbonatorMenu(int pContainerId, Inventory pPlayerInventory, FriendlyByteBuf buf) {
        this(pContainerId, pPlayerInventory, new SimpleContainerData(4));
    }

    // // The constructor used by the Server // //
    public CarbonatorMenu(int pContainerId, Inventory pPlayerInventory, ContainerData pData) {
        // // We pass our custom Recipe Type so the menu knows how to handle ghost items/slots // //
        super(ModMenuTypes.CARBONATOR_MENU.get(), CarbonatorRecipe.Type.INSTANCE, RecipeBookType.FURNACE, pContainerId, pPlayerInventory, pData);
    }
}