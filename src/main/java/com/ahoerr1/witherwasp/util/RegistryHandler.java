package com.ahoerr1.witherwasp.util;

import com.ahoerr1.witherwasp.WitherWasp;
import com.ahoerr1.witherwasp.blocks.BlockItemBase;
import com.ahoerr1.witherwasp.blocks.WitherWaspNest;
import com.ahoerr1.witherwasp.entities.WaspEntity;
import com.ahoerr1.witherwasp.items.ItemBase;
import com.ahoerr1.witherwasp.items.SpawnEggFactory;
import com.ahoerr1.witherwasp.items.WitherJelly;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.potion.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    //Handles the new items that will be added using this mod
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, WitherWasp.MODID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, WitherWasp.MODID);
    public static final DeferredRegister<Potion> POTIONS = new DeferredRegister<>(ForgeRegistries.POTION_TYPES, WitherWasp.MODID);
    public static final DeferredRegister<Effect> EFFECTS = new DeferredRegister<>(ForgeRegistries.POTIONS, WitherWasp.MODID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, WitherWasp.MODID);

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        POTIONS.register(FMLJavaModLoadingContext.get().getModEventBus());
        EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Create Wasp
   public static final EntityType<WaspEntity> WITHER_WASP_ENTITY = EntityType.Builder.create(WaspEntity::new, EntityClassification.CREATURE).size(0.6f,0.6f).build(new ResourceLocation(WitherWasp.MODID, "wither_wasp").toString());

    // Registered Items
    public static final RegistryObject<Item> BASALT_PAPER = ITEMS.register("basalt_paper", ItemBase::new);
    public static final RegistryObject<Block> WITHER_WASP_NEST = BLOCKS.register("wither_wasp_nest", WitherWaspNest:: new);
    public static final RegistryObject<Item> WITHER_JELLY = ITEMS.register("wither_jelly", WitherJelly::new);





    //Registered Block Items
    public static final RegistryObject<Item> WITHER_WASP_NEST_ITEM = ITEMS.register("wither_wasp_nest", () -> new BlockItemBase(WITHER_WASP_NEST.get()));
    public static final RegistryObject<EntityType<WaspEntity>> WITHER_WASP = ENTITY_TYPES.register("wither_wasp", () -> EntityType.Builder.<WaspEntity>create(WaspEntity::new, EntityClassification.CREATURE).size(0.6f,0.6f).build(new ResourceLocation(WitherWasp.MODID, "wither_wasp").toString()));


    //Spawn Eggs
    //public static final RegistryObject<Item> WASP_SPAWN_EGG = ITEMS.register("wasp_spawn_egg", () -> SpawnEggFactory.<EntityType<WaspEntity>>create(WITHER_WASP_ENTITY, 0x212121, 0x21d1de));
}
