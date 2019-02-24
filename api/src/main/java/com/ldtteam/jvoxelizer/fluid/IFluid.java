package com.ldtteam.jvoxelizer.fluid;

public interface IFluid
{
    IFluid getStill(IFluidStack fluid);

    int getColor(IFluidStack fluid);
}
