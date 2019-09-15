package com.github.draylar.ve.compat;

import io.github.cottonmc.dynagear.DynaGear;
import io.github.cottonmc.dynagear.api.EquipmentCategory;
import io.github.cottonmc.dynagear.api.EquipmentTypeAdder;
import io.github.cottonmc.dynagear.impl.EquipmentManager;
import io.github.cottonmc.dynagear.impl.SimpleEquipmentType;
import net.minecraft.item.Item;

public class DynaGearCompat implements EquipmentTypeAdder
{
	@Override
	public void addEquipmentTypes(EquipmentManager manager)
	{
		manager.addEquipmentType(new SimpleEquipmentType("excavator", new String[]{"%#%", " / ", " / "}, null, EquipmentCategory.TOOLS,
				(mat) -> new DynaExcavatorItem(mat, new Item.Settings().group(DynaGear.DYNAGEAR_GROUP))));
	}
}
