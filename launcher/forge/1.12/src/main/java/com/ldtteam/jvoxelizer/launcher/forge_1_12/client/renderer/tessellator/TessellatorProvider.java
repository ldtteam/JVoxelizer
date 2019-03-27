package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.tessellator;

import com.ldtteam.jvoxelizer.client.renderer.tessellator.ITessellator;
import com.ldtteam.jvoxelizer.client.renderer.tessellator.ITessellatorProvider;

public class TessellatorProvider implements ITessellatorProvider
{
    private static TessellatorProvider ourInstance = new TessellatorProvider();

    public static TessellatorProvider getInstance()
    {
        return ourInstance;
    }

    private TessellatorProvider()
    {
    }

    @Override
    public ITessellator provideInstance()
    {
        return Tessellator.fromForge(net.minecraft.client.renderer.Tessellator.getInstance());
    }
}
