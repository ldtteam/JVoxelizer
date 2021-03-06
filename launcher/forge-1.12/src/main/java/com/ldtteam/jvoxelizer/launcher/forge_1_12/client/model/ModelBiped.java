package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.model;

import com.ldtteam.jvoxelizer.client.model.IModelBiped;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;

public class ModelBiped implements IModelBiped, IForgeJVoxelizerWrapper
{

    private final net.minecraft.client.model.ModelBiped forgeModelBiped;

    private ModelBiped(final net.minecraft.client.model.ModelBiped forgeModelBiped) {this.forgeModelBiped = forgeModelBiped;}

    public net.minecraft.client.model.ModelBiped getForgeModelBiped()
    {
        return forgeModelBiped;
    }

    public static IModelBiped fromForge(net.minecraft.client.model.ModelBiped modelBiped)
    {
        if (modelBiped instanceof IModelBiped)
        {
            return (IModelBiped) modelBiped;
        }

        return new ModelBiped(modelBiped);
    }

    public static net.minecraft.client.model.ModelBiped asForge(IModelBiped modelBiped)
    {
        if (modelBiped instanceof net.minecraft.client.model.ModelBiped)
        {
            return (net.minecraft.client.model.ModelBiped) modelBiped;
        }

        if (modelBiped == null)
        {
            return null;
        }

        if (!(modelBiped instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("ModelBiped is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) modelBiped).getForgeInstance();
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeModelBiped();
    }
}
