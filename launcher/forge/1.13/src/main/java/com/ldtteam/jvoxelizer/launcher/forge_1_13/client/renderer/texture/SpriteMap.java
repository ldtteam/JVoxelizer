package com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.texture;

import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISpriteMap;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;
import net.minecraft.client.renderer.texture.TextureMap;

public class SpriteMap implements ISpriteMap, IForgeJVoxelizerWrapper
{

    private final TextureMap forgeSpriteMap;

    private SpriteMap(final TextureMap forgeSpriteMap) {this.forgeSpriteMap = forgeSpriteMap;}

    @Override
    public ISprite getSrite(final String spriteName)
    {
        return Sprite.fromForge(forgeSpriteMap.getAtlasSprite(spriteName));
    }

    private TextureMap getForgeSpriteMap()
    {
        return forgeSpriteMap;
    }

    public static TextureMap asForge(ISpriteMap spriteMap)
    {
        if (spriteMap instanceof TextureMap)
        {
            return (TextureMap) spriteMap;
        }

        if (spriteMap == null)
        {
            return null;
        }

        if (!(spriteMap instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("SpriteMap is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) spriteMap).getForgeInstance();
    }

    public static ISpriteMap fromForge(TextureMap textureMap)
    {
        if (textureMap instanceof ISpriteMap)
        {
            return (ISpriteMap) textureMap;
        }

        return new SpriteMap(textureMap);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeSpriteMap();
    }
}
