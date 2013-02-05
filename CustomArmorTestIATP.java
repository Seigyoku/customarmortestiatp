package mod.customarmortestiatp;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "CATIATP", name = "Custom Armor Test with IArmorTextureProvider", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

//As this is only for proof of concept, I used files already contained within Minecraft.jar for the purpose of this test.
//cat.png is merely \gui\items.png, and the test images are copies of the diamond and chain armor skins found in \armor\.

public class CustomArmorTestIATP {
	@Instance("CAT")
	public static CustomArmorTestIATP instance;
	
	@SidedProxy(clientSide = "mod.customarmortestiatp.client.ClientProxy", serverSide = "mod.customarmortestiatp.CommonProxy")
	public static CommonProxy proxy;
	
	//syntax: (name, durability, reductionAmounts, enchantability)
	EnumArmorMaterial customArmorMaterial = EnumHelper.addArmorMaterial("customArmorMaterial", 40, new int[]{5, 14, 9, 5}, 15);
	
	public static Item customHelmetTest;
	public static Item customChestplateTest;
	public static Item customLeggingsTest;
	public static Item customBootsTest;
	
	@PreInit
	public void preInit (FMLPreInitializationEvent event) {
		// Stub Method
	}
	 
	@Init
	public void load (FMLInitializationEvent event) {
		proxy.registerRenderers();
		
		//syntax: (ID, EnumArmorMaterial, renderIndex, armorType)
		//This makes it so that, with the supplied files, everything but the leggings will be rendered on the player as diamond and the leggings will be chain.
		//However, we're intentionally using .setIconCoord(int, int) to make all the parts show up as golden armor items in the inventory.
		//Because of the implementation of CustomArmor's IArmorTextureProvider, renderIndex no longer matters as getArmorTextureFile(String) overrides it anyway.
		//Despite this, only assign 0-4 in renderIndex, as using anything else without going the non-IATP path will give constant render errors every tick.
		customHelmetTest = new CustomArmorIATP(7000, customArmorMaterial, 4, 0).setIconCoord(4, 0).setItemName("customHelmetTest");
		customChestplateTest = new CustomArmorIATP(7001, customArmorMaterial, 4, 1).setIconCoord(4, 1).setItemName("customChestplateTest");
		customLeggingsTest = new CustomArmorIATP(7002, customArmorMaterial, 4, 2).setIconCoord(4, 2).setItemName("customLeggingsTest");
		customBootsTest = new CustomArmorIATP(7003, customArmorMaterial, 4, 3).setIconCoord(4, 3).setItemName("customBootsTest");
		
		LanguageRegistry.addName(customHelmetTest, "Custom Helmet Test");
		LanguageRegistry.addName(customChestplateTest, "Custom Chestplate Test");
		LanguageRegistry.addName(customLeggingsTest, "Custom Leggings Test");
		LanguageRegistry.addName(customBootsTest, "Custom Boots Test");
		
	}
	 
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	} 
}
