package com.ldtteam.jvoxelizer;

import com.ldtteam.jvoxelizer.client.gui.IGui;
import com.ldtteam.jvoxelizer.client.renderer.block.IBlockRenderDispatcher;
import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
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

    ISingleplayerPlayerEntity getSinglePlayerPlayerEntity();

    int getDisplayWidth();

    int getDisplayHeight();

    IGui<?> getCurrentGui();

    void displayGuiScreen(IGui<?> gui);


    IServerInstance getCurrentServerInstance();

    ITextureManager getTextureManager();

    ISpriteMap getTextureMapBlocks();

    IFontRenderer getDefaultFontRenderer();

    IBlockRenderDispatcher getBlockRendererDispatcher();
}
