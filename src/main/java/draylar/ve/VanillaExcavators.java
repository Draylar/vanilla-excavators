package draylar.ve;

import draylar.omegaconfig.OmegaConfig;
import draylar.ve.config.VanillaExcavatorsConfig;
import draylar.ve.registry.VEItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class VanillaExcavators implements ModInitializer {

    public static String MODID = "vanillaexcavators";
    public static VanillaExcavatorsConfig CONFIG = OmegaConfig.register(VanillaExcavatorsConfig.class);
    public static final ItemGroup GROUP = FabricItemGroupBuilder.build(id("group"), () -> new ItemStack(VEItems.SLIME));

    @Override
    public void onInitialize() {
        VEItems.registerExcavators();
        FuelRegistry.INSTANCE.add(VEItems.WOOD, 400);
    }

    public static Identifier id(String name) {
        return new Identifier(MODID, name);
    }
}