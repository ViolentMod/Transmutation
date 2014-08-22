package violentninjad.transmutation.util;
//Credits to @condorcraft110's pull request on @MozeIntel's ProjectE repo
//https://github.com/MozeIntel/ProjectE/pull/11/files

import violentninjad.transmutation.Transmutation;

import java.net.*;
import java.util.*;

public class VersionHelper
{
    public void getVersion()
    {
        try
        {
            URLConnection connection = new URL("https://raw.githubusercontent.com/ViolentMod/VersionFiles/master/TransmutationVersion.txt").openConnection();
            connection.connect();
            Scanner scanSite = new Scanner(connection.getInputStream());
            String getVersion = scanSite.nextLine();

            scanSite.close();

            if(!getVersion.equals(Transmutation.MOD_VERSION))
            {
                LogHelper.warn("A new Build of " + Transmutation.MOD_NAME + ", " + getVersion + ", is avaliable! Get it as soon as possible :)");
            }

        }catch(Exception e){

        }

    }
}
