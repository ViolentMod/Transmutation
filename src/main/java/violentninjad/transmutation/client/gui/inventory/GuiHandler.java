package violentninjad.transmutation.client.gui.inventory;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import violentninjad.transmutation.inventory.ContainerTransmutationTable;
import violentninjad.transmutation.reference.Guild;
import violentninjad.transmutation.tileentity.TileEntityTransmutationTable;

public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int id, EntityPlayer entityPlayer, World world, int x, int y, int z)
    {
        if (id == Guild.TransmutationTable.ordinal())
        {
            TileEntityTransmutationTable tileEntityTransmutationTable = (TileEntityTransmutationTable) world.getTileEntity(x, y, z);
            return new ContainerTransmutationTable(entityPlayer.inventory, tileEntityTransmutationTable);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer entityPlayer, World world, int x, int y, int z)
    {
        if (id == Guild.TransmutationTable.ordinal())
        {
            TileEntityTransmutationTable tileEntityTransmutationTable = (TileEntityTransmutationTable) world.getTileEntity(x, y, z);
            return new GuiTransmutationTable(entityPlayer.inventory, tileEntityTransmutationTable);
        }
        return null;
    }
}
