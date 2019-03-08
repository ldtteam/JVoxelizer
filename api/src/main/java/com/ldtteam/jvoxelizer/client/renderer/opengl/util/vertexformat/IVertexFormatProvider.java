package com.ldtteam.jvoxelizer.client.renderer.opengl.util.vertexformat;

/**
 * Represents the logic for providing the default vertex formats.
 */
public interface IVertexFormatProvider
{
    IVertexFormat block();
    IVertexFormat item();
    IVertexFormat oldModelPositionTexNormal();
    IVertexFormat particlePositionTexColorLightMap();
    IVertexFormat position();
    IVertexFormat positionColor();
    IVertexFormat positionTex();
    IVertexFormat positionNormal();
    IVertexFormat positionTexColor();
    IVertexFormat positionTexNormal();
    IVertexFormat positionTexLightMapColor();
    IVertexFormat positionTexColorNormal();
}
