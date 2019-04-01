package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.INBTLong;
import net.minecraft.nbt.NBTTagLong;

class NBTLong implements INBTLong
{
    private final NBTTagLong forgeNbtLong;

    private NBTLong(final NBTTagLong forgeNbtLong) {this.forgeNbtLong = forgeNbtLong;}

    @Override
    public long getValue()
    {
        return forgeNbtLong.getLong();
    }

    @Override
    public byte getType()
    {
        return forgeNbtLong.getId();
    }

    public static NBTTagLong asForge(INBTLong compound)
    {
        if (compound instanceof NBTTagLong)
        {
            return (NBTTagLong) compound;
        }

        return ((NBTLong) compound).forgeNbtLong;
    }

    public static INBTLong fromForge(NBTTagLong compound)
    {
        if (compound instanceof INBTLong)
        {
            return (INBTLong) compound;
        }

        return new NBTLong(compound);
    }
}

