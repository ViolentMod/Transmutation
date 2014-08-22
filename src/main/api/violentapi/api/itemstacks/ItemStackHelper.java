package violentapi.api.itemstacks;
//Copyright ViolentNInjaD 2014

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class ItemStackHelper {

    public static void mainHelper(Item item, int amount, int metadata) {
        new ItemStack(item, amount, metadata);
    }

}
