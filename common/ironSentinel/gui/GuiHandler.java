package ironSentinel.gui;

import ironSentinel.IronSentinel;
import ironSentinel.container.ContainerSentryMarker;
import ironSentinel.tileentity.TileEntitySentryMarker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler{

	public GuiHandler(){
		NetworkRegistry.instance().registerGuiHandler(IronSentinel.instance, this);
	}
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		switch(id){
		case 0:
			if(entity != null && entity instanceof TileEntitySentryMarker) {
				return new ContainerSentryMarker(player.inventory, (TileEntitySentryMarker) entity);
			} 
			else {
			return null;
			}
		default:
			return null;
		}
	}
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		switch(id){
		case 0:
			if(entity != null && entity instanceof TileEntitySentryMarker) {
				return new GuiSentryMarker(player.inventory, (TileEntitySentryMarker) entity);
			} 
			else {
			return null;
			}
		default:
			return null;
		}
	}
}