package custombreaktime.custombreaktime.commandHandlers;

import custombreaktime.custombreaktime.CustomBreakTime;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;

public class TestingsCommandHandler implements CommandExecutor {
    private final CustomBreakTime plugin;

    public TestingsCommandHandler(CustomBreakTime plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            ((Player) sender).removePotionEffect(PotionEffectType.SLOW_DIGGING);
            ((Player) sender).addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE, -1, false, false));
            return true;
        }
        Bukkit.getLogger().log(Level.WARNING, "This command can't be used as not a player");
        return false;
    }
}
