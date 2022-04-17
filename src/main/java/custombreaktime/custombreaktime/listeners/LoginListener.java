package custombreaktime.custombreaktime.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LoginListener implements Listener {

    @EventHandler
    public void onPlayerLogin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.removePotionEffect(PotionEffectType.SLOW_DIGGING);
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE, -1, false, false));
    }
}