package DiscordBot.commands;

import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;

public class Ping extends Command {

	
	public Ping() {
		this.name = "ping";
		this.help = "Get the ping of the bot";
		this.hidden = true;
		this.guildOnly = true;
		this.userPermissions = new Permission[]{Permission.MESSAGE_MANAGE};
        this.category = main.STAFF;
	}
	
	@Override
	protected void execute(CommandEvent event) {
		event.reply("Ping: " + event.getJDA().getPing());
		
		
	}

}
