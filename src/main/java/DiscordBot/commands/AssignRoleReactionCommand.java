package DiscordBot.commands;

import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AssignRoleReactionCommand extends Command {

    final public String rank = "manager";

    public AssignRoleReactionCommand() {
        this.name = "reactmessage";
        this.requiredRole = main.requiredRoles.get(rank);
        this.category = main.roleCategories.get(rank);
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
            //System.out.println(message.getContentRaw());

            main.userData.get("reactrolemessages").put(message.getId(), textChannel.getId());

            System.out.println(main.emoteRankID.keySet());
            for (String key : main.emoteRankID.keySet()) {
                Emote emote = event.getGuild().getEmoteById(key);
                message.addReaction(emote).queue();
            }

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
