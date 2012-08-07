/*
 * Copyright (C) 2012 Eric Weik / ericw@newriversdigital.com
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation; either version 2 of the License,
 * or (at your option) any later version.
 *
 * Cobertura is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Cobertura; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA
 */

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
