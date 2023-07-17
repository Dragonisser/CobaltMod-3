package de.prwh.cobaltmod.core.items;

import net.minecraft.item.Item;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.BlockTags;

public class CMPickaxeItem extends MiningToolItem {
	protected CMPickaxeItem(ToolMaterial toolMaterial, int i, float f, Item.Settings settings) {
		super((float)i, f, toolMaterial, BlockTags.PICKAXE_MINEABLE, settings);
	}
}
