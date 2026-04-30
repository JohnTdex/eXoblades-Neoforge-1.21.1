package net.johntdex.exoblades.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.network.codec.ByteBufCodecs;


public class CarbonatorRecipeSerializer implements RecipeSerializer<CarbonatorRecipe> {

    public static final MapCodec<CarbonatorRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(CarbonatorRecipe::getIngredient),
            ItemStack.STRICT_CODEC.fieldOf("result").forGetter(CarbonatorRecipe::getResult),
            com.mojang.serialization.Codec.FLOAT.fieldOf("experience").forGetter(CarbonatorRecipe::getExperience),
            com.mojang.serialization.Codec.INT.fieldOf("cookingtime").forGetter(CarbonatorRecipe::getCookingTime)
    ).apply(inst, CarbonatorRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, CarbonatorRecipe> STREAM_CODEC = StreamCodec.of(
            (buf, recipe) -> {
                Ingredient.CONTENTS_STREAM_CODEC.encode(buf, recipe.getIngredient());
                ItemStack.STREAM_CODEC.encode(buf, recipe.getResult());
                buf.writeFloat(recipe.getExperience());
                buf.writeInt(recipe.getCookingTime());
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