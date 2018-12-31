package DiscordBot.commands;

import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class SelfAssignCommand extends Command {

    public SelfAssignCommand() {
        this.name = "notify";
        this.category = main.NORMAL;
        this.guildOnly = true;
        this.arguments = "<server>";
        this.help = "Assign your self a server specific role to recive updates";
    }

    @Override
    protected void execute(CommandEvent event) {
        if (event.getArgs().isEmpty()) {
            event.replyError("You must supply a server!");
            return;
        }

        String args = event.getArgs().split(" ")[0].toLowerCase();

        switch (args) {
            case "pokedash": {
                event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRolesByName("pokedash", true).get(0)).queue();
                break;
            }
            case "pokeverse": {
                event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRolesByName("pokeverse", true).get(0)).queue();
                break;
            }
            case "pokelegends": {
                event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRolesByName("pokelegends", true).get(0)).queue();
                break;
            }
            case "pokeclub": {
                event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRolesByName("pokeclub", true).get(0)).queue();
                break;
            }
            default: {
                event.replyError("We do not support this server!");
                return;
            }
        }
        event.replySuccess("Successfully added " + args + " tag!");
    }
}
