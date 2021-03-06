package net.badlion.potpvp.tasks;

import net.badlion.potpvp.managers.MatchMakingManager;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class MatchInventoryRemovalTask extends BukkitRunnable {

	private Player player;

	public MatchInventoryRemovalTask(Player player) {
		this.player = player;
	}

	@Override
	public void run() {
		MatchMakingManager.removeOpponentInventory(this.player);
	}

}
