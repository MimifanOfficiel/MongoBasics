package fr.mimifan.mongobasics;

import fr.mimifan.mongobasics.commands.SMongoCommand;
import fr.mimifan.mongobasics.dbManagement.getData;
import fr.mimifan.mongobasics.events.EventJoin;
import fr.mimifan.mongobasics.events.EventLeave;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        getLogger().info("Mongo Basics API loading up.");
        PluginManager pm = Bukkit.getPluginManager();
        getLogger().info("Registering events");
        pm.registerEvents(new EventJoin(), this);
        pm.registerEvents(new EventLeave(), this);

        getCommand("smongo").setExecutor(new SMongoCommand());


    }

    @Override
    public void onDisable() {
        getLogger().info("Shutting down Mongo Basics");
    }
}
