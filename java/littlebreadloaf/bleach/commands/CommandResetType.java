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

public class CommandResetType extends CommandBase
{

	@Override
	public String getCommandName()
	{
		return "resettype"; //set command name
	}

	@Override
	public int getRequiredPermissionLevel()
	{
		return 0;
	}

	@Override
	public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
	{

		EntityPlayer var3 = getCommandSenderAsPlayer(par1ICommandSender);
		ExtendedPlayer props = (ExtendedPlayer) var3.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		props.resetType();
		var3.addChatMessage(new ChatComponentText("Resetting zanpakuto type"));
		BleachMod.packetPipeline.sendTo(new PacketSync(var3), (EntityPlayerMP) var3);
		
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		
		return "/resettype";
	}


}