package ganymedes01.ganysend.items;

import ganymedes01.ganysend.core.utils.Utils;
import ganymedes01.ganysend.lib.ModIDs;
import ganymedes01.ganysend.lib.ModMaterials;
import ganymedes01.ganysend.lib.Strings;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Gany's End
 * 
 * @author ganymedes01
 * 
 */

public class ReinforcedEndiumShovel extends EndiumAxe {

	public ReinforcedEndiumShovel() {
		super(ModIDs.REINFORCED_ENDIUM_SHOVEL_ID, ModMaterials.REIN_ENDIUM_TOOLS);
		MinecraftForge.setToolClass(this, "shovel", 3);
		setTextureName(Utils.getItemTexture(Strings.REINFORCED_ENDIUM_SHOVEL_NAME));
		setUnlocalizedName(Utils.getUnlocalizedName(Strings.REINFORCED_ENDIUM_SHOVEL_NAME));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.rare;
	}
}