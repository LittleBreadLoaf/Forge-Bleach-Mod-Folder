package littlebreadloaf.commands;

import littlebreadloaf.events.ExtendedPlayer;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class CommandResetType extends CommandBase
{

	public String getCommandName()
	{
		return "resettype"; //set command name
	}

	public int getRequiredPermissionLevel()
	{
		return 0;
	}

	public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
	{

		EntityPlayer var3 = getCommandSenderAsPlayer(par1ICommandSender);
		ExtendedPlayer props = (ExtendedPlayer) var3.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		props.resetType();
		var3.addChatMessage("Resetting zanpakuto type");
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		
		return "/resettype";
	}


}