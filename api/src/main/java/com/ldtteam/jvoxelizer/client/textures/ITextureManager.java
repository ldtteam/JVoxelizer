package com.ldtteam.jvoxelizer.client.textures;

import com.ldtteam.jvoxelizer.client.renderer.texture.ISpriteMap;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

/**
 * The manager that handles textures for the game.
 *
 * Allows for binding of textures (and the subsequent loading, if the texture has not been loaded before),
 * And gives access to the prebuild sprite maps.
 */
public interface ITextureManager
{
    /**
     * Binds and loads a texture into the rendering engine.
     *
     * @param textureLocation The location of the texture to load.
     */
    void bindTexture(final IIdentifier textureLocation);

    /**
     * Gives access to a given sprite map, based on its identifier.
     *
     * @param spriteName The identifier of the map.
     * @return The map with the given identifier.
     */
    ISpriteMap getSpriteMap(final IIdentifier spriteName);
}
