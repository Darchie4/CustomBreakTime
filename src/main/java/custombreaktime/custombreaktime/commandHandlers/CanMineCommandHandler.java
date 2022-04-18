package custombreaktime.custombreaktime.commandHandlers;

import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.node.Node;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class CanMineCommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            if (args.length == 0){
                sender.sendMessage("Please specify to set or remove (true/false)");
                return false;
            }
            if (args[0].toLowerCase(Locale.ROOT).equals("true")) {
                Node node = Node.builder("cbt.canMine").build();
                LuckPermsProvider.get().getUserManager().getUser(((Player) sender).getUniqueId()).data().add(node);
                return true;
            } else if (args[0].toLowerCase(Locale.ROOT).equals("false")){
                Node node = Node.builder("cbt.canMine").build();
                LuckPermsProvider.get().getUserManager().getUser(((Player) sender).getUniqueId()).data().remove(node);
                return true;
            } else {
                sender.sendMessage("Please specify to set or remove (true/false)");
                return false;
            }
        }
        sender.sendMessage("This command must be run as player");
        return false;
    }
}
