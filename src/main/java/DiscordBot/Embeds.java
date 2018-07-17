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

    public static EmbedBuilder gensInstallInfo() {
        EmbedBuilder gensInstallInfo = new EmbedBuilder();

        gensInstallInfo.setColor(Color.green).getDescriptionBuilder().append(
                "This tutorial will explain how to install the **Pixelmon+** modpack\n" +
                " \n" +
                "**Step 1**: Download the Technic Launcher at http://bit.ly/2u9bs2e\n" +
                "**Step 2**: Open the launcher\n" +
                "**Step 3**: Click \"Modpacks\" on the top of the launcher\n" +
                "**Step 4**: Paste \"http://api.technicpack.net/modpack/ultimate-reallife-roleplay\" (without the quotes) into the \"Search\" box\n" +
                "**Step 5**: Click \"Install\" on the bottom right of the launcher\n" +
                "**Step 6**: Wait for the download to finish and join a server!");

        return gensInstallInfo;
    }

    public static EmbedBuilder reforgedInstallInfo() {
        EmbedBuilder reforgedInstallInfo = new EmbedBuilder();

        reforgedInstallInfo.setColor(Color.green).getDescriptionBuilder().append(
                "This tutorial will explain how to install the **Pixelmon Reborn** modpack\n" +
                " \n" +
                "**Step 1**: Download the Technic Launcher at http://bit.ly/2u9bs2e\n" +
                "**Step 2**: Open the launcher\n" +
                "**Step 3**: Click \"Modpacks\" on the top of the launcher\n" +
                "**Step 4**: Paste \"http://api.technicpack.net/modpack/pixelmon-reborn-official\" (without the quotes) into the \"Search\" box\n" +
                "**Step 5**: Click \"Install\" on the bottom right of the launcher\n" +
                "**Step 6**: Wait for the download to finish and join the server!");

        return reforgedInstallInfo;
    }
}
