package draylar.ve.config;


import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;

@Config(name = "vanillaexcavators")
public class VanillaExcavatorsConfig implements ConfigData {
    public boolean enableExtraMaterials = true;
    public int durabilityModifier = 5;
}
