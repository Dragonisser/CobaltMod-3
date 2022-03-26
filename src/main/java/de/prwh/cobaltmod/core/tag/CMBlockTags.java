package de.prwh.cobaltmod.core.tag;

import de.prwh.cobaltmod.core.CobaltMod;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class CMBlockTags {
    public static final TagKey<Block> LEAVES = register("leaves");
    public static final TagKey<Block> LOGS = register("logs");
    public static final TagKey<Block> LOGS_THAT_BURN = register("logs_that_burn");
    public static final TagKey<Block> COBEX_LOGS = register("cobex_logs");
    public static final TagKey<Block> DIRT = register("dirt");

    private CMBlockTags() {
    }

    private static TagKey<Block> register(String id) {
        return TagKey.of(Registry.BLOCK_KEY, new Identifier(CobaltMod.MOD_ID, id));
    }
}