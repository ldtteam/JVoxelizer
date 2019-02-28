package com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.player;

import com.ldtteam.jvoxelizer.entity.living.player.IMultiplayerPlayerEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import org.jetbrains.annotations.NotNull;

public class MultiplayerPlayerEntity extends PlayerEntity implements IMultiplayerPlayerEntity
{
    private EntityPlayerMP forgeMPPlayer;

    public MultiplayerPlayerEntity(@NotNull final EntityPlayerMP forgeEntity)
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

    /**
     * Getter for the wrapped forge object.
     * @return the EntityPlayerMP.
     */
    public EntityPlayerMP getForgePlayer()
    {
        return this.forgeMPPlayer;
    }
}
