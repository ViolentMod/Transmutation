package violentninjad.transmutation.util;
//Copyright ViolentNInjaD 2014

import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import violentninjad.transmutation.init.ItemInit;

public class OreDictRegister
{
    public static void init()
    {
        registerOre("matterRed", ItemInit.redMatter);
        registerOre("matterDark", ItemInit.darkMatter);
    }

    public static void registerOre(String name, Item item)
    {
        OreDictionary.registerOre(name, item);
    }
}
