package DiscordBot;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class Embeds {

    public static EmbedBuilder onServerStatusEmbed() {
        EmbedBuilder eb = new EmbedBuilder().setTitle("**PokeZone Server Stats**\n").setColor(Color.decode("#19750b"));

        return eb;
    }

    public static EmbedBuilder reforgedInstallInfo() {
        EmbedBuilder reforgedInstallInfo = new EmbedBuilder();

        reforgedInstallInfo.setColor(Color.green).getDescriptionBuilder()
                .append("This tutorial will explain how to download & install the **Pixelmon+ Modpack**\n" +
                        " \n" +
                        "**1)** Download the Technic Launcher at https://technicpack.net/download\n" +
                        "**2)** Open the launcher\n" +
                        "**3)** Click \"Modpacks\" on the top of the launcher\n" +
                        "**4)** Paste \"http://api.technicpack.net/modpack/ultimate-reallife-roleplay\" (without the quotes) into the \"Search\" box\n" +
                        "**5)** Click \"Install\" on the bottom right of the launcher\n" +
                        "**6)** Wait for the download to finish and join the server!\n");

        return reforgedInstallInfo;
    }

    public static EmbedBuilder ramInfo() {
        EmbedBuilder ramInfo = new EmbedBuilder();

        ramInfo.setColor(Color.green).getDescriptionBuilder()
                .append("This tutorial will explain how to allocate more ram on **Technic** & **Forge** versions\n" +
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
                        "**6)** Click on 'Save'\n" +
                        " \n" +
                        "*For further assistance, consider following this tutorial: http://bit.ly/RAMTutorial");

        return ramInfo;
    }

    public static EmbedBuilder linkInfo() {
        EmbedBuilder linkInfo = new EmbedBuilder();

        linkInfo.setColor(Color.green).getDescriptionBuilder()
                .append("This tutorial will show you how to link your discord account to your Minecraft Account\n" +
                        "*(Note: This is for all players!)*\n" +
                        " \n" +
                        "**1)** On the server you play on, run the command \"/link\"\n" +
                        "**2)** Note down the PIN given to you in game (Note: if you lose this PIN, /link will restate it!)\n" +
                        "**3)** Look for the bot that matches your server's name. It should tell you which one in game upon running /link. (Note: these are <@!399343165145874444>, <@!399344633861242911>, <@!399345474156494848>, <@!399345241699778560>, <@!532768773980028928>, <@!749359623382892676> and <@!749359731612582030>)\n" +
                        "**4)** Send a Direct Message to the bot for your server saying your pin (e.g. 111111)\n" +
                        "**5)** Return to our discord and make sure you have received the correct role(s). These would be Verified, your server's role, and the ServerDonator role if you are a Donator or Veteran. (Note: If you have any troubles message any staff!)\n");

        return linkInfo;
    }

    public static EmbedBuilder logsWin() {
        EmbedBuilder logsWin = new EmbedBuilder();

        logsWin.setColor(Color.green).getDescriptionBuilder()
                .append("This tutorial will explain how to access logs on Windows!\n" +
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
                        "These can include player names, pokemon names, or commands!)\n");

        return logsWin;
    }

    public static EmbedBuilder logsMac() {
        EmbedBuilder logsMac = new EmbedBuilder();

        logsMac.setColor(Color.green).getDescriptionBuilder()
                .append("This tutorial will explain how to access logs on Windows!\n" +
                        " \n" +
                        "**Forge**\n" +
                        "**1)** Open finder\n" +
                        "**2)** Go to \"help\" at the top left\n" +
                        "**3)** Open the library folder\n" +
                        "**a)** Open finder and search for \"ÔlibraryÕ\" in help\n" +
                        "**b)** Follow the arrow from the help bar into the \"ÒGoÓ\" section of finder and double click the library icon\n" +
                        "**c)** Go directly into the Go section, hold down option to make library appear and open it\n" +
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
                        "**5)** Save your evidence and message staff!\n");

        return logsMac;
    }

    public static EmbedBuilder modsWin() {
        EmbedBuilder modsWin = new EmbedBuilder();

        modsWin.setColor(Color.green).getDescriptionBuilder()
                .append("This guide will explain how to install external Mods\n" +
                        "(Note: Before anything, download the selected Mod(s))\n" +
                        " \n" +
                        "**Forge**\n" +
                        "**1)** Press Win + R\n" +
                        "**2)** Type in %appdata%\n" +
                        "**3)** Go to .minecraft/mods\n" +
                        "**4)** Drag the downloaded Mod into the mods folder\n" +
                        "**5)** Restart your Minecraft\n" +
                        " \n" +
                        "**Technic**\n" +
                        "**1)** Press Win + R\n" +
                        "**2)** Type in %appdata%\n" +
                        "**3)** Go to .technic/modpacks/ultimate-reallife-roleplay/mods\n" +
                        "**4)** Drag the downloaded Mod into the mods folder\n" +
                        "**5)** Restart your Minecraft\n");

        return modsWin;
    }

    public static EmbedBuilder modsMac() {
        EmbedBuilder modsMac = new EmbedBuilder();

        modsMac.setColor(Color.green).getDescriptionBuilder()
                .append("This guide will explain how to install external Mods\n" +
                        "(Note: Before anything, download the selected Mod(s))\n" +
                        " \n" +
                        "**Forge**\n" +
                        "**1)** Open finder\n" +
                        "**2)** Go to \"help\" at the top left\n" +
                        "**3)** Open the library folder\n" +
                        "**4)** Go to \"~/Library/Application Support/Minecraft/mods\"" +
                        "**5)** Drag the downloaded Mod into the mods folder\n" +
                        "**6)** Restart your Minecraft\n" +
                        " \n" +
                        "**Technic**\n" +
                        "**1)** Open finder\n" +
                        "**2)** Go to \"help\" at the top left\n" +
                        "**3)** Open the library folder\n" +
                        "**a)** Open finder and search for \"ÔlibraryÕ\" in help\n" +
                        "**b)** Follow the arrow from the help bar into the \"ÒGoÓ\" section of finder and double click the library icon\n" +
                        "**c)** Go directly into the Go section, hold down option to make library appear and open it\n" +
                        "**4)** Go to \"Application Support\"\n" +
                        "**5)** Go to your Technic folder\n" +
                        "**6)** Go to \"ÔmodpacksÕ\"\n" +
                        "**7)** Go to \"Òultimate-reallife-roleplayÓ\"\n" +
                        "**8)** Go to \"mods\" and drag the mod into that folder\n" +
                        "**9)** Restart your Minecraft\n");

        return modsMac;
    }

    public static EmbedBuilder siteInfo() {
        EmbedBuilder websiteInfo = new EmbedBuilder();

        websiteInfo
                .setTitle("PokeZone Website")
                .setColor(Color.green)
                .setThumbnail("https://i.gyazo.com/ee5b702c85849b5f01cf8b9cee44d4fa.png").getDescriptionBuilder()
                .append("**Site:**\thttps://pokezone.net\n");

        return websiteInfo;
    }

    public static EmbedBuilder appInfo() {
        EmbedBuilder appealInfo = new EmbedBuilder();

        appealInfo
                .setTitle("PokeZone Appeals and Applications")
                .setColor(Color.decode("#89d0e5"))
                .setThumbnail("https://i.gyazo.com/ee5b702c85849b5f01cf8b9cee44d4fa.png")
                .getDescriptionBuilder()
                .append("**Site:**\thttps://www.pixelmonplus.com\n");

        return appealInfo;
    }

    public static EmbedBuilder pricesInfo() {
        EmbedBuilder pricesInfo = new EmbedBuilder();

        pricesInfo.setTitle("Minimum Prices").setColor(Color.green)
//                .setThumbnail("https://i.gyazo.com/13255ea852d4551df36e9c1c9c3d4e92.png")
                .getDescriptionBuilder()
                .append("<:pokedash:725057210526335127> **PokeDash** <:pokedash:725057210526335127> https://pxl.plus/pdprices" +
                        "\n<:pokeverse:714032214245113907> **Pokeverse** <:pokeverse:714032214245113907> https://pxl.plus/pvprices" +
                        "\n<:pokelegends:722273123172614166> **PokeLegends** <:pokelegends:722273123172614166> https://pxl.plus/plprices " +
                        "\n<:pokeclub:725057231971942490> **PokeClub** <:pokeclub:725057231971942490> https://pxl.plus/pcprices" +
                        "\n<:pokebrawl:722273098744987740> **PokeBrawl** <:pokebrawl:722273098744987740> https://pxl.plus/pbprices" +
                        "\n<:pokezoneblue:722273150250909706> **PokeSilver** <:pokezoneblue:722273150250909706> https://pxl.plus/psprices" +
                        "\n<:pokezonered:722458281536258060> **PokeGold** <:pokezonered:722458281536258060> https://pxl.plus/pgprices");

        return pricesInfo;
    }

    public static EmbedBuilder ipInfo() {
        EmbedBuilder ipInfo = new EmbedBuilder();

        ipInfo
                .setTitle("PokeZone IP")
                .setColor(Color.decode("#89d0e5"))
                .setThumbnail("https://i.gyazo.com/ee5b702c85849b5f01cf8b9cee44d4fa.png").getDescriptionBuilder()
                .append("**IP:**\tplay.pokezone.net\n**Version:**\t 1.12.2\n**Modpack:**\t bit.ly/pixelmonplus\n");

        return ipInfo;
    }

    public static EmbedBuilder noArgsLogs() {
        EmbedBuilder noArgsLogs = new EmbedBuilder();
        noArgsLogs.setTitle("Minecraft Logs").setColor(Color.red).getDescriptionBuilder()
                .append("**.logs (operating system)**\n\n**Operating Systems:**\n\t*windows*\n\t*mac*");

        return noArgsLogs;
    }

    public static EmbedBuilder noArgsMods() {
        EmbedBuilder noArgsMods = new EmbedBuilder();
        noArgsMods.setTitle("Minecraft Mods").setColor(Color.red).getDescriptionBuilder()
                .append("**.mods (operating system)**\n\n**Operating Systems:**\n\t*windows*\n\t*mac*");

        return noArgsMods;
    }
}