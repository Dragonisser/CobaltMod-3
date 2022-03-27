package de.prwh.cobaltmod.core.api;

import net.minecraft.block.Block;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

/**
 * Contains all the Blocks or Item the Mod has added
 */
public enum CMContent {
	INSTANCE;

	//ItemGroup
	public static ItemGroup BLOCK_GROUP;
	public static ItemGroup ITEM_GROUP;

	//Particle
	public static DefaultParticleType COBALT_AURA;

	//Trees
	public static RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> COBEX;

	//FoodComponents
	//public static FoodComponent

	// ToolMaterial
	// public static ToolMaterial COBALT_TOOL;
	// public static ToolMaterial COBEX_TOOL;

	// ArmorMaterial
	// public static ArmorMaterial COBALT_ARMOR;

	// Fluid
	// public static Fluid DARK_WATER_FLUID;

	// Blocks
	public static Block COBALT_ORE;
	public static Block COBALT_GRASS_BLOCK;
	public static Block COBALT_BLOCK;
	public static Block COBEX_LOG;
	public static Block COBEX_PLANKS;
	public static Block COBEX_LEAVES;
	public static Block COBEX_SAPLING;
	public static Block BLUE_GRASS;
//	public static BlockSlab COBALT_HALF_SLAB;
//	public static BlockSlab COBALT_DOUBLE_SLAB;
	public static Block CLEMATIS_FLOWER;
	public static Block RED_CABBAGE_CROP;
	public static Block COBALT_BRICK;
	public static Block COBALT_BRICK_STAIR;
	public static Block COBALT_STONE;
//	public static BlockPortal PORTAL_COBALDIS;
	public static Block COBEX_TORCH;

	public static Block BLUEBERRY_BUSH;
	public static Block RITUAL_STONE;
	public static Block ALTAR_OF_ASSOCIATION;
	public static Block COBEX_STAIR;

//	public static BlockSlab COBEX_HALF_SLAB;
//	public static BlockSlab COBEX_DOUBLE_SLAB;

	public static Block BLUE_FIRE;
	public static Block BELL_FLOWER;
	public static Block BOUNCY_COBALT;
	public static Block COBALT_FURNACE_IDLE;
	public static Block COBALT_FURNACE_BURNING;
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

//	public static BlockSlab CARTHUN_BRICK_SINGLE_SLAB;
//	public static BlockSlab CARTHUN_BRICK_DOUBLE_SLAB;

	public static Block GLOW_FLOWER;
	public static Block BLUE_VINE;
	public static Block WATER_THORN;
	public static Block CORRUPTED_STONE;
	public static Block COBALT_DIRT;
	public static Block FARMLAND;
	public static Block PODIUM;
	public static Block BIG_COBEX_SAPLING;
	public static Block BIG_COBEX_LEAVES;
	public static Block CORRUPTED_STONE_FURNACE_BURNING;
	public static Block CORRUPTED_STONE_FURNACE_IDLE;
	public static Block LOCKED_COBALT_CHEST;
	public static Block COBALT_CHEST;

	public static Block HARDENED_CORRUPTED_STONE;
	public static Block PORTAL_FRAME_CAVES;
//	public static BlockPortal PORTAL_CAVES;
	public static Block BLUISH_MUSHROOM;
	public static Block COBEX_DEAD_BUSH;

	public static Block NEUTRALIZER_BURNING;
	public static Block NEUTRALIZER_IDLE;

	// Items
	public static Item COBALT_PICKAXE;
	public static Item COBALT_AXE;
	public static Item COBALT_SHOVEL;
	public static Item COBALT_SWORD;
	public static Item COBALT_HOE;
	public static Item COBALT_INGOT;
	public static Item RAW_COBALT;
	public static Item COBALT_APPLE;
	public static Item COBEX_STICK;
	public static Item COBEX_BOW;
	public static Item COBEX_ARROW;
	public static Item RED_CABBAGE_SEEDS;
	public static Item RED_CABBAGE;
	public static Item COOKED_RED_CABBAGE;
	public static Item COBALT_HELMET;
	public static Item COBALT_CHEST_PLATE;
	public static Item COBALT_LEGGINGS;
	public static Item COBALT_BOOTS;
	public static Item COBALT_NUGGET;
	public static Item COBEX_PICKAXE;
	public static Item COBEX_AXE;
	public static Item COBEX_SHOVEL;
	public static Item COBEX_SWORD;
	public static Item COBEX_HOE;
	public static Item RECIPE_BOOK;
	public static Item FOENUM_STAFF;
	public static Item NJOSS_STAFF;
	public static Item FOENUM_CRYSTAL;
	public static Item NJOSS_CRYSTAL;
	public static Item COBALT_STONE_FRAGMENT;
	public static Item COBALT_STONE_CRYSTAL;
	public static Item BLUE_ESSENCE;
	public static Item GREEN_ESSENCE;
	public static Item BLUE_BERRY;
	public static Item COBALT_FERTILIZER;
	public static Item FIRE_SHARD;
	public static Item COBEX_DOOR_I;
	public static Item COBALT_DOOR_I;
	public static Item COBALT_BED_I;
	public static Item STONE_FRAGMENT;
	public static Item STONE_CRYSTAL;
	public static Item BUCKET_DARK_WATER;
	public static Item COBALT_DIVING_GOGGLES;
	public static Item WIND_AXE;
	public static Item CARTHUN_INGOT;
	public static Item BLUE_SLIME_BALL;
	public static Item COBALT_SCYTHE;
	public static Item COBALT_SICKLE;
	public static Item HUNTER_KNIFE;
	public static Item LEATHER_STRIPS;
	public static Item BLUE_BACKPACK;
	public static Item COBALT_CHEST_PLATE_BACKPACK;
	public static Item BLUE_STRING;
	public static Item BLUE_WOOL;
	public static Item SPEED_COBALT_BOOTS;
	public static Item CHEST_KEY;
	public static Item WATER_THORN_I;
}
