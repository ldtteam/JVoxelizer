package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.INBTBase;
import com.ldtteam.jvoxelizer.util.nbt.INBTByte;
import com.ldtteam.jvoxelizer.util.nbt.INBTEnd;
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
                return NBTEnd.fromForge((NBTTagEnd) nbtBase);
            case 1:
                return NBTByte.fromForge((NBTTagByte) nbtBase);
            case 2:
                return NBTShort.fromForge((NBTTagShort) nbtBase);
            case 3:
                return NBTInteger.fromForge((NBTTagInt) nbtBase);
            case 4:
                return NBTLong.fromForge((NBTTagLong) nbtBase);
            case 5:
                return NBTFloat.fromForge((NBTTagFloat) nbtBase);
            case 6:
                return NBTDouble.fromForge((NBTTagDouble) nbtBase);
            case 7:
                return NBTByteArray.fromForge((NBTTagByteArray) nbtBase);
            case 8:
                return NBTString.fromForge((NBTTagString) nbtBase);
            case 9:
                return NBTList.fromForge((NBTTagList) nbtBase);
            case 10:
                return NBTCompound.fromForge((NBTTagCompound) nbtBase);
            case 11:
                return NBTIntArray.fromForge((NBTTagIntArray) nbtBase);
            case 12:
                return NBTLongArray.fromForge((NBTTagLongArray) nbtBase);
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
                return NBTEnd.asForge((INBTEnd) nbtBase);
            case 1:
                return NBTByte.asForge((INBTByte) nbtBase);
            case 2:
                return NBTShort.asForge((NBTShort) nbtBase);
            case 3:
                return NBTInteger.asForge((NBTInteger) nbtBase);
            case 4:
                return NBTLong.asForge((NBTLong) nbtBase);
            case 5:
                return NBTFloat.asForge((NBTFloat) nbtBase);
            case 6:
                return NBTDouble.asForge((NBTDouble) nbtBase);
            case 7:
                return NBTByteArray.asForge((NBTByteArray) nbtBase);
            case 8:
                return NBTString.asForge((NBTString) nbtBase);
            case 9:
                return NBTList.asForge((NBTList) nbtBase);
            case 10:
                return NBTCompound.asForge((NBTCompound) nbtBase);
            case 11:
                return NBTIntArray.asForge((NBTIntArray) nbtBase);
            case 12:
                return NBTLongArray.asForge((NBTLongArray) nbtBase);
            default:
                return null;
        }
    }
}
