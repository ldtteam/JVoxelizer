package com.ldtteam.jvoxelizer.client.renderer.texture;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface ISpriteMap
{
    static String getLocationOfBlocksTexture()
    {
        throw new NotImplementedException();
    }

    ISprite getAtlasSprite(String spriteName);
}
