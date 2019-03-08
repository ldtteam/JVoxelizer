package com.ldtteam.jvoxelizer.client.renderer.tessellator;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

/**
 * Holder for the logic that provides access to the tessellator.
 */
final class ITessellatorProviderHolder extends AbstractHolder<ITessellatorProvider> implements ITessellatorProvider
{
    private static ITessellatorProviderHolder ourInstance = new ITessellatorProviderHolder();

    public static ITessellatorProviderHolder getInstance()
    {
        return ourInstance;
    }

    private ITessellatorProviderHolder()
    {
        super(ITessellator.class.getName());
    }

    @Override
    public ITessellator provideInstance()
    {
        return getProvider().provideInstance();
    }
}