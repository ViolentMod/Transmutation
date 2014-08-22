package violentapi.api;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class CraftingHelper {

    public static void standard(ItemStack outputItemStack, Object... objectInputs) {
        GameRegistry.addRecipe(outputItemStack, objectInputs);
    }

    public static void shapeless(ItemStack outputItemStack, Object... objectInputs) {
        GameRegistry.addShapelessRecipe(outputItemStack, objectInputs);
    }

    public static void shaped(ItemStack outputItemStack, Object... objectInputs) {
        GameRegistry.addShapedRecipe(outputItemStack, objectInputs);
    }

    public static void oreShapeless(ItemStack outputItemStack, Object... objectInputs) {
        CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(outputItemStack, objectInputs));
    }

    public static void oreShaped(ItemStack outputItemStack, Object... objectInputs) {
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(outputItemStack, objectInputs));
    }
}
