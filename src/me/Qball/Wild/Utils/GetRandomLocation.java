package me.Qball.Wild.Utils;

import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import me.Qball.Wild.Wild;
public class GetRandomLocation {
	private final Wild wild;
	public Checks check;
	public GetRandomLocation(Wild wild)
	{
		this.wild = wild;
		check = new Checks(this.wild);
	}
	public WorldInfo wInfo = new WorldInfo();
	
	public void getWorldInfo(Player p)
	{
		
		String w = wInfo.getWorldName(p);
		int minX = wInfo.getMinX(w);
		int maxX = wInfo.getMaxX(w);
		int minZ = wInfo.getMinZ(w);
		int maxZ = wInfo.getMaxZ(w);
		getRandomLoc(p,Bukkit.getWorld(w),maxX,minX,maxZ,minZ);
	 
	
	}
	public void getRandomLoc(Player p,World w,int maxX,int minX,int maxZ,int minZ)
	{
		Random rand = new Random();
		int x = rand.nextInt(maxX - minX + 1) + minX;
		int z = rand.nextInt(maxZ - minZ + 1) + minZ;
		int y = 0;
		if(!w.getBiome(x, z).equals(Biome.HELL))
		{
			y = check.getSolidBlock(x, z, p);
		}
		else
		{
			GetHighestNether nether = new GetHighestNether();
			y = nether.getSolidBlock(x, z, p);
		}
		Location loc = new Location(w,x,y,z,0.0F,0.0F);
		wild.random(p, loc);
	}
	public String getWorldInfomation(Player p)
	{
		String world =wInfo.getWorldName(p);
		String minX = String.valueOf(wInfo.getMinX(world)); 
		String maxX = String.valueOf(wInfo.getMaxX(world)); 
		String minZ = String.valueOf(wInfo.getMinZ(world));
		String maxZ = String.valueOf(wInfo.getMaxZ(world));
		String info = world+":"+minX+":"+maxX+":"+minZ+":"+maxZ;;
		return info;
	}
	public Location getRandomLoc(String info, Player p)
	{
		Random rand = new Random();
		String[] worldInfo = info.split(":");
		World w = Bukkit.getWorld(worldInfo[0]);
		int minX = Integer.parseInt(worldInfo[1]);
		int maxX = Integer.parseInt(worldInfo[2]);
		int minZ = Integer.parseInt(worldInfo[3]);
		int maxZ = Integer.parseInt(worldInfo[4]);
		int x = rand.nextInt(maxX - minX + 1) + minX;
		int z = rand.nextInt(maxZ - minZ + 1) + minZ;
		int y = 0; 
		if(!w.getBiome(x, z).equals(Biome.HELL))
		{   
			y = check.getSolidBlock(x, z, p);
		}
		else
		{
			GetHighestNether nether = new GetHighestNether();
			y = nether.getSolidBlock(x, z, p);
		} 
		Location loc = new Location(w,x,y,z,0.0F,0.0F);
		return loc;
	}
	public void recallTeleport(Location loc, Player p)
	{
		TeleportTarget tele = new TeleportTarget(wild);
		tele.TP(loc, p);
	}
	

}
