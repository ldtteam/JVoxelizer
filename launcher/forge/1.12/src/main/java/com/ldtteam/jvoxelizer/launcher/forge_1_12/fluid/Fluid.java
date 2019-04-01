package com.ldtteam.jvoxelizer.launcher.forge_1_12.fluid;

import com.ldtteam.jvoxelizer.fluid.IFluid;
import com.ldtteam.jvoxelizer.fluid.IFluidStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.identifier.Identifier;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

public class Fluid implements IFluid, IForgeJVoxelizerWrapper
{
    private net.minecraftforge.fluids.Fluid forgeFluid;

    private Fluid(final net.minecraftforge.fluids.Fluid forgeFluid)
    {
        this.forgeFluid = forgeFluid;
    }

    @Override
    public IIdentifier getStill(final IFluidStack fluid)
    {
        return Identifier.fromForge(this.forgeFluid.getStill(FluidStack.asForge(fluid)));
    }

    @Override
    public int getColor(final IFluidStack fluid)
    {
        return this.forgeFluid.getColor(FluidStack.asForge(fluid));
    }

    private net.minecraftforge.fluids.Fluid getForgeFluid()
    {
        return forgeFluid;
    }

    public static net.minecraftforge.fluids.Fluid asForge(IFluid fluid)
    {
        if (fluid instanceof net.minecraftforge.fluids.Fluid)
            return (net.minecraftforge.fluids.Fluid) fluid;

        if (!(fluid instanceof IForgeJVoxelizerWrapper))
            throw new IllegalArgumentException("Fluid is not a wrapper");

        return ((IForgeJVoxelizerWrapper) fluid).getForgeInstance();
    }

    public static IFluid fromForge(net.minecraftforge.fluids.Fluid fluid)
    {
        if (fluid instanceof IFluid)
            return (IFluid) fluid;

        return new Fluid(fluid);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeFluid();
    }
}
