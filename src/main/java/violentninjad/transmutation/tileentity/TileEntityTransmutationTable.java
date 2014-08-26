package violentninjad.transmutation.tileentity;
//Copyright ViolentNInjaD 2014
//I knew how to do some of the code, but some of it I looked at @Pahimar's EE3 Source Code!
//https://github.com/pahimar/Equivalent-Exchange-3/

import com.pahimar.ee3.exchange.EnergyValueRegistry;
import com.pahimar.ee3.exchange.WrappedStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import violentninjad.transmutation.reference.Names;
import violentninjad.transmutation.util.LogHelper;

public class TileEntityTransmutationTable extends TileEntityTransmutation implements IInventory
{
    public static int TRANSTABLE_INVSIZE = 12;
    public static int SLOT_1 = 0;
    public static int SLOT_2 = 1;
    public static int SLOT_3 = 2;
    public static int SLOT_4 = 3;
    public static int SLOT_5 = 4;
    public static int SLOT_6 = 5;
    public static int SLOT_7 = 6;
    public static int SLOT_8 = 7;
    public static int SLOT_9 = 8;
    public static int SLOT_10 = 9;
    public static int SLOT_11 = 10;
    public static int SLOT_12 = 11;

    public static int currentEP;

    public static ItemStack getStackInInput;
    public static ItemStack getStackInTarget;
    public float energy;

    //public int inputStackSize = this.getStackInSlot(3).stackSize;
    //public String inputName = this.getStackInSlot(3).getUnlocalizedName();

    private ItemStack[] inventory;

    public TileEntityTransmutationTable()
    {
        inventory = new ItemStack[TRANSTABLE_INVSIZE];
    }

    @Override
    public int getSizeInventory()
    {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slotIndex)
    {
        return inventory[slotIndex];
    }

    @Override
    public ItemStack decrStackSize(int slotIndex, int decrementAmount)
    {
        ItemStack itemStack = getStackInSlot(slotIndex);
        if (itemStack != null)
        {
            if (itemStack.stackSize <= decrementAmount)
            {
                setInventorySlotContents(slotIndex, null);
            }
            else
            {
                itemStack = itemStack.splitStack(decrementAmount);
                if (itemStack.stackSize == 0)
                {
                    setInventorySlotContents(slotIndex, null);
                }
            }
        }

        return itemStack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slotIndex)
    {
        ItemStack itemStack = getStackInSlot(slotIndex);
        if (itemStack != null)
        {
            setInventorySlotContents(slotIndex, null);
        }
        return itemStack;
    }

    @Override
    public void setInventorySlotContents(int slotIndex, ItemStack itemStack)
    {
        inventory[slotIndex] = itemStack;
        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
        {
            itemStack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName()
    {
        return this.hasCustomName() ? this.getCustomName() : Names.Containers.TRANSMUTATION_TABLE;
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return this.hasCustomName();
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer)
    {
        return true;
    }

    @Override
    public void openInventory()
    {

    }

    @Override
    public void closeInventory()
    {

    }

    @Override
    public boolean isItemValidForSlot(int slotIndex, ItemStack itemStack)
    {
        return !EnergyValueRegistry.getInstance().hasEnergyValue(new WrappedStack(itemStack));
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);

        NBTTagList tagList = new NBTTagList();
        for (int currentIndex = 0; currentIndex < inventory.length; ++currentIndex)
        {
            if (inventory[currentIndex] != null)
            {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                inventory[currentIndex].writeToNBT(tagCompound);
                tagList.appendTag(tagCompound);
            }
        }
        nbtTagCompound.setTag(Names.NBT.ITEMS, tagList);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);

        // Read in the ItemStacks in the inventory from NBT
        NBTTagList tagList = nbtTagCompound.getTagList(Names.NBT.ITEMS, 10);
        inventory = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < tagList.tagCount(); ++i)
        {
            NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
            byte slotIndex = tagCompound.getByte("Slot");
            if (slotIndex >= 0 && slotIndex < inventory.length)
            {
                inventory[slotIndex] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
    }

    @Override
    public void updateEntity()
    {
        getStackInInput = this.getStackInSlot(10);
        getStackInTarget = this.getStackInSlot(11);

        for (int i = 8; i >= 0; i--)
        {
            if ((getStackInInput != null) && (EnergyValueRegistry.getInstance().hasEnergyValue(new WrappedStack(getStackInInput))))
            {
                float energyValue = EnergyValueRegistry.getInstance().getEnergyValue(new WrappedStack(getStackInInput)).getEnergyValue();
                while (this.energy + energyValue <= 2000000.0F)
                {
                    getStackInInput.stackSize -= 1;
                    this.energy += energyValue;

                    if(getStackInInput.stackSize == 0)
                    {
                        setInventorySlotContents(i, null);
                    }
                }
            }


        }

        if ((getStackInTarget == null) || (!EnergyValueRegistry.getInstance().hasEnergyValue(getStackInTarget)))
        {
            return;
        }

        float targetValue = EnergyValueRegistry.getInstance().getEnergyValue(new WrappedStack(getStackInTarget)).getEnergyValue();
        if (this.energy >= targetValue)
        {
            for (int i = 0; i < 10; i++)
            {
                ItemStack stackSlot = this.getStackInSlot(11);
                if (stackSlot == null)
                {
                    ItemStack stackToPut = getStackInTarget.copy();
                    stackToPut.stackSize = 1;
                    setInventorySlotContents(i, stackToPut);
                    this.energy -= targetValue;
                    return;
                }
            }
        }
    }




}
