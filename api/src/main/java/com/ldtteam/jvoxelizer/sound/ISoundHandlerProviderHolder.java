package com.ldtteam.jvoxelizer.sound;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class ISoundHandlerProviderHolder extends AbstractHolder<ISoundHandlerProvider> implements ISoundHandlerProvider
{
    private static ISoundHandlerProviderHolder ourInstance = new ISoundHandlerProviderHolder();

    public static ISoundHandlerProviderHolder getInstance()
    {
        return ourInstance;
    }

    private ISoundHandlerProviderHolder()
    {
        super(ISoundHandler.class.getName());
    }

    @Override
    public ISound getMissingSound()
    {
        return getProvider().getMissingSound();
    }
}