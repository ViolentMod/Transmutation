package violentninjad.transmutation.client.gui.inventory;
//Copyright ViolentNInjaD 2014

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;
import violentninjad.transmutation.inventory.ContainerTransmutationTable;
import violentninjad.transmutation.reference.Names;
import violentninjad.transmutation.reference.Textures;
import violentninjad.transmutation.tileentity.TileEntityTransmutationTable;

public class GuiTransmutationTable extends GuiContainer
{
    private TileEntityTransmutationTable tileEntityTransmutationTable;

    public GuiTransmutationTable(InventoryPlayer inventoryPlayer, TileEntityTransmutationTable tileEntityTransmutationTable)
    {
        super(new ContainerTransmutationTable(inventoryPlayer, tileEntityTransmutationTable));
        this.tileEntityTransmutationTable = tileEntityTransmutationTable;
        xSize = 246;
        ySize = 223;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        String containerName = StatCollector.translateToLocal(Names.Containers.TRANSMUTATION_TABLE);
        fontRendererObj.drawString(containerName, xSize / 2 - fontRendererObj.getStringWidth(containerName) / 2, 6, 4210752);
        fontRendererObj.drawString(StatCollector.translateToLocal(Names.Containers.VANILLA_INV), 8, ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        this.mc.getTextureManager().bindTexture(Textures.GUI.TRANSMUTATION_TABLE);

        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }
}
