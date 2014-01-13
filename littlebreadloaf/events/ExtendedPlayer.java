package littlebreadloaf.events;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Random;

import littlebreadloaf.armor.Armor;
import littlebreadloaf.armor.pmasks.ItemPlayerMask10;
import littlebreadloaf.armor.pmasks.ItemPlayerMask11;
import littlebreadloaf.armor.pmasks.ItemPlayerMask12;
import littlebreadloaf.armor.pmasks.ItemPlayerMask20;
import littlebreadloaf.armor.pmasks.ItemPlayerMask21;
import littlebreadloaf.armor.pmasks.ItemPlayerMask22;
import littlebreadloaf.armor.pmasks.ItemPlayerMask30;
import littlebreadloaf.armor.pmasks.ItemPlayerMask31;
import littlebreadloaf.armor.pmasks.ItemPlayerMask32;
import littlebreadloaf.armor.pmasks.ItemPlayerMask40;
import littlebreadloaf.armor.pmasks.ItemPlayerMask41;
import littlebreadloaf.armor.pmasks.ItemPlayerMask42;
import littlebreadloaf.items.Items;
import littlebreadloaf.libraries.BleachModInfo;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
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
	
	private boolean validFlash = true;
	private int stickTimer = 60;
	
	private boolean isShinigami = true;
	
	private int Mask = rand.nextInt(4);
	private int MaskLines = rand.nextInt(3);
	private int MaskColor = 333333 + rand.nextInt(333333) - rand.nextInt(333333);
	
	private float MaskTime;
	private int MaskTimeCap;
	private float MaskXP;
	private int MaskLevel;
	
	public ExtendedPlayer(EntityPlayer player)
	{
		this.player = player;
		this.SoulEnergy = this.SoulCap = 50;
	}
	
	
	
	
	
	//NBT Tags
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
        nbt.setInteger("MaskColor", this.MaskColor);
        
        nbt.setInteger("MaskTimeCap", this.MaskTimeCap);
        nbt.setFloat("MaskTime", this.MaskTime);
        nbt.setFloat("MaskXP", this.MaskXP);
        nbt.setInteger("MaskLevel", this.MaskLevel);
        
        nbt.setBoolean("Shinigami", this.isShinigami);
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
		this.MaskColor = nbt.getInteger("MaskColor");
		
		this.MaskTimeCap = nbt.getInteger("MaskTimeCap");
		this.MaskTime = nbt.getFloat("MaskTime");
		this.MaskXP = nbt.getFloat("MaskXP");
		this.MaskLevel = nbt.getInteger("MaskLevel");
		
		this.isShinigami = nbt.getBoolean("Shinigami");
	}
	
	
	
	//Things
	@Override
	public void init(Entity entity, World world)
	{
		
	}
	
	
	
	//Syncing
	public final void syncExtendedProperties()
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream(66);
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
			outputStream.writeInt(this.MaskTimeCap);
			outputStream.writeFloat(this.MaskTime);
			outputStream.writeInt(this.MaskLevel);
			outputStream.writeInt(this.MaskColor);
			outputStream.writeBoolean(this.isShinigami);
			outputStream.writeBoolean(this.validFlash);
			outputStream.writeInt(this.stickTimer);
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
	
	public void syncThings(int i) 
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream(4);
		DataOutputStream outputStream = new DataOutputStream(bos);
		
		try
		{
			outputStream.writeInt(i);
			
		} catch(Exception ex){
			ex.printStackTrace();
		}
		
		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = "Deactivate";
		packet.data = bos.toByteArray();
		packet.length = bos.size();
		
		Side side = FMLCommonHandler.instance().getEffectiveSide();
		
		if(side == Side.CLIENT)
		{
			EntityClientPlayerMP player1 = (EntityClientPlayerMP)player;
			player1.sendQueue.addToSendQueue(packet);
		}
	}

	
	
	
	
	

	
	
	
	
	
	//Setters
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
	public void setZType(int var1)
	{
		this.ZType = var1;
		this.syncExtendedProperties();
	}
	public void setName(String name)
	{
		this.ZName = name;
	}
	public void setZName(String name)
	{
		this.ZName = name;
		this.syncExtendedProperties();
	}
	public void setTexture(int var1)
	{
		this.ZTex = var1;
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
	public void setMaskTimeCap(int var1)
	{
		this.MaskTimeCap = var1;
		this.syncExtendedProperties();
	}
	public void setMaskTime(float var1)
	{
		this.MaskTime = var1;
		this.syncExtendedProperties();
	}
	public void setMaskLevel(int var1)
	{
		this.MaskLevel = var1;
		this.syncExtendedProperties();
	}
	public void setMaskColor(int var1)
	{
		this.MaskColor = var1;	
		this.syncExtendedProperties();
	}
	public void setIsShinigami(boolean var1)
	{
		this.isShinigami = var1;
		this.syncExtendedProperties();
	}
	public void setValidFlash(boolean var1)
	{
		this.validFlash = var1;
		this.syncExtendedProperties();
	}
	public void setStickTimer(int var1)
	{
		this.stickTimer = var1;
		this.syncExtendedProperties();
	}
	
	public void setType(int var3)
	{
		 if(var3 == 0)
  		{
  			this.Flame = 400;
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
   			this.Ice = 400;
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
   			this.Earth = 400;
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
   			this.Wind = 400;
   			this.Light = 0;
   			this.Dark = 0;
   		}
     	 if(var3 == 4)
   		{
   			this.Flame = 0;
   			this.Ice = 0;
   			this.Poison = 400;
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
   			this.Heal = 400;
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
  			this.Light = 400;
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
   			this.Dark = 400;
   		}
     	 if(var3 == 8)
   		{
   			this.Flame = 0;
   			this.Ice = 0;
   			this.Poison = 0;
   			this.Heal = 0;
   			this.Earth = 0;
   			this.Wind = 0;
   			this.Light = 200;
   			this.Dark = 200;
   		}
     	 if(var3 == 9)
   		{
   			this.Flame = 0;
   			this.Ice = 0;
   			this.Poison = 0;
   			this.Heal = 0;
   			this.Earth = 0;
   			this.Wind = 200;
   			this.Light = 200;
   			this.Dark = 0;
   		}
     	 
     	 if(var3 == 10)
   		{
   			this.Flame = 50;
   			this.Ice = 50;
   			this.Poison = 50;
   			this.Heal = 50;
   			this.Earth = 50;
   			this.Wind = 50;
   			this.Light = 50;
   			this.Dark = 50;
   			this.ZType = 0;
   		}
     	 
     	 if(var3 == 11)
     	 {
     		this.Flame = 200;
     		this.Ice = 200;
    		this.Poison = 0;
    		this.Heal = 0;
    		this.Earth = 0;
    		this.Wind = 0;
    		this.Light = 0;
    		this.Dark = 0;
     	 }
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
	
	
	
	
	
	
	
	
	
	//Getters
	
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
	public String getName()
	{
		return ZName;
	}
	public int getZTex()
	{
		return this.ZTex;
	}
	public int getZTotal()
	{
		return this.ZTotal;
	}
	public String getZName()
	{
		return ZName;
	}
	public int getZType()
	{
		return ZType;
	}
	public int getMask()
	{
		return this.Mask;
	}
	public int getLines()
	{
		return this.MaskLines;
	}
	public int getMaskColor()
	{
		return this.MaskColor;
	}
	public int getMaskTimeCap()
	{
		return this.MaskTimeCap;
	}
	public float getMaskTime()
	{
		return this.MaskTime;
	}
	public float getMaskXP()
	{
		return this.MaskXP;
	}
	public int getMaskLevel()
	{
		return this.MaskLevel;
	}
	public boolean getIsShinigami()
	{
		return this.isShinigami;
	}
	public boolean getValidFlash()
	{
		return this.validFlash;
	}
	public int getStickTimer()
	{
		return this.stickTimer;
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
	
	
	
	
	
	
	
	
	
	
	
	
	//Adding and Subtracting

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
	public void addMaskTimeCap()
	{
		this.MaskTimeCap += 5;
		this.syncExtendedProperties();
	}
	public void addMaskXP(int amount)
	{
		this.MaskXP += (float)amount / (float)(this.MaskLevel * 10);
	}
	public void addMaskLevel()
	{
		this.MaskLevel += 1;
		this.MaskXP = 0;
	}
	
	public boolean consumeEnergy(int amount)
	{
		//TODO: make and event handler for this and add to API
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
	
	public void addPoints(int type, int amount)
	{
		if(type == 1)
		{
			Flame += amount;
		}
		if(type == 2)
		{
			 Ice += amount;
		}
		if(type == 3)
		{
			 Heal += amount;
		}
		if(type == 4)
		{
			 Poison += amount;
		}
		if(type == 5)
		{
			 Earth += amount;
		}
		if(type == 6)
		{
			 Wind += amount;
		}
		if(type == 7)
		{
			 Light += amount;
		}
		if(type == 8)
		{
			 Dark += amount;
		}
		else
		{
			 ZTotal += amount;
		}
		this.syncExtendedProperties();
	}
	public void balanceTotal()
	{
		this.ZTotal = this.Flame + this.Ice + this.Heal + this.Poison + this.Earth + this.Wind + this.Light + this.Dark;
		this.syncExtendedProperties();
	}
	
	
	
	
	
	
	
	
	
	
	//Randomize
	
	public void randomTexture()
	{
		this.ZTex = rand.nextInt(5);
	}
	public void randomColor()
	{
		this.MaskColor = 333333 + rand.nextInt(333333) - rand.nextInt(333333);
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
	
	
	
	
	
	
	
	

	
	
	
	
	//Doing Things

	public void decideWhatToDo(byte readByte) 
	{
		if(readByte == 1)
		{

			ItemStack var9 = player.inventory.armorInventory[0];
	        ItemStack var10 = player.inventory.armorInventory[1];
	        ItemStack var11 = player.inventory.armorInventory[2];
			if(this.isShinigami && var9 != null && var9.itemID == Armor.Sandals.itemID && var10 != null && var10.itemID == Armor.ShiniPants.itemID && var11 != null && var11.itemID == Armor.ShiniRobe.itemID && this.getCurrentEnergy() >= (float)5/(float)this.getCurrentCap())
			{ 
	
				this.movePlayer();
			}
			else if(!this.isShinigami && var9 != null && var9.itemID == Armor.QuincyShoes.itemID && var10 != null && var10.itemID == Armor.QuincyPants.itemID && var11 != null && var11.itemID == Armor.QuincyRobe.itemID && this.getCurrentEnergy() >= (float)5/(float)this.getCurrentCap())
			{ 
				this.movePlayer();
			}
		}
		else if(readByte == 0)
		{
			this.Hollowfy();
		}
		
		
	}

	public void deactivate(int id) 
	{
		ItemStack heldItem = player.getCurrentEquippedItem();
		if(id == Items.zanpakuto.itemID)
		{
			heldItem.itemID = id;
		}
		else if(id == Items.quincybow.itemID)
		{
			ItemStack Pendant = new ItemStack(Items.quincypendant, 1, 1);
			heldItem.itemID = Pendant.itemID;
			heldItem.setItemDamage(0);
		}
		else if(id == Items.quincyweb.itemID)
		{
			ItemStack Pendant  = new ItemStack(Items.quincypendant, 1, 2);
			heldItem.itemID = Pendant.itemID;
			heldItem.setItemDamage(1);
		}
	}

	public void movePlayer() 
	{
		if(this.getValidFlash() && this.getCurrentEnergy() >= (float)5/(float)this.getCurrentCap())
		{
            player.worldObj.playSoundAtEntity(player, "lblbm:shunpo", 0.4F, 1.0F); 
            ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
            int distance = 10 + (int)(props.getCurrentCap() *(0.01* (float)props.getCurrentEnergy()));
			player.moveEntity(distance*Math.cos(-player.rotationPitch * (Math.PI / 180F))*Math.sin(-player.rotationYaw * (Math.PI / 180F)), distance*Math.sin(-player.rotationPitch * (Math.PI / 180F)), distance*Math.cos(-player.rotationPitch * (Math.PI / 180F))*Math.cos(-player.rotationYaw * (Math.PI / 180F)));
			props.consumeEnergy(5);
			props.setValidFlash(false);
			props.stickTimer = 0;
            player.worldObj.playSoundAtEntity(player, "lblbm:shunpo", 0.4F, 1.0F); 
		}
		
	}

	

	public void Hollowfy() 
	{
		PacketDispatcher.sendPacketToPlayer(MaskPacket.getPacket(this.Mask, this.MaskLines), (Player)player);
	}
	
	public void putOnMask(int mask, int line)
	{
		/**ItemStack HollowMask;
		
		if(mask == 0)
		{
			if(line == 0)
			{
		   		HollowMask = new ItemStack(Armor.PlayerMask10, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
		   		((ItemPlayerMask10)HollowMask.getItem()).setNBTColor(HollowMask, this.getMaskColor());
			}
			else if(line == 1)
			{
		   		 HollowMask = new ItemStack(Armor.PlayerMask11, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
		   		((ItemPlayerMask11)HollowMask.getItem()).setNBTColor(HollowMask, this.getMaskColor());
		   		
			}
			else if(line == 2)
			{
		   		 HollowMask = new ItemStack(Armor.PlayerMask12, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
		   		((ItemPlayerMask12)HollowMask.getItem()).setNBTColor(HollowMask, this.getMaskColor());
		   		
			}
		}
		else if(mask == 1)
		{
			if(line == 0)
			{
		   		 HollowMask = new ItemStack(Armor.PlayerMask20, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
		   		((ItemPlayerMask20)HollowMask.getItem()).setNBTColor(HollowMask, this.getMaskColor());
			}
			else if(line == 1)
			{
		   		 HollowMask = new ItemStack(Armor.PlayerMask21, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
		   		((ItemPlayerMask21)HollowMask.getItem()).setNBTColor(HollowMask, this.getMaskColor());
			}
			else if(line == 2)
			{
		   		 HollowMask = new ItemStack(Armor.PlayerMask22, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
		   		((ItemPlayerMask22)HollowMask.getItem()).setNBTColor(HollowMask, this.getMaskColor());
			}
		}
		else if(mask == 2)
		{
			if(line == 0)
			{
		   		 HollowMask = new ItemStack(Armor.PlayerMask30, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
		   		((ItemPlayerMask30)HollowMask.getItem()).setNBTColor(HollowMask, this.getMaskColor());
			}
			else if(line == 1)
			{
		   		 HollowMask = new ItemStack(Armor.PlayerMask31, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
		   		((ItemPlayerMask31)HollowMask.getItem()).setNBTColor(HollowMask, this.getMaskColor());
			}
			else if(line == 2)
			{
		   		 HollowMask = new ItemStack(Armor.PlayerMask32, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
		   		((ItemPlayerMask32)HollowMask.getItem()).setNBTColor(HollowMask, this.getMaskColor());
			}
		}
		else if(mask == 3)
		{
			if(line == 0)
			{
		   		 HollowMask = new ItemStack(Armor.PlayerMask40, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
		   		((ItemPlayerMask40)HollowMask.getItem()).setNBTColor(HollowMask, this.getMaskColor());
			}
			else if(line == 1)
			{
		   		 HollowMask = new ItemStack(Armor.PlayerMask41, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
		   		((ItemPlayerMask41)HollowMask.getItem()).setNBTColor(HollowMask, this.getMaskColor());
			}
			else if(line == 2)
			{
		   		 HollowMask = new ItemStack(Armor.PlayerMask42, 1);
		   		player.setCurrentItemOrArmor(4, HollowMask);
		   		((ItemPlayerMask42)HollowMask.getItem()).setNBTColor(HollowMask, this.getMaskColor());
			}
		}**/
	}














	

}
