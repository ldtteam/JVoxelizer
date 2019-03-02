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

public class GameEngine implements IGameEngine
{
    @Override
    public boolean isDedicatedServer()
    {
        return false;
    }

    @Override
    public ISingleplayerPlayerEntity getSinglePlayerPlayerEntity()
    {
        return new SinglePlayerEntity(Minecraft.getMinecraft().player);
    }

    @Override
    public int getDisplayWidth()
    {
        return Minecraft.getMinecraft().displayWidth;
    }

    @Override
    public int getDisplayHeight()
    {
        return Minecraft.getMinecraft().displayHeight;
    }

    @Override
    public IGuiScreen<?> getCurrentGui()
    {
        //TODO: Implement JVox side.
        return Minecraft.getMinecraft().currentScreen;
    }

    @Override
    public void displayGuiScreen(final IGui<?> gui)
    {
        //TODO: Implement JVox side.
        Minecraft.getMinecraft().displayGuiScreen(gui);
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
        return Minecraft.getMinecraft().getTextureManager();
    }

    @Override
    public ISpriteMap getTextureMapBlocks()
    {
        //TODO: Implement JVox side.
        return Minecraft.getMinecraft().getTextureMapBlocks();
    }

    @Override
    public IFontRenderer getDefaultFontRenderer()
    {
        //TODO: Implement JVox side.
        return Minecraft.getMinecraft().fontRenderer;
    }

    @Override
    public IBlockRenderDispatcher getBlockRendererDispatcher()
    {
        //TODO: Implement JVox side.
        return Minecraft.getMinecraft().getBlockRendererDispatcher();
    }

    @Override
    public IItemRenderer getItemRenderer()
    {
        //TODO: Implement JVox side.
        return Minecraft.getMinecraft().getItemRenderer();
    }

    public Minecraft getForgeGameEngine()
    {
        return Minecraft.getMinecraft();
    }

    public static Minecraft asForge(IGameEngine engine)
    {
        return ((GameEngine) engine).getForgeGameEngine();
    }
}
