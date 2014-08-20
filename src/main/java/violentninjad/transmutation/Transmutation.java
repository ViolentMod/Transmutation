package violentninjad.transmutation;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import violentninjad.transmutation.proxy.IProxy;
import violentninjad.transmutation.reference.ProxyRef;

@Mod(modid = Transmutation.MOD_ID, name = Transmutation.MOD_NAME, version = Transmutation.MOD_VERSION)
public class Transmutation
{

    public static final String MOD_ID = "transmutation";
    public static final String MOD_NAME = "Transmutation";
    public static final String MOD_VERSION = "ALPHA";

    @Mod.Instance
    public static Transmutation instance;

    @SidedProxy(clientSide = ProxyRef.Client.Class, serverSide = ProxyRef.Server.Class)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }

}