package DiscordBot.events;


import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;

import java.util.TimerTask;

import static DiscordBot.main.jda;
public class StaffCounter extends TimerTask {

    public void run() {
        Guild guild = jda.getGuildById("258797004757532672");
        Role role = guild.getRoleById("322569890093465620");

        guild.retrieveMembers().thenRunAsync(() -> {

            int staffListSize = guild.getMembersWithRoles(role).size();
            guild.getVoiceChannelById("535503921322524673").getManager().setName("Staff Count: " + staffListSize).queue();
        });

    }
}
