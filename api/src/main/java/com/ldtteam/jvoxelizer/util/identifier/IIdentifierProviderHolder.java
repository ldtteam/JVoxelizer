package com.ldtteam.jvoxelizer.util.identifier;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class IIdentifierProviderHolder extends AbstractHolder<IIdentifierProvider> implements IIdentifierProvider
{
    private static IIdentifierProviderHolder ourInstance = new IIdentifierProviderHolder();

    public static IIdentifierProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IIdentifierProviderHolder()
    {
        super(IIdentifier.class.getName());
    }

    @Override
    public IIdentifier provide(final String domain, final String path)
    {
        return getProvider().provide(domain, path);
    }

    @Override
    public IIdentifier provide(final String string)
    {
        return getProvider().provide(string);
    }
}
