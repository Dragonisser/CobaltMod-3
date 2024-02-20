package de.prwh.cobaltmod.core.world.gen.treedecorator;

import com.mojang.serialization.Codec;
import de.prwh.cobaltmod.core.block.CMBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.VineBlock;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class LeavesBlueVineTreeDecorator extends TreeDecorator {

	public static final LeavesBlueVineTreeDecorator INSTANCE = new LeavesBlueVineTreeDecorator();
	// Our constructor doesn't have any arguments, so we create a unit codec that returns the singleton instance
	public static final Codec<LeavesBlueVineTreeDecorator> CODEC = Codec.unit(() -> INSTANCE);

	private LeavesBlueVineTreeDecorator() {}

	@Override
	protected TreeDecoratorType<?> getType() {
		return null;
	}

	@Override
	public void generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, List<BlockPos> logPositions, List<BlockPos> leavesPositions) {
		leavesPositions.forEach(pos -> {
			BlockPos blockPos;
			if (random.nextInt(4) == 0) {
				blockPos = pos.west();
				if (Feature.isAir(world, blockPos)) {
					placeVines(world, blockPos, VineBlock.EAST, replacer);
				}
			}

			if (random.nextInt(4) == 0) {
				blockPos = pos.east();
				if (Feature.isAir(world, blockPos)) {
					placeVines(world, blockPos, VineBlock.WEST, replacer);
				}
			}

			if (random.nextInt(4) == 0) {
				blockPos = pos.north();
				if (Feature.isAir(world, blockPos)) {
					placeVines(world, blockPos, VineBlock.SOUTH, replacer);
				}
			}

			if (random.nextInt(4) == 0) {
				blockPos = pos.south();
				if (Feature.isAir(world, blockPos)) {
					placeVines(world, blockPos, VineBlock.NORTH, replacer);
				}
			}

		});
	}

	private static void placeVines(TestableWorld world, BlockPos pos, BooleanProperty facing, BiConsumer<BlockPos, BlockState> replacer) {
		placeVine(replacer, pos, facing);
		int i = 4;

		for(pos = pos.down(); Feature.isAir(world, pos) && i > 0; --i) {
			placeVine(replacer, pos, facing);
			pos = pos.down();
		}

	}

	protected static void placeVine(BiConsumer<BlockPos, BlockState> replacer, BlockPos pos, BooleanProperty facing) {
		replacer.accept(pos, CMBlocks.BLUE_VINE.getDefaultState().with(facing, true));
	}
}
