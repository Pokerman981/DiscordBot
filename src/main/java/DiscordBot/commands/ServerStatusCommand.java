//package DiscordBot.commands;
//
//import DiscordBot.Embeds;
//import DiscordBot.main;
//import ch.jamiete.mcping.MinecraftPing;
//import ch.jamiete.mcping.MinecraftPingOptions;
//import ch.jamiete.mcping.MinecraftPingReply;
//import com.jagrosh.jdautilities.command.Command;
//import com.jagrosh.jdautilities.command.CommandEvent;
//import net.dv8tion.jda.api.EmbedBuilder;
//import net.md_5.bungee.api.ProxyServer;
//import net.md_5.bungee.api.ServerConnectRequest;
//import net.md_5.bungee.api.ServerPing;
//import net.md_5.bungee.api.config.ServerInfo;
//import net.md_5.bungee.api.connection.ProxiedPlayer;
//import net.md_5.bungee.api.connection.Server;
//
//import java.io.IOException;
//import java.net.InetSocketAddress;
//import java.net.SocketException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.ExecutionException;
//
//public class ServerStatusCommand extends Command {
//
//    public ServerStatusCommand() {
//        this.name = "status";
//        this.help = "Displays the status of each server";
//        this.guildOnly = false;
//        this.category = main.roleCategories.get("player");
//    }
//
//    @Override
//    protected void execute(CommandEvent event) {
//        MinecraftPingReply totalPing;
//        ServerInfo dashInfo = ProxyServer.getInstance().getServerInfo("pokedash");
//        ServerInfo verseInfo = ProxyServer.getInstance().getServerInfo("pokeverse");
//        ServerInfo legendsInfo = ProxyServer.getInstance().getServerInfo("pokelegends");
//        ServerInfo clubInfo = ProxyServer.getInstance().getServerInfo("pokeclub");
//        ServerInfo brawlInfo = ProxyServer.getInstance().getServerInfo("pokebrawl");
//        ServerInfo silverInfo = ProxyServer.getInstance().getServerInfo("pokesilver");
//        ServerInfo goldInfo = ProxyServer.getInstance().getServerInfo("pokegold");
//
//        HashMap<String, ServerInfo> serverMap = new HashMap<>();
//        EmbedBuilder eb = Embeds.onServerStatusEmbed();
//
//        try {
//            String id = event.getChannel().sendMessage("Getting server status... " + event.getAuthor().getAsMention()).submit().get().getId();
//
//            for (ServerInfo server : serverMap.values()) {
//                try {
//                    if (server.equals(dashInfo)) {
//                        int count = server.getPlayers().size();
//                        eb.getDescriptionBuilder().append("\n<:pokedash:725057210526335127> **PokeDash**\n \t\t**"
//                                + count + "** players online!\n");
//                    }
//                } catch (NullPointerException e) {
//                    eb.getDescriptionBuilder().append("\n:x: **PokeDash**\n \t\t**"
//                            + "Server Offline!**\n");
//                    e.printStackTrace();
//                }
//
//                try {
//                    if (server.equals(verseInfo)) {
//                        int count = server.getPlayers().size();
//                        eb.getDescriptionBuilder().append("\n<:pokeverse:714032214245113907> **Pokeverse**\n \t\t**"
//                                + count + "** players online!\n");
//                    }
//                } catch (NullPointerException e) {
//                    eb.getDescriptionBuilder().append("\n:x: **Pokeverse**\n \t\t**"
//                            + "Server Offline!**\n");
//                    e.printStackTrace();
//                }
//
//                try {
//                    if (server.equals(legendsInfo)) {
//                        int count = server.getPlayers().size();
//                        eb.getDescriptionBuilder().append("\n<:pokelegends:722273123172614166> **PokeLegends**\n \t\t**"
//                                + count + "** players online!\n");
//                    }
//                } catch (NullPointerException e) {
//                    eb.getDescriptionBuilder().append("\n:x: **Pokeverse**\n \t\t**"
//                            + "Server Offline!**\n");
//                    e.printStackTrace();
//                }
//
//                try {
//                    if (server.equals(clubInfo)) {
//                        int count = server.getPlayers().size();
//                        eb.getDescriptionBuilder().append("\n<:pokeclub:725057231971942490> **PokeClub**\n \t\t**"
//                                + count + "** players online!\n");
//                    }
//
//                } catch (NullPointerException e) {
//                    eb.getDescriptionBuilder().append("\n:x: **PokeClub**\n \t\t**"
//                            + "Server Offline!**\n");
//                    e.printStackTrace();
//                }
//
//                try {
//                    if (server.equals(brawlInfo)) {
//                        int count = server.getPlayers().size();
//                        eb.getDescriptionBuilder().append("\n<:pokebrawl:722273098744987740> **PokeBrawl**\n \t\t**"
//                                + count + "** players online!\n");
//                    }
//
//                } catch (NullPointerException e) {
//                    eb.getDescriptionBuilder().append("\n:x: **PokeBrawl**\n \t\t**"
//                            + "Server Offline!**\n");
//                    e.printStackTrace();
//                }
//
//                try {
//                    if (server.equals(silverInfo)) {
//                        int count = server.getPlayers().size();
//                        eb.getDescriptionBuilder().append("\n<:pokezoneblue:722273150250909706> **PokeSilver**\n \t\t**"
//                                + count + "** players online!\n");
//                    }
//
//                } catch (NullPointerException e) {
//                    eb.getDescriptionBuilder().append("\n:x: **PokeSilver**\n \t\t**"
//                            + "Server Offline!**\n");
//                    e.printStackTrace();
//                }
//
//                try {
//                    if (server.equals(goldInfo)) {
//                        int count = server.getPlayers().size();
//                        eb.getDescriptionBuilder().append("\n<:pokezonered:722458281536258060> **PokeGold**\n \t\t**"
//                                + count + "** players online!\n");
//                    }
//
//                } catch (NullPointerException e) {
//                    eb.getDescriptionBuilder().append("\n:x: **PokeGold**\n \t\t**"
//                            + "Server Offline!**\n");
//                    e.printStackTrace();
//                }
//            }
//
//
//            totalPing = new MinecraftPing().getPing(new MinecraftPingOptions().setHostname("play.pokezone.net"));
//            eb.getDescriptionBuilder().append("\n<:pokezoneblue:722273150250909706> **PokeZone Total**\n \t\t**"
//                    + totalPing.getPlayers().getOnline() + "** players online!\n");
//
//            event.getChannel().editMessageById(id, eb.build()).queue();
//
//            eb.getDescriptionBuilder().append("\n<:pokezoneblue:722273150250909706> **PokeZone Total**\n \t\tCould not catch player count, check console.");
//        } catch (InterruptedException | ExecutionException | IOException e) {
//                e.printStackTrace();
//            }
//
//    }
//}
