package net.johntdex.exoblades.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class CarbonatorRecipeSerializer implements RecipeSerializer<CarbonatorRecipe> {

    public static final MapCodec<CarbonatorRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(r -> r.ingredient),
            ItemStack.STRICT_CODEC.fieldOf("result").forGetter(r -> r.result),
            MapCodec.unit(0.7f).fieldOf("experience").forGetter(r -> r.experience),
            MapCodec.unit(200).fieldOf("cookingtime").forGetter(r -> r.cookingTime)
    ).apply(inst, CarbonatorRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, CarbonatorRecipe> STREAM_CODEC = StreamCodec.of(
            (buf, recipe) -> {
                Ingredient.CONTENTS_STREAM_CODEC.encode(buf, recipe.ingredient);
                ItemStack.STREAM_CODEC.encode(buf, recipe.result);
                buf.writeFloat(recipe.experience);
                buf.writeInt(recipe.cookingTime);
            },
            buf -> new CarbonatorRecipe(
                    Ingredient.CONTENTS_STREAM_CODEC.decode(buf),
                    ItemStack.STREAM_CODEC.decode(buf),
                    buf.readFloat(),
                    buf.readInt()
            )
    );

    @Override
    public MapCodec<CarbonatorRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, CarbonatorRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}