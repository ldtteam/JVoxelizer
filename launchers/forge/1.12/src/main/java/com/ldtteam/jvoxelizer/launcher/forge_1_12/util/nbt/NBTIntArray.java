package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.INBTIntArray;
import net.minecraft.nbt.NBTTagIntArray;

class NBTIntArray implements INBTIntArray
{
    public final NBTTagIntArray forgeNbtIntArray;

    NBTIntArray(final NBTTagIntArray forgeNbtIntArray) {this.forgeNbtIntArray = forgeNbtIntArray;}

    @Override
    public int[] getValue()
    {
        return forgeNbtIntArray.getIntArray();
    }

    @Override
    public byte getType()
    {
        return forgeNbtIntArray.getId();
    }
}
