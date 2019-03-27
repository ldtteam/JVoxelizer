package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.texture;

import com.ldtteam.jvoxelizer.client.renderer.texture.ISpriteMapProvider;
import net.minecraft.client.renderer.texture.TextureMap;

public class SpriteMapProvider implements ISpriteMapProvider
{
    private static SpriteMapProvider ourInstance = new SpriteMapProvider();

    public static SpriteMapProvider getInstance()
    {
        return ourInstance;
    }

    private SpriteMapProvider()
    {
    }

    @Override
    public String getLocationOfBlocksTexture()
    {
        return TextureMap.LOCATION_BLOCKS_TEXTURE.toString();
    }
}
