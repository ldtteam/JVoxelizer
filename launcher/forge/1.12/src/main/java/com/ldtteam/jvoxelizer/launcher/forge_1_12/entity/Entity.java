package com.ldtteam.jvoxelizer.launcher.forge_1_12.entity;

import com.ldtteam.jvoxelizer.common.capability.ICapability;
import com.ldtteam.jvoxelizer.entity.IEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt.NBTCompound;
import com.ldtteam.jvoxelizer.util.facing.IFacing;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
import com.ldtteam.jvoxelizer.util.math.coordinate.entity.IEntityCoordinate;
import com.ldtteam.jvoxelizer.util.nbt.INBTCompound;
import com.ldtteam.jvoxelizer.util.ticking.data.IReadOnlyTickingDataEntry;
import com.ldtteam.jvoxelizer.util.ticking.data.ITickingDataEntry;
import net.minecraft.nbt.NBTTagCompound;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class Entity implements IEntity
{
    net.minecraft.entity.Entity forgeEntity;

    public Entity(@NotNull final net.minecraft.entity.Entity forgeEntity)
    {
        this.forgeEntity = forgeEntity;
    }

    @Override
    public UUID getId()
    {
        return forgeEntity.getUniqueID();
    }

    @Override
    public boolean shouldEntitySpawn()
    {
        return forgeEntity.preventEntitySpawning;
    }

    @Override
    public boolean shouldEntityForceSpawn()
    {
        return forgeEntity.forceSpawn;
    }

    @Override
    public int getDimension()
    {
        return forgeEntity.dimension;
    }

    @Override
    public ITickingDataEntry<IEntityCoordinate> getPositionOfEntityOrigin()
    {
        // TODO
        return forgeEntity.getPosition();
    }

    @Override
    public ITickingDataEntry<IBlockCoordinate> getPositionOfBlockContainingEntity()
    {
        // TODO
        return null;
    }

    @Override
    public IReadOnlyTickingDataEntry<Float> getRotationYaw()
    {
        // TODO
        return null;
    }

    @Override
    public IReadOnlyTickingDataEntry<Float> getRotationPitch()
    {
        // TODO
        return null;
    }

    @Override
    public boolean isOnGround()
    {
        return forgeEntity.onGround;
    }

    @Override
    public boolean hasCollidedHorizontally()
    {
        return forgeEntity.collidedHorizontally;
    }

    @Override
    public boolean hasCollidedVertically()
    {
        return forgeEntity.collidedVertically;
    }

    @Override
    public boolean hasVelocityChanged()
    {
        return forgeEntity.velocityChanged;
    }

    @Override
    public boolean isDead()
    {
        return forgeEntity.isDead;
    }

    @Override
    public float getWidth()
    {
        return forgeEntity.width;
    }

    @Override
    public IReadOnlyTickingDataEntry<Float> getDistanceWalkedModified()
    {
        // TODO
        return null;
    }

    @Override
    public float getDistanceWalkedOnStepModified()
    {
        return forgeEntity.distanceWalkedOnStepModified;
    }

    @Override
    public float getFallDistance()
    {
        return forgeEntity.fallDistance;
    }

    @Override
    public IEntity setFallDistance(final float fallDistance)
    {
        forgeEntity.fallDistance = fallDistance;
        return this;
    }

    @Override
    public boolean hasCapability(final ICapability<?> capability, final IFacing facing)
    {
        // TODO
        return forgeEntity.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(final ICapability<T> capability, final IFacing facing)
    {
        // TODO
        return forgeEntity.getCapability(capability, facing);
    }

    @Override
    public INBTCompound write()
    {
        return new NBTCompound(forgeEntity.writeToNBT(new NBTTagCompound()));
    }

    @Override
    public void read(final INBTCompound data)
    {
        forgeEntity.readFromNBT(((NBTCompound) data).forgeNbtCompound);
    }
}
