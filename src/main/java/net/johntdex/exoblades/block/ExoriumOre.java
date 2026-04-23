package net.johntdex.exoblades.block;

import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ExoriumOre extends DropExperienceBlock {

    public ExoriumOre(UniformInt xpRange, Properties properties) {
        super(xpRange, properties);
    }

    @Override
    public boolean canHarvestBlock(BlockState state, BlockGetter level, BlockPos pos, Player player) {
        return isNetheritePickaxe(player.getMainHandItem());
    }


    private static boolean isNetheritePickaxe(ItemStack stack) {
        return stack.is(Items.NETHERITE_PICKAXE);
    }
}
