package DiscordBot;

import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Config {

    public static void init(File jsonConfig) {
        try {
            // Create the config if it doesn't already exist.
            if (!jsonConfig.exists() && jsonConfig.createNewFile()) {
                // Get a default map of blocks. You could just use a blank map, however.
                Map<String, Map<String, String>> defaultMap = getDefaults();
                // Convert the map to JSON format. There is a built in (de)serializer for it already.
                String json = main.gson.toJson(defaultMap, new TypeToken<Map<String, Map<String, String>>>(){}.getType());
                FileWriter writer = new FileWriter(jsonConfig);
                // Write to the file you passed
                writer.write(json);
                // Always close when done.
                writer.close();
            }

            // If the file exists (or we just made one exist), convert it from JSON format to a populated Map object
            main.userData = main.gson.fromJson(new FileReader(jsonConfig), new TypeToken<Map<String, Map<String, String>>>(){}.getType());

            if (!main.userData.containsKey("starboard")) {
                Map<String, String> temp = new HashMap<>();
                temp.put("0", "000000000");
                main.userData.put("starboard", temp);
                main.Save();
            }
        } catch (IOException e) {
            // Print an error if something fails. Please use a real logger, not System.out.
            System.out.println("Error creating default configuration.");
        }
    }

    private static Map<String, Map<String, String>> getDefaults() {
        Map<String, Map<String, String>> ret = new HashMap<String, Map<String, String>>();
        
        Map<String, String> links = new HashMap<String, String>();
        
        links.put("1", ".*/torrent/[0-9]");
        
        Map<String, String> priv = new HashMap<String, String>();
        
        priv.put("ID", "ChannelID");
        
        ret.put("links", links);
        ret.put("private", priv);
        return ret;
    }

}