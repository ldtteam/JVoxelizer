package com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.player;

import com.ldtteam.jvoxelizer.entity.living.player.IMultiplayerPlayerEntity;
import net.minecraft.entity.player.EntityPlayer;
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

    public EntityPlayerMP asForge(IMultiplayerPlayerEntity playerEntity)
    {
        if (playerEntity instanceof EntityPlayerMP)
            return (EntityPlayerMP) playerEntity;

        return ((MultiplayerPlayerEntity) playerEntity).getForgePlayer();
    }

    public IMultiplayerPlayerEntity fromForge(EntityPlayerMP playerMP)
    {
        if (playerMP instanceof IMultiplayerPlayerEntity)
            return (IMultiplayerPlayerEntity) playerMP;

        return new MultiplayerPlayerEntity(playerMP);
    }
}
