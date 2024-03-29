package de.prwh.cobaltmod.core.item;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import de.prwh.cobaltmod.core.block.CMBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CMHoeItem extends MiningToolItem {
	protected static final Map<Block, Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>>> TILLING_ACTIONS;

	protected CMHoeItem(ToolMaterial toolMaterial, int i, float f, Item.Settings settings) {
		super(i, f, toolMaterial, BlockTags.HOE_MINEABLE, settings);
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		World world = context.getWorld();
		BlockPos blockPos = context.getBlockPos();
		Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>> pair = TILLING_ACTIONS.get(world.getBlockState(blockPos).getBlock());
		if (pair == null) {
			return ActionResult.PASS;
		} else {
			Predicate<ItemUsageContext> predicate = pair.getFirst();
			Consumer<ItemUsageContext> consumer = pair.getSecond();
			if (predicate.test(context)) {
				PlayerEntity playerEntity = context.getPlayer();
				world.playSound(playerEntity, blockPos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
				if (!world.isClient) {
					consumer.accept(context);
					if (playerEntity != null) {
						context.getStack().damage(1, playerEntity, (p) -> {
							p.sendToolBreakStatus(context.getHand());
						});
					}
				}

				return ActionResult.success(world.isClient);
			} else {
				return ActionResult.PASS;
			}
		}
	}

	public static Consumer<ItemUsageContext> createTillAction(BlockState result) {
		return (context) -> {
			context.getWorld().setBlockState(context.getBlockPos(), result, 11);
		};
	}

	public static Consumer<ItemUsageContext> createTillAndDropAction(BlockState result, ItemConvertible droppedItem) {
		return (context) -> {
			context.getWorld().setBlockState(context.getBlockPos(), result, 11);
			Block.dropStack(context.getWorld(), context.getBlockPos(), context.getSide(), new ItemStack(droppedItem));
		};
	}

	public static boolean canTillFarmland(ItemUsageContext context) {
		return context.getSide() != Direction.DOWN && context.getWorld().getBlockState(context.getBlockPos().up()).isAir();
	}

	static {
		TILLING_ACTIONS = Maps.newHashMap(Map.of(Blocks.GRASS_BLOCK, Pair.of(HoeItem::canTillFarmland, createTillAction(Blocks.FARMLAND.getDefaultState())),
			Blocks.DIRT_PATH, Pair.of(HoeItem::canTillFarmland, createTillAction(Blocks.FARMLAND.getDefaultState())),
			Blocks.DIRT, Pair.of(HoeItem::canTillFarmland, createTillAction(Blocks.FARMLAND.getDefaultState())),
			Blocks.COARSE_DIRT, Pair.of(HoeItem::canTillFarmland, createTillAction(Blocks.DIRT.getDefaultState())),
			CMBlocks.COBALT_GRASS_BLOCK, Pair.of(HoeItem::canTillFarmland, createTillAction(CMBlocks.FARMLAND.getDefaultState())),
			CMBlocks.COBALT_DIRT, Pair.of(HoeItem::canTillFarmland, createTillAction(CMBlocks.FARMLAND.getDefaultState())),
			Blocks.ROOTED_DIRT, Pair.of(itemUsageContext -> true, createTillAndDropAction(Blocks.DIRT.getDefaultState(), Items.HANGING_ROOTS))));
	}
}
