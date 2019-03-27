package com.ldtteam.jvoxelizer.item;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class IItemStackProviderHolder extends AbstractHolder<IItemStackProvider> implements IItemStackProvider
{
    private static IItemStackProviderHolder ourInstance = new IItemStackProviderHolder();

    public static IItemStackProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IItemStackProviderHolder()
    {
        super(IItemStack.class.getName());
    }

    @Override
    public IItemStack provide()
    {
        return getProvider().provide();
    }

    @Override
    public boolean areItemStackTagsEqual(final IItemStack pItemStack1, final IItemStack pItemStack2)
    {
        return getProvider().areItemStackTagsEqual(pItemStack1, pItemStack2);
    }
}
