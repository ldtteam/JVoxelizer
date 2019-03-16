package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

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
        return ((NBTDouble)compound).forgeNbtDouble;
    }

    public static INBTDouble fromForge(NBTTagDouble compound)
    {
        return new NBTDouble(compound);
    }
}
