package de.prwh.cobaltmod.core.items.toolmaterial;

import de.prwh.cobaltmod.core.blocks.CMBlocks;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class CobexToolMaterial implements ToolMaterial {

	public static final CobexToolMaterial INSTANCE = new CobexToolMaterial();

	@Override
	public int getDurability() {
		return 150;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 6.0f;
	}

	@Override
	public float getAttackDamage() {
		return 1.0f;
	}

	@Override
	public int getMiningLevel() {
		return 1;
	}

	@Override
	public int getEnchantability() {
		return 10;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(CMBlocks.COBEX_PLANKS);
	}
}
