package draylar.ve.registry;

import draylar.magna.item.ExcavatorItem;
import draylar.ve.VanillaExcavators;
import draylar.ve.item.FieryExcavatorItem;
import draylar.ve.material.ExcavatorMaterials;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class VEItems {

    public static ExcavatorItem WOOD;
    public static ExcavatorItem SLIME;

    public static void registerExcavators() {
        WOOD = register(ExcavatorMaterials.WOOD, 0, -2.5f, "wooden");
        register(ExcavatorMaterials.STONE, 1, -2.6f, "stone");
        register(ExcavatorMaterials.IRON, 2, -2.8f, "iron");
        register(ExcavatorMaterials.GOLD, 2, -2.5f, "golden");
        register(ExcavatorMaterials.DIAMOND, 5, -3f, "diamond");
        register(ExcavatorMaterials.NETHERITE, 6, -3.1f, "netherite");

        if (VanillaExcavators.CONFIG.enableExtraMaterials) {
            register(ExcavatorMaterials.EMERALD, 5, -3f, "emerald");
            register(ExcavatorMaterials.OBSIDIAN, 3, -3.5f, "obsidian");
            register(ExcavatorMaterials.QUARTZ, 2, -2f, "lapis");
            register(ExcavatorMaterials.LAPIS, 0, -2.5f, "quartz");
            registerFiery(ExcavatorMaterials.FIERY, 2, -2.3f, "fiery");
            register(ExcavatorMaterials.PRISMARINE, 2, -2.3f, "prismarine");
            register(ExcavatorMaterials.ENDER, 6, -3.3f, "ender");
            SLIME = register(ExcavatorMaterials.SLIME, 3, -3f, "slime");
        }

        if (FabricLoader.getInstance().isModLoaded("netherthings")) {
            register(ExcavatorMaterials.GLOWSTONE, 5, -2.3f, "glowstone");
            register(ExcavatorMaterials.NETHER, 4, -2.1f, "nether");
            register(ExcavatorMaterials.VIBRANIUM, 10, -2.9f, "vibranium");
        }
    }

    private static ExcavatorItem register(ToolMaterial material, int attackDamage, float attackSpeed, String excavatorName) {
        return Registry.register(Registry.ITEM, new Identifier("vanillaexcavators", excavatorName + "_excavator"), new ExcavatorItem(material, attackDamage, attackSpeed, new Item.Settings().group(VanillaExcavators.GROUP)));
    }

    private static FieryExcavatorItem registerFiery(ToolMaterial material, int attackDamage, float attackSpeed, String excavatorName) {
        return Registry.register(Registry.ITEM, new Identifier("vanillaexcavators", excavatorName + "_excavator"), new FieryExcavatorItem(material, attackDamage, attackSpeed, new Item.Settings().group(VanillaExcavators.GROUP)));
    }
}
