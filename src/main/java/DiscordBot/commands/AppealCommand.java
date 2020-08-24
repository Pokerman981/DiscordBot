package DiscordBot.commands;

import DiscordBot.Embeds;
import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class AppealCommand extends Command {

    public AppealCommand() {
        this.name = "appeal";
        this.category = main.roleCategories.get("player");
        this.help = "Displays information about appeals";
    }

    @Override
    protected void execute(CommandEvent event) {
        if (event.getChannel().getName().contains("-chat")) return;
        event.reply(Embeds.appealInfo().build());
    }

}