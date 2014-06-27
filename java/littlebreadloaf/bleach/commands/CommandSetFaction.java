package littlebreadloaf.bleach.commands;

import java.util.List;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.events.PacketSync;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

public class CommandSetFaction extends CommandBase
{

	@Override
  public String getCommandName()
	{
		return "setfaction"; //set command name
	}

	@Override
	public int getRequiredPermissionLevel()
	{
		return 2;
	}

	@Override
	public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
	{
		
		EntityPlayer var3 = getCommandSenderAsPlayer(par1ICommandSender);
		ExtendedPlayer props = (ExtendedPlayer) var3.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		int faction = 0;
		if(par2ArrayOfStr.length == 1)
		{
			faction  = this.getTypeToSet(par1ICommandSender, par2ArrayOfStr[0]);
			 var3.addChatMessage(new ChatComponentText("Setting faction to" + " " + par2ArrayOfStr[0]));
		}

		 if (par2ArrayOfStr.length > 1)
	        {
			 	EntityPlayerMP entityplayermp = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(par2ArrayOfStr[0]);
	            var3 = entityplayermp;
	            props = (ExtendedPlayer) var3.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
				faction = this.getTypeToSet(par1ICommandSender, par2ArrayOfStr[1]);
				 var3.addChatMessage(new ChatComponentText("Setting faction to" + " " + par2ArrayOfStr[1]));
				 getCommandSenderAsPlayer(par1ICommandSender).addChatMessage(new ChatComponentText("Setting " + par2ArrayOfStr[0] + "'s faction to " + par2ArrayOfStr[1]));
	        }
		 props.setFaction(faction + 1);

		BleachMod.packetPipeline.sendTo(new PacketSync(var3), (EntityPlayerMP) var3);
		
		
		

		
		
	
	}

	
	/**
     * Return the zanpakuto type
     */
    protected int getTypeToSet(ICommandSender par1ICommandSender, String par2Str)
    {
        return !par2Str.equalsIgnoreCase("shinigami") ? (!par2Str.equalsIgnoreCase("quincy") ? (!par2Str.equalsIgnoreCase("human") ? parseIntBounded(par1ICommandSender, par2Str, 0, 1) : 2) : 1) : 0;
    }

	@Override
	/**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
        return par2ArrayOfStr.length == 1 ? getListOfStringsMatchingLastWord(par2ArrayOfStr, new String[] {"shinigami", "quincy", "human"}): null;
    }

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		return "/setfaction {username} [quincy, shinigami, human]";
	}
}
