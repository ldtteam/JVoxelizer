package com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living;

import com.ldtteam.jvoxelizer.entity.living.ILivingEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import net.minecraft.entity.EntityLiving;
import org.jetbrains.annotations.NotNull;

public class LivingEntity extends LivingBaseEntity implements ILivingEntity
{
    private final EntityLiving forgeEntityLiving;

    private LivingEntity(@NotNull final EntityLiving forgeEntity)
    {
        super(forgeEntity);
        this.forgeEntityLiving = forgeEntity;
    }

    private EntityLiving getForgeEntityLiving()
    {
        return forgeEntityLiving;
    }

    public static EntityLiving asForge(ILivingEntity entity)
    {
        if (entity instanceof EntityLiving)
        {
            return (EntityLiving) entity;
        }

        if (entity == null)
        {
            return null;
        }

        if (!(entity instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("EntityLiving is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) entity).getForgeInstance();
    }

    public static ILivingEntity fromForge(EntityLiving entityLiving)
    {
        if (entityLiving instanceof ILivingEntity)
        {
            return (ILivingEntity) entityLiving;
        }

        return new LivingEntity(entityLiving);
    }
}
