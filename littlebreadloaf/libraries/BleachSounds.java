package littlebreadloaf.libraries;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class BleachSounds 
{
	  @ForgeSubscribe
	    public void onSound(SoundLoadEvent event)
	    {
	        
	            event.manager.addSound("lblbm:bowcharge.ogg");    
	            event.manager.addSound("lblbm:bowfire.ogg");    
	            event.manager.addSound("lblbm:fisherlaugh1.ogg");    
	            event.manager.addSound("lblbm:fisherlaugh2.ogg");    
	            event.manager.addSound("lblbm:fisherlaugh3.ogg"); 
	            event.manager.addSound("lblbm:hollowscream.ogg");      
	            event.manager.addSound("lblbm:ore_hollow.ogg");
	            event.manager.addSound("lblbm:shunpo.ogg");
	            
	            //event.manager.addMusic("lblbm;calm4.ogg");
	            //event.manager.addMusic("lblbm;calm5.ogg");
	            //event.manager.addMusic("lblbm;calm6.ogg");
	            //event.manager.addMusic("lblbm;calm7.ogg");
	            
	            event.manager.addStreaming("lblbm:asterisk.ogg");
	            event.manager.addStreaming("lblbm:Escalon.ogg");
	            event.manager.addStreaming("lblbm:NumberOne.ogg");
	      
	    }

}
