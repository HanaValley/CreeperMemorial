package com.hanavalley.CreeperMemorial;

import java.util.logging.Logger;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
//import org.bukkit.plugin.PluginDescriptionFile;

/**
 * CreeperMemorial - leave a memorial when a creeper departs this world of red(stone) dust.
 * 
 * @author Ctenophor5
 *
 */

public class CreeperMemorial extends JavaPlugin {

    Logger log = Logger.getLogger("Minecraft"); // Define a logger
	    
    public void onDisable() {
    	//PluginDescriptionFile pdfFile = getDescription();
    	//log.info(pdfFile.getName() + " version " + pdfFile.getVersion() + " is disabled.");
    }

    public void onEnable() { 
    	// onEnable is now automatically logged, so this is no longer necessary
    	//PluginDescriptionFile pdfFile = getDescription();
    	//log.info(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled.");
    	
		PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new CreeperMemorialEntityListener(), this);    	
    }
}