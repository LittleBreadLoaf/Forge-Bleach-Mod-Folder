package littlebreadloaf.events;

import littlebreadloaf.proxies.CommonProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class DataHandler 
{
	
	public static CommonProxy proxy = new CommonProxy();
	
	@ForgeSubscribe
	public void onEntityConstructing(EntityConstructing event)
	{
		if (event.entity instanceof EntityPlayer &&
				event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME) == null)
				{
					event.entity.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer((EntityPlayer) event.entity));
				}
	}
	
	@ForgeSubscribe
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) 
		{
			NBTTagCompound playerData = proxy.getEntityData(((EntityPlayer)event.entity).username);
			if(playerData != null)
			{
				((ExtendedPlayer)(event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).loadNBTData(playerData);
			}
			((ExtendedPlayer)(event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).syncExtendedProperties();
			if(((ExtendedPlayer)(event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).getZTex() == 5)
			{
				((ExtendedPlayer)(event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).randomTexture();
			}
		}
		
	}
	
	
	@ForgeSubscribe
	public void onLivingDeathEvent(LivingDeathEvent event)
	{
		if(!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
		{
			NBTTagCompound playerData = new NBTTagCompound();
			((ExtendedPlayer)(event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).saveNBTData(playerData);
			proxy.storeEntityData(((EntityPlayer)event.entity).username, playerData);
		}
	}
	
	
	
	/**@ForgeSubscribe
	public void onLivingHurtEvent(EntityLivingBase entity, DamageSource source, float amount)
	{
		EntityPlayer player = (EntityPlayer)entity;
		ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		ItemStack heldItem = player.getCurrentEquippedItem();
		if(heldItem != null)
		{
			if(heldItem.getItem() == Items.shikaipoison)
			{
				if(source.getEntity() instanceof EntityLivingBase)
				{
					EntityLivingBase var5 = (EntityLivingBase) source.getEntity();
					var5.addPotionEffect(new PotionEffect(Potion.poison.id, 80, 1));
				}
			}
		}
		
	}
	*/
	
	

}
