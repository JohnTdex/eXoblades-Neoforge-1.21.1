package net.johntdex.exoblades.recipe;

import net.johntdex.exoblades.ModRecipes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;

public class CarbonatorRecipe extends AbstractCookingRecipe {

    // The Serializer specifically looks for THIS constructor signature
    public CarbonatorRecipe(String pGroup, CookingBookCategory pCategory, Ingredient pIngredient,
                            ItemStack pResult, float pExperience, int pCookingTime) {
        super(ModRecipes.CARBONATING_TYPE.get(), pGroup, pCategory, pIngredient, pResult, pExperience, pCookingTime);
    }
    // Add this to CarbonatorRecipe.java
    public CarbonatorRecipe(Ingredient ingredient, ItemStack result, float experience, int cookingTime) {
        this("", CookingBookCategory.MISC, ingredient, result, experience, cookingTime);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.CARBONATING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.CARBONATING_TYPE.get();
    }

    public Ingredient getIngredient() { return this.ingredient; }
    public ItemStack getResult() { return this.result; }
    public float getExperience() { return this.experience; }
    public int getCookingTime() { return this.cookingTime; }
}