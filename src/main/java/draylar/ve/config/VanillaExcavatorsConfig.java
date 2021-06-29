package draylar.ve.config;


import draylar.omegaconfig.api.Config;

public class VanillaExcavatorsConfig implements Config {

    public boolean enableExtraMaterials = true;
    public int durabilityModifier = 5;

    @Override
    public String getName() {
        return "vanillaexcavators";
    }
}
