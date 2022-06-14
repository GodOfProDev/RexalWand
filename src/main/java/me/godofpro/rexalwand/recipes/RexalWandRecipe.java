package me.godofpro.rexalwand.recipes;

import me.godofpro.rexalwand.RexalWand;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class RexalWandRecipe {
    private final RexalWand plugin;
    public RexalWandRecipe(RexalWand plugin) {this.plugin = plugin;}

    public ShapedRecipe getRecipe() {
        ItemStack item = getItem();

        NamespacedKey key = new NamespacedKey(plugin, "rexal_wand");
        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape("EPE", "PBP", "EPE");

        recipe.setIngredient('E', Material.ENDER_PEARL);
        recipe.setIngredient('P', Material.BLAZE_POWDER);
        recipe.setIngredient('B', Material.BLAZE_ROD);

        return recipe;
    }

    public ItemStack getItem() {
        ItemStack item = new ItemStack(Material.BLAZE_ROD);
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Rexal Wand");
        List<String> lore = new ArrayList<>();
        lore.add("Wand Of Telepathy");
        itemMeta.setLore(lore);

        itemMeta.addEnchant(Enchantment.MENDING, 3, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(itemMeta);

        return item;
    }
}
