package de.prwh.cobaltmod.core.block;

import de.prwh.cobaltmod.core.tag.CMBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class CMSaplingBlock extends SaplingBlock {

    public CMSaplingBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(CMBlockTags.DIRT);
    }
}
