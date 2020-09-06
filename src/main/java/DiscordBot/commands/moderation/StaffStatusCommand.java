package DiscordBot.commands.moderation;

import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;


public class StaffStatusCommand extends Command {

    public StaffStatusCommand() {
        this.name = "sstatus";
        this.guildOnly = true;
        this.help = "Displays information about a specific server";
        this.category = main.roleCategories.get("staff");
        this.requiredRole = main.requiredRoles.get("staff");
        this.hidden = true;
    }

    @Override
    protected void execute(CommandEvent event) {
        if (event.getArgs().isEmpty())
            event.replyError("You must specify a server! You can use the 2 letter abbreviation.");
    }

}
