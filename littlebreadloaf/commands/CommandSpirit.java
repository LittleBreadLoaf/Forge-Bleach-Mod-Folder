package littlebreadloaf.commands;

import littlebreadloaf.events.ExtendedPlayer;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class CommandSpirit extends CommandBase
{

  public String getCommandName()
	{
		return "spirit"; //set command name
	}

	public int getRequiredPermissionLevel()
	{
		return 2;
	}

	public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
	{

		EntityPlayer var3 = getCommandSenderAsPlayer(par1ICommandSender);
		ExtendedPlayer props = (ExtendedPlayer) var3.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		props.setCurrentEnergy(1);
		var3.addChatMessage("Full Spiritual Energy");
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		return "/spirit";
	}


}