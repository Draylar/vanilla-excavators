package com.github.draylar.ve;

import com.github.draylar.ve.config.VanillaExcavatorsConfig;
import com.github.draylar.ve.common.ExcavatorRegistry;
import me.sargunvohra.mcmods.autoconfig1.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.impl.registry.FuelRegistryImpl;

public class VanillaExcavators implements ModInitializer
{
	public static final int DURABILITY_MODIFIER = 3;
	public static VanillaExcavatorsConfig CONFIG = AutoConfig.register(VanillaExcavatorsConfig.class, GsonConfigSerializer::new).getConfig();

	@Override
	public void onInitialize()
	{
		ExcavatorRegistry.registerHammers();
		FuelRegistryImpl.INSTANCE.add(ExcavatorRegistry.WOOD, 400);
	}
}