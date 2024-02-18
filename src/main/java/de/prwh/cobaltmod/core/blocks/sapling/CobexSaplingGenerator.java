package de.prwh.cobaltmod.core.blocks.sapling;

import de.prwh.cobaltmod.core.CobaltMod;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.Holder;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Random;

public class CobexSaplingGenerator extends SaplingGenerator {
    public CobexSaplingGenerator() {
    }

    protected Holder<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return CobaltMod.COBEX;
    }
}
