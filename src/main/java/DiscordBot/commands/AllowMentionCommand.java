package DiscordBot.commands;

import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class AllowMentionCommand extends Command {

    public AllowMentionCommand() {
        this.name = "mention";
        this.category = main.ADMIN;
        this.requiredRole = "admin";
        this.guildOnly = true;
        this.arguments = "<server>";
        this.help = "Enable a role to be mentioned";
    }

    @Override
    protected void execute(CommandEvent event) {
        if (event.getArgs().isEmpty()) {
            event.replyError("You must supply a server!");
            return;
        }

        String[] args = event.getArgs().split(" ");
        String ID = args[0].toLowerCase().replaceAll("<@&", "").replaceAll(">", "");

        switch (ID) {
            case "pokedash": {
                    String PDID = event.getGuild().getRolesByName("pokedash", true).get(0).getId();

                        if (event.getGuild().getRoleById(PDID).isMentionable()) {

                            event.getGuild().getRoleById(PDID).getManager().setMentionable(false).queue();
                        } else {
                            event.getGuild().getRoleById(PDID).getManager().setMentionable(true).queue();
                        }
                break;
            }
            case "pokeverse": {
                String PDID = event.getGuild().getRolesByName("pokeverse", true).get(0).getId();

                if (event.getGuild().getRoleById(PDID).isMentionable()) {

                    event.getGuild().getRoleById(PDID).getManager().setMentionable(false).queue();
                } else {
                    event.getGuild().getRoleById(PDID).getManager().setMentionable(true).queue();
                }
                break;
            }
            case "pokelegends": {
                String PDID = event.getGuild().getRolesByName("pokelegends", true).get(0).getId();

                if (event.getGuild().getRoleById(PDID).isMentionable()) {

                    event.getGuild().getRoleById(PDID).getManager().setMentionable(false).queue();
                } else {
                    event.getGuild().getRoleById(PDID).getManager().setMentionable(true).queue();
                }
                break;
            }
            case "pokeclub": {
                String PDID = event.getGuild().getRolesByName("pokeclub", true).get(0).getId();

                if (event.getGuild().getRoleById(PDID).isMentionable()) {

                    event.getGuild().getRoleById(PDID).getManager().setMentionable(false).queue();
                } else {
                    event.getGuild().getRoleById(PDID).getManager().setMentionable(true).queue();
                }
                break;
            }
            default: {
                event.replyError("You cannot change the mention status of this role!");
                return;
            }
        }
        event.replySuccess("Successfully changed mention status!");
    }
}
