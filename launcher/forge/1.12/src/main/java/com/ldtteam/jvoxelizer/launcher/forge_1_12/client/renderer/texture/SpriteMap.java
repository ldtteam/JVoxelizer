package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.texture;

import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISpriteMap;
import net.minecraft.client.renderer.texture.TextureMap;

public class SpriteMap implements ISpriteMap
{

    private final TextureMap forgeMap;

    public SpriteMap(final TextureMap forgeMap) {this.forgeMap = forgeMap;}

    @Override
    public ISprite getAtlasSprite(final String spriteName)
    {
        return null;
    }

    public TextureMap getForgeMap()
    {
        return forgeMap;
    }

    public static TextureMap asForge(ISpriteMap spriteMap)
    {
        if (spriteMap instanceof TextureMap)
            return (TextureMap) spriteMap;

        return ((SpriteMap) spriteMap).getForgeMap();
    }

    public static ISpriteMap fromForge(TextureMap textureMap)
    {
        if (textureMap instanceof ISpriteMap)
            return (ISpriteMap) textureMap;

        return new SpriteMap(textureMap);
    }
}
