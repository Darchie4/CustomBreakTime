package custombreaktime.custombreaktime.utils;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class BreakTimeCalculatorUtil {
    private Player player;

    public BreakTimeCalculatorUtil(Player player) {
        this.player = player;
    }

    public float getBreakingPower(){
        float breakingSpeed = 0;
        ItemStack item = player.getInventory().getItemInMainHand();
        if (item.getType().equals(Material.WOODEN_PICKAXE)){
            breakingSpeed += 0.0003;
        } else if (item.getType().equals(Material.STONE_PICKAXE)){
            breakingSpeed += 0.0005;
        } else if (item.getType().equals(Material.IRON_PICKAXE)){
            breakingSpeed += 0.0007;
        } else if (item.getType().equals(Material.DIAMOND_PICKAXE)){
            breakingSpeed += 0.001;
        } else if (item.getType().equals(Material.GOLDEN_PICKAXE)){
            breakingSpeed += 0.002;
        }
        breakingSpeed += item.getEnchantmentLevel(Enchantment.DIG_SPEED)*0.0002;

        return breakingSpeed;
    }

    private float test(){

        return (float)0.0;
    }
}
