package DiscordBot;

import net.dv8tion.jda.core.EmbedBuilder;

import java.awt.*;

public class Embeds {

    public static EmbedBuilder onServerStatusEmbed() {
        EmbedBuilder eb = new EmbedBuilder().setTitle("**Pixelmon+ Server Stats**\n").setColor(Color.decode("#19750b"));
        return eb;
    }

    public static EmbedBuilder onUnsupportedTypes() {
        EmbedBuilder error = new EmbedBuilder();
        error.setColor(Color.RED).setTitle(":x: **Unsupported Argument!**").getDescriptionBuilder().append(
                "This argument is not supported for this command!");
        return error;
    }

    public static EmbedBuilder reforgedInstallInfo() {
        EmbedBuilder reforgedInstallInfo = new EmbedBuilder();

        reforgedInstallInfo.setColor(Color.green).getDescriptionBuilder().append(
                "This tutorial will explain how to download & install the **Pixelmon+ Modpack**\n" +
                " \n" +
                "**1)** Download the Technic Launcher at https://technicpack.net/download\n" +
                "**2)** Open the launcher\n" +
                "**3)** Click \"Modpacks\" on the top of the launcher\n" +
                "**4)** Paste \"http://api.technicpack.net/modpack/ultimate-reallife-roleplay\" (without the quotes) into the \"Search\" box\n" +
                "**5)** Click \"Install\" on the bottom right of the launcher\n" +
                "**6)** Wait for the download to finish and join the server!");

        return reforgedInstallInfo;
    }

    public static EmbedBuilder supplyServer() {
        EmbedBuilder supplyServer = new EmbedBuilder();
        supplyServer.setColor(Color.red).getDescriptionBuilder().append(
                "Please supply a server"
        );
        return supplyServer;
    }

    public static EmbedBuilder IPPD() {
        EmbedBuilder pokedash = new EmbedBuilder();
        pokedash.setTitle("Pokedash Info").setColor(Color.decode("#3cb0d6"))
                .setThumbnail("https://i.gyazo.com/13255ea852d4551df36e9c1c9c3d4e92.png").getDescriptionBuilder()
                .append("**IP:**\tplay.pokedash.org\n**Version:**\t 1.12.2");
        return pokedash;
    }

    public static EmbedBuilder IPPV() {
        EmbedBuilder pokeverse = new EmbedBuilder();
        pokeverse.setTitle("Pokeverse Info").setColor(Color.yellow)
                .setThumbnail("https://i.gyazo.com/911b1ee65ef59f36343d5bc5da046d12.png").getDescriptionBuilder()
                .append("**IP:**\tplay.pokeverse.org\n**Version:**\t 1.12.2");
        return pokeverse;
    }

    public static EmbedBuilder IPPC() {
        EmbedBuilder pokeclub = new EmbedBuilder();
        pokeclub.setTitle("Pokeclub Info").setColor(Color.decode("#1e7d72"))
                .setThumbnail("https://i.gyazo.com/21380d908820fc0c78e95a813e66b5cd.png").getDescriptionBuilder()
                .append("**IP:**\tplay.pokeclub.net\n**Version:**\t 1.12.2");
        return pokeclub;
    }
    public static EmbedBuilder IPPL() {
        EmbedBuilder pokelegends = new EmbedBuilder();
        pokelegends.setTitle("Pokelegends Info").setColor(Color.decode("#FF4500"))
                .setThumbnail("https://i.gyazo.com/b79efa7c89576238c00ba4ceb503e055.png").getDescriptionBuilder()
                .append("**IP:**\tplay.pokelegends.net\n**Version:**\t 1.12.2");
        return pokelegends;
    }

    public static EmbedBuilder IPPB() {
        EmbedBuilder pokelegends = new EmbedBuilder();
        pokelegends.setTitle("Pokebrawl Info").setColor(Color.decode("#8573d1"))
                .setThumbnail("https://i.gyazo.com/2a48c980b14bebf92f9e22c18b0e4b56.png").getDescriptionBuilder()
                .append("**IP:**\tplay.poke-brawl.com\n**Version:**\t 1.12.2");
        return pokelegends;
    }

    public EmbedBuilder onUnsupported() {
        EmbedBuilder error = new EmbedBuilder();
        error.setColor(Color.RED).setTitle(":x: **Unsupported server!**").getDescriptionBuilder().append(
                "This server is not supported for this command!\nIf you believe this to be an error contact pokerman99#5742");
        return error;
    }

    public static EmbedBuilder noArgsIP() {
        EmbedBuilder noArgs = new EmbedBuilder();
        noArgs.setTitle("Server IPs").setColor(Color.red).getDescriptionBuilder()
                .append("**.ip (server name)**\n\n**Servers:**\n\t*pokedash*\n\t*pokeverse*\n\t*pokelegends*\n\t*pokeclub*\n\t*pokebrawl*");
        return noArgs;
    }
}