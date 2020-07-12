package DiscordBot;

import net.dv8tion.jda.api.EmbedBuilder;

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
                        "**Note:** Make sure your Java is updated to the most recent version & that you're running 64-bit Java to do so follow these steps\n" +
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

    public static EmbedBuilder linkInfo() {
        EmbedBuilder linkInfo = new EmbedBuilder();

        linkInfo.setColor(Color.green).getDescriptionBuilder().append(
                "This tutorial will show you how to link your discord account to your Minecraft IGN\n" +
                "(Note: This is only for donators or veteran ranked players!)\n" +
                        " \n" +
                        "**1)** On the server you play on, run the command \"/link\"\n" +
                        "**2)** Note down the PIN given to you in game (Note: if you lose this PIN, message a staff member and they can recover it for you!)\n" +
                        "**3)** Look for the bot that matches your server's name (Note: these are <@399343165145874444>, <@399344633861242911>, <@399345474156494848>, <@399345241699778560>, <@532768773980028928>, <@711171634492473404> and <@715424569027985420>)\n" +
                        "**4)** Send a DM to the respective bot for your server saying \"!link <Your IGN> <Your Pin>\" (e.g !link Shmeeb 00000)\n" +
                        "**5)** Return to our discord and make sure you have received the correct role(s) (Note: If you have any troubles message any staff!)\n"
        );
        return linkInfo;
    }

    public static EmbedBuilder logsWin() {
        EmbedBuilder logsWin = new EmbedBuilder();

        logsWin.setColor(Color.green).getDescriptionBuilder().append(
                "This tutorial will explain how to access logs on Windows!\n" +
                        " \n" +
                        "**Forge**\n" +
                        "**1)** Press on \"Win + R\"\n" +
                        "**2)** Type in \"%appdata%\" and press Enter/Ok\n" +
                        "**3)** Go to \".minecraft\\logs\"\n" +
                        "**4)** Look through your log files and find the appropriate one\n\t" +
                        "(Pro Tips: Use the shortcut \"Ctrl + F\" to search for specific keywords! " +
                        "These can include player names, pokemon names, or commands!)\n" +
                        "**5)** Save your evidence and message staff!\n" +
                        " \n" +
                        "**Technic**\n" +
                        "**1)** Press on \"Win + R\"\n" +
                        "**2)** Type in \"%appdata%\" and press Enter/Ok\n" +
                        "**3)** Go to \".technic\\modpacks\\ultimate-reallife-roleplay\\logs\"\n" +
                        "**4)** Look through your log files and find the appropriate one\n\t" +
                        "(Pro Tips: Use the shortcut \"Ctrl + F\" to search for specific keywords! " +
                        "These can include player names, pokemon names, or commands!)\n"
        );
        return logsWin;
    }

    public static EmbedBuilder logsMac() {
        EmbedBuilder logsMac = new EmbedBuilder();

        logsMac.setColor(Color.green).getDescriptionBuilder().append(
                "This tutorial will explain how to access logs on Windows!\n" +
                        " \n" +
                        "**Forge**\n" +
                        "**1)** Open finder\n" +
                        "**2)** To go \"help\" at the top left\n" +
                        "**3)** Open the library folder\n" +
                        "\t**3a)** Open finder and search for \"ÔlibraryÕ\" in help\n" +
                        "\t**3b)** Follow the arrow from the help bar into the \"ÒGoÓ\" section of finder and double click the library icon\n" +
                        "\t**3c)** Go directly into the Go section, hold down option to make library appear and open it\n" +
                        "**4)** Go to \"Application Support\"\n" +
                        "**5)** Go to your Minecraft folder\n" +
                        "**6)** Go to \"logs\"\n" +
                        "**6)** Look through your logs files and find the appropriate one\n\t" +
                        "(Pro Tips: Use the shortcut \"Cmd + F\" to search for specific keywords!" +
                        "These can include player names, pokemon names, or commands!)\n" +
                        "**7)** Save your evidence and message staff!\n" +
                        " \n" +
                        "**Technic**\n" +
                        "**1)** Open the Technic Launcher and go to our Modpack\n" +
                        "**2)** Click on \"Modpack Options\" and it should redirect you to the Modpack files\n" +
                        "**3)** In the Modpack files, you should be able to see a \"Logs\" folder, click that\n" +
                        "**4)** Look through your log files and find the appropriate one\n\t" +
                        "(Pro Tips: Use the shortcut \"Cmd + F\" to search for specific keywords! " +
                        "These can include player names, pokemon names, or commands!)\n" +
                        "**5)** Save your evidence and message staff!\n"
        );
        return logsMac;
    }

    public static EmbedBuilder appealInfo() {
        EmbedBuilder appealInfo = new EmbedBuilder();

        appealInfo.setColor(Color.green).getDescriptionBuilder().append(
                "This tutorial will explain how to appeal your punishments given on the server(s)\n" +
                "(Note: Pinging/Bothering staff about your appeal will **NOT** reduce the wait time)\n" +
                        " \n" +
                        "<:pokedash:725057210526335127> **PokeDash**\n" +
                        "**1)** Click the following link: https://www.pokedash.org/appeal\n" +
                        "**2)** Fill out the form & wait for staff to reply\n" +
                        " \n" +
                        "<:pokeverse:714032214245113907> **Pokeverse**\n" +
                        "**1)** Read the Appeal format link before appealing: https://pxl.plus/pvappealform\n" +
                        "**2)** Click the following link: https://www.pokeverse.org/appeal\n" +
                        "**3)** Fill out the form & wait for staff to reply\n" +
                        " \n" +
                        "<:pokelegends:722273123172614166> **PokeLegends**\n" +
                        "**1)** Click the following link: https://www.pokelegends.net/appeal\n" +
                        "**2)** Fill out the form & wait for staff to reply\n" +
                        " \n" +
                        "<:pokeclub:725057231971942490> **PokeClub**\n" +
                        "**1)** Click the following link: https://www.pokeclub.net/appeal\n" +
                        "**2)** Fill out the form & wait for staff to reply\n" +
                        " \n" +
                        "<:pokebrawl:722273098744987740> **PokeBrawl**\n" +
                        "**1)** Click the following link: https://www.poke-brawl.com/appeal\n" +
                        "**2)** Fill out the form & wait for staff to reply\n" +
                        " \n" +
                        "<:pokezoneblue:722273150250909706> **PokeZone**\n" +
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

    public static EmbedBuilder websiteInfo() {
        EmbedBuilder websiteInfo = new EmbedBuilder();

        websiteInfo.setColor(Color.green).getDescriptionBuilder().append(
                "This tutorial will display every server's website!\n" +
                        " \n" +
                        "<:pokedash:725057210526335127> **PokeDash**: https://www.pokedash.org\n" +
                        "<:pokeverse:714032214245113907> **Pokeverse**: https://www.pokeverse.org\n" +
                        "<:pokelegends:722273123172614166> **PokeLegends**: https://www.pokelegends.net\n" +
                        "<:pokeclub:725057231971942490> **PokeClub**: https://www.pokeclub.net\n" +
                        "<:pokebrawl:722273098744987740> **PokeBrawl**: https://www.poke-brawl.com\n" +
                        "<:pokezoneblue:722273150250909706> **PokeZone**: https://www.pokezone.net\n");
        return websiteInfo;
    }

    public static EmbedBuilder supplyServer() {
        EmbedBuilder supplyServer = new EmbedBuilder();
        supplyServer.setColor(Color.red).getDescriptionBuilder().append(
                "Please supply a server");
        return supplyServer;
    }

    public static EmbedBuilder IPPD() {
        EmbedBuilder pokedash = new EmbedBuilder();
        pokedash.setTitle("PokeDash Info").setColor(Color.decode("#3cb0d6"))
                .setThumbnail("https://i.gyazo.com/2169621b4509d80927fd18cc0533ea65.png").getDescriptionBuilder()
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
                .setThumbnail("https://i.gyazo.com/647fe588ac9316cc53832cf3c4a78bcf.png").getDescriptionBuilder()
                .append("**IP:**\tplay.pokeclub.net\n**Version:**\t 1.12.2");
        return pokeclub;
    }
    public static EmbedBuilder IPPL() {
        EmbedBuilder pokelegends = new EmbedBuilder();
        pokelegends.setTitle("PokeLegends Info").setColor(Color.decode("#ff7da1"))
                .setThumbnail("https://i.gyazo.com/0ae07820d91399c59af42c152e248323.png").getDescriptionBuilder()
                .append("**IP:**\tplay.pokelegends.net\n**Version:**\t 1.12.2");
        return pokelegends;
    }

    public static EmbedBuilder IPPB() {
        EmbedBuilder pokebrawl = new EmbedBuilder();
        pokebrawl.setTitle("PokeBrawl Info").setColor(Color.decode("#8573d1"))
                .setThumbnail("https://i.gyazo.com/ecc1b06ec30234bf4fd70e5b9ef8431f.png").getDescriptionBuilder()
                .append("**IP:**\tplay.poke-brawl.com\n**Version:**\t 1.12.2");
        return pokebrawl;
    }

    public static EmbedBuilder IPPZ() {
        EmbedBuilder pokezone = new EmbedBuilder();
        pokezone.setTitle("PokeZone Info").setColor(Color.decode("#89d0e5"))
                .setThumbnail("https://i.gyazo.com/ee5b702c85849b5f01cf8b9cee44d4fa.png").getDescriptionBuilder()
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

    public static EmbedBuilder noArgsLogs() {
        EmbedBuilder noArgsLogs = new EmbedBuilder();
        noArgsLogs.setTitle("Minecraft Logs").setColor(Color.red).getDescriptionBuilder()
                .append("**.logs (operating system)**\n\n**Operating Systems:**\n\t*windows*\n\t*mac*");
        return noArgsLogs;
    }
}