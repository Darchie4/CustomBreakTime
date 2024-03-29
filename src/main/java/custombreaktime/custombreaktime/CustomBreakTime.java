package custombreaktime.custombreaktime;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import custombreaktime.custombreaktime.commandHandlers.CanMineCommandHandler;
import custombreaktime.custombreaktime.commandHandlers.ReloadCommandHandler;
import custombreaktime.custombreaktime.commandHandlers.TestingsCommandHandler;
import custombreaktime.custombreaktime.listeners.BlockBreakAbortPacketListener;
import custombreaktime.custombreaktime.listeners.BlockDamageEventListener;
import custombreaktime.custombreaktime.listeners.LoginListener;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class CustomBreakTime extends JavaPlugin {
    private ProtocolManager protocolManager;
    private HashMap<Player, BreakerRunnable> runnableMap;

    @Override
    public void onEnable() {
        runnableMap = new HashMap<>();

        this.protocolManager = ProtocolLibrary.getProtocolManager();
        this.protocolManager.addPacketListener(new BlockBreakAbortPacketListener(this, PacketType.Play.Client.BLOCK_DIG));

        Bukkit.getPluginManager().registerEvents(new BlockDamageEventListener(this.protocolManager, this),this);
        Bukkit.getPluginManager().registerEvents(new LoginListener(),this);

        this.getCommand("testings").setExecutor(new TestingsCommandHandler(this));
        this.getCommand("CBTReload").setExecutor(new ReloadCommandHandler(this));
        this.getCommand("CBTCanMine").setExecutor(new CanMineCommandHandler());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public HashMap<Player, BreakerRunnable> getRunnableMap() {
        return runnableMap;
    }
}
