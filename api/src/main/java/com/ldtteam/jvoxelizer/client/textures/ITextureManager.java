package com.ldtteam.jvoxelizer.client.textures;

import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISpriteMap;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

public interface ITextureManager
{
    void bindTexture(final IIdentifier textureLocation);

    ISpriteMap getSpriteMap(final String spriteName);
}
