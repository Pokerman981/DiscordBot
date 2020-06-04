package DiscordBot.commands;

import DiscordBot.Embeds;
import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class LogsCommand extends Command {
    public LogsCommand(){
        this.name = "logs";
        this.category = main.roleCategories.get("player");
        this.help = "Displays a tutorial on how to view logs";
    }

    @Override
    protected void execute(CommandEvent event) {
        if (event.getChannel().getName().contains("-chat")) return;
        event.reply(Embeds.logInfo().build());
    }
}