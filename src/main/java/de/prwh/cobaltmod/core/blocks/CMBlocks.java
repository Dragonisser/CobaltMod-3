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
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;


public class CMBlocks {

    private CMBlocks() {}

    public static void init() {
        CMContent.COBALT_ORE = addBlock("cobalt_ore", new OreBlock(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).requiresTool().strength(3.0F, 3.0F), UniformIntProvider.create(3, 7)));
        CMContent.CORRUPTED_STONE = addBlock("corrupted_stone", new Block(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).requiresTool().strength(1.5F, 6.0F)));
        CMContent.COBALT_GRASS_BLOCK = addBlock("cobalt_grass_block", new CobaltGrassBlock(FabricBlockSettings.of(Material.PLANT).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS)));
        CMContent.COBALT_DIRT = addBlock("cobalt_dirt", new Block(FabricBlockSettings.of(Material.SOIL).strength(0.5F).sounds(BlockSoundGroup.GRAVEL)));
        CMContent.COBALT_BLOCK = addBlock("cobalt_block", new Block(FabricBlockSettings.of(Material.METAL).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL)));
        CMContent.COBEX_LOG = addBlock("cobex_log", new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD)));
        CMContent.COBEX_PLANKS = addBlock("cobex_planks", new Block(FabricBlockSettings.of(Material.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD)));
        CMContent.COBEX_LEAVES = addBlock("cobex_leaves", createLeavesBlock());
        CMContent.COBEX_SAPLING = addBlock("cobex_sapling", new CMSaplingBlock(new CobexSaplingGenerator(), FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque()));
        CMContent.BLUE_GRASS = addBlock("blue_grass", new CMFernBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque()));
        CMContent.CLEMATIS_FLOWER = addBlock("clematis_flower", new CMFernBlock(FabricBlockSettings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque()));
        CMContent.BELL_FLOWER = addBlock("bell_flower", new CMFernBlock(FabricBlockSettings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque()));
        CMContent.GLOW_FLOWER = addBlock("glow_flower", new CMFernBlock(FabricBlockSettings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque().luminance(10)));
        CMContent.RED_CABBAGE_CROP = addBlock("red_cabbage_crop", new RedCabbageBlock(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)), false);
        CMContent.FARMLAND = addBlock("farmland", new CMFarmlandBlock(FabricBlockSettings.of(Material.SOIL).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRAVEL).blockVision(CMBlocks::always).suffocates(CMBlocks::always)));
    }

    private static <T extends Block> T addBlock(String name, T block) {
        return addBlock(name, block, true);
    }

    private static <T extends Block> T addBlock(String name, T block, boolean addToCreative) {
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
