package littlebreadloaf.events;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Random;

import littlebreadloaf.armor.Armor;
import littlebreadloaf.items.Items;
import littlebreadloaf.libraries.BleachModInfo;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;

public class ExtendedPlayer implements IExtendedEntityProperties
{
	public final static String EXT_PROP_NAME = "ExtendedPlayer";
	
	private final EntityPlayer player;
	private Random rand = new Random();
	private int SoulCap;
	private float SoulEnergy;
	private float SoulXP;
	private int Flame = 0;
	private int Ice = 0;
	private int Heal = 0;
	private int Poison = 0;
	private int Earth = 0;
	private int Wind = 0;
	private int Light = 0;
	private int Dark = 0;
	private int ZTotal = 0;
	private int ZType = 0;
	private int ZTex = 5;
	private String ZName = "";
	
	private int Mask = rand.nextInt(4);
	private int MaskLines = rand.nextInt(3);
	private int MaskColor = 333333 + rand.nextInt(333333) - rand.nextInt(333333);
	
	private float MaskTime;
	private int MaskTimeCap;
	private int MaskXP;
	
	public ExtendedPlayer(EntityPlayer player)
	{
		this.player = player;
		this.SoulEnergy = this.SoulCap = 50;
	}
	
	@Override 
	public void saveNBTData(NBTTagCompound nbt)
	{
		nbt.setInteger("SoulCap", this.SoulCap);
		nbt.setFloat("SoulEnergy", this.SoulEnergy);
		nbt.setFloat("SoulXP", this.SoulXP);
		
        nbt.setInteger("Flame", this.Flame);
        nbt.setInteger("Ice", this.Ice);
        nbt.setInteger("Heal", this.Heal);
        nbt.setInteger("Poison", this.Poison);
        nbt.setInteger("Earth", this.Earth);
        nbt.setInteger("Wind", this.Wind);
        nbt.setInteger("Light", this.Light);
        nbt.setInteger("Dark", this.Dark);
        nbt.setInteger("ZTotal", this.ZTotal);
        nbt.setInteger("ZType", this.ZType);
        nbt.setInteger("ZTex", this.ZTex);
        nbt.setString("ZName", this.ZName);
        
        nbt.setInteger("Mask", this.Mask);
        nbt.setInteger("MaskLines", this.MaskLines);
	}
	
	@Override
	public void loadNBTData(NBTTagCompound nbt)
	{
		this.SoulCap = nbt.getInteger("SoulCap");
		this.SoulEnergy = nbt.getFloat("SoulEnergy");
		this.SoulXP = nbt.getFloat("SoulXP");
		
		this.Flame = nbt.getInteger("Flame");
		this.Ice = nbt.getInteger("Ice");
		this.Heal = nbt.getInteger("Heal");
		this.Poison = nbt.getInteger("Poison");
		this.Earth = nbt.getInteger("Earth");
		this.Wind = nbt.getInteger("Wind");
		this.Light = nbt.getInteger("Light");
		this.Dark = nbt.getInteger("Dark");
		this.ZTotal = nbt.getInteger("ZTotal");
		this.ZType = nbt.getInteger("ZType");
		this.ZTex = nbt.getInteger("ZTex");
		this.ZName = nbt.getString("ZName");
		
		this.Mask = nbt.getInteger("Mask");
		this.MaskLines = nbt.getInteger("MaskLines");
	}
	
	@Override
	public void init(Entity entity, World world)
	{
		
	}
	
	public final void syncExtendedProperties()
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream(56);
		DataOutputStream outputStream = new DataOutputStream(bos);
		
		try
		{
			outputStream.writeInt(this.SoulCap);
			outputStream.writeFloat(this.SoulEnergy);
			outputStream.writeInt(this.Flame);
			outputStream.writeInt(this.Ice);
			outputStream.writeInt(this.Heal);
			outputStream.writeInt(this.Poison);
			outputStream.writeInt(this.Earth);
			outputStream.writeInt(this.Wind);
			outputStream.writeInt(this.Light);
			outputStream.writeInt(this.Dark);
			outputStream.writeInt(this.ZTotal);
			outputStream.writeUTF(this.ZName);
			outputStream.writeInt(this.Mask);
			outputStream.writeInt(this.MaskLines);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		
		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = BleachModInfo.CHANNEL;
		packet.data = bos.toByteArray();
		packet.length = bos.size();
		
		Side side = FMLCommonHandler.instance().getEffectiveSide();
		
		if(side == Side.SERVER)
		{
			EntityPlayerMP player1 = (EntityPlayerMP)player;
			PacketDispatcher.sendPacketToPlayer(packet, (Player)player1);
		}
	}
	
	
	
	
	
