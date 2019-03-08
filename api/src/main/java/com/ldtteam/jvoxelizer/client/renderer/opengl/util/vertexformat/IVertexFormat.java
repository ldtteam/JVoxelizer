package com.ldtteam.jvoxelizer.client.renderer.opengl.util.vertexformat;

/**
 * Represents a single vertex format used during rendering.
 *
 * Static methods give access to the default formats used by the game.
 */
public interface IVertexFormat
{
    static IVertexFormat block()
    {
        return IVertexFormatProviderHolder.getInstance().block();
    }

    static IVertexFormat item()
    {
        return IVertexFormatProviderHolder.getInstance().item();
    }

    static IVertexFormat oldModelPositionTexNormal()
    {
        return IVertexFormatProviderHolder.getInstance().oldModelPositionTexNormal();
    }

    static IVertexFormat particlePositionTexColorLightMap()
    {
        return IVertexFormatProviderHolder.getInstance().particlePositionTexColorLightMap();
    }

    static IVertexFormat position()
    {
        return IVertexFormatProviderHolder.getInstance().position();
    }

    static IVertexFormat positionColor()
    {
        return IVertexFormatProviderHolder.getInstance().positionColor();
    }

    static IVertexFormat positionTex()
    {
        return IVertexFormatProviderHolder.getInstance().positionTex();
    }

    static IVertexFormat positionNormal()
    {
        return IVertexFormatProviderHolder.getInstance().positionNormal();
    }

    static IVertexFormat positionTexColor()
    {
        return IVertexFormatProviderHolder.getInstance().positionTexColor();
    }

    static IVertexFormat positionTexNormal()
    {
        return IVertexFormatProviderHolder.getInstance().positionTexNormal();
    }

    static IVertexFormat positionTexLightMapColor()
    {
        return IVertexFormatProviderHolder.getInstance().positionTexLightMapColor();
    }

    static IVertexFormat positionTexColorNormal()
    {
        return IVertexFormatProviderHolder.getInstance().positionTexColorNormal();
    }
}
