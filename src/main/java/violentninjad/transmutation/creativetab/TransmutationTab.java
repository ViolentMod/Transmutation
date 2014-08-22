package violentninjad.transmutation.creativetab;
//Copyright ViolentNInjaD 2014

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import violentninjad.transmutation.Transmutation;
import violentninjad.transmutation.init.ItemInit;

public class TransmutationTab
{

    public static final CreativeTabs tabTransmutation = new CreativeTabs(Transmutation.MOD_ID)
    {
        @Override
        public Item getTabIconItem()
        {
            return ItemInit.redMatter;
        }
    };
}
