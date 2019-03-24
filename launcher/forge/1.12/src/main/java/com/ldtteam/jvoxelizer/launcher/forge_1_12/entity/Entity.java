package com.ldtteam.jvoxelizer.launcher.forge_1_12.entity;

import com.ldtteam.jvoxelizer.common.capability.ICapability;
import com.ldtteam.jvoxelizer.entity.IEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.common.capability.Capability;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.facing.Facing;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.coordinate.block.BlockCoordinate;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.coordinate.entity.EntityCoordinate;
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
    private final net.minecraft.entity.Entity forgeEntity;

    protected Entity(@NotNull final net.minecraft.entity.Entity forgeEntity)
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
        return new ITickingDataEntry<IEntityCoordinate>() {
            @Override
            public ITickingDataEntry<IEntityCoordinate> setPrevious(final IEntityCoordinate previous)
            {
                forgeEntity.prevPosX = previous.getX();
                forgeEntity.prevPosY = previous.getY();
                forgeEntity.prevPosZ = previous.getZ();
                
                return this;
            }

            @Override
            public ITickingDataEntry<IEntityCoordinate> setCurrent(final IEntityCoordinate current)
            {
                forgeEntity.posX = current.getX();
                forgeEntity.posY = current.getY();
                forgeEntity.posZ = current.getZ();

                return this;
            }

            @Override
            public IEntityCoordinate getPrevious()
            {
                return new EntityCoordinate(forgeEntity.prevPosX, forgeEntity.prevPosY, forgeEntity.prevPosZ);
            }

            @Override
            public IEntityCoordinate getCurrent()
            {
                return new EntityCoordinate(forgeEntity.posX, forgeEntity.posY, forgeEntity.posZ);
            }
        };
    }

    @Override
    public ITickingDataEntry<IBlockCoordinate> getPositionOfBlockContainingEntity()
    {
        return new ITickingDataEntry<IBlockCoordinate>() {
            @Override
            public ITickingDataEntry<IBlockCoordinate> setPrevious(final IBlockCoordinate previous)
            {
                forgeEntity.prevPosX = previous.getX() + (forgeEntity.prevPosX - Math.floor(forgeEntity.prevPosX));
                forgeEntity.prevPosY = previous.getY() + (forgeEntity.prevPosY - Math.floor(forgeEntity.prevPosY)) - 0.5d;
                forgeEntity.prevPosX = previous.getZ() + (forgeEntity.prevPosZ - Math.floor(forgeEntity.prevPosZ));
                
                return this;
            }

            @Override
            public ITickingDataEntry<IBlockCoordinate> setCurrent(final IBlockCoordinate current)
            {
                forgeEntity.posX = current.getX() + (forgeEntity.posX - Math.floor(forgeEntity.posX));
                forgeEntity.posY = current.getY() + (forgeEntity.posY - Math.floor(forgeEntity.posY)) - 0.5d;
                forgeEntity.posX = current.getZ() + (forgeEntity.posZ - Math.floor(forgeEntity.posZ));

                return this;
            }

            @Override
            public IBlockCoordinate getPrevious()
            {
                return new BlockCoordinate(forgeEntity.prevPosX, forgeEntity.prevPosY + 0.5d, forgeEntity.prevPosZ);
            }

            @Override
            public IBlockCoordinate getCurrent()
            {
                return BlockCoordinate.fromForge(forgeEntity.getPosition());
            }
        };
    }

    @Override
    public IReadOnlyTickingDataEntry<Float> getRotationYaw()
    {
        return new IReadOnlyTickingDataEntry<Float>() {
            @Override
            public Float getPrevious()
            {
                return forgeEntity.prevRotationYaw;
            }

            @Override
            public Float getCurrent()
            {
                return forgeEntity.rotationYaw;
            }
        };
    }

    @Override
    public IReadOnlyTickingDataEntry<Float> getRotationPitch()
    {
        return new IReadOnlyTickingDataEntry<Float>() {
            @Override
            public Float getPrevious()
            {
                return forgeEntity.prevRotationPitch;
            }

            @Override
            public Float getCurrent()
            {
                return forgeEntity.rotationPitch;
            }
        };
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
        return new IReadOnlyTickingDataEntry<Float>() {
            @Override
            public Float getPrevious()
            {
                return forgeEntity.distanceWalkedModified;
            }

            @Override
            public Float getCurrent()
            {
                return forgeEntity.prevDistanceWalkedModified;
            }
        };
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
        return forgeEntity.hasCapability(Capability.asForge(capability), Facing.asForge(facing));
    }

    @Override
    public <T> T getCapability(final ICapability<T> capability, final IFacing facing)
    {
        return (T) forgeEntity.getCapability(Capability.asForge(capability), Facing.asForge(facing));
    }

    @Override
    public INBTCompound write()
    {
        return NBTCompound.fromForge(forgeEntity.writeToNBT(new NBTTagCompound()));
    }

    @Override
    public void read(final INBTCompound data)
    {
        forgeEntity.readFromNBT(NBTCompound.asForge(data));
    }

    private net.minecraft.entity.Entity getForgeEntity()
    {
        return forgeEntity;
    }

    public static net.minecraft.entity.Entity asForge(IEntity entity)
    {
        if (entity instanceof net.minecraft.entity.Entity)
            return (net.minecraft.entity.Entity) entity;

        return ((Entity) entity).getForgeEntity();
    }

    public static IEntity fromForge(net.minecraft.entity.Entity entity)
    {
        if (entity instanceof IEntity)
            return (IEntity) entity;

        return new Entity(entity);
    }
}
