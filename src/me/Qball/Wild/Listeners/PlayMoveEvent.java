package me.Qball.Wild.Listeners;

import me.Qball.Wild.Utils.TeleportTar;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import java.util.ArrayList;
import java.util.UUID;


public class PlayMoveEvent implements Listener {
	public ArrayList<UUID> moved = new ArrayList<UUID>();

	@EventHandler
public void onMove(PlayerMoveEvent e)
{
	TeleportTar tele =new TeleportTar();
	if (tele.CmdUsed.contains(e.getPlayer().getUniqueId()))
	{
		e.getPlayer().sendMessage(ChatColor.RED +"Teleportation canceled");
		if(!moved.contains(e.getPlayer().getUniqueId())){
			moved.add(e.getPlayer().getUniqueId());
			tele.CmdUsed.remove(e.getPlayer().getUniqueId());
			}
		
		
	}
}
}