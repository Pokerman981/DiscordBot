package DiscordBot.commands.moderation;

import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MuteCommand extends Command {

    int counter = 0;

    public MuteCommand() {
        this.name = "mute";
        this.aliases = new String[]{"m"};
        this.guildOnly = true;
        this.userPermissions = new Permission[] {Permission.KICK_MEMBERS};
        this.help = "Mute a specified user";
        this.category = main.STAFF;
    }

    @Override
    protected void execute(CommandEvent event) {

        String[] args = event.getArgs().split(" ");
        if (event.getArgs().isEmpty()){
            event.replyError("You must supply a user, a time and a reason!");
            return;
        }

        if (args.length == 1){
            event.replyError("You must supply a time and a reason!");
            return;
        }

        if (args.length == 2) {
            event.replyError("You must supply a reason!");
        }

        try{event.getGuild().getMemberById(args[0].replaceAll("<@", "").replaceAll(">", "").replaceAll("!", ""));} catch (NumberFormatException e) {
            event.replyError("Invalid User!");
            return;
        }

        Member member = event.getGuild().getMemberById(args[0].replaceAll("<@", "").replaceAll(">", "").replaceAll("!", ""));
        if (member.hasPermission(Permission.KICK_MEMBERS)){
            event.replyError("You cannot mute another staff member!");
            return;
        }

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                counter ++;
                if (counter == 2);
                    event.getGuild().getController().removeRolesFromMember(member, event.getGuild().getRoleById("707675201181057084")).queue();
            }
        };

        long time1 = timeAmount(args[1]);
        switch (timeUnit(args[1])) {
            case DAYS : time1*=24;
            case HOURS : time1*=60;
            case MINUTES : time1*=60;
            case SECONDS : time1*=1000;
        }
        timer.schedule(task, 0, time1);



        Array.set(args, 0, "");
        String reason = Arrays.toString(Arrays.copyOfRange(args, 2, args.length)).replaceAll(",","");
        String time = (args[1]);
        event.reply(muteUser(member, time, reason).setFooter("Muted by " + event.getAuthor().getName() + "#" + event.getAuthor().getDiscriminator(), event.getAuthor().getAvatarUrl()).build());
        event.getGuild().getController().addRolesToMember(member, event.getGuild().getRoleById("707675201181057084")).queue();
    }

    public EmbedBuilder muteUser(Member user, String time, String reason) {
        EmbedBuilder userMuteMessage = new EmbedBuilder();
        userMuteMessage
                .setTitle("User Muted!")
                .setColor(Color.red)
                .setThumbnail(user.getUser().getAvatarUrl())
                .getDescriptionBuilder()
                .append("Muted user: " + user.getAsMention() + " (" + user.getUser().getId() + ")\nMute time: " + time + "\nReason: " + reason);
        return userMuteMessage;

    }

    private int timeAmount(String time) {
        TimeUnit unit = TimeUnit.SECONDS;
        char[] t = time.toCharArray();
        int breakPoint = 0;
        String amount = "";
        int parsedAmount = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] == 's' || t[i] == 'S') {
                unit = TimeUnit.SECONDS;
                breakPoint = i;
                break;
            }	else if (t[i] == 'm' || t[i] == 'M') {
                unit = TimeUnit.MINUTES;
                breakPoint = i;
                break;
            }	else if (t[i] == 'h' || t[i] == 'H') {
                unit = TimeUnit.HOURS;
                breakPoint = i;
                break;
            }	else if (t[i] == 'd' || t[i] == 'D') {
                unit = TimeUnit.DAYS;
                breakPoint = i;
                break;
            }
        }

        for (int i = 0; i < breakPoint; i++) {
            amount += t[i];
        }
        parsedAmount = Integer.parseInt(amount);
        return parsedAmount;
    }

    private TimeUnit timeUnit(String time) {
        TimeUnit unit = TimeUnit.SECONDS;
        char[] t = time.toCharArray();
        String amount = "";
        int parsedAmount = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] == 's' || t[i] == 'S') {
                unit = TimeUnit.SECONDS;
                break;
            }	else if (t[i] == 'm' || t[i] == 'M') {
                unit = TimeUnit.MINUTES;
                break;
            }	else if (t[i] == 'h' || t[i] == 'H') {
                unit = TimeUnit.HOURS;
                break;
            }	else if (t[i] == 'd' || t[i] == 'D') {
                unit = TimeUnit.DAYS;
                break;
            }
        }
        return unit;
    }
}