	public void setCurrentEnergy(float amount)
	{
		this.SoulEnergy = (amount < 1 ? amount : 1);
		this.syncExtendedProperties();
	}
	public void setMaxCap(int amount)
	{
		this.SoulCap = (amount > 0 ? amount : 0);
		this.syncExtendedProperties();
	}
	
	public void setCapMin()
	{
		this.SoulCap = 50;
		this.syncExtendedProperties();
	}
	public void setCapMax()
	{
		this.SoulCap = 1000;
		this.syncExtendedProperties();
	}
	public void setPoints(int var1, int amount)
	{
	if(var1 == 1)
	{
		Flame = amount;
	}
	if(var1 == 2)
	{
		 Ice = amount;
	}
	if(var1 == 3)
	{
		 Heal = amount;
	}
	if(var1 == 4)
	{
		 Poison = amount;
	}
	if(var1 == 5)
	{
		 Earth = amount;
	}
	if(var1 == 6)
	{
		 Wind = amount;
	}
	if(var1 == 7)
	{
		 Light = amount;
	}
	if(var1 == 8)
	{
		 Dark = amount;
	}
	else
	{
		 ZTotal = amount;
	}
	this.syncExtendedProperties();
		
	}
	
	public void setName(String name)
	{
		this.ZName = name;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void addCap()
	{
		this.SoulCap += 5;
		this.SoulXP = 0;	
		this.syncExtendedProperties();
	}
	public void addSXP(int amount)
	{
		this.SoulXP += (float)amount / (float)(this.SoulCap - 50);
	}
	
	
	
	
	
	
	
	
	
	
	
	public int getCurrentCap()
	{
		return this.SoulCap;
	}
	public float getCurrentEnergy()
	{
		return this.SoulEnergy;
	}
	public float getCurrentSXP()
	{
		return this.SoulXP;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean consumeEnergy(int amount)
	{
		boolean sufficient = amount <= (float)this.SoulEnergy * (float)this.SoulCap;
		
		this.SoulEnergy -= (amount < (float)this.SoulEnergy * (float)this.SoulCap ? (float)amount / (float)this.SoulCap : this.SoulEnergy);
		if(this.SoulEnergy <= 0)
		{
			this.SoulEnergy = 0;
		}
		this.syncExtendedProperties();
		return sufficient;
	}
	
	public boolean replenishEnergy(int amount)
	{
		boolean sufficient = this.SoulEnergy < 1;
		this.SoulEnergy += (this.SoulEnergy < 1 ? (float)amount / (float)this.SoulCap : this.SoulEnergy);
		if(this.SoulEnergy >= 1)
		{
			this.SoulEnergy = 1;
		}
		this.syncExtendedProperties();
		return sufficient;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public int getPoints(int var1)
	{
		if(var1 == 1)
		{
			return Flame;
		}
		if(var1 == 2)
		{
			return Ice;
		}
		if(var1 == 3)
		{
			return Heal;
		}
		if(var1 == 4)
		{
			return Poison;
		}
		if(var1 == 5)
		{
			return Earth;
		}
		if(var1 == 6)
		{
			return Wind;
		}
		if(var1 == 7)
		{
			return Light;
		}
		if(var1 == 8)
		{
			return Dark;
		}
		else
		{
			return ZTotal;
		}

	}
	public String getName()
	{
		return ZName;
	}
	public void resetType()
	{
		
		this.Flame = 0;
		this.Ice = 0;
		this.Heal = 0;
		this.Poison = 0;
		this.Earth = 0;
		this.Wind = 0;
		this.Light = 0;
		this.Dark = 0;
		this.ZTotal = 0;
		this.ZType = 0;
		this.randomTexture();
		this.ZName = "";
	}
	public int getZTex()
	{
		return this.ZTex;
	}
	public int getZTotal()
	{
		return this.ZTotal;
	}
	public void balanceTotal()
	{
		this.ZTotal = this.Flame + this.Ice + this.Heal + this.Poison + this.Earth + this.Wind + this.Light + this.Dark;
		this.syncExtendedProperties();
	}
	public void randomTexture()
	{
		this.ZTex = rand.nextInt(5);
	}
	public void setZType(int var1)
	{
		this.ZType = var1;
		this.syncExtendedProperties();
	}
	public String getZName()
	{
		return ZName;
	}
	
	public int getZType()
	{
		return ZType;
	}
	public void setZName(String name)
	{
		this.ZName = name;
		this.syncExtendedProperties();
	}
	
	public void setType(int var3)
	{
		 if(var3 == 0)
  		{
  			this.Flame = 80;
  			this.Ice = 0;
  			this.Poison = 0;
  			this.Heal = 0;
  			this.Earth = 0;
  			this.Wind = 0;
  			this.Light = 0;
  			this.Dark = 0;
  		}
     	 if(var3 == 1)
   		{
   			this.Flame = 0;
   			this.Ice = 80;
   			this.Poison = 0;
   			this.Heal = 0;
   			this.Earth = 0;
   			this.Wind = 0;
   			this.Light = 0;
   			this.Dark = 0;
   		}
     	 if(var3 == 2)
   		{
   			this.Flame = 0;
   			this.Ice = 0;
   			this.Poison = 0;
   			this.Heal = 0;
   			this.Earth = 80;
   			this.Wind = 0;
   			this.Light = 0;
   			this.Dark = 0;
   		}
     	 if(var3 == 3)
   		{
   			this.Flame = 0;
   			this.Ice = 0;
   			this.Poison = 0;
   			this.Heal = 0;
   			this.Earth = 0;
   			this.Wind = 80;
   			this.Light = 0;
   			this.Dark = 0;
   		}
     	 if(var3 == 4)
   		{
   			this.Flame = 0;
   			this.Ice = 0;
   			this.Poison = 80;
   			this.Heal = 0;
   			this.Earth = 0;
   			this.Wind = 0;
   			this.Light = 0;
   			this.Dark = 0;
   		}
     	 if(var3 == 5)
   		{
   			this.Flame = 0;
   			this.Ice = 0;
   			this.Poison = 0;
   			this.Heal = 80;
   			this.Earth = 0;
   			this.Wind = 0;
   			this.Light = 0;
   			this.Dark = 0;
   		}
     	 if(var3 == 6)
  		{
  			this.Flame = 0;
  			this.Ice = 0;
  			this.Poison = 0;
  			this.Heal = 0;
  			this.Earth = 0;
  			this.Wind = 0;
  			this.Light = 80;
  			this.Dark = 0;
  		}
     	 if(var3 == 7)
   		{
   			this.Flame = 0;
   			this.Ice = 0;
   			this.Poison = 0;
   			this.Heal = 0;
   			this.Earth = 0;
   			this.Wind = 0;
   			this.Light = 0;
   			this.Dark = 80;
   		}
     	 if(var3 == 8)
   		{
   			this.Flame = 0;
   			this.Ice = 0;
   			this.Poison = 0;
   			this.Heal = 0;
   			this.Earth = 0;
   			this.Wind = 0;
   			this.Light = 40;
   			this.Dark = 40;
   		}
     	 if(var3 == 9)
   		{
   			this.Flame = 0;
   			this.Ice = 0;
   			this.Poison = 0;
   			this.Heal = 0;
   			this.Earth = 0;
   			this.Wind = 40;
   			this.Light = 40;
   			this.Dark = 0;
   		}
     	 
     	 if(var3 == 10)
   		{
   			this.Flame = 10;
   			this.Ice = 10;
   			this.Poison = 10;
   			this.Heal = 10;
   			this.Earth = 10;
   			this.Wind = 10;
   			this.Light = 10;
   			this.Dark = 10;
   			this.ZType = 12;
   		}
     	 
     	 if(var3 == 11)
     	 {
     		this.Flame = 40;
     		this.Ice = 40;
    		this.Poison = 0;
    		this.Heal = 0;
    		this.Earth = 0;
    		this.Wind = 0;
    		this.Light = 0;
    		this.Dark = 0;
     	 }
     	this.syncExtendedProperties();
	}
	
	public void setTexture(int var1)
	{
		this.ZTex = var1;
	}
	public void addPoints(int var1, int amount)
	{
		if(var1 == 1)
		{
			Flame += amount;
		}
		if(var1 == 2)
		{
			 Ice += amount;
		}
		if(var1 == 3)
		{
			 Heal += amount;
		}
		if(var1 == 4)
		{
			 Poison += amount;
		}
		if(var1 == 5)
		{
			 Earth += amount;
		}
		if(var1 == 6)
		{
			 Wind += amount;
		}
		if(var1 == 7)
		{
			 Light += amount;
		}
		if(var1 == 8)
		{
			 Dark += amount;
		}
		else
		{
			 ZTotal += amount;
		}
		this.syncExtendedProperties();
	}
	
	
	
	
	
	

	
	
	
	
	
	
	public void deactivateShikai(int id) 
	{
		ItemStack heldItem = player.getCurrentEquippedItem();
		heldItem.itemID = id;
	}

	public void syncSwords() 
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream(4);
		DataOutputStream outputStream = new DataOutputStream(bos);
		
		try
		{
			outputStream.writeInt(Items.zanpakuto.itemID);
			
		} catch(Exception ex){
			ex.printStackTrace();
		}
		
		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = "Shikai";
		packet.data = bos.toByteArray();
		packet.length = bos.size();
		
		Side side = FMLCommonHandler.instance().getEffectiveSide();
		
		if(side == Side.CLIENT)
		{
			EntityClientPlayerMP player1 = (EntityClientPlayerMP)player;
			player1.sendQueue.addToSendQueue(packet);
		}
	}

	public void movePlayer() 
	{
		if(player.onGround)
		{
			player.moveEntity(10*Math.cos(-player.rotationPitch * (Math.PI / 180F))*Math.sin(-player.rotationYaw * (Math.PI / 180F)), 10*Math.sin(-player.rotationPitch * (Math.PI / 180F)), 10*Math.cos(-player.rotationPitch * (Math.PI / 180F))*Math.cos(-player.rotationYaw * (Math.PI / 180F)));
            ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
			props.consumeEnergy(5);
	    	
		}
		
	}
	
	
	
	
	public int getMask()
	{
		return this.Mask;
	}
	public int getLines()
	{
		return this.MaskLines;
	}
	public void randomMask()
	{
		this.Mask = rand.nextInt(4);
		this.syncExtendedProperties();
	}
	public void randomLines() 
	{
		this.MaskLines = rand.nextInt(3);
		this.syncExtendedProperties();
		
	}
	public void setLines(int var1)
	{
		this.MaskLines = var1;
		this.syncExtendedProperties();
	}
	public void setMask(int var1)
	{
		this.Mask = var1;
		this.syncExtendedProperties();
	}

	public void Hollowfy() 
	{
		PacketDispatcher.sendPacketToPlayer(MaskPacket.getPacket(this.Mask, this.MaskLines), (Player)player);
	}
	
	public void putOnMask(int mask, int line)
	{
		ItemStack HollowMask;
		
		if(mask == 0)
		{
			if(line == 0)
			{
		   		HollowMask = new ItemStack(Armor.PlayerMask10, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
			}
			else if(line == 1)
			{
		   		 HollowMask = new ItemStack(Armor.PlayerMask11, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
			}
			else if(line == 2)
			{
		   		 HollowMask = new ItemStack(Armor.PlayerMask12, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
			}
		}
		else if(mask == 1)
		{
			if(line == 0)
			{
		   		 HollowMask = new ItemStack(Armor.PlayerMask20, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
			}
			else if(line == 1)
			{
		   		 HollowMask = new ItemStack(Armor.PlayerMask21, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
			}
			else if(line == 2)
			{
		   		 HollowMask = new ItemStack(Armor.PlayerMask22, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
			}
		}
		else if(mask == 2)
		{
			if(line == 0)
			{
		   		 HollowMask = new ItemStack(Armor.PlayerMask30, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
			}
			else if(line == 1)
			{
		   		 HollowMask = new ItemStack(Armor.PlayerMask31, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
			}
			else if(line == 2)
			{
		   		 HollowMask = new ItemStack(Armor.PlayerMask32, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
			}
		}
		else if(mask == 3)
		{
			if(line == 0)
			{
		   		 HollowMask = new ItemStack(Armor.PlayerMask40, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
			}
			else if(line == 1)
			{
		   		 HollowMask = new ItemStack(Armor.PlayerMask41, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
			}
			else if(line == 2)
			{
		   		 HollowMask = new ItemStack(Armor.PlayerMask42, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
			}
		}
	}


	
	public void decideWhatToDo(byte readByte) 
	{
		if(readByte == 1)
		{
			this.movePlayer();
		}
		else if(readByte == 0)
		{
			this.Hollowfy();
		}
		
	}

	
	

}
