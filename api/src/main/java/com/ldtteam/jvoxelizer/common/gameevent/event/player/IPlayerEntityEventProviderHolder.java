package com.ldtteam.jvoxelizer.common.gameevent.event.player;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.IContainer;

final class IPlayerEntityEventProviderHolder extends AbstractHolder<IPlayerEntityEventProvider> implements IPlayerEntityEventProvider
{
    private static IPlayerEntityEventProviderHolder ourInstance = new IPlayerEntityEventProviderHolder();

    public static IPlayerEntityEventProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IPlayerEntityEventProviderHolder()
    {
        super(IPlayerEntityEvent.class.getName());
    }

    @Override
    public IPlayerEntityEvent.IContainerEvent.IOpen provideContainerOpenEvent(final IPlayerEntity playerEntity, final IContainer<?> inventoryContainer)
    {
        return getProvider().provideContainerOpenEvent(playerEntity, inventoryContainer);
    }

    @Override
    public IPlayerEntityEvent.IContainerEvent.IClose provideContainerCloseEvent(final IPlayerEntity player, final IContainer<?> container)
    {
        return getProvider().provideContainerCloseEvent(player, container);
    }
}