package plugins;

import main.SjBot;
import javaCMD.javaCMD;
import org.pircbotx.*;
import org.pircbotx.hooks.Event;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Command_Freeze extends  ListenerAdapter {
	private static String cmdName = "freeze";
	
	public void onMessage(MessageEvent msg) {
	
		if (msg.getMessage().startsWith(SjBot.pref+cmdName) || msg.getMessage().startsWith(SjBot.pref+" "+cmdName)){
			
			SjBot.freeze();
			System.out.println("Bot is now frozen : "+javaCMD.BooleanToString(SjBot.getFrozen()));
			msg.getBot().sendMessage(msg.getChannel(),msg.getUser().getNick()+" set bot to freeze mode: "+javaCMD.BooleanToString(SjBot.isFrozen));
			
		}
		
	}

	
	
}
