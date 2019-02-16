package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.INBTLongArray;
import net.minecraft.nbt.NBTTagLongArray;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

class NBTLongArray implements INBTLongArray
{
    public final NBTTagLongArray forgeNbtLongArray;

    NBTLongArray(final NBTTagLongArray forgeNbtLongArray) {this.forgeNbtLongArray = forgeNbtLongArray;}

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
}
