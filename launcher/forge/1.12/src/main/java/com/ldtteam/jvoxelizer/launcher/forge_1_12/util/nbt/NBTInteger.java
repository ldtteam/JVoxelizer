package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.INBTInteger;
import net.minecraft.nbt.NBTTagInt;

class NBTInteger implements INBTInteger
{
    private final NBTTagInt forgeNbtInt;

    private NBTInteger(final NBTTagInt forgeNbtInt) {this.forgeNbtInt = forgeNbtInt;}

    @Override
    public int getValue()
    {
        return forgeNbtInt.getInt();
    }

    @Override
    public byte getType()
    {
        return forgeNbtInt.getId();
    }

    public static NBTTagInt asForge(INBTInteger compound)
    {
        if (compound instanceof NBTTagInt)
        {
            return (NBTTagInt) compound;
        }

        return ((NBTInteger) compound).forgeNbtInt;
    }

    public static INBTInteger fromForge(NBTTagInt compound)
    {
        if (compound instanceof INBTInteger)
        {
            return (INBTInteger) compound;
        }

        return new NBTInteger(compound);
    }
}
