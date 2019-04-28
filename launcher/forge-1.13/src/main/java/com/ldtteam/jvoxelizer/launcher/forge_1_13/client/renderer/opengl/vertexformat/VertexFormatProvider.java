package com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.opengl.vertexformat;

import com.ldtteam.jvoxelizer.client.renderer.opengl.util.vertexformat.IVertexFormat;
import com.ldtteam.jvoxelizer.client.renderer.opengl.util.vertexformat.IVertexFormatProvider;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class VertexFormatProvider implements IVertexFormatProvider
{
    private static VertexFormatProvider ourInstance = new VertexFormatProvider();

    public static VertexFormatProvider getInstance()
    {
        return ourInstance;
    }

    private VertexFormatProvider()
    {
    }

    @Override
    public IVertexFormat block()
    {
        return VertexFormat.fromForge(DefaultVertexFormats.BLOCK);
    }

    @Override
    public IVertexFormat item()
    {
        return VertexFormat.fromForge(DefaultVertexFormats.ITEM);
    }

    @Override
    public IVertexFormat oldModelPositionTexNormal()
    {
        return VertexFormat.fromForge(DefaultVertexFormats.OLDMODEL_POSITION_TEX_NORMAL);
    }

    @Override
    public IVertexFormat particlePositionTexColorLightMap()
    {
        return VertexFormat.fromForge(DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
    }

    @Override
    public IVertexFormat position()
    {
        return VertexFormat.fromForge(DefaultVertexFormats.POSITION);
    }

    @Override
    public IVertexFormat positionColor()
    {
        return VertexFormat.fromForge(DefaultVertexFormats.POSITION_COLOR);
    }

    @Override
    public IVertexFormat positionTex()
    {
        return VertexFormat.fromForge(DefaultVertexFormats.POSITION_TEX);
    }

    @Override
    public IVertexFormat positionNormal()
    {
        return VertexFormat.fromForge(DefaultVertexFormats.POSITION_NORMAL);
    }

    @Override
    public IVertexFormat positionTexColor()
    {
        return VertexFormat.fromForge(DefaultVertexFormats.POSITION_TEX_COLOR);
    }

    @Override
    public IVertexFormat positionTexNormal()
    {
        return VertexFormat.fromForge(DefaultVertexFormats.POSITION_TEX_NORMAL);
    }

    @Override
    public IVertexFormat positionTexLightMapColor()
    {
        return VertexFormat.fromForge(DefaultVertexFormats.POSITION_TEX_LMAP_COLOR);
    }

    @Override
    public IVertexFormat positionTexColorNormal()
    {
        return VertexFormat.fromForge(DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL);
    }
}
