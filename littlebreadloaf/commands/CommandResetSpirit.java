package littlebreadloaf.commands;

import littlebreadloaf.events.ExtendedPlayer;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class CommandResetSpirit extends CommandBase
{

  public String getCommandName()
	{
		return "resetspirit"; //set command name
	}

	public int getRequiredPermissionLevel()
	{
		return 0;
	}

	public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
	{
		EntityPlayer var3 = getCommandSenderAsPlayer(par1ICommandSender);
		ExtendedPlayer props = (ExtendedPlayer) var3.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		props.setCapMin(); 
		var3.addChatMessage("Resetting spiritual energy");
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		
		return "/resetspirit";
	}
}