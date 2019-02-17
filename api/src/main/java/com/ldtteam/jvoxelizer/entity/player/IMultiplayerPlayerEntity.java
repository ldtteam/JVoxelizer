package com.ldtteam.jvoxelizer.entity.player;

public interface IMultiplayerPlayerEntity extends IPlayerEntity
{
    void incrementWindowId();

    void closeOpenContainer();

    int getCurrentWindowId();
}
