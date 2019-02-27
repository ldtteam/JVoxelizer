package com.ldtteam.jvoxelizer.launcher.forge_1_12;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.client.gui.IGui;
import com.ldtteam.jvoxelizer.client.gui.IGuiScreen;
import com.ldtteam.jvoxelizer.client.renderer.block.IBlockRenderDispatcher;
import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.client.renderer.item.IItemRenderer;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISpriteMap;
import com.ldtteam.jvoxelizer.client.textures.ITextureManager;
import com.ldtteam.jvoxelizer.entity.living.player.ISingleplayerPlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.player.SinglePlayerEntity;
import com.ldtteam.jvoxelizer.server.IServerInstance;
import net.minecraft.client.Minecraft;
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
    public void displayGuiScreen(final IGui<?> gui)
    {
        //Noop
    }

    @Override
    public IServerInstance getCurrentServerInstance()
    {
        //TODO: Implement JVox side.
        return FMLCommonHandler.instance().getMinecraftServerInstance();
    }

    @Override
    public ITextureManager getTextureManager()
    {
        //TODO: Implement JVox side.
        return null;
    }

    @Override
    public ISpriteMap getTextureMapBlocks()
    {
        //TODO: Implement JVox side.
        return null;
    }

    @Override
    public IFontRenderer getDefaultFontRenderer()
    {
        //TODO: Implement JVox side.
        return null;
    }

    @Override
    public IBlockRenderDispatcher getBlockRendererDispatcher()
    {
        //TODO: Implement JVox side.
        return null;
    }

    @Override
    public IItemRenderer getItemRenderer()
    {
        //TODO: Implement JVox side.
        return null;
    }
}
