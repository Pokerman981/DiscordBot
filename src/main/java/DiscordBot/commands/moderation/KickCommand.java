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

public class KickCommand extends Command {

    public KickCommand() {
        this.name = "kick";
        this.aliases = new String[] { "k" };
        this.guildOnly = true;
        this.help = "Kick a specified user";
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

        try {
            String userID = args[0].replaceAll("<@", "").replaceAll(">", "").replaceAll("!", "");
            String reason = String.join(" ", args);
            Array.set(args, 0, "");

            Member resolvedMember = event.getGuild().retrieveMemberById(userID).complete();
            Role resolvedRole = event.getGuild().getRoleById(main.staffRankID);

            if (resolvedMember.getRoles().contains(resolvedRole) || resolvedMember.hasPermission(Permission.KICK_MEMBERS)) {
                event.replyError("You cannot kick another staff member!");
                return;
            }

            Guild server = event.getGuild();

            event.getGuild().kick(resolvedMember, reason).queue();
            event.reply(kickUser(resolvedMember.getUser(), reason).setFooter("Kicked by " + event.getAuthor().getName() + "#" + event.getAuthor().getDiscriminator(), event.getAuthor().getAvatarUrl()).build());

            TextChannel staffLogs = server.getTextChannelById("322915404043517952");
            staffLogs.sendMessage((kickUser(resolvedMember.getUser(), reason)
                    .setFooter("Kicked by " + event.getAuthor().getName() + "#" + event.getAuthor().getDiscriminator(), event.getAuthor().getAvatarUrl())
                    .build()))
                    .queue();
        } catch (ErrorResponseException e) {
            event.replyError("User not found in guild! Cannot kick!");
        } catch (NumberFormatException e) {
            event.replyError("Cannot find user id!");
        }
    }

    public EmbedBuilder kickUser(User user, String reason) {
        EmbedBuilder userKickMessage = new EmbedBuilder();
        userKickMessage
                .setTitle("User Kicked!")
                .setColor(Color.red)
                .setThumbnail(user.getAvatarUrl())
                .getDescriptionBuilder()
                .append("Kicked user: " + user.getAsMention() + " (" + user.getId() + ")\nReason:" + reason + "");
        return userKickMessage;
    }

}