package mod.customarmortestiatp;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class CustomArmorIATP extends ItemArmor implements IArmorTextureProvider {

	public CustomArmorIATP(int par1, EnumArmorMaterial par2EnumArmorMaterial,
			int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
	}
	
	public String getTextureFile() {
		return CommonProxy.cat_png;
	}

	@Override
	public String getArmorTextureFile(ItemStack itemstack) {
		if (itemstack.itemID == CustomArmorTestIATP.customLeggingsTest.itemID)
        {
            return CommonProxy.testalt_2_png;
        }
        return CommonProxy.test_1_png;
	}
}
