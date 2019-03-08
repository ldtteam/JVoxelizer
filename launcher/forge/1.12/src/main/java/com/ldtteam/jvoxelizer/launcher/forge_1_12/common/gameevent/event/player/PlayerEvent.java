package com.ldtteam.jvoxelizer.launcher.forge_1_12.common.gameevent.event.player;

import com.ldtteam.jvoxelizer.common.gameevent.event.player.IPlayerEvent;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.IContainer;

public abstract class PlayerEvent implements IPlayerEvent
{
    private final IPlayerEntity playerEntity;

    protected PlayerEvent(final IPlayerEntity playerEntity) {this.playerEntity = playerEntity;}

    @Override
    public IPlayerEntity getPlayer()
    {
        return playerEntity;
    }

    public static class PlayerLoggedOutEvent extends PlayerEvent implements IPlayerEvent.IPlayerLoggedOutEvent
    {

        public PlayerLoggedOutEvent(final IPlayerEntity playerEntity)
        {
            super(playerEntity);
        }
    }

    public abstract static class PlayerContainerEvent extends PlayerEvent implements IPlayerEvent.IPlayerContainerEvent
    {

        private final IContainer<?> container;

        protected PlayerContainerEvent(final IPlayerEntity playerEntity, final IContainer<?> container)
        {
            super(playerEntity);
            this.container = container;
        }

        @Override
        public IContainer<?> getContainer()
        {
            return container;
        }

        public static class Open extends PlayerContainerEvent implements IPlayerContainerEvent.IOpen
        {

            public Open(final IPlayerEntity playerEntity, final IContainer<?> container)
            {
                super(playerEntity, container);
            }
        }
    }
}
