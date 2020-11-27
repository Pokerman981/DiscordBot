package DiscordBot.commands;

import DiscordBot.Embeds;
import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class AppealCommand extends Command {

    public AppealCommand() {
        this.name = "appeal";
        this.aliases = new String[] {"appeals", "apply", "application", "helperapp", "builderapp", "staffapp", "gymleaderapp"};
        this.category = main.roleCategories.get("player");
        this.help = "Displays information about apps";
    }

    @Override
    protected void execute(CommandEvent event) {
        if (event.getChannel().getName().contains("-chat")) return;
        event.reply(Embeds.appInfo().build());
    }

}