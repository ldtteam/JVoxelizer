package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.INBTIntArray;
import net.minecraft.nbt.NBTTagIntArray;

class NBTIntArray implements INBTIntArray
{
    private final NBTTagIntArray forgeNbtIntArray;

    private NBTIntArray(final NBTTagIntArray forgeNbtIntArray) {this.forgeNbtIntArray = forgeNbtIntArray;}

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

    public static NBTTagIntArray asForge(INBTIntArray compound)
    {
        if (compound instanceof NBTTagIntArray)
            return (NBTTagIntArray) compound;

        return ((NBTIntArray)compound).forgeNbtIntArray;
    }

    public static INBTIntArray fromForge(NBTTagIntArray compound)
    {
        if (compound instanceof INBTIntArray)
            return (INBTIntArray) compound;

        return new NBTIntArray(compound);
    }
}
