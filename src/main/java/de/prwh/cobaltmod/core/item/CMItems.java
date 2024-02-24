package de.prwh.cobaltmod.core.item;

import de.prwh.cobaltmod.core.CobaltMod;
import de.prwh.cobaltmod.core.block.BlueBerryBushBlock;
import de.prwh.cobaltmod.core.block.CMBlocks;
import de.prwh.cobaltmod.core.item.toolmaterial.CobaltToolMaterial;
import de.prwh.cobaltmod.core.item.toolmaterial.CobexToolMaterial;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class CMItems {

    // Items
    public static Item COBALT_PICKAXE;
    public static ToolItem COBALT_AXE;
    public static Item COBALT_SHOVEL;
    public static Item COBALT_SWORD;
    public static Item COBALT_HOE;
    public static Item COBALT_INGOT;
    public static Item COBEX_TORCH;
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
    public static Item COBALDIS_ESSENCE;
    public static Item OVERWORLD_ESSENCE;
    public static Item BLUE_BERRY;
    public static Item COBALT_FERTILIZER;
    public static Item FIRE_SHARD;
    public static Item COBEX_DOOR;
    public static Item COBALT_DOOR;
    public static Item COBALT_BED;
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
    public static Item WATER_THORN;

    private CMItems() {}

    public static void init() {

        COBALT_INGOT = addItem("cobalt_ingot", new Item(giveDefaultQIS()));
        COBALT_NUGGET = addItem("cobalt_nugget", new Item(giveDefaultQIS()));
        RAW_COBALT = addItem("raw_cobalt", new Item(giveDefaultQIS()));
        COBEX_STICK = addItem("cobex_stick", new Item(giveDefaultQIS()));
        RED_CABBAGE = addItem("red_cabbage", new Item(giveDefaultQIS().food(CobaltMod.RED_CABBAGE)));
        COOKED_RED_CABBAGE = addItem("cooked_red_cabbage", new Item(giveDefaultQIS().food(CobaltMod.COOKED_RED_CABBAGE)));
        RED_CABBAGE_SEEDS = addItem("red_cabbage_seeds", new AliasedBlockItem(CMBlocks.RED_CABBAGE_CROP, giveDefaultQIS()));
        COBEX_TORCH = addItem("cobex_torch", new WallStandingBlockItem(CMBlocks.COBEX_TORCH, CMBlocks.COBEX_WALL_TORCH, giveDefaultQIS()));
        FIRE_SHARD = addItem("fire_shard", new Item(giveDefaultQIS()));
        BLUE_BERRY = addItem("blue_berry", new AliasedBlockItem(CMBlocks.BLUEBERRY_BUSH, giveDefaultQIS().food(CobaltMod.BLUE_BERRY)));
        OVERWORLD_ESSENCE = addItem("overworld_essence", new Item(giveDefaultQIS()));
        COBALDIS_ESSENCE = addItem("cobaldis_essence", new Item(giveDefaultQIS()));
        STONE_CRYSTAL = addItem("stone_crystal", new Item(giveDefaultQIS()));
        STONE_FRAGMENT = addItem("stone_fragment", new Item(giveDefaultQIS()));

		//TOOLS
		COBALT_SWORD = addItem("cobalt_sword", new CMSwordItem(CobaltToolMaterial.INSTANCE, 3, -2.4F, giveDefaultQIS()));
		COBALT_SHOVEL = addItem("cobalt_shovel", new CMShovelItem(CobaltToolMaterial.INSTANCE, 1.5F, -3.0F, giveDefaultQIS()));
		COBALT_PICKAXE = addItem("cobalt_pickaxe", new CMPickaxeItem(CobaltToolMaterial.INSTANCE, 1, -2.8F, giveDefaultQIS()));
		COBALT_AXE = addItem("cobalt_axe", new CMAxeItem(CobaltToolMaterial.INSTANCE, 5.0F, -3.0F, giveDefaultQIS()));
		COBALT_HOE = addItem("cobalt_hoe", new CMHoeItem(CobaltToolMaterial.INSTANCE, -4, 0.0F, giveDefaultQIS()));

		COBEX_SWORD = addItem("cobex_sword", new CMSwordItem(CobexToolMaterial.INSTANCE, 3, -2.4F, giveDefaultQIS()));
		COBEX_SHOVEL = addItem("cobex_shovel", new CMShovelItem(CobexToolMaterial.INSTANCE, 1.5F, -3.0F, giveDefaultQIS()));
		COBEX_PICKAXE = addItem("cobex_pickaxe", new CMPickaxeItem(CobexToolMaterial.INSTANCE, 1, -2.8F, giveDefaultQIS()));
		COBEX_AXE = addItem("cobex_axe", new CMAxeItem(CobexToolMaterial.INSTANCE, 7.0F, -3.2F, giveDefaultQIS()));
		COBEX_HOE = addItem("cobex_hoe", new CMHoeItem(CobexToolMaterial.INSTANCE, -1, -2.0F, giveDefaultQIS()));
    }

    private static <T extends Item> T addItem(String name, T item) {
        return Registry.register(Registry.ITEM, new Identifier(CobaltMod.MOD_ID, name), item);
    }

    private static QuiltItemSettings giveDefaultQIS() {
        return new QuiltItemSettings().group(CobaltMod.ITEM_GROUP);
    }
}



