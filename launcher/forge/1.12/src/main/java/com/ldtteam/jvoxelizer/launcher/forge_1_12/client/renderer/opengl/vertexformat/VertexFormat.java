package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.opengl.vertexformat;

import com.ldtteam.jvoxelizer.client.renderer.opengl.util.vertexformat.IVertexFormat;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;

public class VertexFormat implements IVertexFormat, IForgeJVoxelizerWrapper
{

    private final net.minecraft.client.renderer.vertex.VertexFormat forgeVertexFormat;

    private VertexFormat(final net.minecraft.client.renderer.vertex.VertexFormat forgeVertexFormat) {this.forgeVertexFormat = forgeVertexFormat;}

    private net.minecraft.client.renderer.vertex.VertexFormat getForgeVertexFormat()
    {
        return forgeVertexFormat;
    }

    public static net.minecraft.client.renderer.vertex.VertexFormat asForge(IVertexFormat vertexFormat)
    {
        if (vertexFormat instanceof net.minecraft.client.renderer.vertex.VertexFormat)
            return (net.minecraft.client.renderer.vertex.VertexFormat) vertexFormat;

        if (!(vertexFormat instanceof IForgeJVoxelizerWrapper))
            throw new IllegalArgumentException("VertexFormat is not a wrapper");

        return ((IForgeJVoxelizerWrapper) vertexFormat).getForgeInstance();
    }

    public static IVertexFormat fromForge(net.minecraft.client.renderer.vertex.VertexFormat vertexFormat)
    {
        if (vertexFormat instanceof IVertexFormat)
            return (IVertexFormat) vertexFormat;

        return new VertexFormat(vertexFormat);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeVertexFormat();
    }
}
