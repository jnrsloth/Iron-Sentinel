package ironSentinel.render;

import ironSentinel.entity.EntitySentinel;
import ironSentinel.lib.Reference;
import ironSentinel.lib.Textures;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderIronSentinel extends RenderLiving
{
    private static final ResourceLocation textureLocation = new ResourceLocation(Reference.MOD_ID + ":" + Textures.SENTINEL_TEXTURE);

    /** Iron Sentinel's Model. Taken exactly from the Iron Golem */
    private final ModelIronSentinel ironSentinelModel;

    public RenderIronSentinel()
    {
        super(new ModelIronSentinel(), 0.5F);
        this.ironSentinelModel = (ModelIronSentinel)this.mainModel;
    }

    /**
     * Renders the Iron Golem.
     */
    public void doRenderIronSentinel(EntitySentinel par1EntitySentinel, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntitySentinel, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation func_110898_a(EntitySentinel par1EntitySentinel)
    {
        return textureLocation;
    }

    /**
     * Rotates Iron Golem corpse.
     */
    protected void rotateIronGolemCorpse(EntitySentinel par1EntitySentinel, float par2, float par3, float par4)
    {
        super.rotateCorpse(par1EntitySentinel, par2, par3, par4);

        if ((double)par1EntitySentinel.limbYaw >= 0.01D)
        {
            float f3 = 13.0F;
            float f4 = par1EntitySentinel.limbSwing - par1EntitySentinel.limbYaw * (1.0F - par4) + 6.0F;
            float f5 = (Math.abs(f4 % f3 - f3 * 0.5F) - f3 * 0.25F) / (f3 * 0.25F);
            GL11.glRotatef(6.5F * f5, 0.0F, 0.0F, 1.0F);
        }
    }

    /**
     * Renders Iron Golem Equipped items.
     */
    protected void renderIronGolemEquippedItems(EntitySentinel par1EntitySentinel, float par2)
    {
        super.renderEquippedItems(par1EntitySentinel, par2);

        if (par1EntitySentinel.getHoldRoseTick() != 0)
        {
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glPushMatrix();
            GL11.glRotatef(5.0F + 180.0F * this.ironSentinelModel.ironSentinelRightArm.rotateAngleX / (float)Math.PI, 1.0F, 0.0F, 0.0F);
            GL11.glTranslatef(-0.6875F, 1.25F, -0.9375F);
            GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
            float f1 = 0.8F;
            GL11.glScalef(f1, -f1, f1);
            int i = par1EntitySentinel.getBrightnessForRender(par2);
            int j = i % 65536;
            int k = i / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.func_110776_a(TextureMap.field_110575_b);
            this.renderBlocks.renderBlockAsItem(Block.plantRed, 0, 1.0F);
            GL11.glPopMatrix();
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        }
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.doRenderIronSentinel((EntitySentinel)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    protected void renderEquippedItems(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.renderIronGolemEquippedItems((EntitySentinel)par1EntityLivingBase, par2);
    }

    protected void rotateCorpse(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4)
    {
        this.rotateIronGolemCorpse((EntitySentinel)par1EntityLivingBase, par2, par3, par4);
    }

    public void renderPlayer(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9)
    {
        this.doRenderIronSentinel((EntitySentinel)par1EntityLivingBase, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation func_110775_a(Entity par1Entity)
    {
        return this.func_110898_a((EntitySentinel)par1Entity);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.doRenderIronSentinel((EntitySentinel)par1Entity, par2, par4, par6, par8, par9);
    }
}
