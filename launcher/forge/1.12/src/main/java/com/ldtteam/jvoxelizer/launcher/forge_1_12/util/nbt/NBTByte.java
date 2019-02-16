package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.INBTByte;
import net.minecraft.nbt.NBTTagByte;

class NBTByte implements INBTByte
{
    public final NBTTagByte forgeNbtByte;

    NBTByte(final NBTTagByte forgeNbtByte) {this.forgeNbtByte = forgeNbtByte;}

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
}

