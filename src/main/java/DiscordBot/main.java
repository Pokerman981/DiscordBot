package DiscordBot;

import DiscordBot.commands.*;
import DiscordBot.commands.moderation.BanCommand;
import DiscordBot.commands.moderation.kickCommand;
import DiscordBot.events.GuildJoinEvent;
import DiscordBot.events.GuildLeaveEvent;
import DiscordBot.events.LinkBlockerEvent;
import DiscordBot.events.ReactionEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class main extends ListenerAdapter {

    private static main instance;
    public static main getInstance(){
        return instance;
    }

	public static File file = new File("./userData.json");
	
    public static Map<String, Map<String, String>> userData = new HashMap<String, Map<String, String>>();
    public static List<String> bypassfilter = new ArrayList<>();

    public static Command.Category NORMAL = new Command.Category("Normal");
    public static Command.Category STAFF = new Command.Category("Staff");
    public static Command.Category ADMIN = new Command.Category("Admin");
    public static Command.Category OWNER = new Command.Category("Bot Owner");

    public static String requiredRole = "Staff";
	public static String requiredAdminRole = "Admin";
    
    public static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().disableHtmlEscaping().create();
	
	public static JDA jda;

	public static void main(String[] args) {

	        instance = new main();

	    try {


			//Command builder
			CommandClientBuilder ccb = new CommandClientBuilder()
			.setPrefix(".") //Prefix
			.setAlternativePrefix("**") //Alt prefix
			.setEmojis("\u2705", "\uD83D\uDCA1", "\uD83D\uDEAB") //Unicode emojis
			.setOwnerId(Ref.owner_id) // Owner ID
			.addCommands( //Commands
					new IPCommand(),
                    new QuoteCommand(),
                    new InstallCommand(),
					new ServerStatusCommand(),
					new SelfAssignCommand(),
					new ListBlockedLinksCommand(),
                    new LinkPermitCommand(),
                    new BanCommand(),
                    new kickCommand(),
                    new BlockLinkCommand(),
					new AllowMentionCommand(),
                    new ForceStarboardCommand(),
                    new ShutDownCommand(),
                    new Ping(),
                    new EvalCommand()
            );

			//Get an instance of the event waiter
            EventWaiter waiter = new EventWaiter();

            //Login
			jda = new JDABuilder(AccountType.BOT).setToken(Ref.main_token).buildBlocking();
			//Set Status
			jda.getPresence().setGame(Game.playing("¯\\_(ツ)_/¯"));
            //Register Events
            jda.addEventListener(new GuildLeaveEvent());
            jda.addEventListener(new GuildJoinEvent());
            jda.addEventListener(new LinkBlockerEvent());
            jda.addEventListener(new ReactionEvent());
            jda.addEventListener(new testCommand());
            jda.addEventListener(waiter);
            jda.addEventListener(ccb.build());

            //Make sure the config is there #Going to change to H2 soon
			Config.init(file);
			//Start the saving proccess
			startSave();
			
		} catch (LoginException | IllegalArgumentException | InterruptedException | JsonIOException | JsonSyntaxException e) {
			e.printStackTrace();
		}
	}

	//Start the save task
	public static void startSave(){
		Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new saveTask(), 0, 5, TimeUnit.MINUTES);
	}

	//Save the file #Going to change to H2 soon
	public static void Save() throws IOException{
        String json = gson.toJson(main.userData, new TypeToken<Map<String, Map<String, String>>>(){}.getType());
        FileWriter writer = new FileWriter(file);
        // Write to the file you passed
        writer.write(json);
        // Always close when done.
        writer.close();
        //Print that it's done
        System.out.println("Saved config!");
	}


	/*public static void testing(){
        //int tmnumber = 4942;

        for (int number1 = 1; number1 < 178; number1++){
            System.out.println("    tm"+ number1 +" {");
            System.out.println("        Item {\n            Count = 1");
            System.out.println("            ItemType = \"pixelmon:tm"+ number1 +"\"");
            System.out.println("            UnsafeDamage = 0\n        }\n    }");
        }


       for (int x = 136; x < 181; x++){
           System.out.println("    Slot"+ (x-136) +" = [${aliases.tm"+ (x) +"} {");
           System.out.println("        Item {");
           System.out.println("            DisplayName = \"&b&l%tm"+ (x) +"%\"");
           System.out.println("            ItemLore = [");
           System.out.println("                ${aliases.tm-lore}");
           System.out.println("            ]");
           System.out.println("        }");
           System.out.println("        PrimaryAction {");
           System.out.println("        Command = \"cost: 3000; console: give %player_name% pixelmon:tm"+ x +" 1\"");
           System.out.println("        KeepInventoryOpen = true");
           System.out.println("         }");
           System.out.println("        Requirements = \"%economy_balance% >= 3000\"");
           System.out.println("    }, {");
           System.out.println("        Item {");
           System.out.println("            ItemType = \"pixelmon:tm"+ (x) + "\"");
           System.out.println("            Count = 1");
           System.out.println("            UnsafeDamage = 0");
           System.out.println("            DisplayName = \"&b&l%tm"+ (x) +"%\"");
           System.out.println("            ItemLore = [");
           System.out.println("                ${aliases.tm-lore-nomoney}");
           System.out.println("            ]");
           System.out.println("        }");
           System.out.println("     }]");
       }


	}*/

}
