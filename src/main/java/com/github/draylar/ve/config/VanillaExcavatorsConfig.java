package com.github.draylar.ve.config;


import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;

@Config(name = "vanillaexcavators")
public class VanillaExcavatorsConfig implements ConfigData {
    public boolean enableExtraMaterials = true;
    public boolean enableFull3x3 = false;
    public boolean fullBlockHitbox = false;
    public boolean alwaysShowSingleBlockHitbox = false;
    public boolean showSingleBlockWhenSneaking = true;
    public boolean breakSingleBlockWhenSneaking = true;
    public int durabilityModifier = 5;
}
