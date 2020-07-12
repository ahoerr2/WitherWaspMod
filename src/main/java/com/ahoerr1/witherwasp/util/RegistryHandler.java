package com.ahoerr1.witherwasp.util;

import com.ahoerr1.witherwasp.WitherWasp;
import com.ahoerr1.witherwasp.blocks.BlockItemBase;
import com.ahoerr1.witherwasp.blocks.WitherWaspNest;
import com.ahoerr1.witherwasp.blocks.WitherWaspNestTileEntity;
import com.ahoerr1.witherwasp.entities.WaspEntity;
import com.ahoerr1.witherwasp.items.ItemBase;
import com.ahoerr1.witherwasp.items.WaspSpawnEgg;
import com.ahoerr1.witherwasp.items.WitherJelly;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    //Handles the new items that will be added using this mod
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,WitherWasp.MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, WitherWasp.MODID);
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES, WitherWasp.MODID);
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, WitherWasp.MODID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, WitherWasp.MODID);
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, WitherWasp.MODID);

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        POTIONS.register(FMLJavaModLoadingContext.get().getModEventBus());
        EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILE_ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Create Wasp
   public static final EntityType<WaspEntity> WITHER_WASP_ENTITY = EntityType.Builder.create(WaspEntity::new, EntityClassification.CREATURE).size(0.6f,0.6f).build(new ResourceLocation(WitherWasp.MODID, "wither_wasp").toString());

    // Registered Items
    public static final RegistryObject<Item> BASALT_PAPER = ITEMS.register("basalt_paper", ItemBase::new);
    public static final RegistryObject<Block> WITHER_WASP_NEST = BLOCKS.register("wither_wasp_nest", WitherWaspNest:: new);
    public static final RegistryObject<Item> WITHER_JELLY = ITEMS.register("wither_jelly", WitherJelly::new);


    //Registered Potions
    public static final RegistryObject<Potion> POTION_OF_DECAY = POTIONS.register("potion_of_decay", () -> new Potion("decay", new EffectInstance(Effects.WITHER, 800)));


    //Registered Block Items
    public static final RegistryObject<Item> WITHER_WASP_NEST_ITEM = ITEMS.register("wither_wasp_nest", () -> new BlockItemBase(WITHER_WASP_NEST.get()));
    public static EntityType<?> WITHER_WASP_TYPE = EntityType.Builder.create(WaspEntity::new, EntityClassification.CREATURE).size(0.6f,0.6f).build(new ResourceLocation(WitherWasp.MODID, "wither_wasp").toString());
    public static final RegistryObject<EntityType<WaspEntity>> WITHER_WASP = ENTITY_TYPES.register("wither_wasp", () -> EntityType.Builder.create(WaspEntity::new, EntityClassification.CREATURE).size(0.6f,0.6f).build(new ResourceLocation(WitherWasp.MODID, "wither_wasp").toString()));


    //Spawn Eggs

    //public static final RegistryObject<Item> WASP_SPAWN_EGG = ITEMS.register("wasp_spawn_egg", () -> SpawnEggFactory.create(WITHER_WASP_TYPE, 0x212121, 0x21d1de));
    public static final RegistryObject<Item> WASP_ENTITY_EGG = ITEMS.register("wasp_entity_egg", () -> new WaspSpawnEgg(WITHER_WASP, 0xF0A5A2, 0xA9672B, new Item.Properties().group(ItemGroup.MISC)));

    //Registered Tile Entities

    public static final RegistryObject<TileEntityType<WitherWaspNestTileEntity>> WASP_NEST = TILE_ENTITY_TYPES.register("quarry",
            () -> TileEntityType.Builder.create(WitherWaspNestTileEntity::new, RegistryHandler.WITHER_WASP_NEST.get()).build(null));
}
