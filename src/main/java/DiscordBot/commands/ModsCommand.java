package DiscordBot.commands;

import DiscordBot.Embeds;
import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class ModsCommand extends Command {
    public ModsCommand(){
        this.name = "mod";
        this.category = main.roleCategories.get("player");
        this.help = "Displays a tutorial on how to install mods";
        this.aliases = new String[] {"mods"};
    }

    @Override
    protected void execute(CommandEvent event) {
        if(event.getArgs().isEmpty()) {
            event.reply(Embeds.noArgsMods().build());
            return;
        }

        String[] os = event.getArgs().split(" ");

        switch (os[0].toLowerCase()) {
            case "windows": {
                event.reply(Embeds.modsWin().build());
                break;
            }
            case "mac": {
                event.reply(Embeds.modsMac().build());
                break;
            }

            default: {
                event.replyError("We do not have a guide for this os yet!");
                return;
            }
        }
    }
//    @Override
//    protected void execute(CommandEvent event) {
//        if (event.getChannel().getName().contains("-chat")) return;
//        event.reply(Embeds.modInfo().build());
//    }
}