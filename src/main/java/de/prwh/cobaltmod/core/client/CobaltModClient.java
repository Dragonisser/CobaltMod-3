package de.prwh.cobaltmod.core.client;

import de.prwh.cobaltmod.core.CobaltMod;
import de.prwh.cobaltmod.core.block.CMBlocks;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.SuspendParticle;
import net.minecraft.client.render.RenderLayer;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;

public class CobaltModClient implements ClientModInitializer {

	@Override
	public void onInitializeClient(ModContainer mod) {
		BlockRenderLayerMap.put(RenderLayer.getCutout(), CMBlocks.COBEX_SAPLING, CMBlocks.TALL_COBEX_SAPLING,
			CMBlocks.BLUE_GRASS, CMBlocks.CLEMATIS_FLOWER, CMBlocks.BELL_FLOWER, CMBlocks.GLOW_FLOWER,
			CMBlocks.RED_CABBAGE_CROP, CMBlocks.COBEX_TORCH, CMBlocks.COBEX_WALL_TORCH);

		ParticleFactoryRegistry.getInstance().register(CobaltMod.COBALT_AURA, SuspendParticle.MyceliumFactory::new);
	}
}
