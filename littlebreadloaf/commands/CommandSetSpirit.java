package littlebreadloaf.commands;

import littlebreadloaf.events.ExtendedPlayer;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class CommandSetSpirit extends CommandBase
{

  public String getCommandName()
	{
		return "setspirit"; //set command name
	}

	public int getRequiredPermissionLevel()
	{
		return 2;
	}

	public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
	{

		EntityPlayer var3 = getCommandSenderAsPlayer(par1ICommandSender);
		ExtendedPlayer props = (ExtendedPlayer) var3.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);


		int var5 = 50;
		 if (par2ArrayOfStr.length >= 0)
	        {
			 var5 = parseIntBounded(par1ICommandSender, par2ArrayOfStr[0], 50, 1000);
	        }
		 props.setMaxCap(var5);
		 var3.addChatMessage("Setting Spiritual Energy to" + " " + var5);
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		return "/setspirit <amount>";
	}


}