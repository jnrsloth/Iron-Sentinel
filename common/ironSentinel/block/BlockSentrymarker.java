package ironSentinel.block;

import ironSentinel.lib.Reference;
import ironSentinel.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
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
    public void registerIcons(IconRegister iconRegister) {

        this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName2());
    }
}