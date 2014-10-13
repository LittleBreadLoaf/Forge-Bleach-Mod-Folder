package littlebreadloaf.bleach.player;

import static net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED;
import static net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.player.models.ModelPlayerHollow;
import net.minecraft.block.Block;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.opengl.GL11;

public class HollowRenderer extends RenderPlayer
{
	private static final ResourceLocation texture1_overlay = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/player_hollow_1_overlay.png");
	private static final ResourceLocation texture1 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/player_hollow_1.png");
	
	protected ModelPlayerHollow model;

	public HollowRenderer()
	{
		super();
		 this.mainModel = new ModelPlayerHollow();
		 this.modelBipedMain = (ModelBiped)this.mainModel;
		 this.modelArmorChestplate = new ModelBiped(1.0F);
		 this.modelArmor = new ModelBiped(0.5F);
		 this.renderManager = RenderManager.instance;
		 this.renderPassModel = mainModel;
	}





	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		if(entity instanceof AbstractClientPlayer)
		{
			AbstractClientPlayer player = (AbstractClientPlayer)entity;
			ExtendedPlayer props = ExtendedPlayer.get(player);
		if(props.getFaction() == 3)
			return texture1;
		else
			return player.getLocationSkin();
		}
		
		return null;
		
		
	}
	
	 public static final float[][] colorTable = new float[][] {{1.0F, 1.0F, 1.0F}, {0.85F, 0.5F, 0.2F}, {0.7F, 0.3F, 0.85F}, {0.4F, 0.6F, 0.85F}, {0.9F, 0.9F, 0.2F}, {0.5F, 0.8F, 0.1F}, {0.95F, 0.5F, 0.65F}, {0.3F, 0.3F, 0.3F}, {0.6F, 0.6F, 0.6F}, {0.3F, 0.5F, 0.6F}, {0.5F, 0.25F, 0.7F}, {0.2F, 0.3F, 0.7F}, {0.4F, 0.3F, 0.2F}, {0.4F, 0.5F, 0.2F}, {0.6F, 0.2F, 0.2F}, {0.1F, 0.1F, 0.1F}};
	  
		@Override
		protected int shouldRenderPass(EntityLivingBase entity, int par2, float par3)
		{
			if(entity instanceof AbstractClientPlayer)
			{
				AbstractClientPlayer player = (AbstractClientPlayer)entity;
				ExtendedPlayer props = ExtendedPlayer.get(player);

			if(props.getFaction() == 3)
			{
				
				
					if (par2 != 0)
			        {
			            return -1;
			        }
			        else
			        {
			        	int blug = props.getHColor();
			            this.bindTexture(texture1_overlay);
			            GL11.glColor3f(colorTable[blug][0], colorTable[blug][1], colorTable[blug][2]);
			            

			            return 1;
			        }
					     
			    
			    
			}
			else
			{
				return super.shouldRenderPass(player, par2, par3);
			}
		}
			return -1;
		}

		
		@Override
		protected void func_82408_c(AbstractClientPlayer par1AbstractClientPlayer, int par2, float par3)
	    {
			ExtendedPlayer props = ExtendedPlayer.get(par1AbstractClientPlayer);
			if(props.getFaction() != 3)
				super.func_82408_c(par1AbstractClientPlayer, par2, par3);
	    }
		
		
		@Override
		  /**
	     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
	     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
	     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
	     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
	     */
	    public void doRender(AbstractClientPlayer par1AbstractClientPlayer, double par2, double par4, double par6, float par8, float par9)
	    {
	    	ExtendedPlayer props = ExtendedPlayer.get(par1AbstractClientPlayer);
	    	System.out.println(props.getFaction());
	    	if(props.getFaction() == 3)
	    	{
	    		mainModel = new ModelPlayerHollow();
	    		modelBipedMain = new ModelPlayerHollow();
	    	}
	    	else
	    	{
	    		modelBipedMain = new ModelBiped();
	    		mainModel = new ModelBiped();
	    	}
	    	
			super.doRender(par1AbstractClientPlayer, par2, par4, par6, par8, par9);

	    		if (MinecraftForge.EVENT_BUS.post(new RenderPlayerEvent.Pre(par1AbstractClientPlayer, this, par9))) return;
	            GL11.glColor3f(1.0F, 1.0F, 1.0F);
	            ItemStack itemstack = par1AbstractClientPlayer.inventory.getCurrentItem();
	             this.modelBipedMain.heldItemRight = this.modelArmorChestplate.heldItemRight = this.modelArmor.heldItemRight = itemstack != null ? 1 : 0;

	            if (itemstack != null && par1AbstractClientPlayer.getItemInUseCount() > 0)
	            {
	                EnumAction enumaction = itemstack.getItemUseAction();

	                if (enumaction == EnumAction.block)
	                {
	                     this.modelBipedMain.heldItemRight = this.modelArmorChestplate.heldItemRight = this.modelArmor.heldItemRight = 3;
	                }
	                else if (enumaction == EnumAction.bow)
	                {
	                     this.modelBipedMain.aimedBow = this.modelArmorChestplate.aimedBow = this.modelArmor.aimedBow = true;
	                }
	            }

	             this.modelBipedMain.isSneak = this.modelArmorChestplate.isSneak = this.modelArmor.isSneak = par1AbstractClientPlayer.isSneaking();
	            double d3 = par4 - (double)par1AbstractClientPlayer.yOffset;

	            if (par1AbstractClientPlayer.isSneaking() && !(par1AbstractClientPlayer instanceof EntityPlayerSP))
	            {
	                d3 -= 0.125D;
	            }

	             this.modelBipedMain.aimedBow = this.modelArmorChestplate.aimedBow = this.modelArmor.aimedBow = false;
	             this.modelBipedMain.isSneak =  this.modelArmorChestplate.isSneak = this.modelArmor.isSneak =false;
	             this.modelBipedMain.heldItemRight = this.modelArmorChestplate.heldItemRight = this.modelArmor.heldItemRight = 0;
	            MinecraftForge.EVENT_BUS.post(new RenderPlayerEvent.Post(par1AbstractClientPlayer, this, par9));
	       
	    	
	    }
	    
	    
		@Override
	    /**
	     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
	     * entityLiving, partialTickTime
	     */
	    protected void preRenderCallback(AbstractClientPlayer par1AbstractClientPlayer, float par2)
	    {
	        float f1 = 0.9375F;
	        GL11.glScalef(f1, f1, f1);
	    }
	    @Override
	    protected void func_96449_a(AbstractClientPlayer par1AbstractClientPlayer, double par2, double par4, double par6, String par8Str, float par9, double par10)
	    {
	    	super.func_96449_a(par1AbstractClientPlayer, par2, par4, par6, par8Str, par9, par10);
	    }
	    @Override
	    public void renderFirstPersonArm(EntityPlayer par1EntityPlayer)
	    {
	    	super.renderFirstPersonArm(par1EntityPlayer);
	    }
	    
	    @Override
	    /**
	     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
	     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
	     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
	     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
	     */
	    public void doRender(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9)
	    {
	        this.doRender((AbstractClientPlayer)par1EntityLivingBase, par2, par4, par6, par8, par9);
	    }
	    
	    @Override
	    /**
	     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
	     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
	     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
	     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
	     */
	    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	    {
	        this.doRender((EntityLivingBase)par1Entity, par2, par4, par6, par8, par9);
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
//	    
//	    protected void renderEquippedItems(AbstractClientPlayer par1AbstractClientPlayer, float par2)
//	    {
//	    	 RenderPlayerEvent.Specials.Pre event = new RenderPlayerEvent.Specials.Pre(par1AbstractClientPlayer, this, par2);
//	         if (MinecraftForge.EVENT_BUS.post(event))
//	         {
//	             return;
//	         }
//
//	         GL11.glColor3f(1.0F, 1.0F, 1.0F);
//	         super.renderEquippedItems(par1AbstractClientPlayer, par2);
//	         super.renderArrowsStuckInEntity(par1AbstractClientPlayer, par2);
//	         ItemStack itemstack = par1AbstractClientPlayer.inventory.armorItemInSlot(3);
//
//	         if (itemstack != null && event.renderHelmet)
//	         {
//	             GL11.glPushMatrix();
//	             this.modelBipedMain.bipedHead.postRender(0.0625F);
//	             float f1;
//
//	             if (itemstack.getItem() instanceof ItemBlock)
//	             {
//	                 IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, EQUIPPED);
//	                 boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(EQUIPPED, itemstack, BLOCK_3D));
//
//	                 if (is3D || RenderBlocks.renderItemIn3d(Block.getBlockFromItem(itemstack.getItem()).getRenderType()))
//	                 {
//	                     f1 = 0.625F;
//	                     GL11.glTranslatef(0.0F, -0.25F, 0.0F);
//	                     GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
//	                     GL11.glScalef(f1, -f1, -f1);
//	                 }
//
//	                 this.renderManager.itemRenderer.renderItem(par1AbstractClientPlayer, itemstack, 0);
//	             }
//	             else if (itemstack.getItem() == Items.skull)
//	             {
//	                 f1 = 1.0625F;
//	                 GL11.glScalef(f1, -f1, -f1);
//	                 String s = "";
//
//	                 if (itemstack.hasTagCompound() && itemstack.getTagCompound().hasKey("SkullOwner", 8))
//	                 {
//	                     s = itemstack.getTagCompound().getString("SkullOwner");
//	                 }
//
//	                 TileEntitySkullRenderer.field_147536_b.func_147530_a(-0.5F, 0.0F, -0.5F, 1, 180.0F, itemstack.getItemDamage(), s);
//	             }
//
//	             GL11.glPopMatrix();
//	         }
//
//	         float f3;
//
//	         if (par1AbstractClientPlayer.getCommandSenderName().equals("deadmau5") && par1AbstractClientPlayer.getTextureSkin().isTextureUploaded())
//	         {
//	             this.bindTexture(par1AbstractClientPlayer.getLocationSkin());
//
//	             for (int j = 0; j < 2; ++j)
//	             {
//	                 float f10 = par1AbstractClientPlayer.prevRotationYaw + (par1AbstractClientPlayer.rotationYaw - par1AbstractClientPlayer.prevRotationYaw) * par2 - (par1AbstractClientPlayer.prevRenderYawOffset + (par1AbstractClientPlayer.renderYawOffset - par1AbstractClientPlayer.prevRenderYawOffset) * par2);
//	                 float f2 = par1AbstractClientPlayer.prevRotationPitch + (par1AbstractClientPlayer.rotationPitch - par1AbstractClientPlayer.prevRotationPitch) * par2;
//	                 GL11.glPushMatrix();
//	                 GL11.glRotatef(f10, 0.0F, 1.0F, 0.0F);
//	                 GL11.glRotatef(f2, 1.0F, 0.0F, 0.0F);
//	                 GL11.glTranslatef(0.375F * (float)(j * 2 - 1), 0.0F, 0.0F);
//	                 GL11.glTranslatef(0.0F, -0.375F, 0.0F);
//	                 GL11.glRotatef(-f2, 1.0F, 0.0F, 0.0F);
//	                 GL11.glRotatef(-f10, 0.0F, 1.0F, 0.0F);
//	                 f3 = 1.3333334F;
//	                 GL11.glScalef(f3, f3, f3);
//	                 this.modelBipedMain.renderEars(0.0625F);
//	                 GL11.glPopMatrix();
//	             }
//	         }
//
//	         boolean flag = par1AbstractClientPlayer.getTextureCape().isTextureUploaded();
//	         flag = event.renderCape && flag;
//	         float f5;
//
//	         if (flag && !par1AbstractClientPlayer.isInvisible() && !par1AbstractClientPlayer.getHideCape())
//	         {
//	             this.bindTexture(par1AbstractClientPlayer.getLocationCape());
//	             GL11.glPushMatrix();
//	             GL11.glTranslatef(0.0F, 0.0F, 0.125F);
//	             double d3 = par1AbstractClientPlayer.field_71091_bM + (par1AbstractClientPlayer.field_71094_bP - par1AbstractClientPlayer.field_71091_bM) * (double)par2 - (par1AbstractClientPlayer.prevPosX + (par1AbstractClientPlayer.posX - par1AbstractClientPlayer.prevPosX) * (double)par2);
//	             double d4 = par1AbstractClientPlayer.field_71096_bN + (par1AbstractClientPlayer.field_71095_bQ - par1AbstractClientPlayer.field_71096_bN) * (double)par2 - (par1AbstractClientPlayer.prevPosY + (par1AbstractClientPlayer.posY - par1AbstractClientPlayer.prevPosY) * (double)par2);
//	             double d0 = par1AbstractClientPlayer.field_71097_bO + (par1AbstractClientPlayer.field_71085_bR - par1AbstractClientPlayer.field_71097_bO) * (double)par2 - (par1AbstractClientPlayer.prevPosZ + (par1AbstractClientPlayer.posZ - par1AbstractClientPlayer.prevPosZ) * (double)par2);
//	             f5 = par1AbstractClientPlayer.prevRenderYawOffset + (par1AbstractClientPlayer.renderYawOffset - par1AbstractClientPlayer.prevRenderYawOffset) * par2;
//	             double d1 = (double)MathHelper.sin(f5 * (float)Math.PI / 180.0F);
//	             double d2 = (double)(-MathHelper.cos(f5 * (float)Math.PI / 180.0F));
//	             float f6 = (float)d4 * 10.0F;
//
//	             if (f6 < -6.0F)
//	             {
//	                 f6 = -6.0F;
//	             }
//
//	             if (f6 > 32.0F)
//	             {
//	                 f6 = 32.0F;
//	             }
//
//	             float f7 = (float)(d3 * d1 + d0 * d2) * 100.0F;
//	             float f8 = (float)(d3 * d2 - d0 * d1) * 100.0F;
//
//	             if (f7 < 0.0F)
//	             {
//	                 f7 = 0.0F;
//	             }
//
//	             float f9 = par1AbstractClientPlayer.prevCameraYaw + (par1AbstractClientPlayer.cameraYaw - par1AbstractClientPlayer.prevCameraYaw) * par2;
//	             f6 += MathHelper.sin((par1AbstractClientPlayer.prevDistanceWalkedModified + (par1AbstractClientPlayer.distanceWalkedModified - par1AbstractClientPlayer.prevDistanceWalkedModified) * par2) * 6.0F) * 32.0F * f9;
//
//	             if (par1AbstractClientPlayer.isSneaking())
//	             {
//	                 f6 += 25.0F;
//	             }
//
//	             GL11.glRotatef(6.0F + f7 / 2.0F + f6, 1.0F, 0.0F, 0.0F);
//	             GL11.glRotatef(f8 / 2.0F, 0.0F, 0.0F, 1.0F);
//	             GL11.glRotatef(-f8 / 2.0F, 0.0F, 1.0F, 0.0F);
//	             GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
//	             this.modelBipedMain.renderCloak(0.0625F);
//	             GL11.glPopMatrix();
//	         }
//
//	         ItemStack itemstack1 = par1AbstractClientPlayer.inventory.getCurrentItem();
//
//	         if (itemstack1 != null && event.renderItem)
//	         {
//	             GL11.glPushMatrix();
//	             this.modelBipedMain.bipedRightArm.postRender(0.0625F);
//	             GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
//
//	             if (par1AbstractClientPlayer.fishEntity != null)
//	             {
//	                 itemstack1 = new ItemStack(Items.stick);
//	             }
//
//	             EnumAction enumaction = null;
//
//	             if (par1AbstractClientPlayer.getItemInUseCount() > 0)
//	             {
//	                 enumaction = itemstack1.getItemUseAction();
//	             }
//
//	             IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack1, EQUIPPED);
//	             boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(EQUIPPED, itemstack1, BLOCK_3D));
//
//	             if (is3D || itemstack1.getItem() instanceof ItemBlock && RenderBlocks.renderItemIn3d(Block.getBlockFromItem(itemstack1.getItem()).getRenderType()))
//	             {
//	                 f3 = 0.5F;
//	                 GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
//	                 f3 *= 0.75F;
//	                 GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
//	                 GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
//	                 GL11.glScalef(-f3, -f3, f3);
//	             }
//	             else if (itemstack1.getItem() == Items.bow)
//	             {
//	                 f3 = 0.625F;
//	                 GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
//	                 GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
//	                 GL11.glScalef(f3, -f3, f3);
//	                 GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
//	                 GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
//	             }
//	             else if (itemstack1.getItem().isFull3D())
//	             {
//	                 f3 = 0.625F;
//
//	                 if (itemstack1.getItem().shouldRotateAroundWhenRendering())
//	                 {
//	                     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
//	                     GL11.glTranslatef(0.0F, -0.125F, 0.0F);
//	                 }
//
//	                 if (par1AbstractClientPlayer.getItemInUseCount() > 0 && enumaction == EnumAction.block)
//	                 {
//	                     GL11.glTranslatef(0.05F, 0.0F, -0.1F);
//	                     GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
//	                     GL11.glRotatef(-10.0F, 1.0F, 0.0F, 0.0F);
//	                     GL11.glRotatef(-60.0F, 0.0F, 0.0F, 1.0F);
//	                 }
//
//	                 GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
//	                 GL11.glScalef(f3, -f3, f3);
//	                 GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
//	                 GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
//	             }
//	             else
//	             {
//	                 f3 = 0.375F;
//	                 GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
//	                 GL11.glScalef(f3, f3, f3);
//	                 GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
//	                 GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
//	                 GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
//	             }
//
//	             float f4;
//	             int k;
//	             float f12;
//
//	             if (itemstack1.getItem().requiresMultipleRenderPasses())
//	             {
//	                 for (k = 0; k < itemstack1.getItem().getRenderPasses(itemstack1.getItemDamage()); ++k)
//	                 {
//	                     int i = itemstack1.getItem().getColorFromItemStack(itemstack1, k);
//	                     f12 = (float)(i >> 16 & 255) / 255.0F;
//	                     f4 = (float)(i >> 8 & 255) / 255.0F;
//	                     f5 = (float)(i & 255) / 255.0F;
//	                     GL11.glColor4f(f12, f4, f5, 1.0F);
//	                     this.renderManager.itemRenderer.renderItem(par1AbstractClientPlayer, itemstack1, k);
//	                 }
//	             }
//	             else
//	             {
//	                 k = itemstack1.getItem().getColorFromItemStack(itemstack1, 0);
//	                 float f11 = (float)(k >> 16 & 255) / 255.0F;
//	                 f12 = (float)(k >> 8 & 255) / 255.0F;
//	                 f4 = (float)(k & 255) / 255.0F;
//	                 GL11.glColor4f(f11, f12, f4, 1.0F);
//	                 this.renderManager.itemRenderer.renderItem(par1AbstractClientPlayer, itemstack1, 0);
//	             }
//
//	             GL11.glPopMatrix();
//	         }
//	         MinecraftForge.EVENT_BUS.post(new RenderPlayerEvent.Specials.Post(par1AbstractClientPlayer, this, par2));
//	     
//	    }
}
