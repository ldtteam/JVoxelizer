package com.ldtteam.minelaunch.entity;

import com.ldtteam.minelaunch.world.IDimension;

import java.util.UUID;

public interface IEntity
{
    UUID getId();

    IDimension getDimension();
}
