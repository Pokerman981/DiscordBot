package DiscordBot.commands;

import DiscordBot.Embeds;
import DiscordBot.main;
import ch.jamiete.mcping.MinecraftPing;
import ch.jamiete.mcping.MinecraftPingOptions;
import ch.jamiete.mcping.MinecraftPingReply;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ServerStatusCommand extends Command {

    public ServerStatusCommand(){
        this.name = "status";
        this.help = "Check the status of the servers & how many people are online";
        this.guildOnly = false;
        this.category = main.NORMAL;
    }

    @Override
    protected void execute(CommandEvent event) {
        //make it so the bot doesn't post in the server chats
        if (event.getGuild().getCategoriesByName("server chats", true).get(0).getChannels().toString().contains(event.getChannel().getId())) return;
        //if (event.getGuild().getCategoriesByName("staff", true).get(0).getChannels().toString().contains(event.getChannel().getId())) return;


       /* try {
            event.getChannel().sendMessage("Getting server status... " + event.getAuthor().getAsMention())
                    .submit().get().delete().queueAfter(1, TimeUnit.SECONDS);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }*/
        MinecraftPingReply pokedash;
        MinecraftPingReply pokeverse;
        MinecraftPingReply pokelegends;
        MinecraftPingReply pokeclub;
        int total = 0;
        EmbedBuilder eb = Embeds.onServerStatusEmbed();

        try {
            String id = event.getChannel().sendMessage("Getting server status... " + event.getAuthor().getAsMention()).submit().get().getId();

        try {
            pokedash = new MinecraftPing().getPing(new MinecraftPingOptions().setHostname("play.pokedash.org").setPort(25565));
            eb.getDescriptionBuilder().append("\n<:pokedash:375433829764169741> **PokeDash**\n \t\t**"
                    + pokedash.getPlayers().getOnline() + "** players online!\n");
            total = total + pokedash.getPlayers().getOnline();
        } catch (IOException e) {
            eb.getDescriptionBuilder().append("\n:x: **Pokedash**\n \t\t**"
                    + "Server Offline!**\n");
        }
        try {
            pokeverse = new MinecraftPing().getPing(new MinecraftPingOptions().setHostname("play.pokeverse.org").setPort(25565));
            eb.getDescriptionBuilder().append("\n<:pokeverse:526264631744790549> **Pokeverse**\n \t\t**"
                    + pokeverse.getPlayers().getOnline() + "** players online!\n");
            total = total + pokeverse.getPlayers().getOnline();
        } catch (IOException e) {
            eb.getDescriptionBuilder().append("\n:x: **Pokeverse**\n \t\t**"
                    + "Server Offline!**\n");
        }
        try {
            pokelegends = new MinecraftPing().getPing(new MinecraftPingOptions().setHostname("play.pokelegends.net").setPort(25565));
            eb.getDescriptionBuilder().append("\n<:pokelegends:375434322339168256> **PokeLegends**\n \t\t**"
                    + pokelegends.getPlayers().getOnline() + "** players online!\n");
            total = total + pokelegends.getPlayers().getOnline();
        } catch (IOException e) {
            eb.getDescriptionBuilder().append("\n:x: **PokeLegends**\n \t\t**"
                    + "Server Offline!**\n");
        }
        try {
            pokeclub = new MinecraftPing().getPing(new MinecraftPingOptions().setHostname("play.pokeclub.net").setPort(25565));
            eb.getDescriptionBuilder().append("\n<:pokeclub:526264234716299284> **PokeClub**\n \t\t**"
                    + pokeclub.getPlayers().getOnline() + "** players online!\n");
            total = total + pokeclub.getPlayers().getOnline();
        } catch (IOException e) {
            eb.getDescriptionBuilder().append("\n:x: **PokeClub**\n \t\t**"
                    + "Server Offline!**\n");
        }
        eb.getDescriptionBuilder().append("\n<:pixelmon:375785337412386828> **Pixelmon+ Total**\n \t\t**"
                + total + "** players online!\n");

            event.getChannel().editMessageById(id, eb.build()).queue();

        } catch (ExecutionException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
