package littlebreadloaf.commands;

import java.util.List;

import littlebreadloaf.events.ExtendedPlayer;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class CommandSetType extends CommandBase
{

  public String getCommandName()
	{
		return "settype"; //set command name
	}

	public int getRequiredPermissionLevel()
	{
		return 2;
	}

	public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
	{
		EntityPlayer var4 = getCommandSenderAsPlayer(par1ICommandSender);
		ExtendedPlayer props = (ExtendedPlayer) var4.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		int var5 = 0;
		
		if (par2ArrayOfStr.length > 0)
        {
            int var3 = this.getTypeToSet(par1ICommandSender, par2ArrayOfStr[0]);
            props.setType(var3);
            	 if(var3 == 0)
         		{
         			var4.addChatMessage("Zanpakuto type set to fire");
         		}
            	 if(var3 == 1)
          		{
         			var4.addChatMessage("Zanpakuto type set to ice");
          		}
            	 if(var3 == 2)
          		{
         			var4.addChatMessage("Zanpakuto type set to earth");
          		}
            	 if(var3 == 3)
          		{
         			var4.addChatMessage("Zanpakuto type set to wind");
          		}
            	 if(var3 == 4)
          		{
         			var4.addChatMessage("Zanpakuto type set to poison");
          		}
            	 if(var3 == 5)
          		{
         			var4.addChatMessage("Zanpakuto type set to heal");
          		}
            	 if(var3 == 6)
         		{
         			var4.addChatMessage("Zanpakuto type set to light");
         		}
            	 if(var3 == 7)
          		{
         			var4.addChatMessage("Zanpakuto type set to dark");
          		}
            	 if(var3 == 8)
          		{
         			var4.addChatMessage("Zanpakuto type set to lunar");
          		}
            	 if(var3 == 9)
          		{
         			var4.addChatMessage("Zanpakuto type set to lightning");
          		}
            	 
            	 if(var3 == 10)
          		{
         			var4.addChatMessage("Zanpakuto type set to normal");
          		}
            	 
            	 if(var3 == 11)
            	 {
          			var4.addChatMessage("Zanpakuto type set to water");
            	 }
            	 

            
            	 if (par2ArrayOfStr.length >= 2)
                 {
                     var5 = parseIntBounded(par1ICommandSender, par2ArrayOfStr[1], 0, 4);
                 }
         		
         		props.setTexture(var5);	
        }
		
		
		

		
		
	
	}
	
	/**
     * Return the zanpakuto type
     */
    protected int getTypeToSet(ICommandSender par1ICommandSender, String par2Str)
    {
        return !par2Str.equalsIgnoreCase("fire") ? (!par2Str.equalsIgnoreCase("ice") ? (!par2Str.equalsIgnoreCase("earth") ? (!par2Str.equalsIgnoreCase("wind") ? (!par2Str.equalsIgnoreCase("poison") ? (!par2Str.equalsIgnoreCase("heal") ? (!par2Str.equalsIgnoreCase("light") ? (!par2Str.equalsIgnoreCase("dark") ? (!par2Str.equalsIgnoreCase("lunar") ? (!par2Str.equalsIgnoreCase("lightning") ? (!par2Str.equalsIgnoreCase("normal") ? (!par2Str.equalsIgnoreCase("water") ? parseIntBounded(par1ICommandSender, par2Str, 0, 11) : 11) : 10) : 9) : 8) : 7) : 6) : 5) : 4) : 3) : 2) : 1) : 0;
    }
	
	/**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
        return par2ArrayOfStr.length == 1 ? getListOfStringsMatchingLastWord(par2ArrayOfStr, new String[] {"fire", "ice", "earth", "wind", "poison", "heal", "light", "dark", "lunar", "lightning", "normal", "water"}): null;
    }

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		return "/settype <type> [texture 0-4]";
	}
}
