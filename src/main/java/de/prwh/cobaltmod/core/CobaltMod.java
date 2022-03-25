package de.prwh.cobaltmod.core;

import de.prwh.cobaltmod.core.api.CMContent;
import de.prwh.cobaltmod.core.blocks.CMBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CobaltMod implements ModInitializer {

    public static final String MOD_ID = "mod_cobalt";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        //TODO change itemstack to cobalt_grass and cobalt_ingot
        CMContent.BLOCK_GROUP = FabricItemGroupBuilder.build(
                new Identifier(MOD_ID, "blocks"),
                () -> new ItemStack(CMContent.COBALT_GRASS_BLOCK));

        CMContent.ITEM_GROUP = FabricItemGroupBuilder.create(
                        new Identifier(MOD_ID, "items"))
                .icon(() -> new ItemStack(Items.BOWL))
                .build();

        CMContent.COBALT_AURA = FabricParticleTypes.simple();
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(MOD_ID, "cobalt_aura"), CMContent.COBALT_AURA);

        CMBlocks.init();
    }
}
