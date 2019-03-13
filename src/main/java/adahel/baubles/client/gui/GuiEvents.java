package adahel.baubles.client.gui;

import com.rikmuld.camping.inventory.gui.GuiCampinginv;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import baubles.client.gui.GuiBaublesButton;
import baubles.common.network.PacketHandler;
import baubles.common.network.PacketOpenBaublesInventory;

public class GuiEvents {	
	
	@SideOnly(value = Side.CLIENT)
	@SubscribeEvent
	public void guiPostInit(GuiScreenEvent.InitGuiEvent.Post event) {

		if (event.gui instanceof GuiCampinginv) {
        	GuiCampinginv gui = (GuiCampinginv) event.gui;
			
			int xSize = 176;
		    int ySize = 166;
			
			int guiLeft = (gui.width - xSize) / 2;
	        int guiTop = (gui.height - ySize) / 2;
	        
	        if (!gui.mc.thePlayer.getActivePotionEffects().isEmpty()) {
	        	gui.tabsTop().clear();
	        	event.buttonList.clear();
	        	guiLeft = 138 + (gui.width - xSize - 200) / 2;
				ReflectionHelper.setPrivateValue(GuiContainer.class, gui, guiLeft, "field_147003_i", "guiLeft");
				gui.initTabbed();
				ReflectionHelper.setPrivateValue(GuiCampinginv.class, gui, guiLeft, "leftGui");
				guiLeft = guiLeft + 22;
	        }
			
			event.buttonList.add(new GuiBaublesButton(55, guiLeft + 66, guiTop + 9, 10, 10, 
					I18n.format("button.baubles", new Object())));
		}
		
	}

	@SideOnly(value = Side.CLIENT)
	@SubscribeEvent
	public void guiPostAction(GuiScreenEvent.ActionPerformedEvent.Post event) {

		if (event.gui instanceof GuiCampinginv) {
			if (event.button.id == 55) {
				PacketHandler.INSTANCE.sendToServer(new PacketOpenBaublesInventory(event.gui.mc.thePlayer));
			}
		}
	}
}
