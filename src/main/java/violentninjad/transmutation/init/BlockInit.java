package violentninjad.transmutation.init;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.common.registry.GameRegistry;
import violentninjad.transmutation.block.BlockDarkMatter;
import violentninjad.transmutation.block.BlockRedMatter;
import violentninjad.transmutation.block.BlockTransmutation;
import violentninjad.transmutation.reference.Names;

public class BlockInit
{

    public static final BlockTransmutation redMatterBlock = new BlockRedMatter();
    public static final BlockTransmutation darkMatterBlock = new BlockDarkMatter();

    public static void init()
    {
        GameRegistry.registerBlock(redMatterBlock, Names.Blocks.RED_MATTER);
        GameRegistry.registerBlock(darkMatterBlock, Names.Blocks.DARK_MATTER);
    }
}
