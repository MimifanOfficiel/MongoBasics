package fr.mimifan.mongobasics.events;

import fr.mimifan.mongobasics.dbManagement.UserManipulation;
import fr.mimifan.mongobasics.dbManagement.dbClient;
import fr.mimifan.mongobasics.dbManagement.getData;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Date;

public class EventJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        getData.getInfos(player.getUniqueId());
        if(getData.isDataInDB(dbClient.players_collection, "uuid", player.getUniqueId().toString())){
            Date now = new Date();
            UserManipulation.updateUser(player.getUniqueId(), "last-login", now);
        } else {
            UserManipulation.createUser(player.getUniqueId(), player.getName());
            player.sendMessage("§7----------------------------\n" +
                    "\n" +
                    "       §eWelcome on Silvenya ! \n" +
                    "§eHopefully you enjoy your time here.\n" + "\n" +
                    "§7----------------------------");
        }
        UserManipulation.updateUser(player.getUniqueId(), "currently-logged", true);
        String rank = getData.getInfos(player.getUniqueId()).rank;
        String prefix = getData.getInfos(rank).prefix.replace("&","§");
        player.setDisplayName(prefix + "§l" + rank + " " + prefix + player.getName());
        player.setPlayerListName(prefix + "§l" + rank + " " + prefix + player.getName());

    }

}
