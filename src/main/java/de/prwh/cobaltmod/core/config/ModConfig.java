package de.prwh.cobaltmod.core.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
@Config(name = "mod_cobalt")
public class ModConfig implements ConfigData {
    boolean test = true;
}
