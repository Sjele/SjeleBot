package main;

import org.pircbotx.*;
import org.pircbotx.hooks.events.MessageEvent;

public class SjBot {

	public static PircBotX bot;
	public static boolean isFrozen;
	public static String pref = "!!";
	
	public static void main(String[] args) {
		
		bot = new PircBotX();
		
        bot.setName("SjBotX"); 
        bot.setVerbose(true); 
        bot.setAutoNickChange(true);
        
        //bot.getListenerManager().addListener(new CLASSFILE());
        bot.getListenerManager().addListener(new plugins.Command_Freeze());
        bot.getListenerManager().addListener(new plugins.Command_Say());
        try {
            
        	bot.connect("irc.esper.net");
            bot.joinChannel("#sjele");
        
        }catch(Exception e){
        	
        	e.printStackTrace();
        
        }  
    }
	public static void err(MessageEvent e) {
		
		bot.sendNotice(e.getUser().getNick(), "Hey you! Who said you could use this command!");
		
	}
	
	public static boolean getFrozen() {
		return isFrozen || false;
	}
	
	public static void freeze() {
		if (isFrozen == true) {
			isFrozen = false;
		}else{
			isFrozen = true;
		}
	}
}	
