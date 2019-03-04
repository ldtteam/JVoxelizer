package com.ldtteam.jvoxelizer.client.renderer.texture;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface ISpriteMap
{
    static String getLocationOfBlocksTexture()
    {
        return ISpriteMapProviderHolder.getInstance().getLocationOfBlocksTexture();
    }

    ISprite getAtlasSprite(String spriteName);
}
