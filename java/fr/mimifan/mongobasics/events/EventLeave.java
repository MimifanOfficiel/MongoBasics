package fr.mimifan.mongobasics.events;

import fr.mimifan.mongobasics.dbManagement.UserManipulation;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Date;

public class EventLeave implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        Date now = new Date();
        UserManipulation.updateUser(player.getUniqueId(), "last-logout", now);
        UserManipulation.updateUser(player.getUniqueId(), "currently-logged", false);
    }

}
