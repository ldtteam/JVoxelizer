package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.INBTByteArray;
import net.minecraft.nbt.NBTTagByteArray;

class NBTByteArray implements INBTByteArray
{
    private final NBTTagByteArray forgeNbtByteArray;

    private NBTByteArray(final NBTTagByteArray forgeNbtByteArray) {this.forgeNbtByteArray = forgeNbtByteArray;}

    @Override
    public byte[] getValue()
    {
        return forgeNbtByteArray.getByteArray();
    }

    @Override
    public byte getType()
    {
        return forgeNbtByteArray.getId();
    }

    public static NBTTagByteArray asForge(INBTByteArray compound)
    {
        if (compound instanceof NBTTagByteArray)
            return (NBTTagByteArray) compound;

        return ((NBTByteArray) compound).forgeNbtByteArray;
    }

    public static INBTByteArray fromForge(NBTTagByteArray compound)
    {
        if (compound instanceof INBTByteArray)
            return (INBTByteArray) compound;

        return new NBTByteArray(compound);
    }
}

