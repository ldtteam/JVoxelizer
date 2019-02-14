package com.ldtteam.minelaunch.entity;

import com.ldtteam.minelaunch.util.nbt.INBTSerializable;
import com.ldtteam.minelaunch.world.IDimension;

import java.util.UUID;

public interface IEntity extends INBTSerializable
{
    UUID getId();

    IDimension getDimension();
}
