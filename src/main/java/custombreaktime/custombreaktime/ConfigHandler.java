package custombreaktime.custombreaktime;

import org.bukkit.Material;


public class ConfigHandler {
    private CustomBreakTime plugin;

    public ConfigHandler(CustomBreakTime plugin) {
        this.plugin = plugin;
    }

    public double getBlockHardness(Material material){
        return (Double) plugin.getConfig().get("Material." + material.name());
    }

    public double getToolBreakingPower(Material material){
        return (Double) plugin.getConfig().get("Tool." + material.name());
    }

}
