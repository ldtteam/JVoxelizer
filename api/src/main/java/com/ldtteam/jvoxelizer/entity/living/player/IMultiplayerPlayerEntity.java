package com.ldtteam.jvoxelizer.entity.living.player;

public interface IMultiplayerPlayerEntity extends IPlayerEntity
{
    void incrementWindowId();

    void closeOpenContainer();

    int getCurrentWindowId();
}
