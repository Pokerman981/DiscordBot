package DiscordBot.commands;

import DiscordBot.Embeds;
import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;


public class IPCommand extends Command {

    public IPCommand() {
        this.name = "ip";
        this.category = main.roleCategories.get("player");
        this.help = "Displays a list of each server's IP address";
    }

    @Override
    protected void execute(CommandEvent event) {
        if(event.getArgs().isEmpty()) {
            event.reply(Embeds.noArgsIP().build());
            return;
        }

        String[] server = event.getArgs().split(" ");
        switch (server[0].toLowerCase()) {
            case "pd":
            case "dash":
            case "pokedash": {
                event.reply(Embeds.IPPD().build());
                break;
            }
            case "pv":
            case "verse":
            case "pokeverse": {
                event.reply(Embeds.IPPV().build());
                break;
            }
            case "pl":
            case "legends":
            case "pokelegends": {
                event.reply(Embeds.IPPL().build());
                break;
            }
            case "pc":
            case "club":
            case "pokeclub": {
                event.reply(Embeds.IPPC().build());
                break;
            }
            case "pb":
            case "brawl":
            case "pokebrawl": {
                event.reply(Embeds.IPPB().build());
                break;
            }
            case "pz":
            case "zone":
            case "pokezone": {
                event.reply(Embeds.IPPZ().build());
                break;
            }

            default: {
                event.replyError("We do not support this server!");
                return;
            }
        }
    }

}
