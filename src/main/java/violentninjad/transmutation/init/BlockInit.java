package violentninjad.transmutation.init;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.common.registry.GameRegistry;
import violentninjad.transmutation.block.*;
import violentninjad.transmutation.reference.Names;

public class BlockInit
{

    public static final BlockTransmutation redMatterBlock = new BlockRedMatter();
    public static final BlockTransmutation darkMatterBlock = new BlockDarkMatter();
    public static final BlockTransmutation redMatterSolar = new BlockRedMatterSolar();
    public static final BlockTransmutation transmutationTable = new BlockTransmutationTable();

    public static void init()
    {
        GameRegistry.registerBlock(redMatterBlock, Names.Blocks.RED_MATTER);
        GameRegistry.registerBlock(darkMatterBlock, Names.Blocks.DARK_MATTER);
        GameRegistry.registerBlock(redMatterSolar, Names.Blocks.RED_MATTER_SOLAR);
        GameRegistry.registerBlock(transmutationTable, Names.Blocks.TRANSMUTATION_TABLE);
    }
}
