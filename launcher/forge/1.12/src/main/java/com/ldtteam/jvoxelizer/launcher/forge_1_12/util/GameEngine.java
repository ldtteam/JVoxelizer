package com.ldtteam.jvoxelizer.launcher.forge_1_12.util;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.client.gui.IGui;
import com.ldtteam.jvoxelizer.entity.living.player.ISingleplayerPlayerEntity;
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
        /**
         * TODO
         */
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
}
