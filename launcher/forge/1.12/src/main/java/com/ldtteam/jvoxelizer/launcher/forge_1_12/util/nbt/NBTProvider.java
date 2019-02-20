package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.ldtteam.jvoxelizer.util.nbt.*;
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
        return new NBTByte(new NBTTagByte(value));
    }

    @Override
    public INBTByteArray provide(final byte... value)
    {
        return new NBTByteArray(new NBTTagByteArray(value));
    }

    @Override
    public INBTCompound provide()
    {
        return new NBTCompound(new NBTTagCompound());
    }

    @Override
    public INBTCompound provideFromJson(final String jsonString)
    {
        try
        {
            return new NBTCompound(JsonToNBT.getTagFromJson(jsonString));
        }
        catch (NBTException e)
        {
            return null;
        }
    }

    @Override
    public INBTList provide(final Iterable<INBTBase> values)
    {
        final NBTList list = new NBTList(new NBTTagList());

        for (final INBTBase value : values)
        {
            list.add(value);
        }

        return list;
    }

    @Override
    public INBTDouble provide(final double value)
    {
        return new NBTDouble(new NBTTagDouble(value));
    }

    @Override
    public INBTFloat provide(final float value)
    {
        return new NBTFloat(new NBTTagFloat(value));
    }

    @Override
    public INBTInteger provide(final int value)
    {
        return new NBTInteger(new NBTTagInt(value));
    }

    @Override
    public INBTLong provide(final long value)
    {
        return new NBTLong(new NBTTagLong(value));
    }

    @Override
    public INBTShort provide(final short value)
    {
        return new NBTShort(new NBTTagShort(value));
    }

    @Override
    public INBTString provide(final String value)
    {
        return new NBTString(new NBTTagString(value));
    }

    @Override
    public INBTIntArray provide(final int... value)
    {
        return new NBTIntArray(new NBTTagIntArray(value));
    }

    @Override
    public INBTLongArray provide(final long... value)
    {
        return new NBTLongArray(new NBTTagLongArray(value));
    }
}
