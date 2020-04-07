package DiscordBot.commands;

import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;

import java.awt.*;

public class RamCommand extends Command {
    public RamCommand(){
        this.name = "ram";
        this.category = main.NORMAL;
        this.help = "Displays a link to the ram tutorial";
    }

    @Override
    protected void execute(CommandEvent event) {
        EmbedBuilder ram = new EmbedBuilder();

        ram.setTitle("RAM Tutorial")
                .setColor(Color.green)
                .getDescriptionBuilder()
                .append("Follow this tutorial to allocate more RAM to your game: http://bit.ly/RAMTutorial");

        event.reply(ram.build());
    }
}