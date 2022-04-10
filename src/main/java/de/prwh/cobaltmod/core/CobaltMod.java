package de.prwh.cobaltmod.core;

import de.prwh.cobaltmod.core.api.CMReplace;
import de.prwh.cobaltmod.core.blocks.CMBlocks;
import de.prwh.cobaltmod.core.items.CMItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CobaltMod implements ModInitializer {

    public static final String MOD_ID = "mod_cobalt";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    //ItemGroup
    public static ItemGroup BLOCK_GROUP;
    public static ItemGroup ITEM_GROUP;

    //Particle
    public static DefaultParticleType COBALT_AURA;

    //Trees
    public static RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> COBEX;

    @Override
    public void onInitialize() {
        BLOCK_GROUP = FabricItemGroupBuilder.build(
                new Identifier(MOD_ID, "blocks"),
                () -> new ItemStack(CMBlocks.COBALT_GRASS_BLOCK));

        ITEM_GROUP = FabricItemGroupBuilder.create(
                        new Identifier(MOD_ID, "items"))
                .icon(() -> new ItemStack(CMItems.COBALT_INGOT))
                .build();

        COBALT_AURA = FabricParticleTypes.simple();
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(MOD_ID, "cobalt_aura"), COBALT_AURA);

        CMBlocks.init();
        CMItems.init();

        COBEX = ConfiguredFeatures.register("cobex", Feature.TREE, (builder(CMBlocks.COBEX_LOG, CMBlocks.COBEX_LEAVES, 4, 2, 0, 2)).dirtProvider(BlockStateProvider.of(CMBlocks.COBALT_DIRT)).ignoreVines().build());


        CMReplace.addBlocks(CMBlocks.COBALT_DIRT, CMBlocks.COBALT_GRASS_BLOCK);
        CMReplace.addBlocks(Blocks.DIRT, CMBlocks.COBALT_GRASS_BLOCK);
        CMReplace.addBlocks(Blocks.GRASS_BLOCK, CMBlocks.COBALT_GRASS_BLOCK);
        CMReplace.addBlocks(Blocks.ACACIA_LOG, CMBlocks.COBEX_LOG);
        CMReplace.addBlocks(Blocks.BIRCH_LOG, CMBlocks.COBEX_LOG);
        CMReplace.addBlocks(Blocks.DARK_OAK_LOG, CMBlocks.COBEX_LOG);
        CMReplace.addBlocks(Blocks.JUNGLE_LOG, CMBlocks.COBEX_LOG);
        CMReplace.addBlocks(Blocks.OAK_LOG, CMBlocks.COBEX_LOG);
        CMReplace.addBlocks(Blocks.SPRUCE_LOG, CMBlocks.COBEX_LOG);
        CMReplace.addBlocks(Blocks.GRASS, CMBlocks.BLUE_GRASS);
        CMReplace.addBlocks(Blocks.TALL_GRASS, CMBlocks.BLUE_GRASS);

        CMReplace.addFlowers(CMBlocks.CLEMATIS_FLOWER);
        CMReplace.addFlowers(CMBlocks.BELL_FLOWER);
        CMReplace.addFlowers(CMBlocks.GLOW_FLOWER);
    }

    private static TreeFeatureConfig.Builder builder(Block log, Block leaves, int baseHeight, int firstRandomHeight, int secondRandomHeight, int radius) {
        return new TreeFeatureConfig.Builder(BlockStateProvider.of(log), new StraightTrunkPlacer(baseHeight, firstRandomHeight, secondRandomHeight), BlockStateProvider.of(leaves), new BlobFoliagePlacer(ConstantIntProvider.create(radius), ConstantIntProvider.create(0), 3), new TwoLayersFeatureSize(1, 0, 1));
    }
}
