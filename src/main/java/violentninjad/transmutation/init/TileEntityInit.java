package violentninjad.transmutation.init;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.common.registry.GameRegistry;
import violentninjad.transmutation.reference.Names;
import violentninjad.transmutation.tileentity.TileEntityRedMatterSolar;

public class TileEntityInit
{
    public static void init()
    {
        GameRegistry.registerTileEntity(TileEntityRedMatterSolar.class, Names.Blocks.RED_MATTER_SOLAR);
        //GameRegistry.registerTileEntity(TileEntityDarkMatterSolar.class, Names.Blocks.DARK_MATTER_SOLAR); - added when ready!
    }
}
