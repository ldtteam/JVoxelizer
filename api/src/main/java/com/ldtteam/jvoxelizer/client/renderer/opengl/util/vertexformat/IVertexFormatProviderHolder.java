package com.ldtteam.jvoxelizer.client.renderer.opengl.util.vertexformat;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class IVertexFormatProviderHolder extends AbstractHolder<IVertexFormatProvider> implements IVertexFormatProvider
{
    private static IVertexFormatProviderHolder ourInstance = new IVertexFormatProviderHolder();

    public static IVertexFormatProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IVertexFormatProviderHolder()
    {
        super(IVertexFormat.class.getName());
    }

    @Override
    public IVertexFormat block()
    {
        return getProvider().block();
    }

    @Override
    public IVertexFormat item()
    {
        return getProvider().item();
    }

    @Override
    public IVertexFormat oldModelPositionTexNormal()
    {
        return getProvider().oldModelPositionTexNormal();
    }

    @Override
    public IVertexFormat particlePositionTexColorLightMap()
    {
        return getProvider().particlePositionTexColorLightMap();
    }

    @Override
    public IVertexFormat position()
    {
        return getProvider().position();
    }

    @Override
    public IVertexFormat positionColor()
    {
        return getProvider().positionColor();
    }

    @Override
    public IVertexFormat positionTex()
    {
        return getProvider().positionTex();
    }

    @Override
    public IVertexFormat positionNormal()
    {
        return getProvider().positionNormal();
    }

    @Override
    public IVertexFormat positionTexColor()
    {
        return getProvider().positionTexColor();
    }

    @Override
    public IVertexFormat positionTexNormal()
    {
        return getProvider().positionTexNormal();
    }

    @Override
    public IVertexFormat positionTexLightMapColor()
    {
        return getProvider().positionTexLightMapColor();
    }

    @Override
    public IVertexFormat positionTexColorNormal()
    {
        return getProvider().positionTexColorNormal();
    }
}