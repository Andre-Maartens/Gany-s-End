package ganymedes01.ganysend.blocks;

import ganymedes01.ganysend.GanysEnd;
import ganymedes01.ganysend.core.utils.Utils;
import ganymedes01.ganysend.items.ModItems;
import ganymedes01.ganysend.lib.Strings;
import ganymedes01.ganysend.tileentities.TileEntityBlockShifter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Gany's End
 * 
 * @author ganymedes01
 * 
 */

public class BlockShifter extends BlockContainer {

	@SideOnly(Side.CLIENT)
	protected IIcon blockSide, blockBottom, blockTop;

	public BlockShifter() {
		super(Material.iron);
		setHardness(1.5F);
		setResistance(10.0F);
		if (GanysEnd.activateShifters)
			setCreativeTab(GanysEnd.endTab);
		setBlockName(Utils.getUnlocalizedName(Strings.BLOCK_SHIFTER_NAME));
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityBlockShifter();
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbour) {
		if (world.isRemote)
			return;
		TileEntityBlockShifter tile = Utils.getTileEntity(world, x, y, z, TileEntityBlockShifter.class);
		if (tile != null)
			tile.direction = world.isBlockIndirectlyGettingPowered(x, y, z);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int id, float hitX, float hitY, float hitZ) {
		if (player.inventory.getCurrentItem() == null)
			return false;
		if (player.inventory.getCurrentItem().getItem() == ModItems.enderTag)
			if (player.inventory.getCurrentItem().getTagCompound().getBoolean("Tagged")) {
				TileEntityBlockShifter tile = Utils.getTileEntity(world, x, y, z, TileEntityBlockShifter.class);
				if (tile != null) {
					int telX = player.inventory.getCurrentItem().getTagCompound().getIntArray("Position")[0];
					int telY = player.inventory.getCurrentItem().getTagCompound().getIntArray("Position")[1];
					int telZ = player.inventory.getCurrentItem().getTagCompound().getIntArray("Position")[2];
					int telDim = player.inventory.getCurrentItem().getTagCompound().getInteger("Dimension");

					if (telX == x && telY == y && telZ == z)
						return false;

					tile.receiverX = telX;
					tile.receiverY = telY;
					tile.receiverZ = telZ;
					tile.receiverDim = telDim;
					tile.tagged = true;
					world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "random.click", 0.3F, 0.6F);
					return true;
				}
			}
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return side == 0 ? blockBottom : side == 1 ? blockTop : blockSide;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
		blockSide = reg.registerIcon(Utils.getBlockTexture(Strings.BLOCK_SHIFTER_NAME) + "_side");
		blockBottom = reg.registerIcon(Utils.getBlockTexture(Strings.BLOCK_SHIFTER_NAME) + "_bottom");
		blockTop = reg.registerIcon(Utils.getBlockTexture(Strings.BLOCK_SHIFTER_NAME) + "_top");
	}
}