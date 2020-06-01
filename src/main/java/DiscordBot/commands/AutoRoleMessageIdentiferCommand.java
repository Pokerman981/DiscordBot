package DiscordBot.commands;

import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.HashMap;
import java.util.Map;

public class AutoRoleMessageIdentiferCommand extends Command {

    public AutoRoleMessageIdentiferCommand() {
        this.name = "reactmessage";
        this.requiredRole = main.requiredAdminRole;
        this.help = "";
        this.guildOnly = true;
        this.category = main.ADMIN;
    }

    @Override
    protected void execute(CommandEvent event) {
        try {
            if (event.getArgs().split(" ").length > 2) return;
            String[] args = event.getArgs().split(" ");

            Guild guild = event.getGuild();
            TextChannel textChannel = guild.getTextChannelById(args[0]);
            Message message = textChannel.retrieveMessageById(args[0]).complete();
            //System.out.println(message.getContentRaw());
            Emote pokeverse = event.getGuild().getEmoteById("526264631744790549");
            Emote pokedash = event.getGuild().getEmoteById("375433829764169741");
            Emote pokelegends = event.getGuild().getEmoteById("375434322339168256");
            Emote pokeclub = event.getGuild().getEmoteById("526264234716299284");
            Emote pokebrawl = event.getGuild().getEmoteById("586480683397152820");



            Map<String, String> reactrolemessages = new HashMap<String, String>();

            main.userData.get("reactrolemessages").put(message.getId(), textChannel.getId());
            message.addReaction(pokeverse).queue();
            message.addReaction(pokedash).queue();
            message.addReaction(pokeclub).queue();
            message.addReaction(pokelegends).queue();
            message.addReaction(pokebrawl).queue();


            //System.out.println(message.getReactions().get(1).getReactionEmote().getId() + " " + message.getReactions().get(1).getReactionEmote().getName());


            event.reactSuccess();
        } catch (NullPointerException e) {
            event.replyError("Something went wrong check console");
            e.printStackTrace();
        }

    }


}
