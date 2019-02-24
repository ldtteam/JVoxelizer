package com.ldtteam.jvoxelizer.client.renderer.bufferbuilder;

import com.ldtteam.jvoxelizer.client.renderer.opengl.util.vertexformat.IVertexFormat;

public interface IBufferBuilder
{
    void begin(int mode, IVertexFormat format);

    IBufferBuilder pos(double x, double y, double z);

    IBufferBuilder tex(double u, double v);

    IBufferBuilder color(float r, float g, float b, float a);

    void endVertex();
}
