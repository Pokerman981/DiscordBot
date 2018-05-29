package DiscordBot.commands;

import java.awt.Color;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import DiscordBot.main;
import net.dv8tion.jda.core.EmbedBuilder;

public class ListBlockedLinksCommand extends Command{

	public ListBlockedLinksCommand() {
		this.name = "showlinks";
		this.help = "Show which types of links are blocked";
		this.requiredRole = main.requiredRole;
        this.category = main.STAFF;
	}
	
	@Override
	protected void execute(CommandEvent event) {	
		List<String> links = new ArrayList<String>(main.userData.get("links").values());
		
		EmbedBuilder linksembed = new EmbedBuilder();	
		linksembed.setColor(Color.green);
		linksembed.setTimestamp(OffsetDateTime.now());
		linksembed.setTitle("Blocked Links");
		
		for (int x = 0; x < links.size(); x++ ) {
			linksembed.getDescriptionBuilder()
			.append("\n" + (x+1) + ". `" + links.get(x) + "`");
		}
		
		linksembed.appendDescription("\n");
		
		event.reply(linksembed.build());
	}

}
