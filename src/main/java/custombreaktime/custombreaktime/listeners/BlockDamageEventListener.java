package custombreaktime.custombreaktime.listeners;

import com.comphenix.protocol.ProtocolManager;
import custombreaktime.custombreaktime.BreakerRunnable;
import custombreaktime.custombreaktime.CustomBreakTime;
import custombreaktime.custombreaktime.utils.BreakTimeCalculatorUtil;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;

public class BlockDamageEventListener implements Listener {
    private ProtocolManager protocolManager;
    private CustomBreakTime plugin;

    public BlockDamageEventListener(ProtocolManager protocolManager, CustomBreakTime plugin) {
        this.protocolManager = protocolManager;
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockDamage(BlockDamageEvent event){
        BreakTimeCalculatorUtil breakTimeCalculatorUtil = new BreakTimeCalculatorUtil(event.getPlayer());
        if (!event.getInstaBreak()){
            BreakerRunnable task = new BreakerRunnable(event.getPlayer(), this.protocolManager, event.getBlock(), this.plugin, breakTimeCalculatorUtil.getBreakingPower());
            plugin.getRunnableMap().put(event.getPlayer(), task);
            Bukkit.getScheduler().runTaskAsynchronously(plugin, task);
        }
    }
}