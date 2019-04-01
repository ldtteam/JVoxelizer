package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.INBTEnd;
import net.minecraft.nbt.NBTTagEnd;

class NBTEnd implements INBTEnd
{
    private final NBTTagEnd forgeNbtEnd;

    private NBTEnd(final NBTTagEnd forgeNbtEnd) {this.forgeNbtEnd = forgeNbtEnd;}

    @Override
    public byte getType()
    {
        return forgeNbtEnd.getId();
    }

    public static NBTTagEnd asForge(INBTEnd compound)
    {
        if (compound instanceof NBTTagEnd)
        {
            return (NBTTagEnd) compound;
        }

        return ((NBTEnd) compound).forgeNbtEnd;
    }

    public static INBTEnd fromForge(NBTTagEnd compound)
    {
        if (compound instanceof INBTEnd)
        {
            return (INBTEnd) compound;
        }

        return new NBTEnd(compound);
    }
}
