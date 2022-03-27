package de.prwh.cobaltmod.core.blocks;

import de.prwh.cobaltmod.core.api.CMContent;
import net.minecraft.item.ItemConvertible;

public class RedCabbageBlock extends CMCropBlock {
    public RedCabbageBlock(Settings settings) {
        super(settings);
    }

    protected ItemConvertible getSeedsItem() {
        return CMContent.RED_CABBAGE_SEEDS;
    }
}
