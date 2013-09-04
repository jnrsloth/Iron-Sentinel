package ironSentinel.block;

import ironSentinel.entity.EntitySentinel;
import ironSentinel.lib.Reference;
import ironSentinel.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRedPumpkin extends BlockDirectional
{
    /** Boolean used to separate different states of blocks */
	@SideOnly(Side.CLIENT)
	public static Icon topIcon;
	@SideOnly(Side.CLIENT)
	public static Icon bottomIcon;
	@SideOnly(Side.CLIENT)
	public static Icon sideIcon;
	@SideOnly(Side.CLIENT)
	public static Icon frontIcon;

    protected BlockRedPumpkin(int par1, boolean par2)
    {
        super(par1, Material.pumpkin);
        this.setHardness(1.0F);
        this.setStepSound(Block.soundWoodFootstep);
        this.setLightValue(1.0F);
        this.setResistance(1.0F);
        this.setTickRandomly(true);
        //this.blockType = par2;
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setUnlocalizedName(Strings.REDPUMPKIN_NAME);
    }

    

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int metadata) {
    	if (side == 0){
    		return bottomIcon;
    	}
    	else if (side == 1){
    		return topIcon;
    	}
    	else if (side == 2){
    		return frontIcon;
    	}
    	else {
    		return sideIcon;
    	}
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);

        if (par1World.getBlockId(par2, par3 - 1, par4) == Block.blockIron.blockID && par1World.getBlockId(par2, par3 - 2, par4) == Block.blockIron.blockID)
            {
            boolean flag = par1World.getBlockId(par2 - 1, par3 - 1, par4) == Block.blockIron.blockID && par1World.getBlockId(par2 + 1, par3 - 1, par4) == Block.blockIron.blockID;
            boolean flag1 = par1World.getBlockId(par2, par3 - 1, par4 - 1) == Block.blockIron.blockID && par1World.getBlockId(par2, par3 - 1, par4 + 1) == Block.blockIron.blockID;

            if (flag || flag1)
            {
                par1World.setBlock(par2, par3, par4, 0, 0, 2);
                par1World.setBlock(par2, par3 - 1, par4, 0, 0, 2);
                par1World.setBlock(par2, par3 - 2, par4, 0, 0, 2);

                if (flag)
                {
                    par1World.setBlock(par2 - 1, par3 - 1, par4, 0, 0, 2);
                    par1World.setBlock(par2 + 1, par3 - 1, par4, 0, 0, 2);
                }
                else
                {
                    par1World.setBlock(par2, par3 - 1, par4 - 1, 0, 0, 2);
                    par1World.setBlock(par2, par3 - 1, par4 + 1, 0, 0, 2);
                }

                EntitySentinel entitySentinel = new EntitySentinel(par1World);
                entitySentinel.setPlayerCreated(true);
                entitySentinel.setLocationAndAngles((double)par2 + 0.5D, (double)par3 - 1.95D, (double)par4 + 0.5D, 0.0F, 0.0F);
                par1World.spawnEntityInWorld(entitySentinel);

            }
            }
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        int l = par1World.getBlockId(par2, par3, par4);
        Block block = Block.blocksList[l];
        return (block == null || block.isBlockReplaceable(par1World, par2, par3, par4)) && par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4);
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
    }
    
    @Override
    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister icon)
    {
        this.sideIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "pumpkin_Side");
        this.topIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "pumpkin_top");
        this.bottomIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "pumpkin_top");
        this.frontIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "pumpkin_red");
    }
}
