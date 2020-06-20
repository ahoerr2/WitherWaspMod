package com.ahoerr1.witherwasp.blocks;


import com.ahoerr1.witherwasp.util.RegistryHandler;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.BeehiveTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.extensions.IForgeBlock;

import javax.annotation.Nullable;

public class WitherWaspNest extends Block {
    public static final IntegerProperty JELLY_LEVEL = BlockStateProperties.HONEY_LEVEL;

    public WitherWaspNest() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(0.9f,0.9f)
                .sound(SoundType.STONE)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE)
        );

        this.setDefaultState(this.stateContainer.getBaseState().with(JELLY_LEVEL, Integer.valueOf(5)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(JELLY_LEVEL);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return RegistryHandler.WASP_NEST.get().create();
    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack itemstack = player.getHeldItem(handIn);
        ItemStack itemstack1 = itemstack.copy();
        int i = state.get(JELLY_LEVEL);
        boolean flag = false;
        if (i >= 5) {
            if (itemstack.getItem() == Items.GLASS_BOTTLE) {
                itemstack.shrink(1);
                worldIn.playSound(player, player.getPosX(), player.getPosY(), player.getPosZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                if (itemstack.isEmpty()) {
                    player.setHeldItem(handIn, new ItemStack(RegistryHandler.WITHER_JELLY.get()));
                } else if (!player.inventory.addItemStackToInventory(new ItemStack(RegistryHandler.WITHER_JELLY.get()))) {
                    player.dropItem(new ItemStack(RegistryHandler.WITHER_JELLY.get()), false);
                }

                flag = true;
            }
        }

        if (flag) {
            /*
            if (!CampfireBlock.isLitCampfireInRange(worldIn, pos, 5)) {
                if (this.hasBees(worldIn, pos)) {
                    this.angerNearbyBees(worldIn, pos);
                }

                this.takeHoney(worldIn, state, pos, player, BeehiveTileEntity.State.EMERGENCY);
            } else {

            */

            this.takeHoney(worldIn, state, pos);
            if (player instanceof ServerPlayerEntity) {
                CriteriaTriggers.SAFELY_HARVEST_HONEY.test((ServerPlayerEntity) player, pos, itemstack1);
            }
        //}

            return ActionResultType.SUCCESS;
        } else {
            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
        }
    }

    public void takeHoney(World p_226876_1_, BlockState p_226876_2_, BlockPos p_226876_3_) {
        p_226876_1_.setBlockState(p_226876_3_, p_226876_2_.with(JELLY_LEVEL, Integer.valueOf(0)), 3);
    }
}

