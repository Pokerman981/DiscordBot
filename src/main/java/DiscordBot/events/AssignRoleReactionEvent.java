package DiscordBot.events;

import DiscordBot.main;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;


public class AssignRoleReactionEvent implements EventListener {

    @Override
    public void onEvent(@NotNull GenericEvent e) {
        if (e instanceof GuildMessageReactionAddEvent) {
            GuildMessageReactionAddEvent event = (GuildMessageReactionAddEvent) e;
            String messageID = event.getMessageId();
            String emoteID = event.getReactionEmote().getId();
            Member member = event.getMember();

            if (!main.userData.get("reactrolemessages").containsKey(messageID)) return;

            switch (emoteID) {
                case "526264234716299284": { //Pokeclub
                    event.getGuild().addRoleToMember(member, event.getGuild().getRoleById("467459975812218922")).submit();
                    //event.getReaction().removeReaction(member.getUser()).submit();
                    break;
                }

                case "375433829764169741": { //Pokedash
                    event.getGuild().addRoleToMember(member, event.getGuild().getRoleById("467459853116375040")).submit();
                    break;
                }

                case "526264631744790549": { //Pokeverse
                    event.getGuild().addRoleToMember(member, event.getGuild().getRoleById("467459888516431903")).submit();
                    break;
                }

                case "375434322339168256": { //Pokelegends
                    event.getGuild().addRoleToMember(member, event.getGuild().getRoleById("467459940093657108")).submit();
                    break;
                }

                case "586480683397152820": { //Pokebrawl
                    event.getGuild().addRoleToMember(member, event.getGuild().getRoleById("586792372969668613")).submit();
                    break;
                }
            }
        }
    }
}