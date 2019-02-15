package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.INBTShort;
import net.minecraft.nbt.NBTTagShort;

class NBTShort implements INBTShort
{
    public final NBTTagShort forgeNbtShort;

    NBTShort(final NBTTagShort forgeNbtShort) {this.forgeNbtShort = forgeNbtShort;}

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
}

