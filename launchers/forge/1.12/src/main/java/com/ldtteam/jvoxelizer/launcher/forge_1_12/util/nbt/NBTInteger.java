package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.INBTInteger;
import net.minecraft.nbt.NBTTagInt;

class NBTInteger implements INBTInteger
{
    public final NBTTagInt forgeNbtInt;

    NBTInteger(final NBTTagInt forgeNbtInt) {this.forgeNbtInt = forgeNbtInt;}

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
}
