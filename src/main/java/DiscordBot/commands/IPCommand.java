package DiscordBot.commands;

import DiscordBot.Embeds;
import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;


public class IPCommand extends Command {

    public IPCommand() {
        this.name = "ip";
        this.category = main.roleCategories.get("player");
        this.help = "Displays a list of each server's IP address";
    }

    @Override
    protected void execute(CommandEvent event) {
        if (event.getArgs().isEmpty()) {
            event.reply(Embeds.ipInfo().build());
        } else {
            event.reply(Embeds.ipInfo().build());
        }
    }
}
