package DiscordBot.events;

import DiscordBot.main;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.core.hooks.EventListener;

public class RoleReactionEvent implements EventListener {

    @Override
    public void onEvent(Event e) {
        if (e instanceof GuildMessageReactionAddEvent) {
            GuildMessageReactionAddEvent event = (GuildMessageReactionAddEvent) e;
            String messageID = event.getMessageId();
            String emoteID = event.getReactionEmote().getId();
            Member member = event.getMember();

            if (!main.userData.get("reactrolemessages").containsKey(messageID)) return;

            switch (emoteID) {
                case "375433829764169741": { //PokeDash
                    event.getGuild().getController().addRolesToMember(member, event.getGuild().getRoleById("467459853116375040")).submit();
                    break;
                }

                case "714032214245113907": { //PokeVerse
                    event.getGuild().getController().addRolesToMember(member, event.getGuild().getRoleById("467459888516431903")).submit();
                    break;
                }

                case "628381164939247636": { //PokeLegends
                    event.getGuild().getController().addRolesToMember(member, event.getGuild().getRoleById("467459940093657108")).submit();
                    break;
                }

                case "526264234716299284": { //PokeClub
                    event.getGuild().getController().addRolesToMember(member, event.getGuild().getRoleById("467459975812218922")).submit();
                    break;
                }

                case "707662953926623232": { //PokeBrawl
                    event.getGuild().getController().addSingleRoleToMember(member, event.getGuild().getRoleById("586792372969668613")).submit();
                    //event.getReaction().removeReaction(member.getUser()).submit();
                    break;
                }

                case "711289077491564605": { //PokeZone
                    event.getGuild().getController().addRolesToMember(member, event.getGuild().getRoleById("711157151246057482")).submit();
                    break;
                }

            }
        }
    }

}
