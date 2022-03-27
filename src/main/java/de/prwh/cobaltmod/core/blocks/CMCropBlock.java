package de.prwh.cobaltmod.core.blocks;

import de.prwh.cobaltmod.core.tag.CMBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class CMCropBlock extends CropBlock {
    public CMCropBlock(Settings settings) {
        super(settings);
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(CMBlockTags.FARMLAND);
    }
}
