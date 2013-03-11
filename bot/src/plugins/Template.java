package plugins;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import main.SjBot;
import javaCMD.javaCMD;

public class Template extends ListenerAdapter {
	
	private static String cmdName = "";
	private static boolean isFrozen;
	PircBotX bot = SjBot.bot;
	
	public void onMessage(MessageEvent msg) {
		isFrozen = SjBot.getFrozen();
		
		if (isFrozen == false) {
			
		}else{
			System.out.println("Bot is frozen");
		}
		
	}
	
}
