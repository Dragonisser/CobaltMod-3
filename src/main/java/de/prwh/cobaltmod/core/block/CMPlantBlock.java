package de.prwh.cobaltmod.core.block;

import de.prwh.cobaltmod.core.tag.CMBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class CMPlantBlock extends PlantBlock {

    public CMPlantBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(CMBlockTags.DIRT);
    }
}
