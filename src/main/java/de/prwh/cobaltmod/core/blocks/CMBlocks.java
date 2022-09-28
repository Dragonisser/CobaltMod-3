package de.prwh.cobaltmod.core.blocks;

import de.prwh.cobaltmod.core.CobaltMod;
import de.prwh.cobaltmod.core.blocks.sapling.CobexSaplingGenerator;
import de.prwh.cobaltmod.core.blocks.sapling.TallCobexSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;


public class CMBlocks {

    // Blocks
    public static Block COBALT_ORE;
    public static Block COBALT_GRASS_BLOCK;
    public static Block COBALT_BLOCK;
    public static Block COBEX_LOG;
    public static Block COBEX_PLANKS;
    public static Block COBEX_LEAVES;
    public static Block COBEX_SAPLING;
    public static Block BLUE_GRASS;

    public static Block CLEMATIS_FLOWER;
    public static Block RED_CABBAGE_CROP;
    public static Block COBALT_BRICK;
    public static Block COBALT_BRICK_STAIR;
    public static Block COBALT_BRICK_SLAB;
    public static Block COBALT_STONE;
    //	public static BlockPortal PORTAL_COBALDIS;
    public static Block COBEX_TORCH;
    public static Block COBEX_WALL_TORCH;

    public static Block BLUEBERRY_BUSH;
    public static Block RITUAL_STONE;
    public static Block ALTAR_OF_ASSOCIATION;
    public static Block COBEX_STAIR;

    public static Block COBEX_SLAB;

    public static Block BLUE_FIRE;
    public static Block BELL_FLOWER;
    public static Block BOUNCY_COBALT;
    public static Block CORRUPTED_STONE_FURNACE_BURNING;
    public static Block CORRUPTED_STONE_FURNACE_IDLE;
    public static Block COBEX_CHEST;
    public static Block COBEX_DOOR;
    public static Block COBALT_DOOR;
    public static Block PORTAL_FRAME;
    public static Block COBEX_WORK_BENCH;
    public static Block COBALT_BED;
    public static Block DARK_WATER;
    public static Block COBALT_RUNE;
    public static Block CARTHUN_ORE;
    public static Block CARTHUN_BLOCK;
    public static Block CARTHUN_BRICK;
    public static Block CARTHUN_BRICK_STAIR;

//	public static BlockSlab CARTHUN_BRICK_SLAB;

    public static Block GLOW_FLOWER;
    public static Block BLUE_VINE;
    public static Block WATER_THORN;
    public static Block CORRUPTED_STONE;
    public static Block COBALT_DIRT;
    public static Block FARMLAND;
    public static Block PODIUM;
    public static Block TALL_COBEX_SAPLING;
    public static Block TALL_COBEX_LEAVES;
    public static Block LOCKED_COBALT_CHEST;
    public static Block COBALT_CHEST;

    public static Block HARDENED_CORRUPTED_STONE;
    public static Block PORTAL_FRAME_CAVES;
    //	public static BlockPortal PORTAL_CAVES;
    public static Block BLUISH_MUSHROOM;
    public static Block COBEX_DEAD_BUSH;

    public static Block NEUTRALIZER_BURNING;
    public static Block NEUTRALIZER_IDLE;

    private CMBlocks() {
    }

