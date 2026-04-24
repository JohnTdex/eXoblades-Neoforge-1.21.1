package net.johntdex.exoblades.registry;

import net.johntdex.exoblades.recipe.CarbonatingRecipe;
import net.johntdex.exoblades.recipe.CarbonatingRecipeSerializer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, "exoblades");

    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, "exoblades");

    public static final DeferredHolder<RecipeType<CarbonatingRecipe>> CARBONATING_TYPE =
            TYPES.register("carbonating", () -> new RecipeType<>() {});

    public static final DeferredHolder<RecipeSerializer<CarbonatingRecipe>> CARBONATING_SERIALIZER =
            SERIALIZERS.register("carbonating", CarbonatingRecipeSerializer::new);
}
