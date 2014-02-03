package littlebreadloaf.bleach.commands;

import littlebreadloaf.bleach.events.ExtendedPlayer;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

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
		if (par2ArrayOfStr.length >= 1 && par2ArrayOfStr[0].length() > 0)
        {
            EntityPlayerMP entityplayermp = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(par2ArrayOfStr[0]);
            EntityPlayer var3 = entityplayermp;
            ExtendedPlayer props = (ExtendedPlayer) var3.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
            props.setCurrentEnergy(1);
            var3.addChatMessage("Full Spiritual Energy");
        }
		else
		{
			EntityPlayer var3 = getCommandSenderAsPlayer(par1ICommandSender);
            ExtendedPlayer props = (ExtendedPlayer) var3.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
            props.setCurrentEnergy(1);
            var3.addChatMessage("Full Spiritual Energy");
		}
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		return "/spirit [username]";
	}


}