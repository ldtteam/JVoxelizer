package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.INBTString;
import net.minecraft.nbt.NBTTagString;

class NBTString implements INBTString
{
    private final NBTTagString forgeNbtString;

    private NBTString(final NBTTagString forgeNbtString) {this.forgeNbtString = forgeNbtString;}

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

    public static NBTTagString asForge(INBTString compound)
    {
        if (compound instanceof NBTTagString)
        {
            return (NBTTagString) compound;
        }

        return ((NBTString) compound).forgeNbtString;
    }

    public static INBTString fromForge(NBTTagString compound)
    {
        if (compound instanceof INBTString)
        {
            return (INBTString) compound;
        }

        return new NBTString(compound);
    }
}
