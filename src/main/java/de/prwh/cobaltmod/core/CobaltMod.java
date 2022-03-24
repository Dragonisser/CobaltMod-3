package de.prwh.cobaltmod.core;

import de.prwh.cobaltmod.core.blocks.CMBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CobaltMod implements ModInitializer {

    public static final String MODID = "mod_cobalt";

    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    //TODO change itemstack to carthun_ore and cobalt_ingot
    public static final ItemGroup blockItemGroup = FabricItemGroupBuilder.build(
            new Identifier(MODID, "blocks"),
            () -> new ItemStack(Blocks.COBBLESTONE));

    public static final ItemGroup itemItemGroup = FabricItemGroupBuilder.create(
                    new Identifier(MODID, "items"))
            .icon(() -> new ItemStack(Items.BOWL))
            .build();

    @Override
    public void onInitialize() {
        CMBlocks.init();
    }
}
