package com.ldtteam.jvoxelizer.launcher.forge_1_13;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.client.gui.IGuiScreen;
import com.ldtteam.jvoxelizer.client.renderer.block.IBlockRenderDispatcher;
import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.client.renderer.item.IItemRenderer;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISpriteMap;
import com.ldtteam.jvoxelizer.client.textures.ITextureManager;
import com.ldtteam.jvoxelizer.entity.living.player.ISingleplayerPlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui.GuiScreen;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.block.BlockRenderDispatcher;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.font.FontRenderer;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.item.ItemRenderer;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.texture.SpriteMap;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.textures.TextureManager;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.living.player.SinglePlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.server.ServerInstance;
import com.ldtteam.jvoxelizer.server.IServerInstance;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

public class GameEngine implements IGameEngine
{
    private final Minecraft minecraft;

    private GameEngine(final Minecraft minecraft)
    {
        this.minecraft = minecraft;
    }

    @Override
    public boolean isDedicatedServer()
    {
        return false;
    }

    @Override
    public ISingleplayerPlayerEntity getSinglePlayerPlayerEntity()
    {
        return SinglePlayerEntity.fromForge(minecraft.player);
    }

    @Override
    public int getDisplayWidth()
    {
        return minecraft.mainWindow.getWidth();
    }

    @Override
    public int getDisplayHeight()
    {
        return minecraft.mainWindow.getHeight();
    }

    @Override
    public IGuiScreen<?> getCurrentGui()
    {
        return GuiScreen.fromForge(minecraft.currentScreen);
    }

    @Override
    public void displayGuiScreen(final IGuiScreen<?> gui)
    {
        minecraft.displayGuiScreen(GuiScreen.asForge(gui));
    }

    @Override
    public IServerInstance getCurrentServerInstance()
    {
        return ServerInstance.fromForge(ServerLifecycleHooks.getCurrentServer());
    }

    @Override
    public ITextureManager getTextureManager()
    {
        return TextureManager.fromForge(minecraft.getTextureManager());
    }

    @Override
    public ISpriteMap getTextureMapBlocks()
    {
        return SpriteMap.fromForge(minecraft.getTextureMap());
    }

    @Override
    public IFontRenderer getDefaultFontRenderer()
    {
        return FontRenderer.fromForge(minecraft.fontRenderer);
    }

    @Override
    public IBlockRenderDispatcher getBlockRendererDispatcher()
    {
        return BlockRenderDispatcher.fromForge(minecraft.getBlockRendererDispatcher());
    }

    @Override
    public IItemRenderer getItemRenderer()
    {
        return ItemRenderer.fromForge(minecraft.getItemRenderer());
    }

    public static Minecraft asForge(final IGameEngine engine)
    {
        return ((GameEngine) engine).minecraft;
    }

    public static IGameEngine fromForge(final Minecraft engine)
    {
        return new GameEngine(engine);
    }
}
