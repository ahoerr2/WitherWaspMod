package com.ahoerr1.witherwasp.items;

import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class WitherJelly extends Item{

    public static Food WITHER_JELLY = (new Food.Builder().hunger(2).saturation(0.2f).effect(new EffectInstance(Effects.HUNGER, 1200) , 1.0f).setAlwaysEdible().build());

    public WitherJelly() {
        super(new Item.Properties().food(WITHER_JELLY).group(ItemGroup.FOOD).maxStackSize(16));
    }

    /**
     * How long it takes to use or consume an item
     */
    @Override
    public int getUseDuration(ItemStack stack) {
        return 40;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public SoundEvent getDrinkSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }

    @Override
    public SoundEvent getEatSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }


}
