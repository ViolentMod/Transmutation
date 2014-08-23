package violentninjad.transmutation.block;
//Copyright ViolentNInjaD 2014

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import violentninjad.transmutation.Transmutation;
import violentninjad.transmutation.creativetab.TransmutationTab;
import violentninjad.transmutation.reference.Guild;
import violentninjad.transmutation.reference.Names;
import violentninjad.transmutation.tileentity.TileEntityTransmutationTable;

public class BlockTransmutationTable extends BlockTransmutation implements ITileEntityProvider
{
    public BlockTransmutationTable()
    {
        super(Material.rock);
        this.setCreativeTab(TransmutationTab.tabTransmutation);
        this.setBlockName(Names.Blocks.TRANSMUTATION_TABLE);
        this.setHardness(10.0F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata)
    {
        return new TileEntityTransmutationTable();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {

        if (player.isSneaking())
        {
            return false;
        }

        else
        {
            if (!world.isRemote)
            {
                if (world.getTileEntity(x, y, z) instanceof TileEntityTransmutationTable)
                {
                    player.openGui(Transmutation.instance, Guild.TransmutationTable.ordinal(), world, x, y, z);
                }
            }
        }

        return true;

    }
}
