package com.github.draylar.ve.api;

import net.minecraft.block.BlockState;

public interface BreakValidator {
    boolean canBreak(BlockState state);
}
