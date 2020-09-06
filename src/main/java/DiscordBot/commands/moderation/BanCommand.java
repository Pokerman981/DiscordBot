package DiscordBot.commands.moderation;

import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.exceptions.ErrorResponseException;

import java.awt.*;
import java.lang.reflect.Array;

public class BanCommand extends Command {

    public BanCommand() {
        this.name = "ban";
        this.aliases = new String[] { "b", "begonethot", "byebye" };
        this.guildOnly = true;
        this.help = "Ban a specified user";
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

        long userID;
        try {
            userID = Long.parseLong(args[0].replaceAll("<@", "").replaceAll(">", "").replaceAll("!", ""));
        } catch (NumberFormatException e) {
            event.replyError("Could not find discord id!");
            return;
        }

        Array.set(args, 0, "");
        String reason = String.join(" ", args);

        User resolvedUser = event.getJDA().retrieveUserById(userID).complete();
        Member resolvedMember;
        Role resolvedRole;
        try {
            resolvedMember = event.getGuild().retrieveMember(resolvedUser).complete();
            resolvedRole = event.getGuild().getRoleById(main.staffRankID);
            if (resolvedMember.getRoles().contains(resolvedRole) || resolvedMember.hasPermission(Permission.BAN_MEMBERS)) {
                event.replyError("You cannot ban another staff member!");
                return;
            }
        } catch (ErrorResponseException e) {
            event.replyWarning("User not found in guild! Attempting to ban..");
        }

        Guild server = event.getGuild();

        event.getGuild().ban(resolvedUser,  7).queue();
        event.reply(banUser(resolvedUser, reason).setFooter("Banned by " + event.getAuthor().getName() + "#" + event.getAuthor().getDiscriminator(), event.getAuthor().getAvatarUrl()).build());

        TextChannel staffLogs = server.getTextChannelById("322915404043517952");
        staffLogs
                .sendMessage((banUser(resolvedUser, reason)
                .setFooter("Banned by " + event.getAuthor().getName() + "#" + event.getAuthor().getDiscriminator(), event.getAuthor().getAvatarUrl())
                .build()))
                .queue();
    }

    public EmbedBuilder banUser(User banid, String reason) {
        EmbedBuilder userBanMessage = new EmbedBuilder();
        userBanMessage
                .setTitle("User Banned!")
                .setThumbnail(banid.getAvatarUrl())
                .setColor(Color.red)
                .getDescriptionBuilder()
                    .append("Banned user: " + banid.getAsMention() + " (" + banid.getName() + "#" + banid.getDiscriminator() + ")\nReason:" + reason + "");
        return userBanMessage;
    }

}