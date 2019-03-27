package com.ldtteam.jvoxelizer.launcher.forge_1_12;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.client.gui.IGuiScreen;
import com.ldtteam.jvoxelizer.client.renderer.block.IBlockRenderDispatcher;
import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.client.renderer.item.IItemRenderer;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISpriteMap;
import com.ldtteam.jvoxelizer.client.textures.ITextureManager;
import com.ldtteam.jvoxelizer.entity.living.player.ISingleplayerPlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.server.ServerInstance;
import com.ldtteam.jvoxelizer.server.IServerInstance;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class DedicatedServerGameEngine implements IGameEngine
{
    @Override
    public boolean isDedicatedServer()
    {
        return true;
    }

    @Override
    public ISingleplayerPlayerEntity getSinglePlayerPlayerEntity()
    {
        return null;
    }

    @Override
    public int getDisplayWidth()
    {
        return 0;
    }

    @Override
    public int getDisplayHeight()
    {
        return 0;
    }

    @Override
    public IGuiScreen<?> getCurrentGui()
    {
        return null;
    }

    @Override
    public void displayGuiScreen(final IGuiScreen<?> gui)
    {
        //Noop
    }

    @Override
    public IServerInstance getCurrentServerInstance()
    {
        return ServerInstance.fromForge(FMLCommonHandler.instance().getMinecraftServerInstance());
    }

    @Override
    public ITextureManager getTextureManager()
    {
        return null;
    }

    @Override
    public ISpriteMap getTextureMapBlocks()
    {
        return null;
    }

    @Override
    public IFontRenderer getDefaultFontRenderer()
    {
        return null;
    }

    @Override
    public IBlockRenderDispatcher getBlockRendererDispatcher()
    {
        return null;
    }

    @Override
    public IItemRenderer getItemRenderer()
    {
        return null;
    }
}
