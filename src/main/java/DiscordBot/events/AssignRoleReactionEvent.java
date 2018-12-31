package DiscordBot.events;

import DiscordBot.main;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.core.hooks.EventListener;
import net.dv8tion.jda.core.requests.RequestFuture;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class AssignRoleReactionEvent implements EventListener{

    @Override
    public void onEvent(Event e){
        if (e instanceof GuildMessageReactionAddEvent) {
            GuildMessageReactionAddEvent event = (GuildMessageReactionAddEvent) e;

            String channelID = event.getChannel().getId();
            String messageID = event.getMessageId();
            String emoteID = event.getReactionEmote().getId();
            String id = null;

            Member member = event.getMember();

            JDA jda = event.getJDA();

            try {
                id = event.getJDA().getTextChannelById(channelID).getMessageById(messageID).submit().get().getAuthor().getId();
            } catch (InterruptedException | ExecutionException e1) {
                e1.printStackTrace();
            }


            if (member.getUser().getId().equals("126427288496504834")) return;
            if (!id.equals("282056777003171841")) return;

            System.out.println(event.getGuild().getRoles().toString());

            switch (emoteID) {
                case "375434302730665994": { //Pokeclub
                    event.getGuild().getController().addSingleRoleToMember(member, event.getGuild().getRoleById("467459975812218922")).submit();
                    break;
                }

                case "375433829764169741": { //Pokedash
                    event.getGuild().getController().addRolesToMember(member, event.getGuild().getRoleById("467459853116375040")).submit();
                    break;
                }

                case "375434343071481857": { //Pokeverse
                    event.getGuild().getController().addRolesToMember(member, event.getGuild().getRoleById("467459888516431903")).submit();
                    break;
                }

                case "375434322339168256": { //Pokelegends
                    event.getGuild().getController().addRolesToMember(member, event.getGuild().getRoleById("467459940093657108")).submit();
                    break;
                }
            }
                event.getReaction().removeReaction(member.getUser()).submit();
        }



















       /* if (e instanceof GuildMessageReactionAddEvent) {
            GuildMessageReactionAddEvent event = (GuildMessageReactionAddEvent) e;
            if (event.getUser().isBot()) return;
            if (!event.getReactionEmote().getName().equals("⭐")) {
                return;
            }

            if (main.userData.get("starboard").containsValue(event.getMessageId())) return;

            TextChannel quotechannel = event.getGuild().getTextChannelsByName("starboard", true).get(0);


            try {
                int count = event.getReaction().getUsers().submit().get().size();
                if (count >= 20) {
                    main.userData.get("starboard").put(String.valueOf(main.userData.get("starboard").size()), event.getMessageId());
                    main.Save();
                    RequestFuture<Message> quote = event.getChannel().getMessageById(event.getMessageId()).submit();
                    EmbedBuilder embed = new EmbedBuilder();

                    embed.setColor(Color.decode("#000000"))
                            .setTimestamp(quote.get().getCreationTime())
                            .setFooter(quote.get().getAuthor().getName() + "#" + quote.get().getAuthor().getDiscriminator(), quote.get().getAuthor().getAvatarUrl());

                    if (!quote.get().getContentRaw().isEmpty()) {
                        embed.setDescription("\"" + quote.get().getContentRaw() + "\"");
                    }

                    if (!quote.get().getAttachments().isEmpty() && quote.get().getAttachments().get(0).isImage()) {
                        embed.setImage(quote.get().getAttachments().get(0).getUrl());
                    }

                    quotechannel.sendMessage(embed.build()).queue();
                }
            } catch (InterruptedException | ExecutionException | IOException e1) {
                e1.printStackTrace();
            }


        } */
    }
}
