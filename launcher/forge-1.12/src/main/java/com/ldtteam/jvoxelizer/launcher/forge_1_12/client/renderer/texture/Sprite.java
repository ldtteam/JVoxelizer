package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.texture;

import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class Sprite implements ISprite, IForgeJVoxelizerWrapper
{

    private final TextureAtlasSprite forgeSprite;

    private Sprite(final TextureAtlasSprite forgeSprite) {this.forgeSprite = forgeSprite;}

    @Override
    public float getMinU()
    {
        return forgeSprite.getMinU();
    }

    @Override
    public float getInterpolatedV(final double h)
    {
        return forgeSprite.getInterpolatedV(h);
    }

    @Override
    public float getInterpolatedU(final double w)
    {
        return forgeSprite.getInterpolatedU(w);
    }

    @Override
    public float getMaxU()
    {
        return forgeSprite.getMaxU();
    }

    @Override
    public float getMaxV()
    {
        return forgeSprite.getMaxV();
    }

    @Override
    public float getMinV()
    {
        return forgeSprite.getMinV();
    }

    private TextureAtlasSprite getForgeSprite()
    {
        return forgeSprite;
    }

    public static TextureAtlasSprite asForge(ISprite sprite)
    {
        if (sprite instanceof TextureAtlasSprite)
        {
            return (TextureAtlasSprite) sprite;
        }

        if (sprite == null)
        {
            return null;
        }

        if (!(sprite instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("Sprite is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) sprite).getForgeInstance();
    }

    public static ISprite fromForge(TextureAtlasSprite sprite)
    {
        if (sprite == null)
        {
            return null;
        }

        if (sprite instanceof ISprite)
        {
            return (ISprite) sprite;
        }

        return new Sprite(sprite);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return null;
    }
}
