package littlebreadloaf.bleach.events;

import littlebreadloaf.bleach.BleachIds;
import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.BleachModInfo;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraftforge.client.event.sound.PlayBackgroundMusicEvent;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLLog;

public class BleachSounds
{

	private static final String LBLBM = BleachModInfo.ID.toLowerCase() + ":";

	public static String[] soundFiles = { "bowcharge.ogg", "bowfire.ogg", "fisherlaugh1.ogg", "fisherlaugh2.ogg", "fisherlaugh3.ogg", "hollowscream.ogg", "ore_hollow.ogg", "shunpo.ogg" };
	public static String[] streamingFiles = { "asterisk.ogg", "NumberOne.ogg", "Escalon.ogg" };
	public static String[] HuecoMundoMusic = { "ardor.ogg", "belong.ogg", "heart.ogg", "home.ogg", "stay.ogg" };
	     
    
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event)
	{
		for (String soundFile : soundFiles)
		{
			try
			{
				event.manager.soundPoolSounds.addSound(LBLBM + soundFile);
				System.out.println("Sound file loaded: " + soundFile);

			} catch (Exception e)
			{
				System.out.println("Failed loading sound file: " + soundFile);
			}
		}

		

		for (String streamingFile : streamingFiles)
		{
			try
			{
				event.manager.soundPoolStreaming.addSound(LBLBM + streamingFile);
				System.out.println("Sound file loaded: " + streamingFile);

			} catch (Exception e)
			{
				System.out.println("Failed loading sound file: " + streamingFile);
			}
		}

		for (String musicFile : HuecoMundoMusic)
		{
			try
			{
				event.manager.soundPoolMusic.addSound(LBLBM + musicFile);
				System.out.println("Sound file loaded: " + musicFile);

			} catch (Exception e)
			{
				System.out.println("Failed loading sound file: " + musicFile);
			}
		}
	}

	@ForgeSubscribe
	public void onBackgroundMusic(PlayBackgroundMusicEvent event)
	{
		SoundPoolEntry sound = event.source;

		if(FMLClientHandler.instance().getClient().thePlayer.worldObj.provider.dimensionId == BleachIds.worldHuecoMundoID)
		{
//			FMLLog.info("Sound event");

			while(!isHuecoMundoMusic(sound.getSoundName()))
			{
//				FMLLog.info("Not HuecoMundo music: " + sound.getSoundName());
				sound = event.manager.soundPoolMusic.getRandomSound();
			}
//			FMLLog.info("HuecoMundo music: " + sound.getSoundName());
			event.result = sound;
		} else {
			while(isHuecoMundoMusic(sound.getSoundName()))
			{
//				FMLLog.info("HuecoMundo music: " + sound.getSoundName());
				sound = event.manager.soundPoolMusic.getRandomSound();
			}
//			FMLLog.info("Not HuecoMundo music: " + sound.getSoundName());
			event.result = sound;
		}
	}
	
	public boolean isHuecoMundoMusic(String name)
	{
		for(int i = 0; i < HuecoMundoMusic.length; i++)
		{
			if(name.equals("bleach:" + HuecoMundoMusic[i]))
				return true;
		}
		
		return false;
	}
}
