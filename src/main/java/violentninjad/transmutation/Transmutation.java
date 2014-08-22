package violentninjad.transmutation;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import violentninjad.transmutation.config.ConfigHandler;
import violentninjad.transmutation.init.BlockInit;
import violentninjad.transmutation.init.ItemInit;
import violentninjad.transmutation.init.Recipes;
import violentninjad.transmutation.proxy.IProxy;
import violentninjad.transmutation.reference.ProxyRef;
import violentninjad.transmutation.util.OreDictRegister;
import violentninjad.transmutation.util.VersionHelper;

import java.io.File;

@Mod(modid = Transmutation.MOD_ID, name = Transmutation.MOD_NAME, version = Transmutation.MOD_VERSION)
public class Transmutation
{

    public static final String MOD_ID = "transmutation";
    public static final String MOD_NAME = "Transmutation";
    public static final String MOD_VERSION = "1.7.10-ALPHA-01";

    @Mod.Instance
    public static Transmutation instance;

    @SidedProxy(clientSide = ProxyRef.Client.Class, serverSide = ProxyRef.Server.Class)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

        ConfigHandler.init(new File(Loader.instance().getConfigDir(), "Transmutation" + File.separator + "Transmutation.cfg"));
        FMLCommonHandler.instance().bus().register(new ConfigHandler());

        OreDictRegister.init();

        ItemInit.init();
        BlockInit.init();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        new VersionHelper().getVersion();
        new VersionHelper().getDownloads();

        Recipes.initCraftingRecipes();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }

}