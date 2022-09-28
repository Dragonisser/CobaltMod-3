package de.prwh.cobaltmod.core;

import de.prwh.cobaltmod.core.blocks.CMBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.SuspendParticle;
import net.minecraft.client.render.RenderLayer;

public class CobaltModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(CMBlocks.COBEX_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CMBlocks.TALL_COBEX_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CMBlocks.BLUE_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CMBlocks.CLEMATIS_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CMBlocks.BELL_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CMBlocks.GLOW_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CMBlocks.RED_CABBAGE_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CMBlocks.COBEX_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CMBlocks.COBEX_WALL_TORCH, RenderLayer.getCutout());

        ParticleFactoryRegistry.getInstance().register(CobaltMod.COBALT_AURA, SuspendParticle.MyceliumFactory::new);
    }
}
