package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.google.common.collect.Maps;
import com.ldtteam.jvoxelizer.util.nbt.INBTBase;
import com.ldtteam.jvoxelizer.util.nbt.INBTCompound;
import net.minecraft.nbt.NBTTagCompound;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class NBTCompound implements INBTCompound
{
    private final NBTTagCompound forgeNbtCompound;

    private NBTCompound(final NBTTagCompound forgeNbtCompound) {this.forgeNbtCompound = forgeNbtCompound;}

    @Override
    public byte getType()
    {
        return forgeNbtCompound.getId();
    }

    @Override
    public int size()
    {
        return forgeNbtCompound.getKeySet().size();
    }

    @Override
    public boolean isEmpty()
    {
        return size() == 0;
    }

    @Override
    public boolean containsKey(final Object key)
    {
        return forgeNbtCompound.getKeySet().contains(key);
    }

    @Override
    public boolean containsValue(final Object value)
    {
        return toMap().containsValue(value);
    }

    @Override
    public INBTBase get(final Object key)
    {
        if (containsKey(key))
            return null;

        return NBTConversionHandler.toINbtBase(forgeNbtCompound.getTag((String) key));
    }

    @Nullable
    @Override
    public INBTBase put(final String key, final INBTBase value)
    {
        final INBTBase current = get(key);

        forgeNbtCompound.setTag(key, NBTConversionHandler.toNbtBase(value));

        return current;
    }

    @Override
    public INBTBase remove(final Object key)
    {
        if (!containsKey(key))
            return null;

        final INBTBase current = get(key);

        forgeNbtCompound.removeTag((String) key);

        return current;
    }

    @Override
    public void putAll(@NotNull final Map<? extends String, ? extends INBTBase> m)
    {
        for (final Entry<? extends String, ? extends INBTBase> entry : m.entrySet())
        {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear()
    {
        toMap().keySet().forEach(forgeNbtCompound::removeTag);
    }

    @NotNull
    @Override
    public Set<String> keySet()
    {
        return forgeNbtCompound.getKeySet();
    }

    @NotNull
    @Override
    public Collection<INBTBase> values()
    {
        return toMap().values();
    }

    @NotNull
    @Override
    public Set<Entry<String, INBTBase>> entrySet()
    {
        return toMap().entrySet();
    }

    private Map<String, INBTBase> toMap()
    {
        final Map<String, INBTBase> map = Maps.newHashMap();

        forgeNbtCompound.getKeySet().forEach(key -> map.put(key, NBTConversionHandler.toINbtBase(forgeNbtCompound.getTag(key))));

        return map;
    }

    public static NBTTagCompound asForge(INBTCompound compound)
    {
        if (compound instanceof NBTTagCompound)
            return (NBTTagCompound) compound;

        return ((NBTCompound)compound).forgeNbtCompound;
    }

    public static INBTCompound fromForge(NBTTagCompound compound)
    {
        if (compound instanceof INBTCompound)
            return (INBTCompound) compound;

        return new NBTCompound(compound);
    }
}
