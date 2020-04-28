package DiscordBot.commands;

import DiscordBot.Embeds;
import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class RadarCommand extends Command {
    public RadarCommand(){
        this.name = "radar";
        this.category = main.NORMAL;
        this.help = "Displays a tutorial on how to install Pixelradar";
        this.aliases = new String[] {"pokeradar","pixelradar"};
    }

    @Override
    protected void execute(CommandEvent event) {
        if (event.getChannel().getName().contains("-chat")) return;
        event.reply(Embeds.radarInfo().build());
    }
}