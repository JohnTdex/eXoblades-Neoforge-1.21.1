package net.johntdex.exoblades.block.custom;

import com.mojang.serialization.MapCodec;
import net.johntdex.exoblades.block.ModBlockEntities;
import net.johntdex.exoblades.block.entity.CarbonatorBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class CarbonatorBlock extends AbstractFurnaceBlock {
    public static final MapCodec<CarbonatorBlock> CODEC = simpleCodec(CarbonatorBlock::new);


    public CarbonatorBlock(Properties properties) {
        super(properties);
    }


    @Override
    protected MapCodec<? extends AbstractFurnaceBlock> codec() {
        return CODEC;
    }

    @Override
    protected void openContainer(Level pLevel, BlockPos pPos, Player pPlayer) {
        BlockEntity blockentity = pLevel.getBlockEntity(pPos);
        if (blockentity instanceof CarbonatorBlockEntity carbonatorBlockEntity) {
            ((ServerPlayer) pPlayer).openMenu (new SimpleMenuProvider(carbonatorBlockEntity, Component.literal("Carbonator")), pPos);
            pPlayer.awardStat(Stats.INTERACT_WITH_FURNACE);
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CarbonatorBlockEntity(pos, state);
    }

    @Override
    public void animateTick(BlockState pState, Level plevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(LIT)) {
            double d0 = (double) pPos.getX() + 0.5D;
            double d1 = (double) pPos.getY();
            double d2 = (double) pPos.getZ() + 0.5D;
            if (pRandom.nextDouble() < 0.1D) {
                plevel.playLocalSound(d0, d1, d2, net.minecraft.sounds.SoundEvents.FURNACE_FIRE_CRACKLE, net.minecraft.sounds.SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }

            Direction direction = pState.getValue(FACING);
            Direction.Axis direction$axis = direction.getAxis();
            double d4 = 0.52D;
            double d5 = pRandom.nextDouble() * 0.6D - 0.3D;
            double d6 = direction$axis == Direction.Axis.X ? (double) direction.getStepX() * 0.52D : d5;
            double d7 = pRandom.nextDouble() * 6.0D / 16.0D;
            double d8 = direction$axis == Direction.Axis.Z ? (double) direction.getStepZ() * 0.52D : d5;
            plevel.addParticle(net.minecraft.core.particles.ParticleTypes.SMOKE, d0 + d6, d1 + d7, d2 + d8, 0.0D, 0.0D, 0.0D);
            plevel.addParticle(net.minecraft.core.particles.ParticleTypes.FLAME, d0 + d6, d1 + d7, d2 + d8, 0.0D, 0.0D, 0.0D);
        }
    }


    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof CarbonatorBlockEntity be) {
                Containers.dropContents(pLevel, pPos, be);
            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos,
                                              Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof CarbonatorBlockEntity carbonatorBlockEntity) {
                ((ServerPlayer) pPlayer).openMenu(new SimpleMenuProvider(carbonatorBlockEntity, Component.literal("Carbonator")), pPos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }

        return ItemInteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return level.isClientSide() ? null : createTickerHelper(blockEntityType, ModBlockEntities.CARBONATOR_BLOCK_ENTITY.get(), CarbonatorBlockEntity::tick);
        }
    }

