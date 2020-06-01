package DiscordBot.events;

import ch.jamiete.mcping.MinecraftPing;
import ch.jamiete.mcping.MinecraftPingOptions;
import ch.jamiete.mcping.MinecraftPingReply;
import net.dv8tion.jda.api.entities.Guild;

import java.io.IOException;
import java.util.TimerTask;

import static DiscordBot.main.jda;

public class NetworkCounter extends TimerTask {
    /**
     * The action to be performed by this timer task.
     */
    @Override
    public void run() {
        MinecraftPingReply pokedash;
        MinecraftPingReply pokeverse;
        MinecraftPingReply pokelegends;
        MinecraftPingReply pokeclub;
        MinecraftPingReply pokebrawl;

        int total = 0;
        try {
                pokedash = new MinecraftPing().getPing(new MinecraftPingOptions().setHostname("play.pokedash.org").setPort(25565));
                total = total + pokedash.getPlayers().getOnline();


                pokeverse = new MinecraftPing().getPing(new MinecraftPingOptions().setHostname("play.pokeverse.org").setPort(25565));
                total = total + pokeverse.getPlayers().getOnline();


                pokelegends = new MinecraftPing().getPing(new MinecraftPingOptions().setHostname("play.pokelegends.net").setPort(25565));
                total = total + pokelegends.getPlayers().getOnline();


                pokeclub = new MinecraftPing().getPing(new MinecraftPingOptions().setHostname("play.pokeclub.net").setPort(25565));
                total = total + pokeclub.getPlayers().getOnline();


                pokebrawl = new MinecraftPing().getPing(new MinecraftPingOptions().setHostname("play.poke-brawl.com").setPort(25565));
                total = total + pokebrawl.getPlayers().getOnline();
        } catch (IOException e){
            e.printStackTrace();
        }

        Guild guild = jda.getGuildsByName("pixelmon+", true).get(0);
        guild.getVoiceChannelById("622957862184026122").getManager().setName("Players Online: " + total).queue();
    }
}
