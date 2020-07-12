package DiscordBot.commands;

import DiscordBot.Embeds;
import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;


public class LogsCommand extends Command {

    public LogsCommand(){
        this.name = "logs";
        this.category = main.roleCategories.get("player");
        this.help = "Displays how to access minecraft logs";
    }

    @Override
    protected void execute(CommandEvent event) {
        if(event.getArgs().isEmpty()) {
            event.reply(Embeds.noArgsLogs().build());
            return;
        }

        String[] os = event.getArgs().split(" ");

        switch (os[0].toLowerCase()) {
            case "windows": {
                event.reply(Embeds.logsWin().build());
                break;
            }
            case "mac": {
                event.reply(Embeds.logsMac().build());
                break;
            }

            default: {
                event.replyError("We do not have a guide for this os!");
                return;
            }
        }
    }
}
