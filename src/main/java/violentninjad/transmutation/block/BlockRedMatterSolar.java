package violentninjad.transmutation.block;
//Copyright ViolentNInjaD 2014

import cofh.api.block.IDismantleable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import violentninjad.transmutation.Transmutation;
import violentninjad.transmutation.reference.Names;
import violentninjad.transmutation.tileentity.TileEntityRedMatterSolar;
import violentninjad.transmutation.util.LogHelper;


public class BlockRedMatterSolar extends BlockTransmutation
{
    public IIcon redMatterSolar[] = new IIcon[2];

    public BlockRedMatterSolar()
    {
        super(Material.iron);
        this.setHardness(16.0F);
        this.setBlockName(Names.Blocks.RED_MATTER_SOLAR);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ri)
    {
        this.redMatterSolar[0] = ri.registerIcon(Transmutation.MOD_ID +":solarTop");
        this.redMatterSolar[1] = ri.registerIcon("iron_block");
    }

    public IIcon getIcon()
    {
        return redMatterSolar[1];
    }

    public IIcon getBlockTexture(IBlockAccess access, int i, int j, int k, int side)
    {
        return super.getBlockTextureFromSide(0);
    }

    @Override
    public TileEntity createTileEntity(World world, int meta)
    {
        if (meta == 0) {
            return new TileEntityRedMatterSolar();
        }
        return super.createTileEntity(world, meta);
    }

    public TileEntity createNewTileEntity(World world)
    {
        return null;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if (world.isRemote)
        {

        }
        return true;
    }

}

