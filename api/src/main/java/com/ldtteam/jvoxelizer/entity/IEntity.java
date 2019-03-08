package com.ldtteam.jvoxelizer.entity;

import com.ldtteam.jvoxelizer.block.IBlock;
import com.ldtteam.jvoxelizer.common.capability.ICapabilityProvider;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
import com.ldtteam.jvoxelizer.util.math.coordinate.entity.IEntityCoordinate;
import com.ldtteam.jvoxelizer.util.nbt.INBTSerializable;
import com.ldtteam.jvoxelizer.util.ticking.data.IReadOnlyTickingDataEntry;
import com.ldtteam.jvoxelizer.util.ticking.data.ITickingDataEntry;
import com.ldtteam.jvoxelizer.dimension.IDimension;

import java.util.*;

/**
 * Represents an entity in the game.
 */
public interface IEntity extends INBTSerializable, ICapabilityProvider
{

    /**
     * Constructs a new entity that lives the given dimension at 0,0,0.
     *
     * @param dimension The dimension to create the entity in.
     * @return The entity created.
     */
    static IEntity create(IDimension dimension)
    {
        return IEntityProviderHolder.getInstance().provide(dimension);
    }

    /**
     * Constructor used to create a new entity from its ID.
     * If an entity with the given id already exists, then it is returned instead.
     *
     * @param id The id of the entity to create or find.
     * @return The entity with the given id.
     */
    static IEntity create(UUID id)
    {
        return IEntityProviderHolder.getInstance().provide(id);
    }

    /**
     * Constructor for a blank entity.
     * @return A blank entity.
     */
    static IEntity create()
    {
        return IEntityProviderHolder.getInstance().provide();
    }

    /**
     * The id of this {@link IEntity}.
     *
     * @return The id of this {@link IEntity}.
     */
    UUID getId();

    /**
     * Indicates if this {@link IEntity} can spawn when they do their AABB check to make sure the spot is clear of entities that can
     * prevent spawning.
     *
     * @return an indication if this {@link IEntity} can spawn after it completes its AABB check.
     */
    boolean shouldEntitySpawn();

    /**
     * If true, forces the {@link IDimension} to spawn the {@link IEntity} and send it to clients even if the Chunk it is located in has not
     * yet been loaded.
     *
     * @return an indication if this {@link IEntity} can spawn after it completes its AABB check.
     */
    boolean shouldEntityForceSpawn();

    /**
     * The Dimension this {@link IEntity} is in.
     *
     * @return the Dimension this {@link IEntity} is in.
     */
    int getDimension();

    /**
     * The {@link IEntityCoordinate} of the {@link IEntity} origin.
     * 
     * @return The {@link IEntityCoordinate} of the {@link IEntity} origin.
     */
    ITickingDataEntry<IEntityCoordinate> getPositionOfEntityOrigin();

    /**
     * The {@link IBlockCoordinate} of the {@link IBlock} that contains the feet of the {@link IEntity}.
     * 
     * @return The {@link IBlockCoordinate} of the {@link IBlock} that contains the feet of the {@link IEntity}.
     */
    ITickingDataEntry<IBlockCoordinate> getPositionOfBlockContainingEntity();

    /**
     * The yaw factor of the {@link IEntity} rotation.
     * 
     * @return the yaw factor of the {@link IEntity} rotation.
     */
    IReadOnlyTickingDataEntry<Float> getRotationYaw();

    /**
     * The pitch factor of the {@link IEntity} rotation.
     *
     * @return the pitch factor of the {@link IEntity} rotation.
     */
    IReadOnlyTickingDataEntry<Float> getRotationPitch();

    /**
     * Indicates if this {@link IEntity} is on the ground.
     * 
     * @return {@code True} when the {@link IEntity} is on the ground.
     */
    boolean isOnGround();

    /**
     * Indicates if this {@link IEntity} has collided horizontally.
     * 
     * @return {@code True} when the {@link IEntity} has collided horizontally
     */
    boolean hasCollidedHorizontally();

    /**
     * Indicates if this {@link IEntity} has collided vertically.
     *
     * @return {@code True} when the {@link IEntity} has collided vertically
     */
    boolean hasCollidedVertically();

    /**
     * Indicates if this {@link IEntity} has collided.
     *
     * @return {@code True} when the {@link IEntity} has collided.
     */
    default boolean hasCollided()
    {
        return hasCollidedHorizontally() || hasCollidedVertically();
    }

    /**
     * Indicates if the velocity of this {@link IEntity} has changed since the last tick,
     * and if an update packet needs to be send from the server to the client to update the speed.
     *
     * @return {@code True} when the velocity has changed.
     */
    boolean hasVelocityChanged();

    /**
     * Indicates if this {@link IEntity} is still alive and ticking.
     *
     * @return {@code True} when this {@link IEntity} is still alive.
     */
    boolean isDead();

    /**
     * Returns the width of this {@link IEntity}.
     *
     * @return the width of this {@link IEntity}.
     */
    float getWidth();

    IReadOnlyTickingDataEntry<Float> getDistanceWalkedModified();

    /**
     * The distance that this {@link IEntity} walked on step, modified, so multiplied with 0.6.
     *
     * @return The modified distance that this {@link IEntity} walked on step.
     */
    float getDistanceWalkedOnStepModified();

    /**
     * The distance that the {@link IEntity} has been falling.
     *
     * @return The falling distance.
     */
    float getFallDistance();

    /**
     * Sets the distance that the {@link IEntity} has been falling.
     *
     * @param fallDistance The new falling distance.
     * @return The instance of {@link IEntity} that this has been called on.
     */
    IEntity setFallDistance(final float fallDistance);
}
