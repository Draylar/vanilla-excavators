package draylar.ve.registry;

import draylar.magna.item.ExcavatorItem;
import draylar.ve.VanillaExcavators;
import draylar.ve.item.FieryExcavatorItem;
import draylar.ve.material.ExcavatorMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class VEItems {

    public static ExcavatorItem WOOD = register(ExcavatorMaterials.WOOD, 0, -2.5f, "wooden");
    public static ExcavatorItem STONE = register(ExcavatorMaterials.STONE, 1, -2.6f, "stone");
    public static ExcavatorItem IRON = register(ExcavatorMaterials.IRON, 2, -2.8f, "iron");
    public static ExcavatorItem GOLD = register(ExcavatorMaterials.GOLD, 2, -2.5f, "golden");
    public static ExcavatorItem DIAMOND = register(ExcavatorMaterials.DIAMOND, 5, -3f, "diamond");
    public static ExcavatorItem NETHERITE = registerFireproof(ExcavatorMaterials.NETHERITE, 6, -3.1f, "netherite");
    public static ExcavatorItem SLIME;

    public static void registerExcavators() {
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
    }

    private static ExcavatorItem register(ToolMaterial material, int attackDamage, float attackSpeed, String excavatorName) {
        return Registry.register(Registry.ITEM, new Identifier("vanillaexcavators", excavatorName + "_excavator"), new ExcavatorItem(material, attackDamage, attackSpeed, new Item.Settings().group(VanillaExcavators.GROUP)));
    }

    private static FieryExcavatorItem registerFiery(ToolMaterial material, int attackDamage, float attackSpeed, String excavatorName) {
        return Registry.register(Registry.ITEM, new Identifier("vanillaexcavators", excavatorName + "_excavator"), new FieryExcavatorItem(material, attackDamage, attackSpeed, new Item.Settings().group(VanillaExcavators.GROUP)));
    }

    private static FieryExcavatorItem registerFireproof(ToolMaterial material, int attackDamage, float attackSpeed, String excavatorName) {
        return Registry.register(Registry.ITEM, new Identifier("vanillaexcavators", excavatorName + "_excavator"), new FieryExcavatorItem(material, attackDamage, attackSpeed, new Item.Settings().group(VanillaExcavators.GROUP).fireproof()));
    }
}
