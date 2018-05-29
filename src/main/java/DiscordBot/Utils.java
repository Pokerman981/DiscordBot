package DiscordBot;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;

public class Utils {

	// Sendes message with expriy
	public static void MessageChannelWithDelete(String message, int timer, TextChannel channel) throws InterruptedException, ExecutionException {
		channel.sendMessage(message).submit().get().delete().queueAfter(timer, TimeUnit.SECONDS);
	}

	// Sends message to channel
	public static void MessageChannel(String message, TextChannel channel) {
		channel.sendMessage(message).queue();
	}
	
	// Delete the users message
	public static void DeleteUserMessageWithDelay(Message msg, int timer){
		msg.delete().queueAfter(timer, TimeUnit.SECONDS);
	}

	public static Boolean isStaff(CommandEvent event){
		Member member = event.getMember();
		
		if (member.hasPermission(Permission.BAN_MEMBERS)){
			return true;
		}
		return false;
	}

	public static boolean CheckRequirements(CommandEvent event){
		String[] cmd = event.getArgs().split(" ");
		if (event.getArgs().isEmpty()) {
			event.replyError("You must supply an argument!");
			return false;
		}

		if (cmd.length > 1) {
		    event.replyError("You have supplied to many arguments!");
		    return false;
        }

        try {
		    String args = event.getArgs().replace("<@", "").replaceAll(">", "");
            event.getGuild().getMemberById(args);
            return true;
        } catch (NumberFormatException e) {
		    System.out.println("t");
		    event.replyError("Invalid User!");
		    return false;
        }
	}

	public static Member getMember(CommandEvent event){
        try {
            String args = event.getArgs().replace("<@", "").replaceAll(">", "");
            event.getGuild().getMemberById(args);
            return event.getGuild().getMemberById(args);
        } catch (NumberFormatException e) {
            System.out.println("t");
            event.replyError("Invalid User!");
            return null;
        }
    }
	
}
