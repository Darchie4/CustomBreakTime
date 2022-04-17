package custombreaktime.custombreaktime.listeners;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import custombreaktime.custombreaktime.CustomBreakTime;
import org.bukkit.plugin.Plugin;

public class BlockBreakAbortPacketListener extends PacketAdapter {
    public BlockBreakAbortPacketListener(Plugin plugin, PacketType... types) {
        super(plugin, types);
    }

    @Override
    public void onPacketReceiving(PacketEvent event) {
        if (event.getPacketType().name().equals("ABORT_DESTROY_BLOCK") || ((CustomBreakTime)getPlugin()).getRunnableMap().get(event.getPlayer()) != null){
            ((CustomBreakTime)getPlugin()).getRunnableMap().get(event.getPlayer()).setStop(true);
        }
    }
}
