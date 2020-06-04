package DiscordBot.commands;

import DiscordBot.Embeds;
import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class LinkCommand extends Command {

    public LinkCommand() {
        this.name = "link";
        this.aliases = new String[]{"donor", "donator", "rank"};
        this.category = main.roleCategories.get("player");
        this.help = "Displays a list of each server's IP address";
    }

    @Override
    protected void execute(CommandEvent event) {
        if (event.getArgs().isEmpty()) {
            event.reply(Embeds.linkInfo().build());
            return;
        }
    }
}