    public static void init() {
        COBALT_ORE = addBlock("cobalt_ore", new OreBlock(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).requiresTool().strength(3.0F, 3.0F), UniformIntProvider.create(3, 7)));
        CORRUPTED_STONE = addBlock("corrupted_stone", new Block(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).requiresTool().strength(1.5F, 6.0F)));
        COBALT_GRASS_BLOCK = addBlock("cobalt_grass_block", new CobaltGrassBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS)));
        COBALT_DIRT = addBlock("cobalt_dirt", new Block(FabricBlockSettings.of(Material.SOIL).strength(0.5F).sounds(BlockSoundGroup.GRAVEL)));
        COBALT_BLOCK = addBlock("cobalt_block", new Block(FabricBlockSettings.of(Material.METAL).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL)));
        COBEX_LOG = addBlock("cobex_log", new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD)));
        COBEX_PLANKS = addBlock("cobex_planks", new Block(FabricBlockSettings.of(Material.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD)));
        COBEX_LEAVES = addBlock("cobex_leaves", createLeavesBlock());
        COBEX_SAPLING = addBlock("cobex_sapling", new CMSaplingBlock(new CobexSaplingGenerator(), FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque()));
        BLUE_GRASS = addBlock("blue_grass", new CMFernBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque()));
        CLEMATIS_FLOWER = addBlock("clematis_flower", new CMFernBlock(FabricBlockSettings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque()));
        BELL_FLOWER = addBlock("bell_flower", new CMFernBlock(FabricBlockSettings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque()));
        GLOW_FLOWER = addBlock("glow_flower", new CMFernBlock(FabricBlockSettings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque().luminance(10)));
        RED_CABBAGE_CROP = addBlock("red_cabbage_crop", new RedCabbageBlock(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)), false, true);
        FARMLAND = addBlock("farmland", new CMFarmlandBlock(FabricBlockSettings.of(Material.SOIL).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRAVEL).blockVision(CMBlocks::always).suffocates(CMBlocks::always)));
        COBEX_TORCH = addBlock("cobex_torch", new TorchBlock(FabricBlockSettings.of(Material.DECORATION).noCollision().breakInstantly().luminance(14).sounds(BlockSoundGroup.WOOD), ParticleTypes.FLAME), false, false);
        COBEX_WALL_TORCH = addBlock("cobex_wall_torch", new WallTorchBlock(FabricBlockSettings.of(Material.DECORATION).noCollision().breakInstantly().luminance(14).sounds(BlockSoundGroup.WOOD).dropsLike(COBEX_TORCH), ParticleTypes.FLAME), false, false);
        COBEX_STAIR = addBlock("cobex_stairs", new StairsBlock(COBEX_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(COBEX_PLANKS)));
        COBEX_SLAB = addBlock("cobex_slab", new SlabBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));
        COBALT_BRICK = addBlock("cobalt_brick", new Block(FabricBlockSettings.of(Material.STONE).strength(2.0F).sounds(BlockSoundGroup.STONE)));
        COBALT_BRICK_STAIR = addBlock("cobalt_brick_stairs", new StairsBlock(COBALT_BRICK.getDefaultState(), AbstractBlock.Settings.copy(COBALT_BRICK)));
        COBALT_BRICK_SLAB = addBlock("cobalt_brick_slab", new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(2.0F, 3.0F).sounds(BlockSoundGroup.STONE)));
        PORTAL_FRAME = addBlock("portal_frame", new Block(FabricBlockSettings.of(Material.STONE).strength(-1.0F, 3600000.0F).dropsNothing()));
        HARDENED_CORRUPTED_STONE = addBlock("hardened_corrupted_stone", new Block(AbstractBlock.Settings.copy(CORRUPTED_STONE)));

        TALL_COBEX_SAPLING = addBlock("tall_cobex_sapling", new CMSaplingBlock(new TallCobexSaplingGenerator(), FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque()));
        TALL_COBEX_LEAVES = addBlock("tall_cobex_leaves", createLeavesBlock());
    }

    private static <T extends Block> T addBlock(String name, T block) {
        return addBlock(name, block, true, true);
    }

    private static <T extends Block> T addBlock(String name, T block, boolean addToItemGroup, boolean registerBlockItem) {
        Registry.register(Registry.BLOCK, new Identifier(CobaltMod.MOD_ID, name), block);

        FabricItemSettings itemSettings = new FabricItemSettings();
        if (addToItemGroup) {
            itemSettings.group(CobaltMod.BLOCK_GROUP);
        }
        if (registerBlockItem) {
            Registry.register(Registry.ITEM, new Identifier(CobaltMod.MOD_ID, name), new BlockItem(block, itemSettings));
        }
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
