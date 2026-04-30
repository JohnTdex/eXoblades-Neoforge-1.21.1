package net.johntdex.exoblades;

import net.johntdex.exoblades.recipe.CarbonatorRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, "exoblades");
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, "exoblades");

    // // This is the "ID" of your recipe type. You will use this in your JSON files. //
    public static final DeferredHolder<RecipeType<?>, RecipeType<CarbonatorRecipe>> CARBONATING_TYPE =
            RECIPE_TYPES.register("carbonating", () -> new RecipeType<CarbonatorRecipe>() {
                @Override
                public String toString() {
                    return "carbonating";
                }
            });

    // // The Serializer converts your JSON file into actual Java code variables. //
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<CarbonatorRecipe>> CARBONATING_SERIALIZER =
            SERIALIZERS.register("carbonating", () -> new SimpleCookingSerializer<>(CarbonatorRecipe::new, 200));

}
