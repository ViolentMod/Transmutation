package violentninjad.transmutation.proxy;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.common.registry.GameRegistry;
import violentninjad.transmutation.reference.Names;
import violentninjad.transmutation.tileentity.TileEntityTransmutationTable;

public abstract class CommonProxy implements IProxy
{
    public void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityTransmutationTable.class, Names.Blocks.TRANSMUTATION_TABLE);
    }
}
