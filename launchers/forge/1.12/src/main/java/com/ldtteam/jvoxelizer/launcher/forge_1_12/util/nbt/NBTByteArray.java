package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.INBTByteArray;
import net.minecraft.nbt.NBTTagByteArray;

class NBTByteArray implements INBTByteArray
{
    public final NBTTagByteArray forgeNbtByteArray;

    NBTByteArray(final NBTTagByteArray forgeNbtByteArray) {this.forgeNbtByteArray = forgeNbtByteArray;}

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
}

