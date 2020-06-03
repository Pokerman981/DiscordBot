package DiscordBot.commands;

import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.io.IOException;

public class AssignRoleReactionCommand extends Command {

    public AssignRoleReactionCommand() {
        this.name = "reactmessage1";
        // this.requiredRole = main.requiredAdminRole;
        this.help = "";
        this.guildOnly = true;
        // this.category = main.ADMIN;
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

            for (String key : main.emoteRankID.keySet()) {
                Emote emote = event.getGuild().getEmoteById(key);
                message.addReaction(emote).queue();
            }

            //System.out.println(message.getReactions().get(1).getReactionEmote().getId() + " " + message.getReactions().get(1).getReactionEmote().getName());


            main.Save();
            event.reactSuccess();
        } catch (NullPointerException | IOException e) {
            event.replyError("Something went wrong check console");
            e.printStackTrace();
        }

    }


}
