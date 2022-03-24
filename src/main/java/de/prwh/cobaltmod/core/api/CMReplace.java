package de.prwh.cobaltmod.core.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;

public class CMReplace {

	private static HashMap<Block, Block> map = new HashMap<>();
	private static List<Block> listFlowers = new ArrayList<>();

	/***
	 * Gets the map of blocks
	 * 
	 * @return map
	 */
	public static Map<Block, Block> getSpread() {
		return map;
	}
	
	/***
	 * Gets the list of flowers
	 * 
	 * @return list_flowers
	 */
	public static List<Block> getFlowers() {
		return listFlowers;
	}

	/***
	 * Adds the target and replace block to the list
	 * 
	 * @param target
	 *            = the block that gets replaced
	 * @param replace
	 *            = the block which should be used for the replacement
	 */
	public static void addBlocks(Block target, Block replace) {
		getSpread().put(target, replace);
	}

	/***
	 * Adds the flower to the flower list
	 * 
	 * @param flower
	 *            = the block that gets added to the flower list
	 */
	public static void addFlowers(Block flower) {
		getFlowers().add(flower);
	}
}
