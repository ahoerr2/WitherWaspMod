package com.ahoerr1.witherwasp.blocks;


import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class WitherWaspNest extends Block {

    public WitherWaspNest() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(0.9f,0.9f)
                .sound(SoundType.STONE)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE)
        );
    }

}
