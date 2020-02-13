package DiscordBot.events;

import DiscordBot.main;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.core.hooks.EventListener;
import net.dv8tion.jda.core.requests.RequestFuture;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

            if (!main.userData.get("reactrolemessages").containsKey(messageID)) return;

            Member member = event.getMember();
            JDA jda = event.getJDA();

            try {
                id = event.getJDA().getTextChannelById(channelID).getMessageById(messageID).submit().get().getAuthor().getId();
            } catch (InterruptedException | ExecutionException e1) {
                e1.printStackTrace();
            }
            //System.out.println(1);
            //if (member.getUser().getId().equals("126427288496504834")) return;
            //if (!id.equals("282056777003171841")) return;

            switch (emoteID) {
                case "526264234716299284": { //Pokeclub
                    event.getGuild().getController().addSingleRoleToMember(member, event.getGuild().getRoleById("467459975812218922")).submit();
                    //event.getReaction().removeReaction(member.getUser()).submit();
                    break;
                }

                case "375433829764169741": { //Pokedash
                    event.getGuild().getController().addRolesToMember(member, event.getGuild().getRoleById("467459853116375040")).submit();
                    break;
                }

                case "526264631744790549": { //Pokeverse
                    event.getGuild().getController().addRolesToMember(member, event.getGuild().getRoleById("467459888516431903")).submit();
                    break;
                }

                case "375434322339168256": { //Pokelegends
                    event.getGuild().getController().addRolesToMember(member, event.getGuild().getRoleById("467459940093657108")).submit();
                    break;
                }

                case "586480683397152820": { //Pokebrawl
                    event.getGuild().getController().addRolesToMember(member, event.getGuild().getRoleById("586792372969668613")).submit();
                    break;
                }
            }
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
