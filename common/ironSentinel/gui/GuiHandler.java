package ironSentinel.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{
	NetworkRegistry.instance().registerGuiHandler(Tutorial.instance, this);
	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {

	}
	
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		switch(id) {
		case 0:
		
		return new GuiSentryMarker(player);
		
		}
		
		default:
			return null;
			
		}
		}
	}
}
