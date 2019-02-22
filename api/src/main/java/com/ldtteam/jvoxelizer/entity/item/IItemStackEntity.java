package com.ldtteam.jvoxelizer.entity.item;

import com.ldtteam.jvoxelizer.entity.IEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.math.coordinate.entity.IEntityCoordinate;
import com.ldtteam.jvoxelizer.dimension.IDimension;

/**
 * A special {@link IEntity} case that holds an {@link IItemStack} in the {@link IDimension}
 */
public interface IItemStackEntity extends IEntity
{

    static IItemStackEntity create(final IDimension dimension, final IEntityCoordinate coordinate)
    {
        return IItemStackEntityProviderHolder.getInstance().provide(dimension, coordinate);
    }

    static IItemStackEntity create(final IDimension dimension, final IEntityCoordinate coordinate, final IItemStack stack)
    {
        return IItemStackEntityProviderHolder.getInstance().provide(dimension, coordinate, stack);
    }

    /**
     * The initial height that the {@link IItemStackEntity} is above the ground.
     *
     * @return The initial height that the {@link IItemStackEntity} hovers above the ground.
     */
    float getHoverStart();

    /**
     * Sets the initial height that the {@link IItemStackEntity} is above the ground.
     *
     * @param hoverStart The initial height that the {@link IItemStackEntity} hovers above the ground.
     * @return The {@link IItemStackEntity} this was called on.
     */
    IItemStackEntity setHoverStart(final float hoverStart);

    /**
     * The max amount of tick this {@link IItemStackEntity} can exist.
     * Once this amount of ticks has reached the {@link IItemStackEntity} expires and despawns.
     *
     * @return The max amount of ticks that this {@link IItemStackEntity} can exist.
     */
    int getLifeSpan();

    /**
     * Sets the max amount of tick this {@link IItemStackEntity} can exist.
     * Once this amount of ticks has reached the {@link IItemStackEntity} expires and despawns.
     *
     * @param lifeSpan The max amount of ticks that this {@link IItemStackEntity} can exist.
     * @return The {@link IItemStackEntity} this was called on.
     */
    IItemStackEntity setLifeSpan(final int lifeSpan);


    /**
     * Sets the age of the {@link IItemStackEntity} so that it'll despawn one minute after it has been dropped (instead of five). Used when
     * items are dropped from players in creative mode
     *
     * @return The instance of {@link IItemStackEntity} that this was called upon.
     */
    IItemStackEntity setAgeToCreativeDespawnTime();

    /**
     * The name of the {@link IItemStackEntity}.
     *
     * @return The name.
     */
    String getName();

    /**
     * Gets the {@link IItemStack} that this {@link IItemStackEntity} represents.
     */
    IItemStack getItemStack();

    /**
     * Sets the {@link IItemStack} that this {@link IItemStackEntity} represents.
     *
     * @param stack The new {@link IItemStack} contained in this {@link IItemStackEntity}
     * @return The instance of {@link IItemStackEntity} this was called upon.
     */
    IItemStackEntity setItem(IItemStack stack);
}
