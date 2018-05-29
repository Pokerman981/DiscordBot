package DiscordBot.commands.moderation;

import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;

import java.awt.*;
import java.lang.reflect.Array;

public class BanCommand extends Command {

    public BanCommand(){
        this.name = "ban";
        this.aliases = new String[] {"b","begonethot"};
        this.guildOnly = true;
        this.userPermissions = new Permission[]{Permission.BAN_MEMBERS};
        this.help = "Ban a specified user";
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
            event.replyError("You cannot ban another staff member!");
            return;
        }


        Array.set(args, 0, "");
        String reason = String.join(" ", args);

        event.reply(banUser(member, reason).setFooter("Banned by " + event.getAuthor().getName() + "#" + event.getAuthor().getDiscriminator(), event.getAuthor().getAvatarUrl()).build());
        event.getGuild().getController().ban(member, 7).reason(reason + " - banned by " + event.getAuthor().getName() + "#" + event.getAuthor().getDiscriminator() + " (" + event.getAuthor().getId() + ")").queue();

    }















































    public EmbedBuilder banUser(Member banid, String reason) {
        EmbedBuilder userBanMessage = new EmbedBuilder();
        userBanMessage
                .setTitle("User Banned!")
                .setThumbnail(banid.getUser().getAvatarUrl())
                .setColor(Color.red)
                .getDescriptionBuilder()
                    .append("Banned user: " + banid.getAsMention() + " (" + banid.getUser().getId() + ")\nReason:" + reason + "");
        return userBanMessage;

    }
}
