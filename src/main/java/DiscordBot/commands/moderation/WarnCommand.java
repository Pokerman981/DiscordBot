package DiscordBot.commands.moderation;

import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
import java.lang.reflect.Array;

public class WarnCommand extends Command {

    public WarnCommand() {
        this.name = "warn";
        this.aliases = new String[]{"w"};
        this.guildOnly = true;
        this.help = "Warn a specified user";
        this.category = main.roleCategories.get("staff");
        this.requiredRole = main.requiredRoles.get("staff");
        this.hidden = true;
    }

    @Override
    protected void execute(CommandEvent event) {
        String[] args = event.getArgs().split(" ");
        if (event.getArgs().isEmpty()){
            event.replyError("You must supply a user and a reason!");
            return;
        }

        if (args.length == 1){
            event.replyError("You must supply a reason!");
            return;
        }

        try{event.getGuild().getMemberById(args[0].replaceAll("<@", "").replaceAll(">", "").replaceAll("!", ""));} catch (NumberFormatException e) {
            event.replyError("Invalid User!");
            return;
        }

        Member member = event.getGuild().getMemberById(args[0].replaceAll("<@", "").replaceAll(">", "").replaceAll("!", ""));

        if (member.hasPermission(Permission.KICK_MEMBERS)){
            event.replyError("You cannot warn another staff member!");
            return;
        }


        Array.set(args, 0, "");
        String reason = String.join(" ", args);
        Guild server = event.getGuild();
        TextChannel staffLogs = server.getTextChannelById("322915404043517952");

        event.reply(warnUser(member, reason).setFooter("Warned by " + event.getAuthor().getName() + "#" + event.getAuthor().getDiscriminator(), event.getAuthor().getAvatarUrl()).build());
        staffLogs.sendMessage((warnUser(member, reason).setFooter("Warned by " + event.getAuthor().getName() + "#" + event.getAuthor().getDiscriminator(), event.getAuthor().getAvatarUrl()).build())).queue();
    }

    public EmbedBuilder warnUser(Member warnid, String reason) {
        EmbedBuilder userWarnMessage = new EmbedBuilder();
        userWarnMessage
                .setTitle("User Warned!")
                .setThumbnail(warnid.getUser().getAvatarUrl())
                .setColor(Color.yellow)
                .getDescriptionBuilder()
                .append("Warned user: " + warnid.getAsMention() + " (" + warnid.getUser().getId() + ")\nReason:" + reason + "");
        return userWarnMessage;
    }
}
