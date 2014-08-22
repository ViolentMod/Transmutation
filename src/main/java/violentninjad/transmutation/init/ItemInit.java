package violentninjad.transmutation.init;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.common.registry.GameRegistry;
import violentninjad.transmutation.Item.ItemAeternalisFuel;
import violentninjad.transmutation.Item.ItemDarkMatter;
import violentninjad.transmutation.Item.ItemRedMatter;
import violentninjad.transmutation.Item.ItemTransmutation;
import violentninjad.transmutation.reference.Names;

public class ItemInit
{
    public static final ItemTransmutation redMatter = new ItemRedMatter();
    public static final ItemTransmutation darkMatter = new ItemDarkMatter();
    public static final ItemTransmutation aeternalisFuel = new ItemAeternalisFuel();

    public static void init()
    {
        GameRegistry.registerItem(redMatter, Names.Items.RED_MATTER);
        GameRegistry.registerItem(darkMatter, Names.Items.DARK_MATTER);
        GameRegistry.registerItem(aeternalisFuel, Names.Items.AETERNALIS_FUEL);
    }
}
