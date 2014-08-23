package violentninjad.transmutation.reference;
//Copyright ViolentNInjaD 2014

public class Names
{
    public static final class Items
    {
        public static final String DARK_MATTER = "darkMatter";
        public static final String RED_MATTER = "redMatter";
        public static final String AETERNALIS_FUEL = "aeternalisFuel";
    }

    public static final class Blocks
    {
        public static final String DARK_MATTER = "darkMatterBlock";
        public static final String RED_MATTER = "redMatterBlock";
        public static final String RED_MATTER_SOLAR = "redMatterSolar";
        public static final String DARK_MATTER_SOLAR = "darkMatterSolar";
        public static final String TRANSMUTATION_TABLE = "transmutationTable";
    }

    public static final class NBT
    {
        public static final String STATE = "teState";
        public static final String CUSTOM_NAME = "CustomName";
        public static final String DIRECTION = "teDirection";
        public static final String OWNER = "owner";
        public static final String OWNER_UUID_MOST_SIG = "ownerUUIDMostSig";
        public static final String OWNER_UUID_LEAST_SIG = "ownerUUIDLeastSig";
        public static final String UUID_MOST_SIG = "UUIDMostSig";
        public static final String UUID_LEAST_SIG = "UUIDLeastSig";
        public static final String TRANSMUTATION_TABLE_GUI_OPEN = "transmutationGuiOpen";
        public static final String ITEMS = "Items";
    }

    public static final class Containers
    {
        public static final String TRANSMUTATION_TABLE = "container.transmutation:" + Blocks.TRANSMUTATION_TABLE;
        public static final String VANILLA_INV = "container.inventory";
    }
}
