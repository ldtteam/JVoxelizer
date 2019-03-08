package com.ldtteam.jvoxelizer.launcher.forge_1_12.fluid;

import com.ldtteam.jvoxelizer.fluid.IFluid;
import com.ldtteam.jvoxelizer.fluid.IFluidStack;

public class FluidStack implements IFluidStack
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

        return ((FluidStack) fluidStack).getFluidStack();
    }

    public static IFluidStack fromForge(net.minecraftforge.fluids.FluidStack fluidStack)
    {
        if (fluidStack instanceof IFluidStack)
            return (IFluidStack) fluidStack;

        return new FluidStack(fluidStack);
    }
}
