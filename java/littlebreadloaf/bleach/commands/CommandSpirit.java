package littlebreadloaf.bleach.commands;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.network.ClientSyncMessage;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

public class CommandSpirit extends CommandBase
{

	@Override
  public String getCommandName()
	{
		return "spirit"; //set command name
	}

	@Override
	public int getRequiredPermissionLevel()
	{
		return 2;
	}

	@Override
	public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
	{
		if (par2ArrayOfStr.length >= 1 && par2ArrayOfStr[0].length() > 0)
        {
            EntityPlayerMP entityplayermp = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(par2ArrayOfStr[0]);
            EntityPlayer var3 = entityplayermp;
            ExtendedPlayer props = (ExtendedPlayer) var3.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
            props.setCurrentEnergy(1);
            var3.addChatMessage(new ChatComponentText("Full Spiritual Energy"));
            getCommandSenderAsPlayer(par1ICommandSender).addChatMessage(new ChatComponentText("Filling " + par2ArrayOfStr[0] + "'s Spiritual Energy"));
    		BleachMod.network.sendTo(new ClientSyncMessage(var3), (EntityPlayerMP) var3);
        }
		else
		{
			EntityPlayer var3 = getCommandSenderAsPlayer(par1ICommandSender);
            ExtendedPlayer props = (ExtendedPlayer) var3.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
            props.setCurrentEnergy(1);
            var3.addChatMessage(new ChatComponentText("Full Spiritual Energy"));
    		BleachMod.network.sendTo(new ClientSyncMessage(var3), (EntityPlayerMP) var3);
		}

	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		return "/spirit [username]";
	}


}