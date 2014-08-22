package violentninjad.transmutation.block;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import violentninjad.transmutation.Transmutation;
import violentninjad.transmutation.creativetab.TransmutationTab;

public class BlockTransmutation extends Block
{
    public BlockTransmutation()
    {
        this(Material.rock);
    }

    public BlockTransmutation(Material material)
    {
        super(material);
        this.setCreativeTab(TransmutationTab.tabTransmutation);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Transmutation.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
