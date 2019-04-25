package com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.living.player;

import com.ldtteam.jvoxelizer.entity.living.player.IMultiplayerPlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;
import net.minecraft.entity.player.EntityPlayerMP;
import org.jetbrains.annotations.NotNull;

public class MultiplayerPlayerEntity extends PlayerEntity implements IMultiplayerPlayerEntity
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
        {
            return (EntityPlayerMP) playerEntity;
        }

        if (playerEntity == null)
        {
            return null;
        }

        if (!(playerEntity instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("PlayerEntity is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) playerEntity).getForgeInstance();
    }

    public static IMultiplayerPlayerEntity fromForge(EntityPlayerMP playerMP)
    {
        if (playerMP instanceof IMultiplayerPlayerEntity)
        {
            return (IMultiplayerPlayerEntity) playerMP;
        }

        return new MultiplayerPlayerEntity(playerMP);
    }
}
