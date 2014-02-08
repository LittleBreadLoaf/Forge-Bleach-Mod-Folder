package littlebreadloaf.bleach.commands;

import littlebreadloaf.bleach.events.ExtendedPlayer;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class CommandToggle3D extends CommandBase
{

  public String getCommandName()
	{
		return "toggle3d"; //set command name
	}

	public int getRequiredPermissionLevel()
	{
		return 0;
	}

	public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
	{
		EntityPlayer var3 = getCommandSenderAsPlayer(par1ICommandSender);
		ExtendedPlayer props = (ExtendedPlayer) var3.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		if(props.getIs3D())
		{
			props.set3D(false);
		}
		else
		{
			props.set3D(true);	
		}
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		
		return "/toggle3d";
	}
}