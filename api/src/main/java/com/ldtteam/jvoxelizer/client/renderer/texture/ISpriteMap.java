package com.ldtteam.jvoxelizer.client.renderer.texture;

import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

/**
 * Defines a collection of sprites in a map.
 */
public interface ISpriteMap
{
    /**
     * The location of the map that defines the block textures.
     *
     * @return The location of the block textures map.
     */
    static IIdentifier getLocationOfBlocksTexture()
    {
        return ISpriteMapProviderHolder.getInstance().getLocationOfBlocksTexture();
    }

    /**
     * Returns a sprite with a given name.
     *
     * @param spriteName The name.
     * @return The sprite with the given name, or null.
     */
    ISprite getSrite(String spriteName);
}
