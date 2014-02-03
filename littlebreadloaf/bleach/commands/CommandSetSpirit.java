package littlebreadloaf.bleach.commands;

import littlebreadloaf.bleach.events.ExtendedPlayer;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

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

		int var5 = 50;
		EntityPlayer var3 = getCommandSenderAsPlayer(par1ICommandSender);
		ExtendedPlayer props = (ExtendedPlayer) var3.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		if(par2ArrayOfStr.length == 1)
		{
			var5 = parseIntBounded(par1ICommandSender, par2ArrayOfStr[0], 50, 1000);
		}

		 if (par2ArrayOfStr.length > 1)
	        {
			 	EntityPlayerMP entityplayermp = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(par2ArrayOfStr[0]);
	            var3 = entityplayermp;
	            props = (ExtendedPlayer) var3.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
				var5 = parseIntBounded(par1ICommandSender, par2ArrayOfStr[1], 50, 1000);
	        }
		 props.setMaxCap(var5);
		 var3.addChatMessage("Setting Spiritual Energy to" + " " + var5);
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		return "/setspirit {username} <amount>";
	}


}