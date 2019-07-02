package com.ldtteam.jvoxelizer.common.capability;

import com.ldtteam.jvoxelizer.item.handling.IItemHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a single capability an object might have.
 * @param <T> The type of the capability.
 */
public interface ICapability<T>
{
    /**
     * Gives access to the IItemHandler capability.
     *
     * @return The IItemHandler capability.
     */
    static ICapability<IItemHandler> getItemHandlerCapability()
    {
        return ICapabilityLogicHolder.getInstance().getItemHandlerCapability();
    }

    /**
     * Method to convert a none JVox instance of a capability into a JVox instance.
     * @param possibleTInstance The none JVox instance to convert.
     * @return The converted capability, compatible with JVox.
     */
    @Nullable
    T convertToJVoxInstanceOrNull(@Nullable Object possibleTInstance);

    /**
     * Method to convert a JVox instance into an instance of a capability usable in the runtime.
     * @param possibleRuntimeInstance The instance of a JVox capability that needs to be converted to a runtime capable version.
     * @return The converted capability, compatible with the Runtime.
     */
    @Nullable
    Object covertToRuntimeInstanceOrNull(@NotNull T possibleRuntimeInstance);
}
