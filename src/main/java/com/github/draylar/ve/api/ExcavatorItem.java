package com.github.draylar.ve.api;

import com.github.draylar.ve.VanillaExcavators;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;
import java.util.Set;

public class ExcavatorItem extends ShovelItem
{
    private static final Set<Block> EFFECTIVE_BLOCKS;

    public ExcavatorItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed)
    {
        this(toolMaterial, attackDamage, attackSpeed, new Item.Settings().group(ItemGroup.TOOLS));
    }

    public ExcavatorItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Item.Settings settings)
    {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean isEffectiveOn(BlockState state) {
        return EFFECTIVE_BLOCKS.contains(state.getBlock());
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos blockPos, PlayerEntity player) {
        if (VanillaExcavators.CONFIG.breakSingleBlockWhenSneaking && player.isSneaking()) {
            return true;
        }

        float originHardness = world.getBlockState(blockPos).getHardness(null, null);

        // only do a 3x3 break if the player's tool is effective on the block they are breaking
        // this makes it so breaking gravel doesn't break nearby stone
        if (player.getMainHandStack().isEffectiveOn(world.getBlockState(blockPos))) {
            BlockBreaker.breakInRadius(world, player, 1, (breakState) -> {
                double hardness = breakState.getHardness(null, null);
                boolean isEffective = player.getMainHandStack().isEffectiveOn(breakState);
                boolean verifyHardness = hardness < originHardness * 5 && hardness > 0;
                return isEffective && verifyHardness;
            }, true);
        }

        // center particle
        if(world.isClient) {
            world.playLevelEvent(2001, blockPos, Block.getRawIdFromState(state));
        }

        return true;
    }

    static {
        EFFECTIVE_BLOCKS = Sets.newHashSet(Blocks.CLAY, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL, Blocks.FARMLAND, Blocks.GRASS_BLOCK, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND, Blocks.RED_SAND, Blocks.SNOW_BLOCK, Blocks.SNOW, Blocks.SOUL_SAND, Blocks.GRASS_PATH, Blocks.WHITE_CONCRETE_POWDER, Blocks.ORANGE_CONCRETE_POWDER, Blocks.MAGENTA_CONCRETE_POWDER, Blocks.LIGHT_BLUE_CONCRETE_POWDER, Blocks.YELLOW_CONCRETE_POWDER, Blocks.LIME_CONCRETE_POWDER, Blocks.PINK_CONCRETE_POWDER, Blocks.GRAY_CONCRETE_POWDER, Blocks.LIGHT_GRAY_CONCRETE_POWDER, Blocks.CYAN_CONCRETE_POWDER, Blocks.PURPLE_CONCRETE_POWDER, Blocks.BLUE_CONCRETE_POWDER, Blocks.BROWN_CONCRETE_POWDER, Blocks.GREEN_CONCRETE_POWDER, Blocks.RED_CONCRETE_POWDER, Blocks.BLACK_CONCRETE_POWDER);
    }
}

