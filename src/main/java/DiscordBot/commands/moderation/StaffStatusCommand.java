package DiscordBot.commands.moderation;

import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.Permission;

public class StaffStatusCommand extends Command {
    public StaffStatusCommand() {
        this.name = "sstatus";
        this.guildOnly = true;
        this.userPermissions = new Permission[] {Permission.KICK_MEMBERS};
        this.help = "Displays information about a specific server";
        this.category = main.STAFF;
    }

    @Override
    protected void execute(CommandEvent event) {
        String[] args = event.getArgs().split(" ");
        if (event.getArgs().isEmpty()){
            event.replyError("You must specify a server! You can use the 2 letter abbreviation.");
        }
        return;
    }
}
