package fr.mimifan.mongobasics.commands;

import fr.mimifan.mongobasics.gui.sMongo.usersManagement.Umanager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SMongoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, String label, String[] args) {
        Player player = (Player)sender;
        if(args.length == 0){
            if(!(sender instanceof Player)) throw new CommandException("The Console can not use this command with no arguments.");
            player.openInventory(Umanager.Inventory());
        }
        if(args.length > 8) throw new IndexOutOfBoundsException(sender.getName() + " §cused too much arguments while using the command §4/smongo§r");
        return false;
    }
}
