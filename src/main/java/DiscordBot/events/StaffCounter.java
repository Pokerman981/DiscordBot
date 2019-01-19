package DiscordBot.events;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;

import java.util.List;
import java.util.TimerTask;
import static DiscordBot.main.jda;
public class StaffCounter extends TimerTask {

    public void run() {
        Guild guild = jda.getGuildsByName("pixelmon+", true).get(0);
        Role role = guild.getRolesByName("staff", true).get(0);

        List<Member> staffList = guild.getMembersWithRoles(role);
        int count = 0;


        for (Member staff : staffList) {
            //if (staff.getOnlineStatus().getKey() != "offline")
                count++;

        }

        guild.getVoiceChannelById("535503921322524673").getManager().setName("Staff Count: " + count).queue();



    }
}
