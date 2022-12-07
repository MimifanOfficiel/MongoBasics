package fr.mimifan.mongobasics.gui.sMongo.usersManagement;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import fr.mimifan.mongobasics.Main;

public class Umanager {

    public static Inventory Inventory (){
        Inventory inv = Bukkit.createInventory(null, 9, "§cError");
        Bukkit.getScheduler().runTaskAsynchronously(Main.getPlugin(Main.class), new Runnable() {
            @Override
            public void run() {
                int nbPlayers = Bukkit.getOnlinePlayers().size();
                double size = (double) nbPlayers / 9;
                if ((size - (int) size) != 0) size = size + 1;
                Inventory inv = Bukkit.createInventory(null, (int) size * 9, "§1§lSilvenya Mongo");
            }
        });
        return inv;

    }

}
