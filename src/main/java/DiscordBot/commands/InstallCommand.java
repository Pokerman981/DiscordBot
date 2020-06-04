package DiscordBot.commands;

import DiscordBot.Embeds;
import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class InstallCommand extends Command {

    public InstallCommand() {
        this.name = "install";
        this.category = main.roleCategories.get("player");
        this.help = "Displays a tutorial on how to join our servers";
        this.aliases = new String[] {"download", "modpack"};
    }

    @Override
    protected void execute(CommandEvent event) {
        if (event.getChannel().getName().contains("-chat")) return;
        event.reply(Embeds.reforgedInstallInfo().build());
    }
}