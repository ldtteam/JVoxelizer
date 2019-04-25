package com.ldtteam.jvoxelizer.launcher.forge_1_13.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.INBTDouble;
import net.minecraft.nbt.NBTTagDouble;

class NBTDouble implements INBTDouble
{
    private final NBTTagDouble forgeNbtDouble;

    private NBTDouble(final NBTTagDouble forgeNbtDouble) {this.forgeNbtDouble = forgeNbtDouble;}

    @Override
    public double getValue()
    {
        return forgeNbtDouble.getDouble();
    }

    @Override
    public byte getType()
    {
        return forgeNbtDouble.getId();
    }

    public static NBTTagDouble asForge(INBTDouble compound)
    {
        if (compound instanceof NBTTagDouble)
        {
            return (NBTTagDouble) compound;
        }

        return ((NBTDouble) compound).forgeNbtDouble;
    }

    public static INBTDouble fromForge(NBTTagDouble compound)
    {
        if (compound instanceof INBTDouble)
        {
            return (INBTDouble) compound;
        }

        return new NBTDouble(compound);
    }
}
