package de.prwh.cobaltmod.core.block.sapling;

import de.prwh.cobaltmod.core.CobaltMod;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Random;

public class CobexSaplingGenerator extends SaplingGenerator {
    public CobexSaplingGenerator() {
    }

    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return CobaltMod.getTreeFeatureCobex();
    }
}
