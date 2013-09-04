package ironSentinel.block;

import ironSentinel.IronSentinel;
import ironSentinel.lib.Reference;
import ironSentinel.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSentrymarker extends Block {

    public BlockSentrymarker(int var1)
    {
        super(var1, Material.plants);
        this.setHardness(1.5F);
        this.setResistance(1.0F);
        this.setLightValue(1.0F);
        this.setStepSound(Block.soundMetalFootstep);
        this.setUnlocalizedName(Strings.SENTRYMARKER_NAME);
        this.setCreativeTab(CreativeTabs.tabBlock);
        
    }
   
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister icon) {

        this.blockIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "sentrymarker");
    }
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
    	if(!world.isRemote) {
    		FMLNetworkHandler.openGui(player, IronSentinel.instance, 0, world, x, y, z);
    	}
    	return true;
    }
}