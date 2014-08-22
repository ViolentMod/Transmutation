package violentninjad.transmutation.net;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import violentninjad.transmutation.Transmutation;

public class PacketHandler
{
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Transmutation.MOD_ID.toLowerCase());

    public static void init()
    {
        INSTANCE.registerMessage(MessageTileEntityTransmutation.class, MessageTileEntityTransmutation.class, 0, Side.CLIENT);
    }

}
