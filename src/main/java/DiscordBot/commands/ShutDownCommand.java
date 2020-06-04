package DiscordBot.commands;

import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class ShutDownCommand extends Command {

	public ShutDownCommand() {
		this.name = "shutdown";
		this.help = "Shut down the bot gracefully";
		this.category = main.roleCategories.get("manager");
		this.requiredRole = main.requiredRoles.get("manager");
	}

	@Override
	protected void execute(CommandEvent event) {

		event.reply("Shutting down...");
		event.getJDA().shutdown();
		main.jda.shutdown();
		System.exit(0);
	}
}
