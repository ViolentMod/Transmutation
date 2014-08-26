package violentninjad.transmutation.inventory;
//Copyright ViolentNInjaD 2014

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import violentninjad.transmutation.tileentity.TileEntityTransmutationTable;

public class ContainerTransmutationTable extends ContainerTransmutation
{
    private TileEntityTransmutationTable tileEntityTransmutationTable;

    public ContainerTransmutationTable(InventoryPlayer inventoryPlayer, TileEntityTransmutationTable tileEntityTransmutationTable)
    {
        this.tileEntityTransmutationTable = tileEntityTransmutationTable;

        this.addSlotToContainer(new Slot(tileEntityTransmutationTable, tileEntityTransmutationTable.SLOT_1,57, 57));
        this.addSlotToContainer(new Slot(tileEntityTransmutationTable, tileEntityTransmutationTable.SLOT_2,57, 18));
        this.addSlotToContainer(new Slot(tileEntityTransmutationTable, tileEntityTransmutationTable.SLOT_3,57, 96));
        this.addSlotToContainer(new Slot(tileEntityTransmutationTable, tileEntityTransmutationTable.SLOT_4,142, 18));
        this.addSlotToContainer(new Slot(tileEntityTransmutationTable, tileEntityTransmutationTable.SLOT_6,99, 18));
        this.addSlotToContainer(new Slot(tileEntityTransmutationTable, tileEntityTransmutationTable.SLOT_7,99, 96));
        this.addSlotToContainer(new Slot(tileEntityTransmutationTable, tileEntityTransmutationTable.SLOT_8,99, 57));
        this.addSlotToContainer(new Slot(tileEntityTransmutationTable, tileEntityTransmutationTable.SLOT_9,142, 96));
        this.addSlotToContainer(new Slot(tileEntityTransmutationTable, tileEntityTransmutationTable.SLOT_10,142, 57));
        this.addSlotToContainer(new Slot(tileEntityTransmutationTable, tileEntityTransmutationTable.SLOT_11,9, 57)); //Furthest Left
        this.addSlotToContainer(new Slot(tileEntityTransmutationTable, tileEntityTransmutationTable.SLOT_12,201, 57)); //Furthest Right

        for (int inventoryRowIndex = 0; inventoryRowIndex < PLAYER_INVENTORY_ROWS; ++inventoryRowIndex)
        {
            for (int inventoryColumnIndex = 0; inventoryColumnIndex < PLAYER_INVENTORY_COLUMNS; ++inventoryColumnIndex)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, inventoryColumnIndex + inventoryRowIndex * 9 + 9, 43 + inventoryColumnIndex * 18, 141 + inventoryRowIndex * 18));
            }
        }

        for (int actionBarSlotIndex = 0; actionBarSlotIndex < PLAYER_INVENTORY_COLUMNS; ++actionBarSlotIndex)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, actionBarSlotIndex, 43 + actionBarSlotIndex * 18, 199));
        }


    }
}
