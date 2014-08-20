package violentninjad.transmutation.config;
//Copyright ViolentNInjaD 2014


import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import violentninjad.transmutation.Transmutation;

import java.io.File;

public class ConfigHandler
{
    public static final String EnergyTransmutationCategory = "EnergyTransmutation";

    public static Configuration config;

    public static int RFPerEnergyPoint = 1;

    public static void init(File configFile)
    {

        if (config == null)
        {
            config = new Configuration(configFile);
            loadConfig();
        }

    }

    private static void loadConfig()
    {
        RFPerEnergyPoint = config.getInt("RFPerEnergyPoint", ConfigHandler.EnergyTransmutationCategory, 1, 0, 100, "The Amount of RF per Energy Point when Transmuted.");

        if (config.hasChanged())
        {
            config.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Transmutation.MOD_ID))
        {
            loadConfig();
        }
    }


}
