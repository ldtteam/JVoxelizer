package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.INBTString;
import net.minecraft.nbt.NBTTagString;

class NBTString implements INBTString
{
    public final NBTTagString forgeNbtString;

    NBTString(final NBTTagString forgeNbtString) {this.forgeNbtString = forgeNbtString;}

    @Override
    public String getValue()
    {
        return forgeNbtString.getString();
    }

    @Override
    public byte getType()
    {
        return forgeNbtString.getId();
    }
}
