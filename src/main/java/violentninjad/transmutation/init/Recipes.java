package violentninjad.transmutation.init;
//Copyright ViolentNInjaD 2014

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import violentapi.api.CraftingHelper;

public class Recipes
{
    public static void initCraftingRecipes()
    {
        CraftingHelper.standard(new ItemStack(ItemInit.darkMatter, 1), "aaa", "ada", "aaa", 'a', ItemInit.aeternalisFuel, 'd', Blocks.diamond_block);
        CraftingHelper.standard(new ItemStack(ItemInit.redMatter, 1), "aaa", "ddd", "aaa", 'a', ItemInit.aeternalisFuel, 'd', ItemInit.darkMatter);

        CraftingHelper.standard(new ItemStack(BlockInit.redMatterBlock, 4), "   ", " rr", " rr", 'r', ItemInit.redMatter);
        CraftingHelper.standard(new ItemStack(BlockInit.darkMatterBlock, 4), "   ", " dd", " dd", 'd', ItemInit.darkMatter);
    }
}
