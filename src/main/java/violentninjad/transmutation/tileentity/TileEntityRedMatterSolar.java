package violentninjad.transmutation.tileentity;
//Copyright ViolentNInjaD 2014

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.util.ForgeDirection;
import violentninjad.transmutation.config.ConfigHandler;
import violentninjad.transmutation.util.LogHelper;

public class TileEntityRedMatterSolar extends TileEntityTransmutation implements IEnergyHandler
{

    public TileEntityRedMatterSolar()
    {
        this.storage.setMaxExtract(512);
    }

    private EnergyStorage storage = new EnergyStorage(1000000);

    public int receiveEnergy(ForgeDirection dir, int i, boolean bool)
    {
        return storage.receiveEnergy(i, bool);
    }

    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate)
    {
        return storage.extractEnergy(maxExtract, simulate);
    }

    public int getEnergyStored(ForgeDirection from)
    {
        return storage.getEnergyStored();
    }

    public int getMaxEnergyStored(ForgeDirection from)
    {
        return storage.getMaxEnergyStored();
    }

    public boolean canConnectEnergy(ForgeDirection from)
    {
        return true;
    }


    public boolean canGenerate()
    {
        return !(worldObj.provider.hasNoSky || worldObj.isRaining() || worldObj.isThundering() || !worldObj.canBlockSeeTheSky(xCoord, yCoord + 1, zCoord) || !worldObj.isDaytime()); // || damage >= getMaxDamage()
    }

    public int getGenerationValue()
    {
        return ConfigHandler.RedMatterSolarGeneration;
    }

    public void onRightClick(EntityPlayer player, int side, float dx, float dy, float dz)
    {
        LogHelper.info("RF Stored: " + this.storage.getEnergyStored());
        player.addChatMessage(new ChatComponentText("RF Stored" + this.storage.getEnergyStored()));
    }




}
