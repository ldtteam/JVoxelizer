package com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living;

import com.ldtteam.jvoxelizer.entity.living.ILivingBaseEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.NotNull;

public class LivingBaseEntity extends Entity implements ILivingBaseEntity
{
    private final EntityLivingBase entityLivingBase;

    public LivingBaseEntity(@NotNull final net.minecraft.entity.EntityLivingBase forgeEntity)
    {
        super(forgeEntity);
        entityLivingBase = forgeEntity;
    }

    /**
     * Getter for the wrapped forge element.
     * @return EntityLivingBase.
     */
    public EntityLivingBase getForgeEntity()
    {
        return this.entityLivingBase;
    }
}
