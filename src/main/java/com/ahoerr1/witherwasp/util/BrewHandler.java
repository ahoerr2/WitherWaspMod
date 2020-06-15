package com.ahoerr1.witherwasp.util;

import net.minecraft.item.Item;
import net.minecraft.potion.*;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BrewHandler {


    public static Method brewing_mixes = null;

    public static void addMix(Potion start, Item ingredient, Potion result){
        if(brewing_mixes == null){
            brewing_mixes = ObfuscationReflectionHelper.findMethod(PotionBrewing.class, "addMix",Potion.class,Item.class,Potion.class);
            brewing_mixes.setAccessible(true);
        }

        try {
            brewing_mixes.invoke(null,start,ingredient,result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    public static void addBrewingRecipes(){
        //Potion Poision + Wither Jelly -> Potion of Decay
        addMix(Potions.POISON,RegistryHandler.WITHER_JELLY.get(),RegistryHandler.POTION_OF_DECAY.get());
    }
}
