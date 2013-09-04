package ironSentinel.gui;

import ironSentinel.lib.Reference;
import ironSentinel.lib.Textures;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiSentryMarker extends GuiScreen{
	public static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, Textures.SENTINEL_SCREEN);
    
    
    public final int xSizeOfTexture = 176;
    public final int ySizeOfTexture = 88;
    
    public GuiSentryMarker (EntityPlayer Player){
        
    }
    @Override
    public void drawScreen(int x, int y, float f){
        
        drawDefaultBackground();
        
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        Minecraft.getMinecraft().func_110434_K().func_110577_a(texture);
        
        int xStart = (width - xSizeOfTexture) / 2;
        int yStart = (height - ySizeOfTexture) / 2;
        
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSizeOfTexture, ySizeOfTexture);
        
        super.drawScreen(x, y, f);
    }
    @Override
    public void initGui(){
        
    this.buttonList.clear();
    
    int xStart = (this.width - xSizeOfTexture) / 2;
    int yStart = (this.height - ySizeOfTexture) / 2;
    this.buttonList.add(new GuiButton(0, xStart+ 40, yStart + 40, 100, 20, "no use"));
    }
}
