package de.prwh.cobaltmod.core.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import de.prwh.cobaltmod.core.CobaltMod;
import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class ModMenu implements ModMenuApi {
	@Override
	@Environment(EnvType.CLIENT)
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return parent -> MidnightConfig.getScreen(parent, CobaltMod.MOD_ID);
	}
}
