package net.johntdex.exoblades.recipe;

import net.johntdex.exoblades.registry.ModRecipes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class CarbonatingRecipe extends AbstractCookingRecipe {

    public CarbonatingRecipe(String group, Ingredient ingredient, ItemStack result, float experience, int cookingTime) {
        super(group, ingredient, result, experience, cookingTime);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.CARBONATING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.CARBONATING_TYPE.get();
    }
}
