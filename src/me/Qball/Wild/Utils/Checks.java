package me.Qball.Wild.Utils;

import java.util.List;

import me.Qball.Wild.Wild;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Checks{
	public static boolean Water;
	public static boolean inNether;
	public static boolean inEnd;
	public static boolean loaded;
	public static boolean World;
	public static boolean Biomes;
	public static Plugin wild = Wild.getInstance();
	@SuppressWarnings("unchecked")
	static List<String> Worlds = (List<String>)wild.getConfig().getList("Worlds");
	 public static boolean getLiquid(int x,int z, Player target)
	  {
		  int Y = 0;
		 for (int i = 255; i > 0;i--)
		 {
			 if(!target.getWorld().getBlockAt(x, i, z).getType().equals((Material.AIR)))
			 {
				  Y = i;
				  break;
			 }
		 }
		 
		  if (target.getWorld().getBlockAt(x,Y,z).isLiquid()||target.getWorld().getBiome(x,z).equals(Biome.OCEAN)||target.getWorld().getBiome(x, z).equals(Biome.DEEP_OCEAN))
	      {
	    	  Water = true;
	      }
		  else
		  {
			  Water = false;
		  }
		  return Water;
	  }
	  public static boolean inNether(int tempx,int tempz, Player target)
	  {
		 
		  if (target.getWorld().getBiome(tempx, tempz) == Biome.HELL)
	      {
	    	  inNether = true; 
	      }
		  else
		  {
			  inNether = false;
		  }
		  return inNether;
	  }
	  public static boolean inEnd(int tempx,int tempz, Player target)
	  {
		 
		  if (target.getWorld().getBiome(tempx, tempz) == Biome.SKY)
	      {
	    	  inEnd = true;
	      }
		  else
		  {
			  inEnd = false;
		  }
		  return inEnd;
	  }
	  public static void ChunkLoaded(int tempx, int tempz, Player target)
	  {
		 
		
		if (target.getWorld().isChunkLoaded(tempx,tempz) == true)
		  {
			
		  }
		  else
		  {
			  target.getWorld().getChunkAt(tempx, tempz).load();
		  }
	  }	 
	  public static int getSoildBlock(int tempx, int tempz, Player target)
	  {
		 int Y = 0;
		  for (int y = 256; y>= 0; y --)
		  {
			 Y = y;
			 if(!target.getWorld().getBlockAt(tempx, Y, tempz).isEmpty())
			 {
				Y+=2;
				break;
			 }
		  }
		 return Y;
	  }
	  public static boolean World(Player p) 
	  {
				 if (Worlds.contains(p.getLocation().getWorld().getName()))
				 {
					 World=true;
				 }
				 else
				 {
					 World = false;
							 
				 }
				 return World;
	  }
	  public static boolean blacklistBiome(Location loc)
	  {
		
		  @SuppressWarnings("unchecked")
		  List<String> biomes = (List<String>)wild.getConfig().getList("Blacklisted_Biomes");
		  for (int i = 0; i <= biomes.size(); i++)
		  {
			  String biome = biomes.get(i).toString().toUpperCase();
			  if(loc.getBlock().getBiome() == Biome.valueOf(biome))
			  {	
				  Biomes= true;
				  break;
			  
			  }
			else{
			  		if (i==biomes.size())
			  		{
			  			Biomes=false;
			  		}
			  	}
			  	
			  
		  }
		return Biomes;
	  }

}
