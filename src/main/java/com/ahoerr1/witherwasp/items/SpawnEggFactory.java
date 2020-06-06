package com.ahoerr1.witherwasp.items;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;

public class SpawnEggFactory{

    public static Item create(EntityType<?> type, int color1, int color2){
        Item newEgg = new SpawnEggItem(type, color1, color2, new Item.Properties().group(ItemGroup.MISC));
        return newEgg;
    }

}
