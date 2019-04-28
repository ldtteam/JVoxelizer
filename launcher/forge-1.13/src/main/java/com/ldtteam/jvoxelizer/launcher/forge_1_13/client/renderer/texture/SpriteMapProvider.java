package com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.texture;

import com.ldtteam.jvoxelizer.client.renderer.texture.ISpriteMapProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.identifier.Identifier;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;
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
    public IIdentifier getLocationOfBlocksTexture()
    {
        return Identifier.fromForge(TextureMap.LOCATION_BLOCKS_TEXTURE);
    }
}
