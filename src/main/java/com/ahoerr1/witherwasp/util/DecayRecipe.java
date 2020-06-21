package com.ahoerr1.witherwasp.util;

import jdk.nashorn.internal.runtime.logging.DebugLogger;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.brewing.IBrewingRecipe;

import javax.annotation.Nonnull;

import static com.mojang.blaze3d.vertex.IVertexBuilder.LOGGER;


public class DecayRecipe implements IBrewingRecipe {
    private static ItemStack INGREDIENT = new ItemStack(RegistryHandler.WITHER_JELLY.get());

    public DecayRecipe(){


    }

    @Override
    public boolean isInput(ItemStack input) {
        //Accepts the input (bottom of the potion rack, if the item is a Poison potion)
        return PotionUtils.getPotionFromItem(input) == Potions.POISON;
    }

    @Override
    public boolean isIngredient(ItemStack ingredient) {
        INGREDIENT = new ItemStack(RegistryHandler.WITHER_JELLY.get());
        //Checks if the top ingredient inserted is wither jelly
        return ingredient.getItem() == RegistryHandler.WITHER_JELLY.get();
    }

    @Override
    public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
        if(isIngredient(ingredient) && isInput(input)){
            ItemStack ret;
            return PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION),RegistryHandler.POTION_OF_DECAY.get());
        }

        return ItemStack.EMPTY;
    }
}
