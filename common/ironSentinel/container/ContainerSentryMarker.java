package ironSentinel.container;

import ironSentinel.tileentity.TileEntitySentryMarker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;


public class ContainerSentryMarker extends Container{
	private TileEntitySentryMarker sentrymarker;
	
	public ContainerSentryMarker(InventoryPlayer invPlayer, TileEntitySentryMarker entity) {
		this.sentrymarker = entity;
	}
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return sentrymarker.isUseableByPlayer(player);
	}
}
