package DiscordBot.events;



import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.time.OffsetDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class GuildJoinEvent implements EventListener {

	@Override
	public void onEvent(@NotNull GenericEvent e) {

		if (e instanceof GuildMemberJoinEvent) {

			GuildMemberJoinEvent event = (GuildMemberJoinEvent) e;

			TextChannel channel = event.getGuild().getTextChannelsByName("join-leave-log", true).get(0);
			channel.sendMessage(onJoin((event).getUser(), (event).getGuild()).build()).queue();


			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					int memberCount = event.getGuild().getMembers().size();
					event.getGuild().getVoiceChannelById("527244427920539688").getManager().setName("Member Count: " + memberCount).queue();
				}
			}, 0, 300 * 1000);
		}
	}
	
	public EmbedBuilder onJoin(User user, Guild guild){
		EmbedBuilder embed = new EmbedBuilder();
		
		embed.setColor(Color.green);
		embed.setFooter(String.valueOf(guild.getMembers().size()) + " Users!", null);
		embed.setTitle("User Joined!");
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