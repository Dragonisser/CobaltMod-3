package de.prwh.cobaltmod.core.blocks;

import de.prwh.cobaltmod.core.items.CMItems;
import net.minecraft.item.ItemConvertible;

public class RedCabbageBlock extends CMCropBlock {
    public RedCabbageBlock(Settings settings) {
        super(settings);
    }

    protected ItemConvertible getSeedsItem() {
        return CMItems.RED_CABBAGE_SEEDS;
    }
}
