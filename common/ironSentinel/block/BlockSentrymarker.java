package ironSentinel.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import ironSentinel.lib.Reference;
import ironSentinel.lib.Strings;

public class BlockSentrymarker extends Block {

    public BlockSentrymarker(int id) {
        
        super(id, Material.plants);
        blockHardness = 1.5F;
        setStepSound(Block.soundMetalFootstep);
        setUnlocalizedName(Strings.SENTRYMARKER_NAME);
        setCreativeTab(CreativeTabs.tabBlock);
        // TODO Auto-generated constructor stub
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {

        blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName2());
    }
}