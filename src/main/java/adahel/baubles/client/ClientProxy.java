package adahel.baubles.client;

import adahel.baubles.client.gui.GuiEvents;
import adahel.baubles.common.CommonProxy;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerKeyBindings() {
		MinecraftForge.EVENT_BUS.register(new GuiEvents());
	}
}