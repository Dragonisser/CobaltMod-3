package de.prwh.cobaltmod.core.item.toolmaterial;

import de.prwh.cobaltmod.core.item.CMItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class CobaltToolMaterial implements ToolMaterial {

	public static final CobaltToolMaterial INSTANCE = new CobaltToolMaterial();

	@Override
	public int getDurability() {
		return 2000;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 10.0f;
	}

	@Override
	public float getAttackDamage() {
		return 4.0f;
	}

	@Override
	public int getMiningLevel() {
		return 4;
	}

	@Override
	public int getEnchantability() {
		return 20;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(CMItems.COBALT_INGOT);
	}
}
