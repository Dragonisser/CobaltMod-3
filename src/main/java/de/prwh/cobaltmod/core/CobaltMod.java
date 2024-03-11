package de.prwh.cobaltmod.core;

import de.prwh.cobaltmod.core.api.CMReplace;
import de.prwh.cobaltmod.core.block.CMBlocks;
import de.prwh.cobaltmod.core.config.Config;
import de.prwh.cobaltmod.core.item.CMItems;
import de.prwh.cobaltmod.core.world.gen.treedecorator.LeavesBlueVineTreeDecorator;
import de.prwh.cobaltmod.mixin.TreeDecoratorTypeInvoker;
import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Holder;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.feature.util.ConfiguredFeatureUtil;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.item.group.api.QuiltItemGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CobaltMod implements ModInitializer {

	public static final String MOD_ID = "mod_cobalt";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	//ItemGroup
	public static final ItemGroup BLOCK_GROUP = QuiltItemGroup.builder(
			new Identifier(MOD_ID, "blocks"))
		.icon(() -> new ItemStack(CMBlocks.COBALT_GRASS_BLOCK))
		.build();
	public static final ItemGroup ITEM_GROUP = QuiltItemGroup.builder(
			new Identifier(MOD_ID, "items"))
		.icon(() -> new ItemStack(CMItems.COBALT_INGOT))
		.build();

	//Particle
	public static final DefaultParticleType COBALT_AURA = FabricParticleTypes.simple();

	//Trees
	private static Holder<ConfiguredFeature<TreeFeatureConfig, ?>> COBEX;
	private static Holder<ConfiguredFeature<TreeFeatureConfig, ?>> TALL_COBEX;

	//TreeDecorator
	public static final TreeDecoratorType<LeavesBlueVineTreeDecorator> LEAVES_BLUE_VINE_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("mod_cobalt:leaves_blue_vine_tree_decorator", LeavesBlueVineTreeDecorator.CODEC);

	//FoodComponent
	public static final FoodComponent BLUE_BERRY = (new FoodComponent.Builder()).hunger(1).saturationModifier(0.6F).build();
	public static final FoodComponent RED_CABBAGE = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.6F).build();
	public static final FoodComponent COOKED_RED_CABBAGE = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.6F).build();

	public static Holder<ConfiguredFeature<TreeFeatureConfig, ?>> getTreeFeatureCobex() {
		return COBEX;
	}

	public static void setTreeFeatureCobex(Holder<ConfiguredFeature<TreeFeatureConfig, ?>> configuredFeatureHolder) {
		CobaltMod.COBEX = configuredFeatureHolder;
	}

	public static Holder<ConfiguredFeature<TreeFeatureConfig, ?>> getTreeFeatureTallCobex() {
		return TALL_COBEX;
	}

	public static void setTreeFeatureTallCobex(Holder<ConfiguredFeature<TreeFeatureConfig, ?>> configuredFeatureHolder) {
		CobaltMod.TALL_COBEX = configuredFeatureHolder;
	}

	@Override
	public void onInitialize(ModContainer mod) {

		Registry.register(Registry.PARTICLE_TYPE, new Identifier(MOD_ID, "cobalt_aura"), COBALT_AURA);

		CMBlocks.init();
		CMItems.init();

		setTreeFeatureCobex(ConfiguredFeatureUtil.register("cobex", Feature.TREE, (builder(CMBlocks.COBEX_LOG, CMBlocks.COBEX_LEAVES, 4, 2, 0, 2)).dirtProvider(BlockStateProvider.of(CMBlocks.COBALT_DIRT)).ignoreVines().build()));
		setTreeFeatureTallCobex(ConfiguredFeatureUtil.register("tall_cobex", Feature.TREE, (builder(CMBlocks.COBEX_LOG, CMBlocks.TALL_COBEX_LEAVES, 8, 2, 0, 2)).dirtProvider(BlockStateProvider.of(CMBlocks.COBALT_DIRT)).ignoreVines().build()));

		CustomPortalBuilder.beginPortal()
			.frameBlock(CMBlocks.PORTAL_FRAME)
			.lightWithItem(CMItems.FIRE_SHARD)
			.destDimID(new Identifier(MOD_ID, "cobaldis"))
			.tintColor(7, 37, 94)
			.onlyLightInOverworld()
			.registerPortal();


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

		MidnightConfig.init(MOD_ID, Config.class);
	}

	private static TreeFeatureConfig.Builder builder(Block log, Block leaves, int baseHeight, int firstRandomHeight, int secondRandomHeight, int radius) {
		return new TreeFeatureConfig.Builder(BlockStateProvider.of(log), new StraightTrunkPlacer(baseHeight, firstRandomHeight, secondRandomHeight), BlockStateProvider.of(leaves), new BlobFoliagePlacer(ConstantIntProvider.create(radius), ConstantIntProvider.create(0), 3), new TwoLayersFeatureSize(1, 0, 1));
	}
}
