package com.ldtteam.jvoxelizer;

import com.ldtteam.jvoxelizer.client.gui.IGui;
import com.ldtteam.jvoxelizer.entity.player.ISingleplayerPlayerEntity;
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

}
