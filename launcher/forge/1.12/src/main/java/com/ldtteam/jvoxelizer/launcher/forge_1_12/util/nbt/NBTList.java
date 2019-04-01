package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt;

import com.google.common.collect.Lists;
import com.ldtteam.jvoxelizer.util.nbt.INBTBase;
import com.ldtteam.jvoxelizer.util.nbt.INBTList;
import net.minecraft.nbt.NBTTagList;
import org.jetbrains.annotations.NotNull;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class NBTList implements INBTList
{
    private final NBTTagList forgeNbtList;

    private NBTList(final NBTTagList forgeNbtList) {this.forgeNbtList = forgeNbtList;}

    @Override
    public byte getType()
    {
        return forgeNbtList.getId();
    }

    @Override
    public int size()
    {
        return forgeNbtList.tagCount();
    }

    @Override
    public boolean isEmpty()
    {
        return size() == 0;
    }

    @Override
    public boolean contains(final Object o)
    {
        if (!(o instanceof INBTBase))
        {
            return false;
        }

        return toList().contains(o);
    }

    @NotNull
    @Override
    public Iterator<INBTBase> iterator()
    {
        return toList().iterator();
    }

    @NotNull
    @Override
    public Object[] toArray()
    {
        return toList().toArray();
    }

    @NotNull
    @Override
    public <T> T[] toArray(@NotNull final T[] a)
    {
        return toList().toArray(a);
    }

    @Override
    public boolean add(final INBTBase inbtBase)
    {
        forgeNbtList.appendTag(NBTConversionHandler.toNbtBase(inbtBase));

        return true;
    }

    @Override
    public boolean remove(final Object o)
    {
        int index = toList().indexOf(o);

        if (index == -1)
        {
            return false;
        }

        forgeNbtList.removeTag(index);
        return true;
    }

    @Override
    public boolean containsAll(@NotNull final Collection<?> c)
    {
        return c.stream().allMatch(this::contains);
    }

    @Override
    public boolean addAll(@NotNull final Collection<? extends INBTBase> c)
    {
        return c.stream().anyMatch(this::add);
    }

    @Override
    public boolean removeAll(@NotNull final Collection<?> c)
    {
        return c.stream().anyMatch(this::remove);
    }

    @Override
    public boolean retainAll(@NotNull final Collection<?> c)
    {
        throw new NotImplementedException();
    }

    @Override
    public void clear()
    {
        removeAll(toList());
    }

    private List<INBTBase> toList()
    {
        final List<INBTBase> list = Lists.newArrayList();

        forgeNbtList.forEach(nbt -> list.add(NBTConversionHandler.toINbtBase(nbt)));

        return list;
    }

    public static INBTList fromForge(NBTTagList list)
    {
        return new NBTList(list);
    }

    public static NBTTagList asForge(INBTList list)
    {
        return ((NBTList) list).forgeNbtList;
    }
}
