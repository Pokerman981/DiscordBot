package DiscordBot.commands.moderation;

import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;

import java.awt.*;
import java.lang.reflect.Array;

public class kickCommand extends Command {

    public kickCommand() {
        this.name = "kick";
        this.aliases = new String[]{"k"};
        this.guildOnly = true;
        this.userPermissions = new Permission[] {Permission.KICK_MEMBERS};
        this.help = "Kick a specified user";
        this.category = main.STAFF;
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
        if (member.hasPermission(Permission.BAN_MEMBERS)){
            event.replyError("You cannot kick another staff member!");
            return;
        }


        Array.set(args, 0, "");
        String reason = String.join(" ", args);

        event.reply(kickUser(member, reason).setFooter("Kicked by " + event.getAuthor().getName() + "#" + event.getAuthor().getDiscriminator(), event.getAuthor().getAvatarUrl()).build());
        event.getGuild().getController().kick(member).reason(reason + " - kicked by " + event.getAuthor().getName() + "#" + event.getAuthor().getDiscriminator() + " (" + event.getAuthor().getId() + ")").queue();

    }















































    public EmbedBuilder kickUser(Member user, String reason) {
        EmbedBuilder userKickMessage = new EmbedBuilder();
        userKickMessage
                .setTitle("User Kicked!")
                .setColor(Color.red)
                .setThumbnail(user.getUser().getAvatarUrl())
                .getDescriptionBuilder()
                .append("Kicked user: " + user.getAsMention() + " (" + user.getUser().getId() + ")\nReason:" + reason + "");
        return userKickMessage;

    }

}