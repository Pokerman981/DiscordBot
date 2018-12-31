package DiscordBot.events;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import DiscordBot.main;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.core.hooks.EventListener;
import net.dv8tion.jda.core.requests.RequestFuture;

public class AssignRoleReactionEvent implements EventListener {
    private static final String BotGUID = "435616811602673688";

    @Override
    public void onEvent(Event e) {
        if (e instanceof GuildMessageReactionAddEvent) {
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


        }
    }

}

/*                   */
