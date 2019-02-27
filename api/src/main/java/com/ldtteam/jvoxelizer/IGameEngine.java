package com.ldtteam.jvoxelizer;

import com.ldtteam.jvoxelizer.client.gui.IGui;
import com.ldtteam.jvoxelizer.client.gui.IGuiScreen;
import com.ldtteam.jvoxelizer.client.renderer.block.IBlockRenderDispatcher;
import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.client.renderer.item.IItemRenderer;
import com.ldtteam.jvoxelizer.client.renderer.opengl.IOpenGl;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISpriteMap;
import com.ldtteam.jvoxelizer.client.textures.ITextureManager;
import com.ldtteam.jvoxelizer.entity.living.player.ISingleplayerPlayerEntity;
import com.ldtteam.jvoxelizer.server.IServerInstance;

public interface IGameEngine
{

    static IGameEngine getInstance()
    {
        return IGameEngineProviderHolder.getInstance().provide();
    }

    boolean isDedicatedServer();

    ISingleplayerPlayerEntity getSinglePlayerPlayerEntity();

    int getDisplayWidth();

    int getDisplayHeight();

    IGuiScreen<?> getCurrentGui();

    void displayGuiScreen(IGui<?> gui);


    IServerInstance getCurrentServerInstance();

    ITextureManager getTextureManager();

    ISpriteMap getTextureMapBlocks();

    IFontRenderer getDefaultFontRenderer();

    IBlockRenderDispatcher getBlockRendererDispatcher();

    IItemRenderer getItemRenderer();
}
