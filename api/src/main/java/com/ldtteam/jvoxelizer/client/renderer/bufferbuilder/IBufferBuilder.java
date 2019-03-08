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
     * @return The buffer builder.
     */
    IBufferBuilder pos(double x, double y, double z);

    /**
     * Sets the texture coordinate on the current vertex, or creates a new vertex with the given texture coordinate.
     *
     * @param u The u-coordinate in the texture
     * @param v The v-coordinate in the texture
     * @return The buffer builder.
     */
    IBufferBuilder tex(double u, double v);

    /**
     * Sets the color on the current vertex, or creates a new vertex with the given color.
     *
     * @param r The r-channel of the color
     * @param g The g-channel of the color
     * @param b The b-channel of the color
     * @param a The a-channel of the color
     * @return The buffer builder.
     */
    IBufferBuilder color(float r, float g, float b, float a);

    /**
     * Ends the current vertex and prepares for building a new one.
     */
    void endVertex();
}
