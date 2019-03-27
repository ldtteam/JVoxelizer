package com.ldtteam.jvoxelizer.item;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class IItemProviderHolder extends AbstractHolder<IItemProvider> implements IItemProvider
{
    private static IItemProviderHolder ourInstance = new IItemProviderHolder();

    public static IItemProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IItemProviderHolder()
    {
        super(IItem.class.getName());
    }

    @Override
    public int provideIdFromItem(final IItem<?> item)
    {
        return getProvider().provideIdFromItem(item);
    }
}