package ganymedes01.ganysend.lib;

import ganymedes01.ganysend.items.EnderScythe;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;

/**
 * Gany's End
 * 
 * @author ganymedes01
 * 
 */

public class ModMaterials {

	// Armour
	public static final EnumArmorMaterial ENDIUM_ARMOUR = EnumHelper.addArmorMaterial("ENDIUM", 10, new int[] { 2, 4, 2, 2 }, 0);

	// Item
	public final static EnumToolMaterial ENDIUM_SCYTHE = EnumHelper.addToolMaterial("ENDIUM_SCYTHE", 0, 10, 2F, EnderScythe.DAMAGE - 4F, 0);
	public final static EnumToolMaterial ENDIUM_TOOLS = EnumHelper.addToolMaterial("ENDIUM_TOOLS", 3, 131, 12.0F, 1.0F, 0);
}
