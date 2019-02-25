package com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.item;

import com.ldtteam.jvoxelizer.common.capability.ICapability;
import com.ldtteam.jvoxelizer.entity.IEntity;
import com.ldtteam.jvoxelizer.entity.item.IItemStackEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.ItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt.NBTCompound;
import com.ldtteam.jvoxelizer.util.facing.IFacing;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
import com.ldtteam.jvoxelizer.util.math.coordinate.entity.IEntityCoordinate;
import com.ldtteam.jvoxelizer.util.nbt.INBTCompound;
import com.ldtteam.jvoxelizer.util.ticking.data.IReadOnlyTickingDataEntry;
import com.ldtteam.jvoxelizer.util.ticking.data.ITickingDataEntry;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class ItemStackEntity implements IItemStackEntity
{
    /**
     * The forge entity for the itemstack.
     */
    private EntityItem forgeItemEntity;

    /**
     * The voxel Itemstack
     */
    private ItemStack voxelStack;

    public ItemStackEntity(@NotNull final EntityItem forgeItemEntity, final World world)
    {
        this.forgeItemEntity = forgeItemEntity;
        voxelStack = new ItemStack(forgeItemEntity.getItem());
    }

    @Override
    public float getHoverStart()
    {
        return forgeItemEntity.hoverStart;
    }

    @Override
    public IItemStackEntity setHoverStart(final float hoverStart)
    {
        forgeItemEntity.hoverStart = hoverStart;

        return this;
    }

    @Override
    public int getLifeSpan()
    {
        return forgeItemEntity.lifespan;
    }

    @Override
    public IItemStackEntity setLifeSpan(final int lifeSpan)
    {
        forgeItemEntity.lifespan = lifeSpan;
    }

    @Override
    public IItemStackEntity setAgeToCreativeDespawnTime()
    {
        forgeItemEntity.setAgeToCreativeDespawnTime();
    }

    @Override
    public String getName()
    {
        return forgeItemEntity.getName();
    }

    @Override
    public IItemStack getItemStack()
    {
        return voxelStack;
    }

    @Override
    public IItemStackEntity setItem(final IItemStack stack)
    {
        forgeItemEntity.setItem(((ItemStack) stack).getForgeItem());
    }

    @Override
    public UUID getId()
    {
        return forgeItemEntity.getUniqueID();
    }

    @Override
    public boolean shouldEntitySpawn()
    {
        return forgeItemEntity.preventEntitySpawning;
    }

    @Override
    public boolean shouldEntityForceSpawn()
    {
        return forgeItemEntity.forceSpawn;
    }

    @Override
    public int getDimension()
    {
        return forgeItemEntity.dimension;
    }

    @Override
    public ITickingDataEntry<IEntityCoordinate> getPositionOfEntityOrigin()
    {
        // TODO
        return null;
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
        return forgeItemEntity.onGround;
    }

    @Override
    public boolean hasCollidedHorizontally()
    {
        return forgeItemEntity.collidedHorizontally;
    }

    @Override
    public boolean hasCollidedVertically()
    {
        return forgeItemEntity.collidedVertically;
    }

    @Override
    public boolean hasVelocityChanged()
    {
        return forgeItemEntity.velocityChanged;
    }

    @Override
    public boolean isDead()
    {
        return forgeItemEntity.isDead;
    }

    @Override
    public float getWidth()
    {
        return forgeItemEntity.width;
    }

    @Override
    public IReadOnlyTickingDataEntry<Float> getDistanceWalkedModified()
    {
        // TODO
        return forgeItemEntity.distanceWalkedModified;
    }

    @Override
    public float getDistanceWalkedOnStepModified()
    {
        return forgeItemEntity.distanceWalkedOnStepModified;
    }

    @Override
    public float getFallDistance()
    {
        return forgeItemEntity.fallDistance;
    }

    @Override
    public IEntity setFallDistance(final float fallDistance)
    {
        forgeItemEntity.fallDistance = fallDistance;
        return this;
    }

    @Override
    public boolean hasCapability(final ICapability<?> capability, final IFacing facing)
    {
        // TODO
        return forgeItemEntity.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(final ICapability<T> capability, final IFacing facing)
    {
        // TODO
        return forgeItemEntity.getCapability(capability, facing);
    }

    @Override
    public INBTCompound write()
    {
        return new NBTCompound(forgeItemEntity.writeToNBT(new NBTTagCompound()));
    }

    @Override
    public void read(final INBTCompound data)
    {
        forgeItemEntity.readEntityFromNBT(((NBTCompound) data).forgeNbtCompound);
    }
}
