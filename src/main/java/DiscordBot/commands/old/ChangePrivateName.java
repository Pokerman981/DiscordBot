package DiscordBot.commands.old;

import DiscordBot.main;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;

public class ChangePrivateName implements EventListener{

	@Override
	public void onEvent(Event event) {
		if (event instanceof GuildMessageReceivedEvent){
			String[] msg = ((GuildMessageReceivedEvent) event).getMessage().getContentRaw().split(" ");
			if (msg[0].equals("!rename")){
				User user = ((GuildMessageReceivedEvent) event).getMember().getUser();
				TextChannel channel = ((GuildMessageReceivedEvent) event).getChannel();
				
				if (!main.userData.containsKey(user.getId())){
					channel.sendMessage("You currecntly do not own a channel " + user.getAsMention() + "! Create one by typing '!private'").queue();
					return;
				}
				
				if (!channel.getId().equals(main.userData.get(user.getId()).get(0))){
					channel.sendMessage("You do not own this channel " + user.getAsMention() + "! Please use this command here: <#" + main.userData.get(user.getId()).get(0) + ">").queue();
					return;
				}
				
				if (msg.length < 2){
					channel.sendMessage("You must supply a new name for the channel!").queue();
					return;
				}
				String message = ((GuildMessageReceivedEvent) event).getMessage().getContentRaw().replaceAll("!rename ", "");
				channel.getManager().setName(message).queue();
				channel.sendMessage("Successfully changed channel name to: `" + message + "`").queue();
				
			}
		}
		
	}

}
