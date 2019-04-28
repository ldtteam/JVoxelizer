package com.ldtteam.jvoxelizer.launcher.forge_1_13.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.INBTByte;
import net.minecraft.nbt.NBTTagByte;

class NBTByte implements INBTByte
{
    private final NBTTagByte forgeNbtByte;

    private NBTByte(final NBTTagByte forgeNbtByte) {this.forgeNbtByte = forgeNbtByte;}

    @Override
    public byte getValue()
    {
        return forgeNbtByte.getByte();
    }

    @Override
    public byte getType()
    {
        return forgeNbtByte.getId();
    }

    public static NBTTagByte asForge(INBTByte compound)
    {
        if (compound instanceof NBTTagByte)
        {
            return (NBTTagByte) compound;
        }

        return ((NBTByte) compound).forgeNbtByte;
    }

    public static INBTByte fromForge(NBTTagByte compound)
    {
        if (compound instanceof INBTByte)
        {
            return (INBTByte) compound;
        }

        return new NBTByte(compound);
    }
}

