package littlebreadloaf.bleach.commands;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.events.PacketSync;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

public class CommandSetSpirit extends CommandBase
{

	@Override
  public String getCommandName()
	{
		return "setspirit"; //set command name
	}

	@Override
	public int getRequiredPermissionLevel()
	{
		return 2;
	}

	@Override
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
				getCommandSenderAsPlayer(par1ICommandSender).addChatMessage(new ChatComponentText("Setting " + par2ArrayOfStr[0] + "'s Spiritual Energy to " + var5));
	        }
		 props.setMaxCap(var5);
		 var3.addChatMessage(new ChatComponentText("Setting Spiritual Energy to" + " " + var5));

		BleachMod.packetPipeline.sendTo(new PacketSync(var3), (EntityPlayerMP) var3);
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		return "/setspirit {username} <amount>";
	}


}