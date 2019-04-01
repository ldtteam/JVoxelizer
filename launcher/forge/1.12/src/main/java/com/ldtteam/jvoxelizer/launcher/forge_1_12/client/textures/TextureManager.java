package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.textures;

import com.ldtteam.jvoxelizer.client.renderer.texture.ISpriteMap;
import com.ldtteam.jvoxelizer.client.textures.ITextureManager;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.texture.SpriteMap;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.identifier.Identifier;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;
import net.minecraft.client.renderer.texture.TextureMap;

public class TextureManager implements ITextureManager, IForgeJVoxelizerWrapper
{

    private final net.minecraft.client.renderer.texture.TextureManager forgeTextureManager;

    private TextureManager(final net.minecraft.client.renderer.texture.TextureManager forgeTextureManager) {this.forgeTextureManager = forgeTextureManager;}

    @Override
    public void bindTexture(final IIdentifier textureLocation)
    {
        forgeTextureManager.bindTexture(Identifier.asForge(textureLocation));
    }

    @Override
    public ISpriteMap getSpriteMap(final IIdentifier spriteName)
    {
        return SpriteMap.fromForge((TextureMap) forgeTextureManager.getTexture(Identifier.asForge(spriteName)));
    }

    private net.minecraft.client.renderer.texture.TextureManager getForgeTextureManager()
    {
        return forgeTextureManager;
    }

    public static ITextureManager fromForge(net.minecraft.client.renderer.texture.TextureManager textureManager)
    {
        if (textureManager instanceof ITextureManager)
        {
            return (ITextureManager) textureManager;
        }

        return new TextureManager(textureManager);
    }

    public static net.minecraft.client.renderer.texture.TextureManager asForge(ITextureManager textureManager)
    {
        if (textureManager instanceof net.minecraft.client.renderer.texture.TextureManager)
        {
            return (net.minecraft.client.renderer.texture.TextureManager) textureManager;
        }

        if (textureManager == null)
        {
            return null;
        }

        if (!(textureManager instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("TextureManager is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) textureManager).getForgeInstance();
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeTextureManager();
    }
}
