package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.INBTFloat;
import net.minecraft.nbt.NBTTagFloat;

class NBTFloat implements INBTFloat
{
    private final NBTTagFloat forgeNbtFloat;

    private NBTFloat(final NBTTagFloat forgeNbtFloat) {this.forgeNbtFloat = forgeNbtFloat;}

    @Override
    public float getValue()
    {
        return forgeNbtFloat.getFloat();
    }

    @Override
    public byte getType()
    {
        return forgeNbtFloat.getId();
    }

    public static NBTTagFloat asForge(INBTFloat compound)
    {
        if (compound instanceof NBTTagFloat)
            return (NBTTagFloat) compound;

        return ((NBTFloat)compound).forgeNbtFloat;
    }

    public static INBTFloat fromForge(NBTTagFloat compound)
    {
        if (compound instanceof INBTFloat)
            return (INBTFloat) compound;

        return new NBTFloat(compound);
    }
}
