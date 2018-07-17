package DiscordBot.commands;

import DiscordBot.Embeds;
import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;

import java.awt.*;

public class InstallCommand extends Command {

    public InstallCommand() {
        this.name = "install";
        this.category = main.NORMAL;
        this.help = "How to install our modpacks to join our servers.";
        this.aliases = new String[] {"download", "modpack"};
    }

    @Override
    protected void execute(CommandEvent event) {
        if (event.getGuild().getCategoriesByName("server chats", true).get(0).getChannels().toString().contains(event.getChannel().getId())) return;

        String[] cmd = event.getArgs().split(" ");



        if (event.getArgs().isEmpty()) {
            event.reply(this.noArgsTypes(event.getMessage().getContentRaw().split(" ")[0]).build());
            return;
        }

        switch (cmd[0]) {
            case "1": {
                event.reply(Embeds.gensInstallInfo().build());
                break;
            }
            case "2": {
                event.reply(Embeds.reforgedInstallInfo().build());
                break;
            }
            default: {
                event.reply(Embeds.onUnsupportedTypes().build());
                break;
            }
        }





    }

    public static EmbedBuilder noArgsTypes(String command) {
        EmbedBuilder noArgs = new EmbedBuilder();
        noArgs.setColor(Color.red).getDescriptionBuilder()
                .append("Which mod would you like to install?\n\n" +
                        "● Type **"+ command +" 1** to install **Pixelmon Generations** (for PokeDash, Pokeverse, & PokeLegends)\n" +
                        "● Type **"+ command +" 2** to install **Pixelmon Reforged** (for PokeClub)\n");
        return noArgs;
    }

}
