package com.ldtteam.jvoxelizer.launcher.forge_1_13.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.*;
import com.ldtteam.jvoxelizer.util.nbt.INBTBase;
import net.minecraft.nbt.*;

public class NBTProvider implements INBTProvider
{
    private static NBTProvider ourInstance = new NBTProvider();

    public static NBTProvider getInstance()
    {
        return ourInstance;
    }

    private NBTProvider()
    {
    }

    @Override
    public INBTByte provide(final byte value)
    {
        return NBTByte.fromForge(new NBTTagByte(value));
    }

    @Override
    public INBTByteArray provide(final byte... value)
    {
        return NBTByteArray.fromForge(new NBTTagByteArray(value));
    }

    @Override
    public INBTCompound provide()
    {
        return NBTCompound.fromForge(new NBTTagCompound());
    }

    @Override
    public INBTCompound provideFromJson(final String jsonString)
    {
        try
        {
            return NBTCompound.fromForge(JsonToNBT.getTagFromJson(jsonString));
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public INBTList provide(final Iterable<com.ldtteam.jvoxelizer.util.nbt.INBTBase> values)
    {
        final INBTList list = NBTList.fromForge(new NBTTagList());

        for (final INBTBase value : values)
        {
            list.add(value);
        }

        return list;
    }

    @Override
    public INBTDouble provide(final double value)
    {
        return NBTDouble.fromForge(new NBTTagDouble(value));
    }

    @Override
    public INBTFloat provide(final float value)
    {
        return NBTFloat.fromForge(new NBTTagFloat(value));
    }

    @Override
    public INBTInteger provide(final int value)
    {
        return NBTInteger.fromForge(new NBTTagInt(value));
    }

    @Override
    public INBTLong provide(final long value)
    {
        return NBTLong.fromForge(new NBTTagLong(value));
    }

    @Override
    public INBTShort provide(final short value)
    {
        return NBTShort.fromForge(new NBTTagShort(value));
    }

    @Override
    public INBTString provide(final String value)
    {
        return NBTString.fromForge(new NBTTagString(value));
    }

    @Override
    public INBTIntArray provide(final int... value)
    {
        return NBTIntArray.fromForge(new NBTTagIntArray(value));
    }

    @Override
    public INBTLongArray provide(final long... value)
    {
        return NBTLongArray.fromForge(new NBTTagLongArray(value));
    }
}
