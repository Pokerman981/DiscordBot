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

    public static EmbedBuilder ramInfo() {
        EmbedBuilder ramInfo = new EmbedBuilder();

        ramInfo.setColor(Color.green).getDescriptionBuilder().append(
                "This tutorial will explain how to allocate more ram on **Technic** & **Forge** versions\n" +
                        " \n" +
                        "**Note:** Make sure you're Java is updated to the most recent version & that you're running 64-bit Java to do so follow these steps\n" +
                        "**1)** Go to this link: https://www.java.com/en/download/manual.jsp\n" +
        "**2)** Download the appropriate link for your computer (3rd link for Windows, only link for Mac)\n" +
                "**3)** Restart your PC\n" +
                "**4)** Refer to the following steps\n" +
                " \n" +
                "**On Technic**\n" +
                "**1)** Open the Technic launcher\n" +
                "**2)** Click on the Launcher Settings button in the top right (Under the cross)\n" +
                "**3)** Click on the second tab that says 'Java Settings'\n" +
                "**4)** Click on 'Memory' and make sure that you allocate at least 2GB (2GB-3GB is recommended)\n" +
                " \n" +
                "**On Forge**\n" +
                "**1)** Click on 'Installations' at the top of the launcher\n" +
                "**2)** Select your correct forge profile\n" +
                "**3)** Click on 'more options'\n" +
                "**4)** Under 'JVM Arguments' fine the part that says '-Xmx(Number)G' near the beginning of all the arguments\n" +
                "**5)** Change the '(Number)' to how many gigabytes of ram you want to use (Note: If you see 'M' instead of 'G' you'll have to set the number in megabytes instead, 1000M = 1GB)\n" +
                "**6)** Click on 'Save'");

        return ramInfo;
    }

    public static EmbedBuilder logInfo() {
        EmbedBuilder logInfo = new EmbedBuilder();

        logInfo.setColor(Color.green).getDescriptionBuilder().append(
                "This tutorial will explain how to access logs on **Technic** & **Forge** versions\n" +
                        " \n" +
                        "**On Technic**\n" +
                        "**1)** Press Win + R\n" +
                        "**2)** Type in %appdata%\n" +
                        "**3)** Go to .technic/modpacks/ultimate-reallife-roleplay/logs\n" +
                        "**4)** Find your log file (Should be titled like YYYY-MM-DD) (Note: Your lastest.log file will be the log for your latest connection)\n" +
                        "**5)** Press CTRL + F and search for the item/pokemon/msg you are looking for (e.g Lugia)\n" +
                        "**6)** Message any SeniorMod+ on your server to get your items back!\n" +
                        " \n" +
                        "**On Forge**\n" +
                        "**1)** Press Win + R\n" +
                        "**2)** Type in %appdata%\n" +
                        "**3)** Go to .minecraft/logs\n" +
                        "**4)** Find your log file (Should be titled like YYYY-MM-DD) (Note: Your lastest.log file will be the log for your latest connection)\n" +
                        "**5)** Press CTRL + F and search for the item/pokemon/msg you are looking for (e.g Lugia)\n" +
                        "**6)** Message any SeniorMod+ on your server to get your items back!");

        return logInfo;
    }

    public static EmbedBuilder appealInfo() {
        EmbedBuilder appealInfo = new EmbedBuilder();

        appealInfo.setColor(Color.green).getDescriptionBuilder().append(
                "This tutorial will explain how to appeal your punishments given on the server(s)\n" +
                "(Note: Pinging/Bothering staff about your appeal will **NOT** reduce the wait time)\n" +
                        " \n" +
                        "<:pokedash:375433829764169741> **PokeDash**\n" +
                        "**1)** Click the following link: https://www.pokedash.org/appeal\n" +
                        "**2)** Fill out the form & wait for staff to reply\n" +
                        " \n" +
                        "<:pokeverse:714032214245113907> **Pokeverse**\n" +
                        "**1)** Read the Appeal format link before appealing: https://pxl.plus/pvappealform\n" +
                        "**2)** Click the following link: https://www.pokeverse.org/appeal\n" +
                        "**3)** Fill out the form & wait for staff to reply\n" +
                        " \n" +
                        "<:pokelegends:628381164939247636> **PokeLegends**\n" +
                        "**1)** Click the following link: https://www.pokelegends.net/appeal\n" +
                        "**2)** Fill out the form & wait for staff to reply\n" +
                        " \n" +
                        "<:pokeclub:526264234716299284> **PokeClub**\n" +
                        "**1)** Click the following link: https://www.pokeclub.net/appeal\n" +
                        "**2)** Fill out the form & wait for staff to reply\n" +
                        " \n" +
                        "<:pokebrawl:707662953926623232> **PokeBrawl**\n" +
                        "**1)** Click the following link: https://www.poke-brawl.com/appeal\n" +
                        "**2)** Fill out the form & wait for staff to reply\n" +
                        " \n" +
                        "<:pokezone:711289077491564605> **PokeZone**\n" +
                        "**1)** Click the following link: https://www.pokezone.net/appeal\n" +
                        "**2)** Fill out the form & wait for staff to reply\n");

        return appealInfo;
    }

    public static EmbedBuilder modInfo() {
        EmbedBuilder modInfo = new EmbedBuilder();

        modInfo.setColor(Color.green).getDescriptionBuilder().append(
                "This guide will explain how to install external Mods\n" +
                "(Note: Before anything, download the selected Mod online or pinned in a channel)\n" +
                        " \n" +
                        "**On Technic**\n" +
                        "**1)** Press Win + R\n" +
                        "**2)** Type in %appdata%\n" +
                        "**3)** Go to .technic/modpacks/ultimate-reallife-roleplay/mods\n" +
                        "**4)** Drag the downloaded Mod into the mods folder\n" +
                        " \n" +
                        "**On Forge**\n" +
                        "**1)** Press Win + R\n" +
                        "**2)** Type in %appdata%\n" +
                        "**3)** Go to .minecraft/mods\n" +
                        "**4)** Drag the downloaded Mod into the mods folder\n");
        return modInfo;
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
        pokedash.setTitle("PokeDash Info").setColor(Color.decode("#3cb0d6"))
                .setThumbnail("https://i.gyazo.com/13255ea852d4551df36e9c1c9c3d4e92.png").getDescriptionBuilder()
                .append("**IP:**\tplay.pokedash.org\n**Version:**\t 1.12.2");
        return pokedash;
    }

    public static EmbedBuilder IPPV() {
        EmbedBuilder pokeverse = new EmbedBuilder();
        pokeverse.setTitle("Pokeverse Info").setColor(Color.decode("#f1c40f"))
                .setThumbnail("https://i.gyazo.com/d92082e99c3e2c17d675adc130e83091.png").getDescriptionBuilder()
                .append("**IP:**\tplay.pokeverse.org\n**Version:**\t 1.12.2");
        return pokeverse;
    }

    public static EmbedBuilder IPPC() {
        EmbedBuilder pokeclub = new EmbedBuilder();
        pokeclub.setTitle("PokeClub Info").setColor(Color.decode("#46ff8b"))
                .setThumbnail("https://i.gyazo.com/21380d908820fc0c78e95a813e66b5cd.png").getDescriptionBuilder()
                .append("**IP:**\tplay.pokeclub.net\n**Version:**\t 1.12.2");
        return pokeclub;
    }
    public static EmbedBuilder IPPL() {
        EmbedBuilder pokelegends = new EmbedBuilder();
        pokelegends.setTitle("PokeLegends Info").setColor(Color.decode("#ff7da1"))
                .setThumbnail("https://i.gyazo.com/b79efa7c89576238c00ba4ceb503e055.png").getDescriptionBuilder()
                .append("**IP:**\tplay.pokelegends.net\n**Version:**\t 1.12.2");
        return pokelegends;
    }

    public static EmbedBuilder IPPB() {
        EmbedBuilder pokebrawl = new EmbedBuilder();
        pokebrawl.setTitle("PokeBrawl Info").setColor(Color.decode("#8573d1"))
                .setThumbnail("https://i.gyazo.com/855beae57e80ced02751a3a046e366e0.png").getDescriptionBuilder()
                .append("**IP:**\tplay.poke-brawl.com\n**Version:**\t 1.12.2");
        return pokebrawl;
    }

    public static EmbedBuilder IPPZ() {
        EmbedBuilder pokezone = new EmbedBuilder();
        pokezone.setTitle("PokeZone Info").setColor(Color.decode("#89d0e5"))
                .setThumbnail("https://i.gyazo.com/8b16a7d630dc57177328909d78254b5c.png").getDescriptionBuilder()
                .append("**IP:**\tplay.pokezone.net\n**Version:**\t 1.12.2");
        return pokezone;
    }

    public EmbedBuilder onUnsupported() {
        EmbedBuilder error = new EmbedBuilder();
        error.setColor(Color.RED).setTitle(":x: **Unsupported server!**").getDescriptionBuilder().append(
                "This server is not supported for this command!\nIf you believe this to be an error contact pokerman981#9743");
        return error;
    }

    public static EmbedBuilder noArgsIP() {
        EmbedBuilder noArgs = new EmbedBuilder();
        noArgs.setTitle("Server IPs").setColor(Color.red).getDescriptionBuilder()
                .append("**.ip (server name)**\n\n**Servers:**\n\t*pokedash*\n\t*pokeverse*\n\t*pokelegends*\n\t*pokeclub*\n\t*pokebrawl*\n\t*pokezone*");
        return noArgs;
    }
}