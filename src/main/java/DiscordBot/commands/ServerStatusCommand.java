package DiscordBot.commands;

import DiscordBot.Embeds;
import DiscordBot.main;
import ch.jamiete.mcping.MinecraftPing;
import ch.jamiete.mcping.MinecraftPingOptions;
import ch.jamiete.mcping.MinecraftPingReply;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.ServerConnectRequest;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class ServerStatusCommand extends Command {

    public ServerStatusCommand() {
        this.name = "status";
        this.help = "Displays the status of each server";
        this.guildOnly = false;
        this.category = main.roleCategories.get("player");
    }

    @Override
    protected void execute(CommandEvent event) {
        MinecraftPingReply totalPing;

        EmbedBuilder eb = Embeds.onServerStatusEmbed();

        try {
            String id = event.getChannel().sendMessage("Getting server status... " + event.getAuthor().getAsMention()).submit().get().getId();


            totalPing = new MinecraftPing().getPing(new MinecraftPingOptions().setHostname("play.pokezone.net"));
            eb.getDescriptionBuilder().append("\n<:pokezoneblue:722273150250909706> **PokeZone Total**\n \t\t**"
                    + totalPing.getPlayers().getOnline() + "** players online!\n");

            event.getChannel().editMessageById(id, eb.build()).queue();

        } catch (InterruptedException | ExecutionException | IOException e) {
            e.printStackTrace();
            eb.getDescriptionBuilder().append("\n<:pokezoneblue:722273150250909706> **PokeZone Total**\n \t\tCould not catch player count, check console.");
        }

    }
}
