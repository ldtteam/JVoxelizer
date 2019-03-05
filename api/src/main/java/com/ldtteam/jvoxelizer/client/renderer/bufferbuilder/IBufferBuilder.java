package com.ldtteam.jvoxelizer.client.renderer.bufferbuilder;

import com.ldtteam.jvoxelizer.client.renderer.opengl.util.vertexformat.IVertexFormat;

/**
 * Builds buffers into which rendering is happening.
 */
public interface IBufferBuilder
{
    /**
     * Indicates that rendering is beginning.
     *
     * @param mode The rendering mode.
     * @param format The data format of the individual vertexes.
     */
    void begin(int mode, IVertexFormat format);

    /**
     * Sets the position of the current vertex, or starts a new vertex with the given pos.
     *
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     * @param z The z-coordinate.
     *
     * @return The buffer builder.
     */
    IBufferBuilder pos(double x, double y, double z);

    /**
     * Sets the textu
     * @param u
     * @param v
     * @return
     */
    IBufferBuilder tex(double u, double v);

    IBufferBuilder color(float r, float g, float b, float a);

    void endVertex();
}
