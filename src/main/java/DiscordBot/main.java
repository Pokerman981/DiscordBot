package DiscordBot;

import DiscordBot.commands.*;
import DiscordBot.commands.moderation.*;
import DiscordBot.events.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class main extends ListenerAdapter {
    private static main instance;
    public static main getInstance(){
        return instance;
    }
	public static File file = new File("./userData.json");
    public static Map<String, Map<String, String>> userData = new HashMap<String, Map<String, String>>();
    public static Command.Category NORMAL = new Command.Category("Normal");
    public static Command.Category STAFF = new Command.Category("Staff");
    public static Command.Category ADMIN = new Command.Category("Admin");
    public static Command.Category OWNER = new Command.Category("Bot Owner");
    public static String requiredRole = "Staff";
	public static String requiredAdminRole = "Admin";
    public static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().disableHtmlEscaping().create();
	public static JDA jda;

	public static Map<String, Command.Category> roleCategories = new HashMap<String, Command.Category>() {
		{
			put("owner", new Command.Category("Owner"));
			put("admin", new Command.Category("Admin"));
			put("staff", new Command.Category("Staff"));
			put("player", new Command.Category("Player"));
		}
	};

	public static Map<String, String> emoteRankID = new HashMap<String, String>() {
		{
			put("375433829764169741", "467459853116375040");
			put("714032214245113907", "467459888516431903");
			put("628381164939247636", "467459940093657108");
			put("526264234716299284", "467459975812218922");
			put("707662953926623232", "586792372969668613");
			put("711289077491564605", "711157151246057482");
			put("717636373523464282", "716753331862765608");
		}
	};

	public static Map<String, String> emoteIDs = new HashMap<String, String>() {
		{
			put("dash", "375433829764169741");
			put("verse", "714032214245113907");
			put("legends", "628381164939247636");
			put("club", "526264234716299284");
			put("brawl", "707662953926623232");
			put("zone1", "711289077491564605");
			put("zone2", "711289077491564605");
		}
	};


	public static void main(String[] args) {
		instance = new main();

	    try {
			//Command builder
			CommandClientBuilder ccb = new CommandClientBuilder()
			.setPrefix(".") //Prefix
			.setAlternativePrefix("**") //Alt prefix
			.setEmojis("\u2705", "\uD83D\uDCA1", "\uD83D\uDEAB") //Unicode emojis
			.setOwnerId("126427288496504834") // Owner ID
			.useHelpBuilder(false)
			.setActivity(Activity.playing("¯\\_(ツ)_/¯"))
			.addCommands( //Commands
					new AppealCommand(),
					new LogsCommand(),
					new RamCommand(),
					new IPCommand(),
                    new LinkCommand(),
                    new ModCommand(),
                    new InstallCommand(),
					new ServerStatusCommand(),
                    new StaffStatusCommand(),
                    new BanCommand(),
                    new KickCommand(),
					new MuteCommand(),
					new UnmuteCommand(),
					new WarnCommand(),
					new PricesCommand(),
//                    new ShutDownCommand(),
                    new EvalCommand(),
					new AssignRoleReactionCommand()
//					new TestCommand(),
					new WebsiteCommand()
            );

			//Get an instance of the event waiter
            EventWaiter waiter = new EventWaiter();

            //Login
			jda = JDABuilder.createDefault(args[0]).build(); // MjgyMDU2Nzc3MDAzMTcxODQx.DyPZbQ.yZKJpaSReSpHMO1fQHrmNbsTFBI // "¯\\_(ツ)_/¯"
            //Register Events
//			jda.addEventListener(new AssignRoleReactionEvent());
			jda.addEventListener(new AssignRoleReactionEvent());
			jda.addEventListener(new RemoveRoleReactionEvent());

			jda.addEventListener(new GuildLeaveEvent());
            jda.addEventListener(new GuildJoinEvent());
//            jda.addEventListener(new testCommand());
            jda.addEventListener(waiter);
            jda.addEventListener(ccb.build());

            Timer timer = new Timer();
            timer.schedule(new StaffCounter(), 5000, 50000);
			//timer.schedule(new NetworkCounter(), 0, 30000);


            //Make sure the config is there #Going to change to H2 soon
			Config.init(file);
			//Start the saving process
			startSave();
			
		} catch (LoginException | IllegalArgumentException | JsonIOException | JsonSyntaxException e) {
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
}