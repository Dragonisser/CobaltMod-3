package de.prwh.cobaltmod.core;

import de.prwh.cobaltmod.core.api.CMContent;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.SuspendParticle;
import net.minecraft.client.render.RenderLayer;

public class CobaltModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(CMContent.COBEX_SAPLING, RenderLayer.getCutout());

        ParticleFactoryRegistry.getInstance().register(CMContent.COBALT_AURA, SuspendParticle.MyceliumFactory::new);
    }
}
