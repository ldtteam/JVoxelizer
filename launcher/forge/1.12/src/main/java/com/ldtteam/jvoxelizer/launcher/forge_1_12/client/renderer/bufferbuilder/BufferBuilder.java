package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.bufferbuilder;

import com.ldtteam.jvoxelizer.client.renderer.bufferbuilder.IBufferBuilder;
import com.ldtteam.jvoxelizer.client.renderer.opengl.util.vertexformat.IVertexFormat;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.opengl.vertexformat.VertexFormat;

public class BufferBuilder implements IBufferBuilder
{

    private final net.minecraft.client.renderer.BufferBuilder forgeBufferBuilder;

    public BufferBuilder(final net.minecraft.client.renderer.BufferBuilder forgeBufferBuilder) {this.forgeBufferBuilder = forgeBufferBuilder;}

    @Override
    public void begin(final int mode, final IVertexFormat format)
    {
        forgeBufferBuilder.begin(mode, VertexFormat.asForge(format));
    }

    @Override
    public IBufferBuilder pos(final double x, final double y, final double z)
    {
        forgeBufferBuilder.pos(x, y, z);
        return this;
    }

    @Override
    public IBufferBuilder tex(final double u, final double v)
    {
        forgeBufferBuilder.tex(u,v);
        return this;
    }

    @Override
    public IBufferBuilder color(final float r, final float g, final float b, final float a)
    {
        forgeBufferBuilder.color(r, g, b, a);
        return this;
    }

    @Override
    public void endVertex()
    {
        forgeBufferBuilder.endVertex();
    }

    public net.minecraft.client.renderer.BufferBuilder getForgeBufferBuilder()
    {
        return forgeBufferBuilder;
    }

    public static net.minecraft.client.renderer.BufferBuilder asForge(IBufferBuilder bufferBuilder)
    {
        if (bufferBuilder instanceof net.minecraft.client.renderer.BufferBuilder)
            return (net.minecraft.client.renderer.BufferBuilder) bufferBuilder;

        return ((BufferBuilder) bufferBuilder).getForgeBufferBuilder();
    }

    public static IBufferBuilder fromForge(net.minecraft.client.renderer.BufferBuilder bufferBuilder)
    {
        if (bufferBuilder instanceof IBufferBuilder)
            return (IBufferBuilder) bufferBuilder;

        return new BufferBuilder(bufferBuilder);
    }
}
