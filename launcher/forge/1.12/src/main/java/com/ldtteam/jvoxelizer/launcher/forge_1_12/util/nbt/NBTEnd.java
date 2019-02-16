package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.INBTEnd;
import net.minecraft.nbt.NBTTagEnd;

class NBTEnd implements INBTEnd
{
    public final NBTTagEnd forgeNbtEnd;

    NBTEnd(final NBTTagEnd forgeNbtEnd) {this.forgeNbtEnd = forgeNbtEnd;}

    @Override
    public byte getType()
    {
        return forgeNbtEnd.getId();
    }
}
