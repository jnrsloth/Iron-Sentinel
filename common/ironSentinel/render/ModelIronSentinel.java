package ironSentinel.render;

import ironSentinel.entity.EntitySentinel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelIronSentinel extends ModelBase
{
    /** The head model for the iron golem. */
    public ModelRenderer ironSentinelHead;

    /** The body model for the iron golem. */
    public ModelRenderer ironSentinelBody;

    /** The right arm model for the iron golem. */
    public ModelRenderer ironSentinelRightArm;

    /** The left arm model for the iron golem. */
    public ModelRenderer ironSentinelLeftArm;

    /** The left leg model for the Iron Golem. */
    public ModelRenderer ironSentinelLeftLeg;

    /** The right leg model for the Iron Golem. */
    public ModelRenderer ironSentinelRightLeg;

    public ModelIronSentinel()
    {
        this(0.0F);
    }

    public ModelIronSentinel(float par1)
    {
        this(par1, -7.0F);
    }

    public ModelIronSentinel(float par1, float par2)
    {
        short short1 = 128;
        short short2 = 128;
        this.ironSentinelHead = (new ModelRenderer(this)).setTextureSize(short1, short2);
        this.ironSentinelHead.setRotationPoint(0.0F, 0.0F + par2, -2.0F);
        this.ironSentinelHead.setTextureOffset(0, 0).addBox(-4.0F, -12.0F, -5.5F, 8, 10, 8, par1);
        this.ironSentinelHead.setTextureOffset(24, 0).addBox(-1.0F, -5.0F, -7.5F, 2, 4, 2, par1);
        this.ironSentinelBody = (new ModelRenderer(this)).setTextureSize(short1, short2);
        this.ironSentinelBody.setRotationPoint(0.0F, 0.0F + par2, 0.0F);
        this.ironSentinelBody.setTextureOffset(0, 40).addBox(-9.0F, -2.0F, -6.0F, 18, 12, 11, par1);
        this.ironSentinelBody.setTextureOffset(0, 70).addBox(-4.5F, 10.0F, -3.0F, 9, 5, 6, par1 + 0.5F);
        this.ironSentinelRightArm = (new ModelRenderer(this)).setTextureSize(short1, short2);
        this.ironSentinelRightArm.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.ironSentinelRightArm.setTextureOffset(60, 21).addBox(-13.0F, -2.5F, -3.0F, 4, 30, 6, par1);
        this.ironSentinelLeftArm = (new ModelRenderer(this)).setTextureSize(short1, short2);
        this.ironSentinelLeftArm.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.ironSentinelLeftArm.setTextureOffset(60, 58).addBox(9.0F, -2.5F, -3.0F, 4, 30, 6, par1);
        this.ironSentinelLeftLeg = (new ModelRenderer(this, 0, 22)).setTextureSize(short1, short2);
        this.ironSentinelLeftLeg.setRotationPoint(-4.0F, 18.0F + par2, 0.0F);
        this.ironSentinelLeftLeg.setTextureOffset(37, 0).addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, par1);
        this.ironSentinelRightLeg = (new ModelRenderer(this, 0, 22)).setTextureSize(short1, short2);
        this.ironSentinelRightLeg.mirror = true;
        this.ironSentinelRightLeg.setTextureOffset(60, 0).setRotationPoint(5.0F, 18.0F + par2, 0.0F);
        this.ironSentinelRightLeg.addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, par1);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
        this.ironSentinelHead.render(par7);
        this.ironSentinelBody.render(par7);
        this.ironSentinelLeftLeg.render(par7);
        this.ironSentinelRightLeg.render(par7);
        this.ironSentinelRightArm.render(par7);
        this.ironSentinelLeftArm.render(par7);
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
    {
        this.ironSentinelHead.rotateAngleY = par4 / (180F / (float)Math.PI);
        this.ironSentinelHead.rotateAngleX = par5 / (180F / (float)Math.PI);
        this.ironSentinelLeftLeg.rotateAngleX = -1.5F * this.func_78172_a(par1, 13.0F) * par2;
        this.ironSentinelRightLeg.rotateAngleX = 1.5F * this.func_78172_a(par1, 13.0F) * par2;
        this.ironSentinelLeftLeg.rotateAngleY = 0.0F;
        this.ironSentinelRightLeg.rotateAngleY = 0.0F;
    }

    /**
     * Used for easily adding entity-dependent animations. The second and third float params here are the same second
     * and third as in the setRotationAngles method.
     */
    public void setLivingAnimations(EntityLiving par1EntityLiving, float par2, float par3, float par4)
    {
        EntitySentinel entityironSentinel = (EntitySentinel)par1EntityLiving;
        int i = entityironSentinel.getAttackTimer();

        if (i > 0)
        {
            this.ironSentinelRightArm.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F);
            this.ironSentinelLeftArm.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F);
        }
        else
        {
            int j = entityironSentinel.getHoldRoseTick();

            if (j > 0)
            {
                this.ironSentinelRightArm.rotateAngleX = -0.8F + 0.025F * this.func_78172_a((float)j, 70.0F);
                this.ironSentinelLeftArm.rotateAngleX = 0.0F;
            }
            else
            {
                this.ironSentinelRightArm.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(par2, 13.0F)) * par3;
                this.ironSentinelLeftArm.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3;
            }
        }
    }

    private float func_78172_a(float par1, float par2)
    {
        return (Math.abs(par1 % par2 - par2 * 0.5F) - par2 * 0.25F) / (par2 * 0.25F);
    }
}
