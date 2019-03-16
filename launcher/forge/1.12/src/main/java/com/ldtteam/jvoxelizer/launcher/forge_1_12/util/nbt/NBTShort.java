package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.INBTShort;
import net.minecraft.nbt.NBTTagShort;

class NBTShort implements INBTShort
{
    private final NBTTagShort forgeNbtShort;

    private NBTShort(final NBTTagShort forgeNbtShort) {this.forgeNbtShort = forgeNbtShort;}

    @Override
    public short getValue()
    {
        return forgeNbtShort.getShort();
    }

    @Override
    public byte getType()
    {
        return forgeNbtShort.getId();
    }

    public static NBTTagShort asForge(INBTShort compound)
    {
        if (compound instanceof NBTTagShort)
            return (NBTTagShort) compound;

        return ((NBTShort)compound).forgeNbtShort;
    }

    public static INBTShort fromForge(NBTTagShort compound)
    {
        if (compound instanceof INBTShort)
            return (INBTShort) compound;

        return new NBTShort(compound);
    }
}

