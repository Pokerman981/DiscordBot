package DiscordBot.commands;

import DiscordBot.Embeds;
import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;


public class IPCommand extends Command {

    public IPCommand(){
        this.name = "ip";
        this.category = main.NORMAL;
        this.help = "Check what the IPs of the servers are";
    }

    @Override
    protected void execute(CommandEvent event) {
        if(event.getArgs().isEmpty()) {
            event.reply(Embeds.noArgsIP().build());
            return;
        }

        String[] server = event.getArgs().split(" ");

        switch (server[0].toLowerCase()) {
            case "pokedash": {
                event.reply(Embeds.IPPD().build());
                break;
            }
            case "pokeverse": {
                event.reply(Embeds.IPPV().build());
                break;
            }
            case "pokelegends": {
                event.reply(Embeds.IPPL().build());
                break;
            }
            case "pokeclub": {
                event.reply(Embeds.IPPC().build());
                break;
            }
            case "pokebrawl": {
                event.reply(Embeds.IPPB().build());
                break;
            }
            default: {
                event.replyError("We do not support this server!");
                return;
            }
        }

    }
}
