package DiscordBot.commands;

import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RemoveRoleReactionCommand extends Command {

    public RemoveRoleReactionCommand() {
        this.name = "removereactmessage";
        this.requiredRole = main.requiredRoles.get("manager");
        this.category = main.roleCategories.get("manager");
        this.guildOnly = true;
        this.hidden = true;
    }

    @Override
    protected void execute(CommandEvent event) {
        try {
            if (event.getArgs().split(" ").length > 2) return;
            String[] args = event.getArgs().split(" ");

            Guild guild = event.getGuild();
            TextChannel textChannel = guild.getTextChannelById(args[0]);
            Message message = textChannel.retrieveMessageById(args[1]).complete();

            if (!main.userData.get("reactrolemessages").containsKey(message.getId())) {
                event.replyError("Unable to find supplied message! *(Prolly not a role react message)*");
                return;
            }

            main.userData.get("reactrolemessages").remove(message.getId());
            message.clearReactions().queue();

//            for (String key : main.emoteRankID.keySet()) {
//                Emote emote = event.getGuild().getEmoteById(key);
//                message.addReaction(emote).queue();
//            }

            //System.out.println(message.getReactions().get(1).getReactionEmote().getId() + " " + message.getReactions().get(1).getReactionEmote().getName());


            main.Save();
            event.reactSuccess();
            event.getMessage().delete().queueAfter(5, TimeUnit.SECONDS);
        } catch (NullPointerException | IOException e) {
            event.replyError("Something went wrong check console");
            e.printStackTrace();
        }

    }


}
