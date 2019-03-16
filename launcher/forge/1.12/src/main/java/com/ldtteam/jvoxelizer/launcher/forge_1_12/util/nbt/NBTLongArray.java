package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.INBTLongArray;
import net.minecraft.nbt.NBTTagLongArray;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

class NBTLongArray implements INBTLongArray
{
    private final NBTTagLongArray forgeNbtLongArray;

    private NBTLongArray(final NBTTagLongArray forgeNbtLongArray) {this.forgeNbtLongArray = forgeNbtLongArray;}

    @Override
    public long[] getValue()
    {
        throw new NotImplementedException();
    }

    @Override
    public byte getType()
    {
        return forgeNbtLongArray.getId();
    }

    public static NBTTagLongArray asForge(INBTLongArray compound)
    {
        return ((NBTLongArray)compound).forgeNbtLongArray;
    }

    public static INBTLongArray fromForge(NBTTagLongArray compound)
    {
        return new NBTLongArray(compound);
    }
}
