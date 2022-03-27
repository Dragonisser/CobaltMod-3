package de.prwh.cobaltmod.core.api;

import java.util.*;

import de.prwh.cobaltmod.core.CobaltMod;
import de.prwh.cobaltmod.core.blocks.CobaltGrassBlock;
import net.minecraft.block.*;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;

public class CMReplace {

	private static final HashMap<Block, Block> map = new HashMap<>();
	private static final List<Block> listFlowers = new ArrayList<>();
	private static final EnumProperty<Direction.Axis> AXIS = Properties.AXIS;

	private CMReplace() {
		throw new IllegalStateException("Utility class");
	}

	/***
	 * Gets the map of blocks
	 * 
	 * @return map
	 */
	public static Map<Block, Block> getSpread() {
		return map;
	}
	
	/***
	 * Gets the list of flowers
	 * 
	 * @return list_flowers
	 */
	public static List<Block> getFlowers() {
		return listFlowers;
	}

	/***
	 * Adds the target and replace block to the list
	 * 
	 * @param target
	 *            = the block that gets replaced
	 * @param replace
	 *            = the block which should be used for the replacement
	 */
	public static void addBlocks(Block target, Block replace) {
		getSpread().put(target, replace);
	}

	/***
	 * Adds the flower to the flower list
	 * 
	 * @param flower
	 *            = the block that gets added to the flower list
	 */
	public static void addFlowers(Block flower) {
		getFlowers().add(flower);
	}


	private static BlockState getReplacementBlock(Block block) {
		if (!CMReplace.getSpread().isEmpty() && CMReplace.getSpread().containsKey(block)) {
			return CMReplace.getSpread().get(block).getDefaultState();
		}
		return block.getDefaultState();
	}

	private static BlockState getReplacementFlower(World world) {
		if (!CMReplace.getFlowers().isEmpty()) {
			return CMReplace.getFlowers().get(world.random.nextInt(CMReplace.getFlowers().size())).getDefaultState();
		}
		return Blocks.AIR.getDefaultState();
	}

	private static boolean setBlockState(World world, BlockPos blockPos, BlockState blockStateNew) {
		return setBlockState(world, blockPos, blockStateNew, world.getBlockState(blockPos).getBlock());
	}

	private static boolean setBlockState(World world, BlockPos blockPos, BlockState blockStateNew, Block blockOverride) {
		CobaltMod.LOGGER.info("replacing {} with {}", blockOverride.getTranslationKey(), blockStateNew.getBlock().getTranslationKey());
		if (CMReplace.getSpread().containsKey(blockOverride)) {
			if (blockStateNew.getBlock() instanceof CobaltGrassBlock) {
				if(!canSpread(blockStateNew, world, blockPos)) {
					world.setBlockState(blockPos, CMContent.COBALT_DIRT.getDefaultState());
					return false;
				}
			}
			world.setBlockState(blockPos, blockStateNew);
			return true;
		}
		return false;
	}

	/***
	 * Replaces the give block with
	 *
	 * @param world = world
	 * @param blockPos = position of the block that should be replaced
	 */
	public static void replaceBlock(World world, BlockPos blockPos) {
		Block block = world.getBlockState(blockPos).getBlock();
		Block blockUp = world.getBlockState(blockPos.up()).getBlock();
		Block blockBelow = world.getBlockState(blockPos.down()).getBlock();
		BlockState blockStateReplace = world.getBlockState(blockPos);

		if (block instanceof PillarBlock) {
			setBlockState(world, blockPos, getReplacementBlock(block).with(AXIS, blockStateReplace.get(Properties.AXIS)));
		} else if (block instanceof FlowerBlock || block instanceof TallFlowerBlock) {
			CobaltMod.LOGGER.info("Direct replacing");
			if (setBlockState(world, blockPos.down(), getReplacementBlock(blockBelow))) {
				world.setBlockState(blockPos, getReplacementFlower(world));
			}
		} else if (block instanceof FernBlock || block instanceof TallPlantBlock) {
			CobaltMod.LOGGER.info("Direct replacing");
			setBlockState(world, blockPos, Blocks.AIR.getDefaultState());
			setBlockState(world, blockPos.down(), getReplacementBlock(blockBelow));
			setBlockState(world, blockPos, getReplacementBlock(block), block);
		} else {
			if (blockUp instanceof FlowerBlock) {
				world.setBlockState(blockPos.up(), Blocks.AIR.getDefaultState());
				setBlockState(world, blockPos, getReplacementBlock(block));
				world.setBlockState(blockPos.up(), getReplacementFlower(world));
			} else if (blockUp instanceof TallFlowerBlock) {
				CobaltMod.LOGGER.info("Indirect replacing TallFlowerBlock");
				world.setBlockState(blockPos.up(), Blocks.AIR.getDefaultState());
				setBlockState(world, blockPos, getReplacementBlock(block));
				world.setBlockState(blockPos.up(), getReplacementFlower(world));
			} else if (blockUp instanceof FernBlock) {
				world.setBlockState(blockPos.up(), Blocks.AIR.getDefaultState());
				setBlockState(world, blockPos, getReplacementBlock(block));
				setBlockState(world, blockPos.up(), getReplacementBlock(blockUp), blockUp);
			} else if (blockUp instanceof TallPlantBlock) {
				CobaltMod.LOGGER.info("Indirect replacing TallPlantBlock");
				world.setBlockState(blockPos.up().up(), Blocks.AIR.getDefaultState());
				world.setBlockState(blockPos.up(), Blocks.AIR.getDefaultState());
				setBlockState(world, blockPos, getReplacementBlock(block));
				setBlockState(world, blockPos.up(), getReplacementBlock(blockUp), blockUp);
			} else {
				setBlockState(world, blockPos, getReplacementBlock(block));
			}
		}
	}

	private static boolean canSurvive(BlockState state, WorldView world, BlockPos pos) {
		BlockPos blockPos = pos.up();
		BlockState blockState = world.getBlockState(blockPos);
		if (blockState.getFluidState().getLevel() == 8) {
			return false;
		} else {
			int i = ChunkLightProvider.getRealisticOpacity(world, state, pos, blockState, blockPos, Direction.UP, blockState.getOpacity(world, blockPos));
			return i < world.getMaxLightLevel();
		}
	}

	private static boolean canSpread(BlockState state, WorldView world, BlockPos pos) {
		BlockPos blockPos = pos.up();
		return canSurvive(state, world, pos) && !world.getFluidState(blockPos).isIn(FluidTags.WATER);
	}
}
