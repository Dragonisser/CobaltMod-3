package de.prwh.cobaltmod.core.client.render.block.entity;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.block.ChestAnimationProgress;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;

public class CobexChestBlockEntityRenderer<T extends BlockEntity & ChestAnimationProgress> extends ChestBlockEntityRenderer {
	public CobexChestBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
		super(context);
	}
}
