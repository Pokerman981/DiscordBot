package DiscordBot.commands;

import DiscordBot.Embeds;
import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class PricesCommand extends Command {
    public PricesCommand(){
        this.name = "prices";
        this.category = main.roleCategories.get("player");
        this.help = "Displays links to the price list of each server";
    }

    @Override
    protected void execute(CommandEvent event) {
        if (event.getArgs().isEmpty()) {
            event.reply(Embeds.pricesInfo().build());
            return;
        }
    }
}