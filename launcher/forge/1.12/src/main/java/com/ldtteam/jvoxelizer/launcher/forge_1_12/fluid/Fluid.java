package com.ldtteam.jvoxelizer.launcher.forge_1_12.fluid;

import com.ldtteam.jvoxelizer.fluid.IFluid;
import com.ldtteam.jvoxelizer.fluid.IFluidStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.identifier.Identifier;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

public class Fluid implements IFluid
{
    private net.minecraftforge.fluids.Fluid fluid;

    public Fluid(final net.minecraftforge.fluids.Fluid fluid)
    {
        this.fluid = fluid;
    }

    @Override
    public IIdentifier getStill(final IFluidStack fluid)
    {
        return new Identifier(this.fluid.getStill(((FluidStack) fluid).getFluidStack()));
    }

    @Override
    public int getColor(final IFluidStack fluid)
    {
        return this.fluid.getColor(((FluidStack) fluid).getFluidStack());
    }
}
