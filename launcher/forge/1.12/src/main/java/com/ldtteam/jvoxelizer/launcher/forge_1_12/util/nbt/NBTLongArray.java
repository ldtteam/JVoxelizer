package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.INBTLongArray;
import net.minecraft.nbt.NBTTagLongArray;

class NBTLongArray implements INBTLongArray
{
    private final NBTTagLongArray forgeNbtLongArray;

    private NBTLongArray(final NBTTagLongArray forgeNbtLongArray) {this.forgeNbtLongArray = forgeNbtLongArray;}

    @Override
    public long[] getValue()
    {
        return forgeNbtLongArray.data;
    }

    @Override
    public byte getType()
    {
        return forgeNbtLongArray.getId();
    }

    public static NBTTagLongArray asForge(INBTLongArray compound)
    {
        if (compound instanceof NBTTagLongArray)
        {
            return (NBTTagLongArray) compound;
        }

        return ((NBTLongArray) compound).forgeNbtLongArray;
    }

    public static INBTLongArray fromForge(NBTTagLongArray compound)
    {
        if (compound instanceof INBTLongArray)
        {
            return (INBTLongArray) compound;
        }

        return new NBTLongArray(compound);
    }
}
