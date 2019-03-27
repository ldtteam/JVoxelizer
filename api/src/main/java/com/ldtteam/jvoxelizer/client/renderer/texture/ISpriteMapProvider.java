package com.ldtteam.jvoxelizer.client.renderer.texture;

import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

/**
 * Gives access to the SpriteMap and the location of default sprite maps.
 */
public interface ISpriteMapProvider
{
    IIdentifier getLocationOfBlocksTexture();
}
