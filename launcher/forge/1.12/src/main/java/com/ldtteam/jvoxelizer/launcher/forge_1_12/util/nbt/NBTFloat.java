package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.INBTFloat;
import net.minecraft.nbt.NBTTagFloat;

class NBTFloat implements INBTFloat
{
    public final NBTTagFloat forgeNbtFloat;

    NBTFloat(final NBTTagFloat forgeNbtFloat) {this.forgeNbtFloat = forgeNbtFloat;}

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
}
