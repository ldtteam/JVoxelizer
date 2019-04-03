package com.ldtteam.jvoxelizer.common.gameevent.event.player;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;

final class IPlayerGameEventProviderHolder extends AbstractHolder<IPlayerGameEventProvider> implements IPlayerGameEventProvider
{
    private static IPlayerGameEventProviderHolder ourInstance = new IPlayerGameEventProviderHolder();

    public static IPlayerGameEventProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IPlayerGameEventProviderHolder()
    {
        super(IPlayerGameEvent.class.getName());
    }

    @Override
    public IPlayerGameEvent.ILoggedInEvent provideLoggedInEvent(final IPlayerEntity playerEntity)
    {
        return getProvider().provideLoggedInEvent(playerEntity);
    }

    @Override
    public IPlayerGameEvent.ILoggedOutEvent provideLoggedOutEvent(final IPlayerEntity playerEntity)
    {
        return getProvider().provideLoggedOutEvent(playerEntity);
    }
}