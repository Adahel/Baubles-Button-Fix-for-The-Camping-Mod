package adahel.baubles.common;

import adahel.baubles.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
		modid = BaublesFix.MODID, 
		name = BaublesFix.MODNAME, 
		version = BaublesFix.VERSION, 
		dependencies="required-after:Baubles;required-after:camping")
public class BaublesFix {
	public static final String MODID = "BaublesFix";
	public static final String MODNAME = "Baubles Button Fix for The Camping Mod";
	public static final String VERSION = "1.0";
	
	@SidedProxy(clientSide = "adahel.baubles.client.ClientProxy", serverSide = "adahel.baubles.common.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance(value=BaublesFix.MODID)
	public static BaublesFix instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.registerKeyBindings();
	}
}
