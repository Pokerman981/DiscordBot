package DiscordBot.commands;

import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.requests.RequestFuture;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ForceStarboardCommand extends Command {

    public ForceStarboardCommand(){
        this.name = "force";
        this.guildOnly = true;
        this.help = "Force a message to be quoted to the starboard channel";
        this.requiredRole = main.requiredAdminRole;
        this.category = main.ADMIN;
    }

    @Override
    protected void execute(CommandEvent event) {
        if (event.getArgs().split(" ").length > 1) {
            event.replyError("You have supplied to many arguments, " + event.getAuthor().getAsMention() + "!");
            return;
        }

        if (main.userData.get("starboard").values().contains(event.getArgs())) {
            event.replyError("This has already been quoted!");
            return;
        }

        RequestFuture<Message> quote = event.getChannel().getMessageById(event.getArgs()).submit();

        try {
            main.userData.get("starboard").put(String.valueOf(main.userData.get("starboard").size()), event.getArgs());
            main.Save();
            EmbedBuilder embed = new EmbedBuilder();

            embed.setColor(Color.decode("#000000"))
                    .setTimestamp(quote.get().getCreationTime())
                    .setDescription("\"" + quote.get().getContentRaw() + "\"")
                    .setFooter(quote.get().getAuthor().getName() + "#" + quote.get().getAuthor().getDiscriminator(), quote.get().getAuthor().getAvatarUrl());

            TextChannel quotechannel = event.getJDA().getTextChannelsByName("starboard", true).get(0);
            quotechannel.sendMessage(embed.build()).queue();
            event.reply("Quoted, " + event.getAuthor().getAsMention() + "!");
        } catch (InterruptedException | ExecutionException | IOException e) {
            event.replyError("The ID you supplied is not valid!");
            return;
        }
    }
}
