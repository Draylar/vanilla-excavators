package com.github.draylar.ve.mixin;

import com.github.draylar.ve.common.ExcavatorRegistry;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentHelper.class)
public class ExcavatorKnockbackMixin {

    @Inject(at = @At("HEAD"), method = "getKnockback", cancellable = true)
    private static void getKnockback(LivingEntity livingEntity, CallbackInfoReturnable<Integer> info) {
        if(livingEntity.getMainHandStack().getItem().equals(ExcavatorRegistry.SLIME)) {
            info.setReturnValue(3);
            info.cancel();
        }
    }
}
