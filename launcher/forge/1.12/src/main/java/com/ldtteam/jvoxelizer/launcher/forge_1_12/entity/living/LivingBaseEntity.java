package com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living;

import com.ldtteam.jvoxelizer.entity.living.ILivingBaseEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.NotNull;

public class LivingBaseEntity extends Entity implements ILivingBaseEntity
{
    private final EntityLivingBase entityLivingBase;

    protected LivingBaseEntity(@NotNull final net.minecraft.entity.EntityLivingBase forgeEntity)
    {
        super(forgeEntity);
        entityLivingBase = forgeEntity;
    }

    private EntityLivingBase getForgeEntity()
    {
        return this.entityLivingBase;
    }

    public static EntityLivingBase asForge(ILivingBaseEntity entity)
    {
        if (entity instanceof EntityLivingBase)
            return (EntityLivingBase) entity;

        if (!(entity instanceof IForgeJVoxelizerWrapper))
            throw new IllegalArgumentException("LivingBaseEntity is not a wrapper");

        return ((IForgeJVoxelizerWrapper) entity).getForgeInstance();
    }

    public static ILivingBaseEntity fromForge(EntityLivingBase entityLivingBase)
    {
        if (entityLivingBase instanceof ILivingBaseEntity)
            return (ILivingBaseEntity) entityLivingBase;

        return new LivingBaseEntity(entityLivingBase);
    }
}
