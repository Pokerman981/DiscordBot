package DiscordBot.commands;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;

import java.util.List;
import java.util.stream.Collectors;

public class testCommand implements EventListener {

	@Override
	public void onEvent(Event event) {
		if (event instanceof GuildMessageReceivedEvent) {
			if (((GuildMessageReceivedEvent) event).getMessage().getContentRaw().split(" ")[0].equals("!test")) {
				GuildMessageReceivedEvent e = (GuildMessageReceivedEvent) event;
				List<Member> online = e.getGuild().getMembers().stream().filter(member -> e.getGuild().getSelfMember().getOnlineStatus().getKey().equals("idle")).collect(Collectors.toList());
				System.out.println(online.size());
                        //⭐


			}
				
				
			}

		}
	}
