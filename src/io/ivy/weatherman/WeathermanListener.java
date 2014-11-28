package io.ivy.weatherman;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.stream.Stream;

import net.canarymod.Canary;
import net.canarymod.api.world.World;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.system.ServerTickHook;
import net.canarymod.plugin.PluginListener;

public class WeathermanListener implements PluginListener {
    
    @HookHandler
    public void onServerTickHook(ServerTickHook hook) {
        Collection<World> worlds = Canary.getServer().getWorldManager().getAllWorlds();
        
        Stream<World> raining_worlds = worlds.stream().filter(world -> world.isRaining());
        Stream<World> thundering_worlds = worlds.stream().filter(world -> world.isThundering());
        
        thundering_worlds.forEach(new Consumer<World>() {
                @Override
                public void accept(World the_world) {
                    the_world.setThundering(false);
                }});
        
        raining_worlds.forEach(new Consumer<World>() {
                @Override
                public void accept(World the_world) {
                    the_world.setRaining(false);
                }});
    }
}
