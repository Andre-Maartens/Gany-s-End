package ganymedes01.ganysend.client.gui.inventory;

import ganymedes01.ganysend.core.utils.Utils;
import ganymedes01.ganysend.inventory.ContainerVoidCrate;
import ganymedes01.ganysend.lib.Strings;
import ganymedes01.ganysend.tileentities.TileEntityVoidCrate;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Gany's End
 * 
 * @author ganymedes01
 * 
 */

@SideOnly(Side.CLIENT)
public class GuiVoidCrate extends GuiContainer {

	public GuiVoidCrate(InventoryPlayer inventory, TileEntityVoidCrate tile) {
		super(new ContainerVoidCrate(inventory, tile));
		ySize = 245;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		String name = StatCollector.translateToLocal(Utils.getConainerName(Strings.VOID_CRATE_NAME));
		fontRenderer.drawString(name, xSize / 2 - fontRenderer.getStringWidth(name) / 2, 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int x, int y) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(Utils.getResource(Utils.getGUITexture(Strings.VOID_CRATE_NAME)));
		int j = (width - xSize) / 2;
		int k = (height - ySize) / 2;
		drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
	}
}