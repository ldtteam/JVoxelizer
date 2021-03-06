package com.ldtteam.jvoxelizer.client.renderer.texture;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

/**
 * Holder for the logic to gain access to the SpriteMap and the locations of the default sprite maps.
 */
final class ISpriteMapProviderHolder extends AbstractHolder<ISpriteMapProvider> implements ISpriteMapProvider
{
    private static ISpriteMapProviderHolder ourInstance = new ISpriteMapProviderHolder();

    public static ISpriteMapProviderHolder getInstance()
    {
        return ourInstance;
    }

    private ISpriteMapProviderHolder()
    {
        super(ISpriteMap.class.getName());
    }

    @Override
    public IIdentifier getLocationOfBlocksTexture()
    {
        return getProvider().getLocationOfBlocksTexture();
    }
}