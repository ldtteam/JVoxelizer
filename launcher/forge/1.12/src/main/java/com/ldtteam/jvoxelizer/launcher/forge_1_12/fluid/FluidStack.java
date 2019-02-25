package com.ldtteam.jvoxelizer.launcher.forge_1_12.fluid;

import com.ldtteam.jvoxelizer.fluid.IFluid;
import com.ldtteam.jvoxelizer.fluid.IFluidStack;

public class FluidStack implements IFluidStack
{
    private net.minecraftforge.fluids.FluidStack stack;

    public FluidStack(final net.minecraftforge.fluids.FluidStack stack)
    {
        this.stack = stack;
    }

    @Override
    public IFluid getFluid()
    {
        return new Fluid(stack.getFluid());
    }

    /**
     * Getter for the encapsulated fluidStack.
     * @return the net.minecraftforge.fluids.FluidStack.
     */
    public net.minecraftforge.fluids.FluidStack getFluidStack()
    {
        return this.stack;
    }
}
