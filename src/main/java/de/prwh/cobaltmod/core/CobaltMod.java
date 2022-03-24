package de.prwh.cobaltmod.core;

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

    public static final Logger LOGGER = LoggerFactory.getLogger("mod_cobalt");

    //TODO change itemstack to carthun_ore and cobalt_ingot
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier("mod_cobalt", "blocks"),
            () -> new ItemStack(Blocks.COBBLESTONE));

    public static final ItemGroup OTHER_GROUP = FabricItemGroupBuilder.create(
                    new Identifier("mod_cobalt", "items"))
            .icon(() -> new ItemStack(Items.BOWL))
            .build();

    @Override
    public void onInitialize() {

    }
}
