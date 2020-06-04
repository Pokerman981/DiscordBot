package DiscordBot.commands;

import DiscordBot.Embeds;
import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class ModCommand extends Command {
    public ModCommand(){
        this.name = "mod";
        this.category = main.roleCategories.get("player");
        this.help = "Displays a tutorial on how to install mods";
        this.aliases = new String[] {"mods"};
    }

    @Override
    protected void execute(CommandEvent event) {
        if (event.getChannel().getName().contains("-chat")) return;
        event.reply(Embeds.modInfo().build());
    }
}