package custombreaktime.custombreaktime.commandHandlers;

import custombreaktime.custombreaktime.CustomBreakTime;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ReloadCommandHandler implements CommandExecutor {
    private CustomBreakTime plugin;

    public ReloadCommandHandler(CustomBreakTime plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        plugin.reloadConfig();
        return true;
    }
}
