package de.prwh.cobaltmod.core.blocks.sapling;

import de.prwh.cobaltmod.core.api.CMContent;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Random;

public class CobexSaplingGenerator extends SaplingGenerator {
    public CobexSaplingGenerator() {
    }

    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return CMContent.COBEX;
    }
}
