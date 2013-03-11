package main;

import java.util.ArrayList;

import org.pircbotx.*;
import org.pircbotx.hooks.events.MessageEvent;
import Registry.PluginRegistry;

public class SjBot {

	public static PircBotX bot;
	public static ArrayList<String> ops;
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
        bot.getListenerManager().addListener(new plugins.Command_Date());
        bot.getListenerManager().addListener(new plugins.Command_Op());
        try {
            
        	bot.connect("irc.esper.net");
            bot.joinChannel("#sjele");
        
        }catch(Exception e){
        	
        	e.printStackTrace();
        
        }  
        //PluginRegistry.init();
        ops.add("Sjele");
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
