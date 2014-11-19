package io.ivy.weatherman;

import net.canarymod.Canary;
import net.canarymod.api.world.World;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.world.WeatherChangeHook;
import net.canarymod.plugin.PluginListener;

public class WeathermanListener implements PluginListener {
	@HookHandler
	public void onWeatherChangeHook (WeatherChangeHook hook) {
		Canary.log.info("*** WEATHER CHANGE");
		Canary.log.info(hook.toString());
		World world = hook.getWorld();
		if (world.getThunderStrength() > 0) {
			Canary.log.info("NO THUNDER PLEASE");
			world.setThundering(false);
			world.setRaining(false);
		}
		
		if (world.getRainTicks() > 0) {
			Canary.log.info("NO RAIN PLEASE");
			world.setRaining(false);
		}
	}
}
