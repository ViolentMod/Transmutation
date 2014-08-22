package violentninjad.transmutation.init;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.common.registry.GameRegistry;
import violentninjad.transmutation.Item.ItemRedMatter;
import violentninjad.transmutation.Item.ItemTransmutation;

public class ItemInit
{
    public static final ItemTransmutation redMatter = new ItemRedMatter();

    public static void init()
    {
        GameRegistry.registerItem(redMatter, "redMatter");
    }
}
