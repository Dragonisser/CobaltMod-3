package de.prwh.cobaltmod.core;

import de.prwh.cobaltmod.core.api.CMContent;
import de.prwh.cobaltmod.core.api.CMReplace;
import de.prwh.cobaltmod.core.blocks.CMBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.block.Blocks;
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

        CMReplace.addBlocks(CMContent.COBALT_DIRT, CMContent.COBALT_GRASS_BLOCK);
        CMReplace.addBlocks(Blocks.DIRT, CMContent.COBALT_GRASS_BLOCK);
        CMReplace.addBlocks(Blocks.GRASS, CMContent.COBALT_GRASS_BLOCK);
        CMReplace.addBlocks(Blocks.ACACIA_LOG, CMContent.COBEX_LOG);
        CMReplace.addBlocks(Blocks.BIRCH_LOG, CMContent.COBEX_LOG);
        CMReplace.addBlocks(Blocks.DARK_OAK_LOG, CMContent.COBEX_LOG);
        CMReplace.addBlocks(Blocks.JUNGLE_LOG, CMContent.COBEX_LOG);
        CMReplace.addBlocks(Blocks.OAK_LOG, CMContent.COBEX_LOG);
        CMReplace.addBlocks(Blocks.SPRUCE_LOG, CMContent.COBEX_LOG);
        CMReplace.addBlocks(Blocks.GRASS, CMContent.BLUE_TALL_GRASS);
        CMReplace.addBlocks(Blocks.TALL_GRASS, CMContent.BLUE_TALL_GRASS);

        CMReplace.addFlowers(CMContent.CLEMATIS_FLOWER);
        CMReplace.addFlowers(CMContent.BELL_FLOWER);
        CMReplace.addFlowers(CMContent.GLOW_FLOWER);
    }
}
