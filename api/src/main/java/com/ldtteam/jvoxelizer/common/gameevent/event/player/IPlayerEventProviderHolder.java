package com.ldtteam.jvoxelizer.common.gameevent.event.player;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;
import com.ldtteam.jvoxelizer.entity.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.IInventoryContainer;

final class IPlayerEventProviderHolder extends AbstractHolder<IPlayerEventProvider> implements IPlayerEventProvider
{
    private static IPlayerEventProviderHolder ourInstance = new IPlayerEventProviderHolder();

    public static IPlayerEventProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IPlayerEventProviderHolder()
    {
        super(IPlayerEvent.class.getName());
    }

    @Override
    public IPlayerEvent.IPlayerContainerEvent.IOpen provideContainerOpenEvent(final IPlayerEntity playerEntity, final IInventoryContainer inventoryContainer)
    {
        return getProvider().provideContainerOpenEvent(playerEntity, inventoryContainer);
    }
}