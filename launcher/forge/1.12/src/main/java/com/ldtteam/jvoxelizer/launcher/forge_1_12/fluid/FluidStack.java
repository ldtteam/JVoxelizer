package com.ldtteam.jvoxelizer.launcher.forge_1_12.fluid;

import com.ldtteam.jvoxelizer.fluid.IFluid;
import com.ldtteam.jvoxelizer.fluid.IFluidStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;

public class FluidStack implements IFluidStack, IForgeJVoxelizerWrapper
{
    private net.minecraftforge.fluids.FluidStack forgeFluidStack;

    private FluidStack(final net.minecraftforge.fluids.FluidStack forgeFluidStack)
    {
        this.forgeFluidStack = forgeFluidStack;
    }

    @Override
    public IFluid getFluid()
    {
        return Fluid.fromForge(forgeFluidStack.getFluid());
    }

    private net.minecraftforge.fluids.FluidStack getFluidStack()
    {
        return this.forgeFluidStack;
    }

    public static net.minecraftforge.fluids.FluidStack asForge(IFluidStack fluidStack)
    {
        if (fluidStack instanceof net.minecraftforge.fluids.FluidStack)
            return (net.minecraftforge.fluids.FluidStack) fluidStack;

        if (!(fluidStack instanceof IForgeJVoxelizerWrapper))
            throw new IllegalArgumentException("FluidStack is not a wrapper");

        return ((IForgeJVoxelizerWrapper) fluidStack).getForgeInstance();
    }

    public static IFluidStack fromForge(net.minecraftforge.fluids.FluidStack fluidStack)
    {
        if (fluidStack instanceof IFluidStack)
            return (IFluidStack) fluidStack;

        return new FluidStack(fluidStack);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return null;
    }
}
