package custombreaktime.custombreaktime;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import custombreaktime.custombreaktime.listeners.BlockBreakAbortPacketListener;
import custombreaktime.custombreaktime.listeners.BlockDamageEventListener;
import org.bukkit.Bukkit;
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

        this.getCommand("testings").setExecutor(new CommandHandler(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public HashMap<Player, BreakerRunnable> getRunnableMap() {
        return runnableMap;
    }
}
