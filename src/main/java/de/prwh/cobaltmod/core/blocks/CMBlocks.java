package de.prwh.cobaltmod.core.blocks;

import de.prwh.cobaltmod.core.CobaltMod;
import de.prwh.cobaltmod.core.api.CMContent;
import de.prwh.cobaltmod.core.blocks.sapling.CobexSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;


public class CMBlocks {

    public static void init() {
        CMContent.COBALT_ORE = addBlock(new Block(FabricBlockSettings.of(Material.STONE).strength(5.0F).sounds(BlockSoundGroup.STONE)), "cobalt_ore");
        CMContent.COBALT_GRASS_BLOCK = addBlock(new CobaltGrassBlock(FabricBlockSettings.of(Material.PLANT).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS)), "cobalt_grass_block");
        CMContent.COBALT_DIRT = addBlock(new Block(FabricBlockSettings.of(Material.SOIL).strength(0.5F).sounds(BlockSoundGroup.GRAVEL)), "cobalt_dirt");
        CMContent.COBALT_BLOCK = addBlock(new Block(FabricBlockSettings.of(Material.METAL).strength(5.0F).sounds(BlockSoundGroup.METAL)), "cobalt_block");
        CMContent.COBEX_LOG = addBlock(new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "cobex_log");
        CMContent.COBEX_PLANKS = addBlock(new Block(FabricBlockSettings.of(Material.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "cobex_planks");
        CMContent.COBEX_LEAVES = addBlock(createLeavesBlock(), "cobex_leaves");
        //TODO change Generator
        CMContent.COBEX_SAPLING = addBlock(new CMSaplingBlock(new CobexSaplingGenerator(), FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque()), "cobex_sapling");
        CMContent.BLUE_GRASS = addBlock(new CMFernBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque()), "blue_grass");
        CMContent.CLEMATIS_FLOWER = addBlock(new CMFernBlock(FabricBlockSettings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque()), "clematis_flower");
        CMContent.BELL_FLOWER = addBlock(new CMFernBlock(FabricBlockSettings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque()), "bell_flower");
        CMContent.GLOW_FLOWER = addBlock(new CMFernBlock(FabricBlockSettings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque().luminance(10)), "glow_flower");
    }

    private static <T extends Block> T addBlock(T block, String name) {
        return addBlock(block, name, true);
    }

    private static <T extends Block> T addBlock(T block, String name, boolean addToCreative) {
        Registry.register(Registry.BLOCK, new Identifier(CobaltMod.MOD_ID, name), block);

        FabricItemSettings itemSettings = new FabricItemSettings();
        if(addToCreative) {
            itemSettings.group(CMContent.BLOCK_GROUP);
        }
        Registry.register(Registry.ITEM, new Identifier(CobaltMod.MOD_ID, name), new BlockItem(block, itemSettings));
        return block;
    }

    private static CMLeavesBlock createLeavesBlock() {
        return new CMLeavesBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(CMBlocks::never).suffocates(CMBlocks::never).blockVision(CMBlocks::never));
    }

    private static boolean always(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    private static boolean never(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

    private static Boolean never(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return false;
    }

    private static Boolean always(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return true;
    }
}