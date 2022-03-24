package de.prwh.cobaltmod.core.blocks;

import de.prwh.cobaltmod.core.CobaltMod;
import de.prwh.cobaltmod.core.api.CMContent;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class CMBlocks {

    public static void init() {
        CMContent.COBALT_ORE = addBlock(new Block(FabricBlockSettings.of(Material.STONE).strength(5.0F).sounds(BlockSoundGroup.STONE)), "cobalt_ore");
        CMContent.COBALT_GRASS_BLOCK = addBlock(new CobaltGrassBlock(FabricBlockSettings.of(Material.PLANT).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS)), "cobalt_grass");
        CMContent.COBALT_DIRT = addBlock(new Block(FabricBlockSettings.of(Material.SOIL).strength(0.5F).sounds(BlockSoundGroup.GRAVEL)), "cobalt_dirt");
    }

    private static <T extends Block> T addBlock(T block, String name) {
        return addBlock(block, name, true);
    }

    private static <T extends Block> T addBlock(T block, String name, boolean addToCreative) {
        Registry.register(Registry.BLOCK, new Identifier(CobaltMod.MODID, name), block);

        FabricItemSettings itemSettings = new FabricItemSettings();
        if(addToCreative) {
            itemSettings.group(CobaltMod.blockItemGroup);
        }
        Registry.register(Registry.ITEM, new Identifier(CobaltMod.MODID, name), new BlockItem(block, itemSettings));
        return block;
    }
}
