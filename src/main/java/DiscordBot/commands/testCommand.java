package DiscordBot.commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class testCommand implements EventListener {

	@Override
	public void onEvent(Event event) {
		if (event instanceof GuildMessageReceivedEvent) {
			if (((GuildMessageReceivedEvent) event).getMessage().getContentRaw().split(" ")[0].equals("!test")) {
				GuildMessageReceivedEvent e = (GuildMessageReceivedEvent) event;
				String[] msg = e.getMessage().getContentRaw().split(" ");

				try {
                    if (e.getChannel().getMessageById(msg[1]).submit().get().getContentRaw().isEmpty()) {
                    System.out.println("111");

                    }
                } catch (ExecutionException | InterruptedException e1) {
				    e1.printStackTrace();
                }


			}
				
				
			}

		}
	}
