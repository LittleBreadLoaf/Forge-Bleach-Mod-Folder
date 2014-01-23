package littlebreadloaf.bleach.commands;

import java.util.List;

import littlebreadloaf.bleach.events.ExtendedPlayer;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class CommandSetFaction extends CommandBase
{

  public String getCommandName()
	{
		return "setfaction"; //set command name
	}

	public int getRequiredPermissionLevel()
	{
		return 1;
	}

	public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
	{
		EntityPlayer var4 = getCommandSenderAsPlayer(par1ICommandSender);
		ExtendedPlayer props = (ExtendedPlayer) var4.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		int var5 = 0;
		
		if (par2ArrayOfStr.length > 0)
        {
            int var3 = this.getTypeToSet(par1ICommandSender, par2ArrayOfStr[0]);
            
            	 if(var3 == 0)
         		{
         			var4.addChatMessage("Changing Faction to Shinigami");
         			props.setFaction(1);;
         		}
            	 if(var3 == 1)
          		{
         			var4.addChatMessage("Changing Faction to Quincy");
         			props.setFaction(2);;
          		}
            	
        }
		
		
		

		
		
	
	}
	
	/**
     * Return the zanpakuto type
     */
    protected int getTypeToSet(ICommandSender par1ICommandSender, String par2Str)
    {
        return !par2Str.equalsIgnoreCase("shinigami") ? (!par2Str.equalsIgnoreCase("quincy") ? parseIntBounded(par1ICommandSender, par2Str, 0, 1) : 1) : 0;
    }
	
	/**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
        return par2ArrayOfStr.length == 1 ? getListOfStringsMatchingLastWord(par2ArrayOfStr, new String[] {"shinigami", "quincy"}): null;
    }

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		return "/setfaction [quincy or shinigami]";
	}
}
