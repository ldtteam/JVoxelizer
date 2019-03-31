package com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.player;

import com.ldtteam.jvoxelizer.entity.living.player.IMultiplayerPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.IContainerListener;
import net.minecraft.entity.player.EntityPlayerMP;
import org.jetbrains.annotations.NotNull;

public class MultiplayerPlayerEntity extends PlayerEntity implements IMultiplayerPlayerEntity, IContainerListener
{
    private EntityPlayerMP forgeMPPlayer;

    private MultiplayerPlayerEntity(@NotNull final EntityPlayerMP forgeEntity)
    {
        super(forgeEntity);
        forgeMPPlayer = forgeEntity;
    }

    @Override
    public void incrementWindowId()
    {
        forgeMPPlayer.currentWindowId++;
    }

    @Override
    public void closeOpenContainer()
    {
        forgeMPPlayer.closeContainer();
    }

    @Override
    public int getCurrentWindowId()
    {
        return forgeMPPlayer.currentWindowId;
    }

    private EntityPlayerMP getForgePlayer()
    {
        return this.forgeMPPlayer;
    }

    public static EntityPlayerMP asForge(IMultiplayerPlayerEntity playerEntity)
    {
        if (playerEntity instanceof EntityPlayerMP)
            return (EntityPlayerMP) playerEntity;

        return ((MultiplayerPlayerEntity) playerEntity).getForgePlayer();
    }

    public static IMultiplayerPlayerEntity fromForge(EntityPlayerMP playerMP)
    {
        if (playerMP instanceof IMultiplayerPlayerEntity)
            return (IMultiplayerPlayerEntity) playerMP;

        return new MultiplayerPlayerEntity(playerMP);
    }
}
