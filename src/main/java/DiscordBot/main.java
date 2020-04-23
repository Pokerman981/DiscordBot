package DiscordBot;

import DiscordBot.commands.*;
import DiscordBot.commands.moderation.BanCommand;
import DiscordBot.commands.moderation.kickCommand;
import DiscordBot.events.*;
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
import java.util.*;
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

	public static void main(String[] args) {
		instance = new main();

	    try {
			//Command builder
			CommandClientBuilder ccb = new CommandClientBuilder()
			.setPrefix(".") //Prefix
			.setAlternativePrefix("**") //Alt prefix
			.setEmojis("\u2705", "\uD83D\uDCA1", "\uD83D\uDEAB") //Unicode emojis
			.setOwnerId("126427288496504834") // Owner ID
			.addCommands( //Commands
					new AppealCommand(),
					new LogsCommand(),
					new RamCommand(),
					new IPCommand(),
                    new InstallCommand(),
					new ServerStatusCommand(),
                    new BanCommand(),
                    new kickCommand(),
					new PricesCommand(),
//                    new ShutDownCommand(),
                    new EvalCommand(),
					new AutoRoleMessageIdentiferCommand()
            );

			//Get an instance of the event waiter
            EventWaiter waiter = new EventWaiter();

            //Login
			jda = new JDABuilder(AccountType.BOT).setToken("MjgyMDU2Nzc3MDAzMTcxODQx.DyPZbQ.yZKJpaSReSpHMO1fQHrmNbsTFBI").buildBlocking();
			//Set Status
			jda.getPresence().setGame(Game.playing("¯\\_(ツ)_/¯"));
            //Register Events
			jda.addEventListener(new AssignRoleReactionEvent());
            jda.addEventListener(new GuildLeaveEvent());
            jda.addEventListener(new GuildJoinEvent());
//            jda.addEventListener(new testCommand());
            jda.addEventListener(waiter);
            jda.addEventListener(ccb.build());

            Timer timer = new Timer();
            timer.schedule(new StaffCounter(), 0, 50000);
			//timer.schedule(new NetworkCounter(), 0, 30000);


            //Make sure the config is there #Going to change to H2 soon
			Config.init(file);
			//Start the saving process
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
}