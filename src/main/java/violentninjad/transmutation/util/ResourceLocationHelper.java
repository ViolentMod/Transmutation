package violentninjad.transmutation.util;
//Copyright ViolentNInjaD 2014

import net.minecraft.util.ResourceLocation;
import violentninjad.transmutation.Transmutation;

public class ResourceLocationHelper
{
    public static ResourceLocation getResourceLocation(String path)
    {
        return new ResourceLocation(Transmutation.MOD_ID.toLowerCase(), path);
    }
}
