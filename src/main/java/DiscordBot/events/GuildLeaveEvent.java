package DiscordBot.events;


import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.EventListener;

import java.awt.*;
import java.time.OffsetDateTime;

public class GuildLeaveEvent implements EventListener {

	@Override
	public void onEvent(GenericEvent e) {
		if (e instanceof GuildMemberRemoveEvent){
			GuildMemberRemoveEvent event = (GuildMemberRemoveEvent) e;
			
			TextChannel channel = event.getGuild().getTextChannelsByName("join-leave-log", true).get(0);
			channel.sendMessage(onLeave((event).getUser(), event.getGuild()).build()).queue();
			
			int memberCount = event.getGuild().getMembers().size();
			event.getGuild().getVoiceChannelById("527244427920539688").getManager().setName("Member Count: " + memberCount).queue();
		}
	}

	public EmbedBuilder onLeave(User user, Guild guild){
		EmbedBuilder embed = new EmbedBuilder();
		
		embed.setColor(Color.red);
		embed.setFooter(String.valueOf(guild.getMembers().size()) + " Users!", null);
		embed.setTitle("User Left!");
		embed.setThumbnail(user.getEffectiveAvatarUrl());
		embed.getDescriptionBuilder()
		.append("\n**User**\n")
		.append(user.getName() + "#" + user.getDiscriminator())
		.append("\n\n")
		.append("**User ID**\n")
		.append(user.getId());
		embed.setTimestamp(OffsetDateTime.now());
		return embed;
	}
}