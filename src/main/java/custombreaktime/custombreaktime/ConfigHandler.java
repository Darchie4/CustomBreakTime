package custombreaktime.custombreaktime;

import org.bukkit.Material;

import java.util.logging.Level;


public class ConfigHandler {
    private CustomBreakTime plugin;

    public ConfigHandler(CustomBreakTime plugin) {
        this.plugin = plugin;
    }

    public double getBlockHardness(Material material){
        if (plugin.getConfig().get("Material." + material.name()) == null){
            plugin.getLogger().log(Level.WARNING, material.name() + " Does not exist in config");
            return 0.0;
        }
        return (Double) plugin.getConfig().get("Material." + material.name());
    }

    public double getToolBreakingPower(Material material){
        return (Double) (plugin.getConfig().get("Tool." + material.name()) != null ? plugin.getConfig().get("Tool." + material.name()) : 0.0);
    }

    public double getDigSpeedMultiplier(){
        return (Double) plugin.getConfig().get("Enchant.DIG_SPEED");
    }

}
