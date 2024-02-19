package de.prwh.cobaltmod.core.block;

import de.prwh.cobaltmod.core.tag.CMBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;

import java.util.Random;

public class CMLeavesBlock extends LeavesBlock {
    public CMLeavesBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.setBlockState(pos, updateDistanceFromLogs(state, world, pos), 3);
    }

    private static BlockState updateDistanceFromLogs(BlockState state, WorldAccess world, BlockPos pos) {
        int i = 7;
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        Direction[] var5 = Direction.values();
        int var6 = var5.length;

        for (int var7 = 0; var7 < var6; ++var7) {
            Direction direction = var5[var7];
            mutable.set(pos, direction);
            i = Math.min(i, getDistanceFromLog(world.getBlockState(mutable)) + 1);
            if (i == 1) {
                break;
            }
        }

        return (BlockState) state.with(DISTANCE, i);
    }

    @Override
	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
		int i = getDistanceFromLog(neighborState) + 1;
		if (i != 1 || state.get(DISTANCE) != i) {
			world.scheduleBlockTick(pos, this, 1);
		}

		return state;
	}

    private static int getDistanceFromLog(BlockState state) {
        if (state.isIn(CMBlockTags.LOGS)) {
            return 0;
        } else {
            return state.getBlock() instanceof CMLeavesBlock ? (Integer) state.get(DISTANCE) : 7;
        }
    }
}
