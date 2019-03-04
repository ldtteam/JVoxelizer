package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.opengl.vertexformat;

import com.ldtteam.jvoxelizer.client.renderer.opengl.util.vertexformat.IVertexFormat;

public class VertexFormat implements IVertexFormat
{

    private final net.minecraft.client.renderer.vertex.VertexFormat forgeVertexFormat;

    public VertexFormat(final net.minecraft.client.renderer.vertex.VertexFormat forgeVertexFormat) {this.forgeVertexFormat = forgeVertexFormat;}

    public net.minecraft.client.renderer.vertex.VertexFormat getForgeVertexFormat()
    {
        return forgeVertexFormat;
    }

    public static net.minecraft.client.renderer.vertex.VertexFormat asForge(IVertexFormat vertexFormat)
    {
        if (vertexFormat instanceof net.minecraft.client.renderer.vertex.VertexFormat)
            return (net.minecraft.client.renderer.vertex.VertexFormat) vertexFormat;

        return ((VertexFormat) vertexFormat).getForgeVertexFormat();
    }

    public static IVertexFormat fromForge(net.minecraft.client.renderer.vertex.VertexFormat vertexFormat)
    {
        if (vertexFormat instanceof IVertexFormat)
            return (IVertexFormat) vertexFormat;

        return new VertexFormat(vertexFormat);
    }
}
