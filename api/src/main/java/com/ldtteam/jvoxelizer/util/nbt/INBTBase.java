package com.ldtteam.jvoxelizer.util.nbt;

import java.util.List;

/**
 * The base type for named binary data.
 */
public interface INBTBase
{

    /**
     * Creates a new NBT entry with a {@link Byte} as contained data.
     * 
     * @param value The contained {@link Byte}
     * @return The {@link INBTByte} containing the given {@link Byte}.
     */
    static INBTByte create(final byte value)
    {
        return INBTProviderHolder.getInstance().provide(value);
    }

    /**
     * Creates a new NBT entry with a {@link Byte[]} as contained data.
     *
     * @param value The contained {@link Byte[]}
     * @return The {@link INBTByteArray} containing the given {@link Byte[]}.
     */
    static INBTByteArray create(final byte... value)
    {
        return INBTProviderHolder.getInstance().provide(value);
    }

    /**
     * Creates a new NBT entry that can be composed of several other entries.
     *
     * @return The {@link INBTCompound}.
     */
    static INBTCompound create()
    {
        return INBTProviderHolder.getInstance().provide();
    }

    /**
     * Creates a new NBT entry with a {@link List} as contained data.
     *
     * @param values The contained {@link List} in {@link Iterable} form.
     * @return The {@link INBTList} containing the given {@link List}.
     */
    static INBTList create(final Iterable<INBTBase> values)
    {
        return INBTProviderHolder.getInstance().provide(values);
    }

    /**
     * Creates a new NBT entry with a {@link Double} as contained data.
     *
     * @param value The contained {@link Double}
     * @return The {@link INBTDouble} containing the given {@link Double}.
     */
    static INBTDouble create(final double value)
    {
        return INBTProviderHolder.getInstance().provide(value);
    }

    /**
     * Creates a new NBT entry with a {@link Float} as contained data.
     *
     * @param value The contained {@link Float}
     * @return The {@link INBTFloat} containing the given {@link Float}.
     */
    static INBTFloat create(final float value)
    {
        return INBTProviderHolder.getInstance().provide(value);
    }

    /**
     * Creates a new NBT entry with a {@link Integer} as contained data.
     *
     * @param value The contained {@link Integer}
     * @return The {@link INBTInteger} containing the given {@link Integer}.
     */
    static INBTInteger create(final int value)
    {
        return INBTProviderHolder.getInstance().provide(value);
    }

    /**
     * Creates a new NBT entry with a {@link Long} as contained data.
     *
     * @param value The contained {@link Long}
     * @return The {@link INBTLong} containing the given {@link Long}.
     */
    static INBTLong create(final long value)
    {
        return INBTProviderHolder.getInstance().provide(value);
    }

    /**
     * Creates a new NBT entry with a {@link Short} as contained data.
     *
     * @param value The contained {@link Short}
     * @return The {@link INBTShort} containing the given {@link Short}.
     */
    static INBTShort create(final short value)
    {
        return INBTProviderHolder.getInstance().provide(value);
    }

    /**
     * Creates a new NBT entry with a {@link String} as contained data.
     *
     * @param value The contained {@link String}
     * @return The {@link INBTString} containing the given {@link String}.
     */
    static INBTString create(final String value)
    {
        return INBTProviderHolder.getInstance().provide(value);
    }

    /**
     * Creates a new NBT entry with a {@link int[]} as contained data.
     *
     * @param value The contained {@link int[]}
     * @return The {@link INBTIntArray} containing the given {@link int[]}.
     */
    static INBTIntArray create(final int... value)
    {
        return INBTProviderHolder.getInstance().provide(value);
    }

    /**
     * Creates a new NBT entry with a {@link long[]} as contained data.
     *
     * @param value The contained {@link long[]}
     * @return The {@link INBTLongArray} containing the given {@link long[]}.
     */
    static INBTLongArray create(final long... value)
    {
        return INBTProviderHolder.getInstance().provide(value);
    }

    /**
     * The id of the type stored in this {@link INBTBase}.
     *
     * @return The type id.
     */
    byte getType();
}
