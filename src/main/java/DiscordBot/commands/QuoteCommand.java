package DiscordBot.commands;

import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.requests.RequestFuture;

import java.awt.*;
import java.util.concurrent.ExecutionException;

public class QuoteCommand extends Command {

    public QuoteCommand(){
        this.name = "quote";
        this.guildOnly = true;
        this.help = "Quote a message to easily reply to another person";
        this.category = main.NORMAL;
    }

    @Override
    protected void execute(CommandEvent event) {
        if (event.getArgs().split(" ").length > 1) {
            event.replyError("You have supplied to many arguments, " + event.getAuthor().getAsMention() + "!");
            return;
        }

        RequestFuture<Message> quote = event.getChannel().getMessageById(event.getArgs()).submit();

        try {
            EmbedBuilder embed = new EmbedBuilder();

            embed.setColor(Color.decode("#000000"))
                    .setTimestamp(quote.get().getCreationTime())
                    .setFooter(quote.get().getAuthor().getName() + "#" + quote.get().getAuthor().getDiscriminator(), quote.get().getAuthor().getAvatarUrl());

            if (!quote.get().getContentRaw().isEmpty()) {
                embed.setDescription("\"" + quote.get().getContentRaw() + "\"");
            }

            if (!quote.get().getAttachments().isEmpty() && quote.get().getAttachments().get(0).isImage()) {
                embed.setImage(quote.get().getAttachments().get(0).getUrl());
            }

            event.getChannel().sendMessage(embed.build()).queue();
        } catch (InterruptedException | ExecutionException e) {
            event.replyError("The ID you supplied is not valid!");
            return;
        }
    }
}
