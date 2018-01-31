package com.penpennetworks.minecraft.blocksample;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
@Mod(modid = BlockSampleCore.MOD_ID, version = BlockSampleCore.VERSION)
public class BlockSampleCore {

    public static final String MOD_ID  = "blocksample";
    public static final String VERSION = "0.0.1";

    public static Block sample_block;
    public static Item sample_block_item;

    public static Block sample_block_tnt;
    public static Item sample_block_tnt_item;

    @SubscribeEvent
    public static void registerBlocks( RegistryEvent.Register<Block> event ) {
        event.getRegistry().registerAll(sample_block,sample_block_tnt);
    }

    @SubscribeEvent
    public static void registerItems( RegistryEvent.Register<Item> event ) {
        event.getRegistry().registerAll(sample_block_item,sample_block_tnt_item);
    }

    @SubscribeEvent
    public static void registerModels( ModelRegistryEvent event ){
        ModelLoader.setCustomModelResourceLocation(
                sample_block_item,
                0,
                new ModelResourceLocation(
                        sample_block_item.getRegistryName(), "inventory"
                )
        );
        ModelLoader.setCustomModelResourceLocation(
                sample_block_tnt_item,
                0,
                new ModelResourceLocation(
                        sample_block_tnt_item.getRegistryName(), "inventory"
                )
        );
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event ) {

        sample_block = new Block( Material.CLAY )
                .setCreativeTab( CreativeTabs.BUILDING_BLOCKS )
                .setRegistryName( MOD_ID,"sample_block" )
                .setUnlocalizedName("SampleBlock")
                .setHardness(0.1f);

        sample_block_item = new ItemBlock(sample_block)
                .setRegistryName( MOD_ID, "sample_block" );

        sample_block_tnt = new BlockTNT()
                .setCreativeTab( CreativeTabs.REDSTONE )
                .setRegistryName( MOD_ID, "sample_block_tnt" )
                .setUnlocalizedName("SampleBlockTNT");

        sample_block_tnt_item = new ItemBlock(sample_block_tnt)
                .setRegistryName( MOD_ID, "sample_block_tnt" );

    }

    @EventHandler
    public void init( FMLInitializationEvent event ) {

    }

}
