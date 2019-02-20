package com.ldtteam.jvoxelizer.client.renderer.tessellator;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

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