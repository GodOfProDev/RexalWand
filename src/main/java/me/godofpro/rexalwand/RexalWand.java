package me.godofpro.rexalwand;

import me.godofpro.rexalwand.item.rexalwand.BlockDragHandler;
import me.godofpro.rexalwand.item.rexalwand.BlockHandler;
import me.godofpro.rexalwand.item.rexalwand.BlockInteract;
import me.godofpro.rexalwand.item.rexalwand.FallingBlockLand;
import me.godofpro.rexalwand.recipes.RexalWandRecipe;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class RexalWand extends JavaPlugin {

    private BlockHandler blockHandler;
    private BlockDragHandler blockDragHandler;

    @Override
    public void onEnable() {
        Bukkit.addRecipe(new RexalWandRecipe(this).getRecipe());

        blockHandler = new BlockHandler(this);
        blockDragHandler = new BlockDragHandler(this, blockHandler);

        getServer().getPluginManager().registerEvents(new BlockInteract(blockHandler), this);
        getServer().getPluginManager().registerEvents(new FallingBlockLand(blockHandler), this);
    }

    @Override
    public void onDisable() {
        blockDragHandler.unload();
        blockHandler.unload();
    }

}
