package violentninjad.transmutation.inventory;
//Copyright ViolentNInjaD 2014

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import violentninjad.transmutation.tileentity.TileEntityTransmutationTable;

public class ContainerTransmutationTable extends ContainerTransmutation
{
    private TileEntityTransmutationTable tileEntityTransmutationTable;

    public ContainerTransmutationTable(InventoryPlayer inventoryPlayer, TileEntityTransmutationTable tileEntityTransmutationTable)
    {
        this.tileEntityTransmutationTable = tileEntityTransmutationTable;
    }
}
