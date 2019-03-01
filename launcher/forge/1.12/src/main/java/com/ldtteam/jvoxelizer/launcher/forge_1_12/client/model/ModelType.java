package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.model;

import com.ldtteam.jvoxelizer.client.model.IModelBiped;
import net.minecraft.client.model.ModelBiped;

public class ModelType implements IModelBiped
{
    private ModelBiped model;

    public ModelType(final ModelBiped model)
    {
        this.model = model;
    }

    /**
     * Get then wrapped forge item.
     * @return the ModelBiped.
     */
    public ModelBiped getForgeModelType()
    {
        return this.model;
    }
}
