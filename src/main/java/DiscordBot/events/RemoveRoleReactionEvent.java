package DiscordBot.events;

import DiscordBot.main;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;


public class RemoveRoleReactionEvent implements EventListener {

    @Override
    public void onEvent(@NotNull GenericEvent e) {
        if (e instanceof GuildMessageReactionRemoveEvent) {
            GuildMessageReactionRemoveEvent event = (GuildMessageReactionRemoveEvent) e;
            String messageID = event.getMessageId();

            if (!main.userData.get("reactrolemessages").containsKey(messageID)) return;
//            String emoteName = event.getReactionEmote().getName().replace("poke", "");

            String emoteID = event.getReactionEmote().getId();
            if (!main.emoteRankID.containsKey(emoteID)) return;

            String userID = event.getUserId();

            String roleID = main.emoteRankID.get(emoteID);
            Role resolvedRole = event.getGuild().getRoleById(roleID);
            Member resolvedMember = event.getGuild().retrieveMemberById(userID).complete();

            event.getGuild().removeRoleFromMember(resolvedMember, resolvedRole).queue();
        }
    }

}
