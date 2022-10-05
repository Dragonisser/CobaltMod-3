package de.prwh.cobaltmod.core.blocks.sapling;

import de.prwh.cobaltmod.core.CobaltMod;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Random;

public class TallCobexSaplingGenerator extends SaplingGenerator {
    public TallCobexSaplingGenerator() {
    }

    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return CobaltMod.TALL_COBEX;
    }
}
