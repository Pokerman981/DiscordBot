package DiscordBot.commands;

import DiscordBot.main;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SendMessageCommand extends Command {

    public SendMessageCommand() {
        this.name = "sendmessage";
        this.category = main.roleCategories.get("manager");
        this.requiredRole = main.requiredRoles.get("manager");
        this.guildOnly = true;
        this.hidden = true;
    }

    @Override
    protected void execute(CommandEvent event) {
        String[] args = event.getArgs().split(" ");
        if (args[0].isEmpty()) {
            event.replyError("You must supply a file or ls to list files");
            return;
        } else if (args[0].equals("ls")) {
            File messagesDir = new File("./messages/");
            StringBuilder stringBuilder = new StringBuilder("Available Files: ");
            for (File f : messagesDir.listFiles()) {
                stringBuilder.append("\n" + f.getName());
            }
            event.reply(stringBuilder.toString());
            return;
        }

        File targetFile = new File("./messages/" + args[0]);
        if (!targetFile.exists()) {
            event.replyError("Unable to find: " + args[0]);
            return;
        }




        if (targetFile.getName().contains(".json")) {
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = null;
            try {
                FileReader fileReader = new FileReader(targetFile);
                jsonObject = (JsonObject) jsonParser.parse(fileReader);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            JsonObject embedObject = (JsonObject) jsonObject.get("embed");

            String url = embedObject.get("url") != null ? embedObject.get("url").getAsString() : null;
            String description = embedObject.get("description") != null ? embedObject.get("description").getAsString() : null;
            String color = embedObject.get("color") != null ? embedObject.get("color").getAsString() : null;

            JsonObject footerObject = (JsonObject) embedObject.get("footer");
            String iconUrlFooter = footerObject.get("icon_url") != null ? footerObject.get("icon_url").getAsString() : null;
            String textFooter = footerObject.get("text") != null ? footerObject.get("text").getAsString() : null;

            JsonObject thumbnailObject = (JsonObject) embedObject.get("thumbnail");
            String urlThumbnail = thumbnailObject.get("url") != null ? thumbnailObject.get("url").getAsString() : null;

            JsonObject imageObject = (JsonObject) embedObject.get("image");
            String urlImage = imageObject.get("url") != null ? imageObject.get("url").getAsString() : null;

            JsonObject authorObject = (JsonObject) embedObject.get("author");
            String nameAuthor = authorObject.get("name") != null ? authorObject.get("name").getAsString() : null;
            String urlAuthor = authorObject.get("url") != null ? authorObject.get("url").getAsString() : null;
            String iconUrlAuthor = authorObject.get("icon_url") != null ? authorObject.get("icon_url").getAsString() : null;


            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setDescription(description);
            embedBuilder.setColor(Integer.parseInt(color));
            embedBuilder.setAuthor(nameAuthor, urlAuthor, iconUrlAuthor);
            embedBuilder.setImage(urlImage);
            embedBuilder.setThumbnail(urlThumbnail);
            embedBuilder.setFooter(textFooter, iconUrlFooter);

            event.reply(embedBuilder.build());

        } else {
            StringBuilder message = new StringBuilder();
            Scanner scanner = null;
            try {
                scanner = new Scanner(new FileReader(targetFile));
                while (scanner.hasNext()) {
                    message.append(scanner.nextLine());
                }

                event.reply(message.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        event.getMessage().delete().queueAfter(5, TimeUnit.SECONDS);

    }
}
