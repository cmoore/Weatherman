package io.ivy.weatherman;

import net.canarymod.Canary;
import net.canarymod.plugin.Plugin;

public class Weatherman extends Plugin {

	@Override
	public boolean enable() {
		Canary.log.info("Loading...");
		Canary.hooks().registerListener(new WeathermanListener(), this);
		return true;
	}
	
	@Override
	public void disable() {
		Canary.log.info("Disabling...");
	}
}
