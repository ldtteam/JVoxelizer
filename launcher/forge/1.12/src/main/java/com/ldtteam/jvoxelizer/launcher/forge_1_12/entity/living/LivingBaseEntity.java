package com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living;

import com.ldtteam.jvoxelizer.entity.living.ILivingBaseEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class LivingBaseEntity extends Entity implements ILivingBaseEntity
{
    public LivingBaseEntity(@NotNull final net.minecraft.entity.Entity forgeEntity)
    {
        super(forgeEntity);
    }
}
