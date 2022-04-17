package custombreaktime.custombreaktime.listeners;

import com.comphenix.protocol.ProtocolManager;
import custombreaktime.custombreaktime.BreakerRunnable;
import custombreaktime.custombreaktime.CustomBreakTime;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;

public class BlockDamageEventListener implements Listener {
    private ProtocolManager protocolManager;
    private CustomBreakTime darchiesTestPlugin;

    public BlockDamageEventListener(ProtocolManager protocolManager, CustomBreakTime darchiesTestPlugin) {
        this.protocolManager = protocolManager;
        this.darchiesTestPlugin = darchiesTestPlugin;
    }

    @EventHandler
    public void onBlockDamage(BlockDamageEvent event){
        if (!event.getInstaBreak()){
            BreakerRunnable task = new BreakerRunnable(event.getPlayer(), this.protocolManager, event.getBlock(), this.darchiesTestPlugin);
            darchiesTestPlugin.getRunnableMap().put(event.getPlayer(), task);
            Bukkit.getScheduler().runTaskAsynchronously(darchiesTestPlugin, task);
        }
    }
}