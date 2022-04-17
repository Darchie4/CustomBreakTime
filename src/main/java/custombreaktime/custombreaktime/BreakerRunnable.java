package custombreaktime.custombreaktime;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BreakerRunnable implements Runnable {
    private Player player;
    private ProtocolManager protocolManager;
    private Block block;
    private CustomBreakTime plugin;
    private boolean stop;


    public BreakerRunnable(Player player, ProtocolManager protocolManager, Block block, CustomBreakTime plugin) {
        this.player = player;
        this.protocolManager = protocolManager;
        this.block = block;
        this.plugin = plugin;
        this.stop = false;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            PacketContainer brokenBlock = createBlockBreakAnimationPacket(i);
            protocolManager.broadcastServerPacket(brokenBlock);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
            if (stop){
                resetBreakAnimation();
                return;
            }
        }
        breakMinedBlock();
    }

    private void resetBreakAnimation() {
        PacketContainer blockReset = createBlockBreakAnimationPacket(-1);
        protocolManager.broadcastServerPacket(blockReset);
    }

    @NotNull
    private PacketContainer createBlockBreakAnimationPacket(int i) {
        PacketContainer brokenBlock = protocolManager.createPacket(PacketType.Play.Server.BLOCK_BREAK_ANIMATION);
        brokenBlock.getBlockPositionModifier().write(0, new BlockPosition(block.getX(), block.getY(), block.getZ()));
        brokenBlock.getIntegers().write(0, block.getType().getId());
        brokenBlock.getIntegers().write(1, i);
        return brokenBlock;
    }

    private void breakMinedBlock() {
        Bukkit.getScheduler().runTask(this.plugin, () -> block.breakNaturally(player.getInventory().getItemInMainHand()));
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
