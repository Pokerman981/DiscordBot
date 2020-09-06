package DiscordBot.commands;

import DiscordBot.Embeds;
import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class WebsiteCommand extends Command {

    public WebsiteCommand() {
        this.name = "website";
        this.aliases = new String[] { "site", "url" };
        this.category = main.roleCategories.get("player");
        this.help = "Displays links to all server websites!";
    }

    @Override
    protected void execute(CommandEvent event) {
        if (event.getChannel().getName().contains("-chat")) return;
        event.reply(Embeds.websiteInfo().build());
    }
}
