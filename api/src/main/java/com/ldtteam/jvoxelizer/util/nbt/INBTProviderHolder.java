package com.ldtteam.jvoxelizer.util.nbt;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class INBTProviderHolder extends AbstractHolder<INBTProviderHolder> implements INBTProvider
{
    private static INBTProviderHolder ourInstance = new INBTProviderHolder();

    public static INBTProviderHolder getInstance()
    {
        return ourInstance;
    }

    private INBTProviderHolder()
    {
        super(INBTBase.class.getName());
    }

    @Override
    public INBTByte provide(final byte value)
    {
        return getProvider().provide(value);
    }

    @Override
    public INBTByteArray provide(final byte... value)
    {
        return getProvider().provide(value);
    }

    @Override
    public INBTCompound provide()
    {
        return getProvider().provide();
    }

    @Override
    public INBTCompound provideFromJson(final String jsonString)
    {
        return getProvider().provideFromJson(jsonString);
    }

    @Override
    public INBTList provide(final Iterable<INBTBase> values)
    {
        return getProvider().provide(values);
    }

    @Override
    public INBTDouble provide(final double value)
    {
        return getProvider().provide(value);
    }

    @Override
    public INBTFloat provide(final float value)
    {
        return getProvider().provide(value);
    }

    @Override
    public INBTInteger provide(final int value)
    {
        return getProvider().provide(value);
    }

    @Override
    public INBTLong provide(final long value)
    {
        return getProvider().provide(value);
    }

    @Override
    public INBTShort provide(final short value)
    {
        return getProvider().provide(value);
    }

    @Override
    public INBTString provide(final String value)
    {
        return getProvider().provide(value);
    }

    @Override
    public INBTIntArray provide(final int... value)
    {
        return getProvider().provide(value);
    }

    @Override
    public INBTLongArray provide(final long... value)
    {
        return getProvider().provide(value);
    }
}
