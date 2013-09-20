package ironSentinel.gui;

import ironSentinel.container.ContainerSentryMarker;
import ironSentinel.lib.Reference;
import ironSentinel.lib.Textures;
import ironSentinel.tileentity.TileEntitySentryMarker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;


public class GuiSentryMarker extends GuiContainer{
	public static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, Textures.MARKER_GUI);
    
	public int xSizeOfTexture = 176;
    public int ySizeOfTexture = 165;
    
	public GuiSentryMarker(InventoryPlayer invPlayer, TileEntitySentryMarker entity) {
		super(new ContainerSentryMarker(invPlayer,entity));
			 xSizeOfTexture = 176;
			 ySizeOfTexture = 165;
	}
    
   
    @Override
    public void drawGuiContainerBackgroundLayer(float f, int j, int i) {
    	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    	Minecraft.getMinecraft().func_110434_K().func_110577_a(texture);
    	drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSizeOfTexture, ySizeOfTexture);
    }
        
    
    
}
