package DiscordBot.events;

import DiscordBot.main;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.EventListener;


public class RoleReactionEvent implements EventListener {

    @Override
    public void onEvent(GenericEvent e) {
        if (e instanceof GuildMessageReactionAddEvent) {
            GuildMessageReactionAddEvent event = (GuildMessageReactionAddEvent) e;
            String messageID = event.getMessageId();
            String emoteID = event.getReactionEmote().getId();
            Member member = event.getMember();

            if (!main.userData.get("reactrolemessages").containsKey(messageID)) return;

            switch (emoteID) {
                case "707662953926623232": { //Poke-Brawl
                    event.getGuild().addRoleToMember(member, event.getGuild().getRoleById("586792372969668613")).submit();
                    //event.getReaction().removeReaction(member.getUser()).submit();
                    break;
                }

                case "628381164939247636": { //PokeLegends
                    event.getGuild().addRoleToMember(member, event.getGuild().getRoleById("467459940093657108")).submit();
                    break;
                }

                case "526264631744790549": { //Pokeverse
                    event.getGuild().addRoleToMember(member, event.getGuild().getRoleById("467459888516431903")).submit();
                    break;
                }

                case "526264234716299284": { //PokeClub
                    event.getGuild().addRoleToMember(member, event.getGuild().getRoleById("467459975812218922")).submit();
                    break;
                }

                case "375433829764169741": { //PokeDash
                    event.getGuild().addRoleToMember(member, event.getGuild().getRoleById("467459853116375040")).submit();
                    break;
                }

            }
        }
    }

}
