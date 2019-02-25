package com.ldtteam.jvoxelizer.fluid;

import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

public interface IFluid
{
    IIdentifier getStill(IFluidStack fluid);

    int getColor(IFluidStack fluid);
}
