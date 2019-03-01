package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.texture;

import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class Sprite implements ISprite
{

    private final TextureAtlasSprite forgeSprite;

    public Sprite(final TextureAtlasSprite forgeSprite) {this.forgeSprite = forgeSprite;}

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

    public TextureAtlasSprite getForgeSprite()
    {
        return forgeSprite;
    }
}
