package ironSentinel.block;

import ironSentinel.entity.EntitySentinel;
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
    /** Boolean used to seperate different states of blocks */
    private boolean blockType;
    @SideOnly(Side.CLIENT)
    private Icon field_94474_b;
    @SideOnly(Side.CLIENT)
    private Icon field_94475_c;

    protected BlockRedPumpkin(int par1, boolean par2)
    {
        super(par1, Material.pumpkin);
        this.setTickRandomly(true);
        this.blockType = par2;
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.field_94474_b : (par1 == 0 ? this.field_94474_b : (par2 == 2 && par1 == 2 ? this.field_94475_c : (par2 == 3 && par1 == 5 ? this.field_94475_c : (par2 == 0 && par1 == 3 ? this.field_94475_c : (par2 == 1 && par1 == 4 ? this.field_94475_c : this.blockIcon)))));
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

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.field_94475_c = par1IconRegister.registerIcon(this.blockType ? "pumpkin_face" : "pumpkin_face");
        this.field_94474_b = par1IconRegister.registerIcon("pumpkin_top");
        this.blockIcon = par1IconRegister.registerIcon("pumpkin_side");
    }
}
