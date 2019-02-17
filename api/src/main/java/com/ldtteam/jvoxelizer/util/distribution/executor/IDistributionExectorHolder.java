package com.ldtteam.jvoxelizer.util.distribution.executor;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

import java.util.function.Supplier;

public class IDistributionExectorHolder extends AbstractHolder<IDistributionExecutor> implements IDistributionExecutor
{
    private static IDistributionExectorHolder ourInstance = new IDistributionExectorHolder();

    public static IDistributionExectorHolder getInstance()
    {
        return ourInstance;
    }

    private IDistributionExectorHolder()
    {
        super(IDistributionExecutor.class.getName());
    }

    @Override
    public void runOnClient(final Runnable runnable)
    {
        getProvider().runOnClient(runnable);
    }

    @Override
    public void runOnServer(final Runnable runnable)
    {
        getProvider().runOnServer(runnable);
    }

    @Override
    public <T> T runOn(final Supplier<T> clientSide, final Supplier<T> serverSide)
    {
        return getProvider().runOn(clientSide, serverSide);
    }
}
