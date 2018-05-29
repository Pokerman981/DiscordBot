package DiscordBot.commands;

import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class ShutDownCommand extends Command {

	public ShutDownCommand() {
		this.name = "shutdown";
		this.aliases = new String[] { "die", "gtfobot" };
		this.ownerCommand = true;
		this.help = "Shut down the bot gracefully";
		this.category = main.OWNER;
	}

	@Override
	protected void execute(CommandEvent event) {
		String[] cmd = event.getMessage().getContentRaw().split(" ");

		switch (cmd[0]) {
		case "!die": {
			event.reply("Nooooooooo :skull_crossbones: :ghost:");
			break;
		}
		case "!gtfobot": {
			event.reply("Fine :middle_finger:");
			break;
		}
		
		default:{
			event.reply("Shutting down...");
		}
		}
		//Shut the bot down
		event.getJDA().shutdown();
		System.exit(0);

	}
}
