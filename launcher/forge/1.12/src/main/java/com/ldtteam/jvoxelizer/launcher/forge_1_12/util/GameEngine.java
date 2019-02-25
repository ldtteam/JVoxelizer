package com.ldtteam.jvoxelizer.launcher.forge_1_12.util;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.client.gui.IGui;
import com.ldtteam.jvoxelizer.client.renderer.block.IBlockRenderDispatcher;
import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.client.renderer.item.IItemRenderer;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISpriteMap;
import com.ldtteam.jvoxelizer.client.textures.ITextureManager;
import com.ldtteam.jvoxelizer.entity.living.player.ISingleplayerPlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.player.SinglePlayerEntity;
import com.ldtteam.jvoxelizer.server.IServerInstance;
import net.minecraft.client.Minecraft;

public class GameEngine implements IGameEngine
{
    private Minecraft minecraft;

    public GameEngine(final Minecraft minecraft)
    {
        this.minecraft = minecraft;
    }

    @Override
    public ISingleplayerPlayerEntity getSinglePlayerPlayerEntity()
    {
        return new SinglePlayerEntity(minecraft.player);
    }

    @Override
    public int getDisplayWidth()
    {
        return minecraft.displayWidth;
    }

    @Override
    public int getDisplayHeight()
    {
        return minecraft.displayHeight;
    }

    @Override
    public IGui<?> getCurrentGui()
    {
        /**
         * TODO
         */
    }

    @Override
    public void displayGuiScreen(final IGui<?> gui)
    {
        /**
         * TODO
         */
    }

    @Override
    public IServerInstance getCurrentServerInstance()
    {
        /**
         * TODO
         */
    }

    @Override
    public ITextureManager getTextureManager()
    {
        return minecraft.getTextureManager();
    }

    @Override
    public ISpriteMap getTextureMapBlocks()
    {
        return minecraft.getTextureMapBlocks();
    }

    @Override
    public IFontRenderer getDefaultFontRenderer()
    {
        return minecraft.fontRenderer;
    }

    @Override
    public IBlockRenderDispatcher getBlockRendererDispatcher()
    {
        return minecraft.getBlockRendererDispatcher();
    }

    @Override
    public IItemRenderer getItemRenderer()
    {
        return minecraft.getItemRenderer();
    }
}
