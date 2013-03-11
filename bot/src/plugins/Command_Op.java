package plugins;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import main.SjBot;

public class Command_Op extends ListenerAdapter{
	
	private String cmdName = "op";
	private boolean isFrozen;
	
	public void onMessage(MessageEvent msg) {
		
		if (msg.getMessage().startsWith(main.SjBot.pref+cmdName) || msg.getMessage().startsWith(main.SjBot.pref+" "+cmdName)) {
			if (main.SjBot.ops.contains(msg.getUser().getNick().toString())) {
				Pattern p = Pattern.compile("(\\w+)$");
				Matcher m = p.matcher(msg.getMessage());
				String user = m.group(1);
				SjBot.ops.add(user);
				System.out.println("added "+user+" to op list");
			}
		}
	}
	
}
