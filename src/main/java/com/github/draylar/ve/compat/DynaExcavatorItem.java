package com.github.draylar.ve.compat;

import com.github.draylar.ve.api.ExcavatorItem;
import io.github.cottonmc.dynagear.api.ConfiguredMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class DynaExcavatorItem extends ExcavatorItem
{
	private ConfiguredMaterial material;
	public DynaExcavatorItem(ConfiguredMaterial material, Item.Settings settings)
	{
		super(new ExcavatorConfiguredMaterial(material).asTool(), (int)material.asTool().getAttackDamage(), -2.75f, settings);
		this.material = material;
	}

	@Override
	public String getTranslationKey()
	{
		return "item.vanillaexcavators.dynagear_excavator";
	}

	@Override
	public Text getName()
	{
		String mat = material.getName().substring(0, 1).toUpperCase() + material.getName().substring(1);
		return new TranslatableText(getTranslationKey(), mat);
	}

	@Override
	public Text getName(ItemStack stack)
	{
		String mat = material.getName().substring(0, 1).toUpperCase() + material.getName().substring(1);
		return new TranslatableText(getTranslationKey(), mat);
	}
}
