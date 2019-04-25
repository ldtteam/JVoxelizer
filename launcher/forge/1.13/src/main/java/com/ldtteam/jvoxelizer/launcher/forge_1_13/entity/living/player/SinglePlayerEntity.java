package com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.living.player;

import com.ldtteam.jvoxelizer.entity.living.player.ISingleplayerPlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

public class SinglePlayerEntity extends PlayerEntity implements ISingleplayerPlayerEntity
{
    private final EntityPlayerSP forgeEntity;

    private SinglePlayerEntity(@NotNull final EntityPlayerSP forgeEntity)
    {
        super(forgeEntity);
        this.forgeEntity = forgeEntity;
    }

    private EntityPlayerSP getForgeEntity()
    {
        return forgeEntity;
    }

    public static EntityPlayerSP asForge(ISingleplayerPlayerEntity playerEntity)
    {
        if (playerEntity instanceof EntityPlayerSP)
        {
            return (EntityPlayerSP) playerEntity;
        }

        if (playerEntity == null)
        {
            return null;
        }

        if (!(playerEntity instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("SinglePlayerEntity is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) playerEntity).getForgeInstance();
    }

    public static ISingleplayerPlayerEntity fromForge(EntityPlayerSP playerSP)
    {
        if (playerSP instanceof ISingleplayerPlayerEntity)
        {
            return (ISingleplayerPlayerEntity) playerSP;
        }

        return new SinglePlayerEntity(playerSP);
    }
}
