package draylar.ve.material;

import draylar.ve.VanillaExcavators;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.Lazy;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public enum ExcavatorMaterials implements ToolMaterial {
    WOOD(0, 59 * VanillaExcavators.CONFIG.durabilityModifier, 2.0F / 3.5f, 0.0f, 15, () -> {
        return Ingredient.fromTag(ItemTags.PLANKS);
    }),
    STONE(1, 131 * VanillaExcavators.CONFIG.durabilityModifier, 4.0F / 3.5f, 0.0f, 5, () -> {
        return Ingredient.ofItems(Blocks.COBBLESTONE);
    }),
    IRON(2, 250 * VanillaExcavators.CONFIG.durabilityModifier, 6.0F / 3.5f, 0.0f, 14, () -> {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }),
    DIAMOND(3, 1561 * VanillaExcavators.CONFIG.durabilityModifier, 8.0F / 3.5f, 0.0f, 10, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    NETHERITE(4, 2031 * VanillaExcavators.CONFIG.durabilityModifier, 9.0F / 3.5F, 0.0F, 15, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),
    GOLD(0, 32 * VanillaExcavators.CONFIG.durabilityModifier, 12.0F / 3.5f, 0.0f, 22, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    EMERALD(3, 1028 * VanillaExcavators.CONFIG.durabilityModifier, 12.0F / 3.5f, 0.0f, 25, () -> {
        return Ingredient.ofItems(Items.EMERALD);
    }),
    OBSIDIAN(2, 2048 * VanillaExcavators.CONFIG.durabilityModifier, 5.0F / 3.5f, 0.0f, 5, () -> {
        return Ingredient.ofItems(Items.OBSIDIAN);
    }),
    LAPIS(1, 220 * VanillaExcavators.CONFIG.durabilityModifier, 6.0f / 3.5f, 0.0f, 30, () -> {
        return Ingredient.ofItems(Items.LAPIS_LAZULI);
    }),
    QUARTZ(2, 1028 * VanillaExcavators.CONFIG.durabilityModifier, 8.0F / 3.5f, 0.0f, 10, () -> {
        return Ingredient.ofItems(Items.QUARTZ);
    }),
    FIERY(3, 750 * VanillaExcavators.CONFIG.durabilityModifier, 7.0F / 3.5f, 0f, 15, () -> {
        return Ingredient.ofItems(Items.MAGMA_BLOCK);
    }),
    PRISMARINE(3, 750 * VanillaExcavators.CONFIG.durabilityModifier, 7.0F / 3.5F, 0f, 20, () -> {
        return Ingredient.ofItems(Items.PRISMARINE_SHARD);
    }),
    ENDER(3, 1561 * VanillaExcavators.CONFIG.durabilityModifier, 10f / 3.5f, 0, 10, () -> {
        return Ingredient.ofItems(Items.ENDER_PEARL);
    }),
    SLIME(2, 1500 * VanillaExcavators.CONFIG.durabilityModifier, 6f / 3.5f, 0, 20, () -> {
        return Ingredient.ofItems(Items.SLIME_BALL);
    }),
    POTATO(1, 500 * VanillaExcavators.CONFIG.durabilityModifier, 4.0F / 3.5f, 0.0f, 100, () -> {
        return Ingredient.ofItems(Registry.ITEM.get(new Identifier("lil-tater", "lil_tater")));
    }),
    GLOWSTONE(2, 442 * VanillaExcavators.CONFIG.durabilityModifier, 5.0F / 3.5f, 0.0f, 15, () -> {
        return Ingredient.ofItems(Registry.ITEM.get(new Identifier("netherthings", "glowstone_ingot")));
    }),
    NETHER(1, 280 * VanillaExcavators.CONFIG.durabilityModifier, 5.0F / 3.5f, 0.0f, 77, () -> {
        return Ingredient.ofItems(Registry.ITEM.get(new Identifier("netherthings", "nether_brick")));
    }),
    VIBRANIUM(3, (int) (21850d * (VanillaExcavators.CONFIG.durabilityModifier / 2.5f)), 22f / 3.5f, 0.0f, 7, () -> {
        return Ingredient.ofItems(Registry.ITEM.get(new Identifier("netherthings", "vibranium")));
    });


    private final int miningLevel;
    private final int durability;
    private final float blockBreakSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ExcavatorMaterials(int miningLevel, int durability, float blockBreakSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.durability = durability;
        this.blockBreakSpeed = blockBreakSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    public int getDurability() {
        return this.durability;
    }

    public float getMiningSpeedMultiplier() {
        return this.blockBreakSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
