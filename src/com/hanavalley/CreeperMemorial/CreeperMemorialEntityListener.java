package com.hanavalley.CreeperMemorial;

//import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
//import org.bukkit.entity.Player;
import org.bukkit.entity.Creeper;

/**
 * CreeperMemorialEntityListener - listen for asploding creepers, and leave a memorial for them.
 * 
 * @author Ctenophor5
 *
 */
public class CreeperMemorialEntityListener implements Listener {
	// Define a logger
	Logger log = Logger.getLogger("Minecraft");
	
    /*
     * Called on entity explode.
     */
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onEntityExplode(EntityExplodeEvent event) {
    	//log.info("onEntityExplode event called.");    	
        Entity ent = event.getEntity();
        if (ent instanceof Creeper) {
          //log.info("Entity was a creeper!");
		  // Keep the creeper from exploding.
		  event.setCancelled(true);
		  
		  // Get location of the creeper from the event.
		  Location creeperLoc = event.getEntity().getLocation();
		
		  // Get the various blocks we will be working with
		  Block blockUnderMemorial = creeperLoc.getWorld().getBlockAt(creeperLoc.getBlockX(), creeperLoc.getBlockY() - 1, creeperLoc.getBlockZ());
		  Block block1Memorial = creeperLoc.getWorld().getBlockAt(creeperLoc.getBlockX(), creeperLoc.getBlockY(), creeperLoc.getBlockZ());
		  Block block2Memorial = creeperLoc.getWorld().getBlockAt(creeperLoc.getBlockX(), creeperLoc.getBlockY() + 1, creeperLoc.getBlockZ());
		  Block blockAboveMemorial  = creeperLoc.getWorld().getBlockAt(creeperLoc.getBlockX(), creeperLoc.getBlockY() + 2, creeperLoc.getBlockZ());
		  
		  // Get the material of the block under the creeper
		  Material memorialMat = blockUnderMemorial.getType();
		
		  // Create a 2 block high statue to commemorate the creeper's passing
		  block1Memorial.setType(memorialMat);
		  block2Memorial.setType(memorialMat);
		
		  // Check that the block above the memorial is air and if so add an 
		  // extra goodie based on the block type used to make the memorial
		  if (blockAboveMemorial.getType() == Material.AIR) {
			  
			// Grass or dirt => flower or rose
			if (memorialMat == Material.GRASS || 
				memorialMat == Material.DIRT) {
			  if (blockAboveMemorial.getLightLevel()<7) {
				blockAboveMemorial.setType(Material.YELLOW_FLOWER);
			  } else {
				blockAboveMemorial.setType(Material.RED_ROSE);			  
			  }
			}
			
			// Stone, cobblestone, or gravel (and in a dark area) => red mushroom or brown mushroom
			else if (memorialMat == Material.STONE ||
					   memorialMat == Material.COBBLESTONE ||
					   memorialMat == Material.GRAVEL) {
				if (blockAboveMemorial.getLightLevel()<7) {
					blockAboveMemorial.setType(Material.RED_MUSHROOM);
				} else {
					blockAboveMemorial.setType(Material.BROWN_MUSHROOM);
				}
			}
			
			// All other blocks...
			else { 
				// If area is dark, set a torch
				if (blockAboveMemorial.getLightLevel()<7) {
					blockAboveMemorial.setType(Material.TORCH);
				} else {
					// When all else fails, spawn a chicken...
					creeperLoc.getWorld().spawnCreature(blockAboveMemorial.getLocation(), EntityType.CHICKEN);
				}
				// Else random items:
				// - Pumpkin / jacko
				// - RIP sign?
				//   
			}
		}
		// Log it...
		log.info("Creeper memorial made at ("+creeperLoc.getBlockX()+","+creeperLoc.getBlockY()+","+creeperLoc.getBlockZ()+").");
	}
  }
}