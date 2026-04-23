package net.johntdex.exoblades.menu;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.RecipeType;

public class CarbonatorMenu extends AbstractFurnaceMenu {
    public CarbonatorMenu(int id, Inventory inv) {
        super(MenuType.FURNACE, RecipeType.SMELTING, RecipeBookType.FURNACE, id, inv);
    }
}
