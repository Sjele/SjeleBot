package plugins;

import main.SjBot;
import org.pircbotx.*;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Command_Say extends ListenerAdapter {
	
	private static boolean isFrozen;
	private static String cmdName = "say";
	private int pref;
	PircBotX bot = SjBot.bot;
	
	public void onMessage(MessageEvent event) {
		if (event.getMessage().startsWith(SjBot.pref+cmdName) || event.getMessage().startsWith(SjBot.pref+" "+cmdName)) {
			isFrozen = SjBot.getFrozen();
			if (isFrozen == false) {
				if (event.getMessage().startsWith(SjBot.pref+cmdName)) {
					pref = SjBot.pref.length()+cmdName.length()+1;
				}else{
					pref = SjBot.pref.length()+cmdName.length()+2;
				}
				bot.sendMessage(event.getChannel(), event.getMessage().substring(pref));
				System.out.println("Command say used with args: "+event.getMessage().substring(pref));
			}else{
				System.out.println("Bot is frozen, command tried to be used");
			}
		}	
		
	}
	
}
