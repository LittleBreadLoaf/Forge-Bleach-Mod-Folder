package littlebreadloaf.bleach.commands;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.network.ClientSyncMessage;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

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
		if(ExtendedPlayer.getIs3D())
		{
			ExtendedPlayer.set3D(false);
		}
		else
		{
			ExtendedPlayer.set3D(true);	
		}

		BleachMod.network.sendTo(new ClientSyncMessage(var3), (EntityPlayerMP) var3);
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		
		return "/toggle3d";
	}
}