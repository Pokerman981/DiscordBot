package DiscordBot.commands;

import DiscordBot.main;
import DiscordBot.Utils;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class LinkPermitCommand extends Command {

    public LinkPermitCommand() {
        this.name = "permit";
        this.requiredRole = main.requiredRole;
        this.help = "Allow a user to bypass the link blocker once";
        this.guildOnly = true;
        this.category = main.STAFF;
    }

    @Override
    protected void execute(CommandEvent event) {
        if (Utils.CheckRequirements(event) == false) return;

        String args = event.getArgs().replace("<@", "").replaceAll(">", "").replaceAll("!", "");

        if (!main.bypassfilter.contains(event.getGuild().getMemberById(args).getUser().getId())) {
            main.bypassfilter.add(event.getGuild().getMemberById(args).getUser().getId());
            event.replySuccess("Given <@" + event.getGuild().getMemberById(args).getUser().getId() + "> 1 link bypass!");
        } else {
            event.replyError("User already has a link bypass!");
        }
    }
}
