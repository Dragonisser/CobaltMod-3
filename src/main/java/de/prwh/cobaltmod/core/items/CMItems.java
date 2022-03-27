package de.prwh.cobaltmod.core.items;

import de.prwh.cobaltmod.core.CobaltMod;
import de.prwh.cobaltmod.core.api.CMContent;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CMItems {

    private CMItems() {}

    public static void init() {
        CMContent.COBALT_INGOT = addItem("cobalt_ingot", new Item(new FabricItemSettings().group(CMContent.ITEM_GROUP)));
        CMContent.COBALT_NUGGET = addItem("cobalt_nugget", new Item(new FabricItemSettings().group(CMContent.ITEM_GROUP)));
        CMContent.RAW_COBALT = addItem("raw_cobalt", new Item(new FabricItemSettings().group(CMContent.ITEM_GROUP)));
        CMContent.COBEX_STICK = addItem("cobex_stick", new Item(new FabricItemSettings().group(CMContent.ITEM_GROUP)));
        //TODO create FoodComponent
        CMContent.RED_CABBAGE = addItem("red_cabbage", new Item(new FabricItemSettings().group(CMContent.ITEM_GROUP).food(FoodComponents.BEETROOT)));
        CMContent.COOKED_RED_CABBAGE = addItem("cooked_red_cabbage", new Item(new FabricItemSettings().group(CMContent.ITEM_GROUP).food(FoodComponents.BEETROOT_SOUP)));
        CMContent.RED_CABBAGE_SEEDS = addItem("red_cabbage_seeds", new AliasedBlockItem(CMContent.RED_CABBAGE_CROP, new FabricItemSettings().group(CMContent.ITEM_GROUP)));
    }

    private static <T extends Item> T addItem(String name, T item) {
        return Registry.register(Registry.ITEM, new Identifier(CobaltMod.MOD_ID, name), item);
    }
}



