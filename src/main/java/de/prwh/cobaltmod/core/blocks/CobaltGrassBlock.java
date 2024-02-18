package de.prwh.cobaltmod.core.blocks;

import de.prwh.cobaltmod.core.CobaltMod;
import net.minecraft.advancement.Advancement;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;

import java.util.Random;

public class CobaltGrassBlock extends Block {

    static final String CRITERION = "step_on_block";
    static final Identifier IDENTIFIER = new Identifier(CobaltMod.MOD_ID, "story/root");

    public CobaltGrassBlock(Settings settings) {
        super(settings);
    }

    private static boolean canSurvive(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.up();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.getFluidState().getLevel() == 8) {
            return false;
        } else {
            int i = ChunkLightProvider.getRealisticOpacity(world, state, pos, blockState, blockPos, Direction.UP, blockState.getOpacity(world, blockPos));
            return i < world.getMaxLightLevel();
        }
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!canSurvive(state, world, pos)) {
            world.setBlockState(pos, CMBlocks.COBALT_DIRT.getDefaultState());
        } else {
            /* TODO check later
            if (world.getLightLevel(pos.up()) >= 9) {
                for (int i = 0; i < 4; ++i) {
                    BlockPos blockPos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                    CMReplace.replaceBlock(world, blockPos);
                }
            }*/
        }
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);
        if (random.nextInt(10) == 0) {
            world.addParticle(CobaltMod.COBALT_AURA, (double) pos.getX() + random.nextDouble(), (double) pos.getY() + 1.1D, (double) pos.getZ() + random.nextDouble(), 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {

        //TODO adjust for different boot types
        if (!entity.isFireImmune() && entity instanceof LivingEntity livingEntity && !EnchantmentHelper.hasFrostWalker(livingEntity)) {
            entity.damage(DamageSource.MAGIC, 1.0F);
        }

        if (entity instanceof ServerPlayerEntity serverPlayerEntity) {
            Advancement advancement = serverPlayerEntity.server.getAdvancementLoader().get(IDENTIFIER);
            serverPlayerEntity.getAdvancementTracker().grantCriterion(advancement, CRITERION);
        }
        super.onSteppedOn(world, pos, state, entity);
    }
}
