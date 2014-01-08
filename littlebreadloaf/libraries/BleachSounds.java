package littlebreadloaf.libraries;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class BleachSounds 
{
	
	private static final String LBLBM = BleachModInfo.ID.toLowerCase() + ":";
	
	public static String[] soundFiles = {"bowcharge.ogg", "bowfire.ogg", "fisherlaugh1.ogg", "fisherlaugh2.ogg", "fisherlaugh3.ogg", "hollowscream.ogg", "ore_hollow.ogg", "shunpo.ogg"};
	public static String[] streamingFiles = {"asterisk.ogg", "NumberOne.ogg", "Escalon.ogg"};
	public static String[] musicFiles = {"calm4.ogg", "calm5.ogg", "calm6.ogg", "calm7.ogg"};
	 
	
	@ForgeSubscribe
	    public void onSound(SoundLoadEvent event)
	    {
		  for (String soundFile : soundFiles) 
		  {
              try 
              {
                event.manager.soundPoolSounds.addSound(LBLBM + soundFile);
                System.out.println("Sound file loaded: " + soundFile);

	            
              }
              	catch (Exception e) 
              	{
                      System.out.println("Failed loading sound file: " + soundFile);
              	}
		  	}
		  
		  
		  for (String musicFile : musicFiles) 
		  {
              try 
              {
                event.manager.soundPoolMusic.addSound(LBLBM + musicFile);
                System.out.println("Sound file loaded: " + musicFile);

	            
              }
              	catch (Exception e) 
              	{
                      System.out.println("Failed loading sound file: " + musicFile);
              	}
		  	}
		  
		  
		  for (String streamingFile : streamingFiles) 
		  {
              try 
              {
                event.manager.soundPoolMusic.addSound(LBLBM + streamingFile);
                System.out.println("Sound file loaded: " + streamingFile);

	            
              }
              	catch (Exception e) 
              	{
                      System.out.println("Failed loading sound file: " + streamingFile);
              	}
		  	}
	      
	    }

}
