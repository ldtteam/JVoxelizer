package com.ldtteam.jvoxelizer.launcher.forge_1_12.common.capability;

import com.ldtteam.jvoxelizer.common.capability.ICapability;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;

import java.util.function.Function;

public class Capability<T, R> implements ICapability<T>, IForgeJVoxelizerWrapper
{
    private final net.minecraftforge.common.capabilities.Capability<R> forgeCapability;
    private final Function<R, T> forgeToJVoxConversionCallback;


    private Capability(final net.minecraftforge.common.capabilities.Capability<R> forgeCapability, final Function<R, T> forgeToJVoxConversionCallback) {this.forgeCapability = forgeCapability;
        this.forgeToJVoxConversionCallback = forgeToJVoxConversionCallback;
    }

    private net.minecraftforge.common.capabilities.Capability<R> getForgeCapability()
    {
        return forgeCapability;
    }

    public static net.minecraftforge.common.capabilities.Capability<?> asForge(ICapability<?> capability)
    {
        if (capability instanceof net.minecraftforge.common.capabilities.Capability)
            return (net.minecraftforge.common.capabilities.Capability<?>) capability;

        if (!(capability instanceof IForgeJVoxelizerWrapper))
            throw new IllegalArgumentException("Capability is not a wrapper");

        return ((IForgeJVoxelizerWrapper) capability).getForgeInstance();
    }

    public static <S, Q> ICapability<S> fromForge(net.minecraftforge.common.capabilities.Capability<Q> capability, Function<Q, S> forgeToJVoxConversionCallback)
    {
        if (capability instanceof ICapability)
            return (ICapability<S>) capability;

        return new Capability<>(capability, forgeToJVoxConversionCallback);
    }

    public static <S, T> T convertFromForgeToJVox(ICapability<T> capability, S object)
    {
        //TODO Deal with custom caps:
        if (!(capability instanceof Capability))
            throw new UnsupportedOperationException("Custom caps are not supported yet");

        final Capability<T, S> wrappedCap = (Capability<T, S>) capability;
        return wrappedCap.forgeToJVoxConversionCallback.apply(object);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeCapability();
    }
}
