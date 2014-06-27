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

public class CommandSetType extends CommandBase
{

	@Override
  public String getCommandName()
	{
		return "settype"; //set command name
	}

	@Override
	public int getRequiredPermissionLevel()
	{
		return 2;
	}

	@Override
	public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
	{
		EntityPlayer var4 = getCommandSenderAsPlayer(par1ICommandSender);
		ExtendedPlayer props = (ExtendedPlayer) var4.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		int var5 = 0;
		
		
		if(par2ArrayOfStr.length == 3)
		{
			EntityPlayerMP entityplayermp = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(par2ArrayOfStr[0]);
            var4 = entityplayermp;
            props = (ExtendedPlayer) var4.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
			var5 = parseIntBounded(par1ICommandSender, par2ArrayOfStr[2], 0, 4);
			getCommandSenderAsPlayer(par1ICommandSender).addChatMessage(new ChatComponentText("Setting " + par2ArrayOfStr[0] + "'s Type to " + par2ArrayOfStr[1]));
    		var4.addChatMessage(new ChatComponentText("Zanpakuto Type set to " + par2ArrayOfStr[1]));
    		if(getTypeToSet(par1ICommandSender, par2ArrayOfStr[1]) < 12)
    		{
    			props.setType(getTypeToSet(par1ICommandSender, par2ArrayOfStr[1]));
    			props.setZType(getTypeToSet(par1ICommandSender, par2ArrayOfStr[1]) + 1);
    		}
    		else
    		{
    			props.resetType();
    		}
		
		}
		
		if(par2ArrayOfStr.length == 2)
		{
			if(MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(par2ArrayOfStr[0]) != null)
			{
				EntityPlayerMP entityplayermp = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(par2ArrayOfStr[0]);
	            var4 = entityplayermp;
	            props = (ExtendedPlayer) var4.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
	            var4.addChatMessage(new ChatComponentText("Zanpakuto Type set to " + par2ArrayOfStr[1]));
	            getCommandSenderAsPlayer(par1ICommandSender).addChatMessage(new ChatComponentText("Setting " + par2ArrayOfStr[0] + "'s Type to " + par2ArrayOfStr[1]));
	            if(getTypeToSet(par1ICommandSender, par2ArrayOfStr[1]) < 12)
	    		{
	    			props.setType(getTypeToSet(par1ICommandSender, par2ArrayOfStr[1]));
	    			props.setZType(getTypeToSet(par1ICommandSender, par2ArrayOfStr[1]) + 1);
	    		}
	    		else
	    		{
	    			props.resetType();
	    		}
			}
			else
			{
				var5 = parseIntBounded(par1ICommandSender, par2ArrayOfStr[1], 0, 4);
				 if(getTypeToSet(par1ICommandSender, par2ArrayOfStr[0]) < 12)
		    		{
		    			props.setType(getTypeToSet(par1ICommandSender, par2ArrayOfStr[0]));
		    			props.setZType(getTypeToSet(par1ICommandSender, par2ArrayOfStr[0]) + 1);
		    		}
		    		else
		    		{
		    			props.resetType();
		    		}
				 var4.addChatMessage(new ChatComponentText("Setting Zanpakuto Type to " + par2ArrayOfStr[0]));
			}
			
		}
		if (par2ArrayOfStr.length == 1)
        {
            int var3 = this.getTypeToSet(par1ICommandSender, par2ArrayOfStr[0]);
            if(var3 != 12)
            {
                props.setType(var3);
                props.setZType(var3 + 1);
            }
            	 if(var3 == 12)
            	 {
            		 props.resetType();
            	 }
            	 var4.addChatMessage(new ChatComponentText("Zanpakuto Type set to " + par2ArrayOfStr[0]));
      	 
        }
		

		props.setTexture(var5);
		BleachMod.packetPipeline.sendTo(new PacketSync(var4), (EntityPlayerMP) var4);

		
	}
	
	/**
     * Return the zanpakuto type
     */
    protected int getTypeToSet(ICommandSender par1ICommandSender, String par2Str)
    {
        return !par2Str.equalsIgnoreCase("fire") ? (!par2Str.equalsIgnoreCase("ice") ? (!par2Str.equalsIgnoreCase("heal") ? (!par2Str.equalsIgnoreCase("poison") ? (!par2Str.equalsIgnoreCase("earth") ? (!par2Str.equalsIgnoreCase("wind") ? (!par2Str.equalsIgnoreCase("light") ? (!par2Str.equalsIgnoreCase("dark") ? (!par2Str.equalsIgnoreCase("lunar") ? (!par2Str.equalsIgnoreCase("lightning") ? (!par2Str.equalsIgnoreCase("normal") ? (!par2Str.equalsIgnoreCase("water") ? (!par2Str.equalsIgnoreCase("null") ? parseIntBounded(par1ICommandSender, par2Str, 0, 12) : 12) : 11) : 10) : 9) : 8) : 7) : 6) : 5) : 4) : 3) : 2) : 1) : 0;
    }

	@Override
	/**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
        return par2ArrayOfStr.length == 1 ? getListOfStringsMatchingLastWord(par2ArrayOfStr, new String[] {"fire", "ice", "heal", "poison", "earth", "wind", "light", "dark", "lunar", "lightning", "normal", "water", "null"}): null;
    }

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		return "/settype {username} <type> [texture 0-4] ";
	}
}
