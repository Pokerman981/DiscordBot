package DiscordBot.commands;

import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.io.IOException;

public class BlockLinkCommand extends Command{
	
	public BlockLinkCommand() {
		this.name = "blocklink";
		this.requiredRole = main.requiredAdminRole;
		this.help = "Add a link to be blocked (supports regex)";
		this.guildOnly = true;
		this.category = main.ADMIN;
	}

	@Override
	protected void execute(CommandEvent event) {
		String[] cmd = event.getMessage().getContentRaw().split(" ");
		if (cmd.length == 1) {
			event.replyError("You need to supply an argument");
			return;
		}

		if (cmd.length > 2){
			event.replyError("You have supplied to many arguments!");
			return;
		}

		int size = main.userData.get("links").size();
		
		main.userData.get("links").put(String.valueOf(size + 1), event.getArgs());
		try {main.Save();} catch (IOException e) {e.printStackTrace();}
		
		event.reply("Successfully added `" + event.getArgs() + "` to the blocked links, " + event.getAuthor().getAsMention() + "!");
		
	}
	
	

}
