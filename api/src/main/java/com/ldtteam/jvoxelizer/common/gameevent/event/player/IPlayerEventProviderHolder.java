package com.ldtteam.jvoxelizer.common.gameevent.event.player;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.IContainer;

final class IPlayerEventProviderHolder extends AbstractHolder<IPlayerEventProvider> implements IPlayerEventProvider
{
    private static IPlayerEventProviderHolder ourInstance = new IPlayerEventProviderHolder();

    public static IPlayerEventProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IPlayerEventProviderHolder()
    {
        super(IPlayerEntityEvent.class.getName());
    }

    @Override
    public IPlayerEntityEvent.IPlayerContainerEvent.IOpen provideContainerOpenEvent(final IPlayerEntity playerEntity, final IContainer<?> inventoryContainer)
    {
        return getProvider().provideContainerOpenEvent(playerEntity, inventoryContainer);
    }

    @Override
    public IPlayerEntityEvent.IPlayerContainerEvent.IClose provideContainerCloseEvent(final IPlayerEntity player, final IContainer<?> container)
    {
        return getProvider().provideContainerCloseEvent(player, container);
    }
}