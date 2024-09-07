package com.thatoneaiguy.archipelago.block;

import com.thatoneaiguy.archipelago.init.ArchipelagoBlocks;
import com.thatoneaiguy.archipelago.init.ArchipelagoParticles;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class AstralVase extends HorizontalFacingBlock {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public static final BooleanProperty GENERATED = Properties.ENABLED;

    public AstralVase(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((((BlockState) this.stateManager.getDefaultState()).with(GENERATED, true)));
    }

    //added by winter to test if this would fix the model's renderer being bugged
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        // return SHAPE;
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0, 0, 1, 1.25, 1));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.2, 1.25, 0.1875, 0.8125, 1.3, 0.8125));
        return shape;
    }


    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }


    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    private static Block searchFor = Blocks.SCULK_SHRIEKER;

    public static void Ring(World world, BlockPos pos, BlockState state, PlayerEntity player) {

        ((ServerWorld) world).spawnParticles(ArchipelagoParticles.VASE_BREAK_PARTICLE, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 1, 0.0, 0.0, 0.0, 0.0);

            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) player;
            Stream<BlockPos> blocks = BlockPos.stream(pos.add(-10, -10, -10), pos.add(10, 10, 10));
            blocks.forEach(blockPos -> {
            BlockState blockState = world.getBlockState(blockPos);
            if (blockState.getBlock() == searchFor) {

                //if (serverPlayerEntity != null) {
                ((ServerWorld) world).getBlockEntity(blockPos, BlockEntityType.SCULK_SHRIEKER).ifPresent((blockEntity) -> {
                    blockEntity.shriek(((ServerWorld) world), serverPlayerEntity);

                    //});


                });

                // Found the block, do something with it
                //world.breakBlock(blockPos, true);
                //world.spawnEntity(new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(searchFor)));

            } else if (blockState.getBlock() == ArchipelagoBlocks.ASTRAL_VASE) {}
        });
    }

    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient && player.isCreative()) {
            //TallPlantBlock.onBreakInCreative(world, pos, state, player);
        }
        player.incrementStat(Stats.MINED.getOrCreateStat(this));
        player.addExhaustion(0.005F);
        world.playSound(player, pos, SoundEvents.BLOCK_SCULK_SHRIEKER_SHRIEK, SoundCategory.BLOCKS, 1, 1);
        if (world instanceof ServerWorld serverWorld) {
            if (state.get(GENERATED)) {
                world.playSound(player, pos, SoundEvents.BLOCK_SCULK_SHRIEKER_SHRIEK, SoundCategory.BLOCKS, 1, 1);
                ((ServerWorld) world).spawnParticles(ArchipelagoParticles.VASE_BREAK_PARTICLE, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 1, 0.0, 0.0, 0.0, 0.0);
                this.Ring(world, pos, state, player);
            }
            StatusEffectInstance darkness = new StatusEffectInstance(StatusEffects.DARKNESS, 200, 0, false, false);
            player.addStatusEffect(darkness);
            serverWorld.addParticle(ArchipelagoParticles.VASE_BREAK_PARTICLE, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 0.0, 0.0, 0.0);
        }



        super.onBreak(world, pos, state, player);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(GENERATED);
    }

    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity player, ItemStack itemStack) {
        //if (player==null) do {

        // if (!world.isAir(pos.add((double) 0, (double) 1, (double) 0))) do {
        //     world.

        //     break;
        //} while (!world.isAir(pos.add((double) 0, (double) 1, (double) 0)));
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(GENERATED, true)));
        // break;
        //} while(player==null);
    }
}
