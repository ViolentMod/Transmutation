package violentninjad.transmutation.net;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;
import violentninjad.transmutation.tileentity.TileEntityTransmutation;

public class MessageTileEntityTransmutation implements IMessage, IMessageHandler<MessageTileEntityTransmutation, IMessage>
{
    public int x, y, z;
    public byte orientation, state;
    public String customName, owner;

    public MessageTileEntityTransmutation()
    {

    }

    public MessageTileEntityTransmutation(TileEntityTransmutation tileEntityTransmutation)
    {
        this.x = tileEntityTransmutation.xCoord;
        this.y = tileEntityTransmutation.yCoord;
        this.z = tileEntityTransmutation.zCoord;
        this.orientation = (byte) tileEntityTransmutation.getOrientation().ordinal();
        this.state = (byte) tileEntityTransmutation.getState();
        this.customName = tileEntityTransmutation.getCustomName();
        this.owner = tileEntityTransmutation.getOwner();
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.orientation = buf.readByte();
        this.state = buf.readByte();
        int customNameLength = buf.readInt();
        this.customName = new String(buf.readBytes(customNameLength).array());
        int ownerLength = buf.readInt();
        this.owner = new String(buf.readBytes(ownerLength).array());
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeByte(orientation);
        buf.writeByte(state);
        buf.writeInt(customName.length());
        buf.writeBytes(customName.getBytes());
        buf.writeInt(owner.length());
        buf.writeBytes(owner.getBytes());
    }

    @Override
    public IMessage onMessage(MessageTileEntityTransmutation message, MessageContext ctx)
    {
        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);

        if (tileEntity instanceof TileEntityTransmutation)
        {
            ((TileEntityTransmutation) tileEntity).setOrientation(message.orientation);
            ((TileEntityTransmutation) tileEntity).setState(message.state);
            ((TileEntityTransmutation) tileEntity).setCustomName(message.customName);
            ((TileEntityTransmutation) tileEntity).setOwner(message.owner);
        }

        return null;
    }

    @Override
    public String toString()
    {
        return String.format("MessageTileEntityTransmutation - x:%s, y:%s, z:%s, orientation:%s, state:%s, customName:%s, owner:%s", x, y, z, orientation, state, customName, owner);
    }

}
