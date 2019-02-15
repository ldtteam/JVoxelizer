package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.INBTBase;
import net.minecraft.nbt.*;

public final class NBTConversionHandler
{

    private NBTConversionHandler()
    {
        throw new IllegalStateException("Tried to initialize: NBTConversionHandler but this is a Utility class.");
    }

    public static INBTBase toINbtBase(final NBTBase nbtBase)
    {
        if (nbtBase == null)
            return null;

        final int type = nbtBase.getId();

        switch (type)
        {
            case 0:
                return new NBTEnd((NBTTagEnd) nbtBase);
            case 1:
                return new NBTByte((NBTTagByte) nbtBase);
            case 2:
                return new NBTShort((NBTTagShort) nbtBase);
            case 3:
                return new NBTInteger((NBTTagInt) nbtBase);
            case 4:
                return new NBTLong((NBTTagLong) nbtBase);
            case 5:
                return new NBTFloat((NBTTagFloat) nbtBase);
            case 6:
                return new NBTDouble((NBTTagDouble) nbtBase);
            case 7:
                return new NBTByteArray((NBTTagByteArray) nbtBase);
            case 8:
                return new NBTString((NBTTagString) nbtBase);
            case 9:
                return new NBTList((NBTTagList) nbtBase);
            case 10:
                return new NBTCompound((NBTTagCompound) nbtBase);
            case 11:
                return new NBTIntArray((NBTTagIntArray) nbtBase);
            case 12:
                return new NBTLongArray((NBTTagLongArray) nbtBase);
            default:
                return null;
        }
    }

    public static NBTBase toNbtBase(final INBTBase nbtBase)
    {
        final int type = nbtBase.getType();

        switch (type)
        {
            case 0:
                return new NBTTagEnd();
            case 1:
                return ((NBTByte) nbtBase).forgeNbtByte;
            case 2:
                return ((NBTShort) nbtBase).forgeNbtShort;
            case 3:
                return ((NBTInteger) nbtBase).forgeNbtInt;
            case 4:
                return ((NBTLong) nbtBase).forgeNbtLong;
            case 5:
                return ((NBTFloat) nbtBase).forgeNbtFloat;
            case 6:
                return ((NBTDouble) nbtBase).forgeNbtDouble;
            case 7:
                return ((NBTByteArray) nbtBase).forgeNbtByteArray;
            case 8:
                return ((NBTString) nbtBase).forgeNbtString;
            case 9:
                return ((NBTList) nbtBase).forgeNbtList;
            case 10:
                return ((NBTCompound) nbtBase).forgeNbtCompound;
            case 11:
                return ((NBTIntArray) nbtBase).forgeNbtIntArray;
            case 12:
                return ((NBTLongArray) nbtBase).forgeNbtLongArray;
            default:
                return null;
        }
    }
}
