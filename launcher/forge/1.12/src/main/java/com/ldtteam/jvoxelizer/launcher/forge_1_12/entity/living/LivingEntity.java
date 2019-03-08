package com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living;

import com.ldtteam.jvoxelizer.entity.living.ILivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import org.jetbrains.annotations.NotNull;

public class LivingEntity extends LivingBaseEntity implements ILivingEntity
{
    private final EntityLiving forgeEntityLiving;

    protected LivingEntity(@NotNull final EntityLiving forgeEntity)
    {
        super(forgeEntity);
        this.forgeEntityLiving = forgeEntity;
    }

    private EntityLiving getForgeEntityLiving()
    {
        return forgeEntityLiving;
    }

    public EntityLiving asForge(ILivingEntity entity)
    {
        if (entity instanceof EntityLiving)
            return (EntityLiving) entity;

        return ((LivingEntity) entity).getForgeEntityLiving();
    }

    public ILivingEntity fromForge(EntityLiving entityLiving)
    {
        if (entityLiving instanceof ILivingEntity)
            return (ILivingEntity) entityLiving;

        return new LivingEntity(entityLiving);
    }
}
