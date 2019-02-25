package com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.player;

import com.ldtteam.jvoxelizer.entity.living.player.ISingleplayerPlayerEntity;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;

public class SinglePlayerEntity extends PlayerEntity implements ISingleplayerPlayerEntity
{
    public SinglePlayerEntity(@NotNull final EntityPlayer forgeEntity)
    {
        super(forgeEntity);
    }
}
