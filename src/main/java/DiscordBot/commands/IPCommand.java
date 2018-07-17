package DiscordBot.commands;

import DiscordBot.Embeds;
import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import javafx.util.Builder;
import net.dv8tion.jda.core.EmbedBuilder;
import java.awt.*;


public class IPCommand extends Command {

    public IPCommand(){
        this.name = "ip";
        this.category = main.NORMAL;
        this.help = "Check what the IPs of the servers are";
    }

    @Override
    protected void execute(CommandEvent event) {
        if(event.getArgs().isEmpty()) {
            event.reply(Embeds.supplyServer().build());
            return;
        }
        String[] server = event.getArgs().split(" ");
        server[0].toLowerCase();

        switch (server[0]) {
            case "pokedash": {
                event.reply("play.pokedash.org");
                break;
            }
            case "pokeverse": {
                event.reply("play.pokeverse.org");
                break;
            }
            case "pokelegends": {
                event.reply("play.pokelegends.org");
                break;
            }
            case "pokeclub": {
                event.reply("play.pokeclub.net");
                break;
            }
            default: {
                event.replyError("We do not support this server!");
                return;
            }
        }

    }
}
