package draylar.ve;

import draylar.ve.config.VanillaExcavatorsConfig;
import draylar.ve.registry.Items;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class VanillaExcavators implements ModInitializer {

    public static String MODID = "vanillaexcavators";
    public static VanillaExcavatorsConfig CONFIG = AutoConfig.register(VanillaExcavatorsConfig.class, GsonConfigSerializer::new).getConfig();
    public static final ItemGroup GROUP = FabricItemGroupBuilder.build(id("group"), () -> new ItemStack(Items.SLIME));

    @Override
    public void onInitialize() {
        Items.registerExcavators();
        FuelRegistry.INSTANCE.add(Items.WOOD, 400);
    }

    public static Identifier id(String name) {
        return new Identifier(MODID, name);
    }
}