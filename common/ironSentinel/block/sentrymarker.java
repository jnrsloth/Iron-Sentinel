package ironSentinel.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import ironSentinel.lib.Strings;
public class sentrymarker extends Block {

    public sentrymarker(int id) {
        
        super(id, Material.plants);
        blockHardness = 1.5F;
        setStepSound(Block.soundMetalFootstep);
        setUnlocalizedName(Strings.SENTRY_MARKER);
        setCreativeTab(CreativeTabs.tabBlock);
        // TODO Auto-generated constructor stub
    }

}
agf