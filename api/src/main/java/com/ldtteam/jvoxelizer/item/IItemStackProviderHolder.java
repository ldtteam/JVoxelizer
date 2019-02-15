package com.ldtteam.jvoxelizer.item;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractProviderHolder;

final class IItemStackProviderHolder extends AbstractProviderHolder<IItemStackProvider> implements IItemStackProvider
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
}
