package com.ldtteam.jvoxelizer.entity;

import com.ldtteam.jvoxelizer.util.nbt.INBTSerializable;
import com.ldtteam.jvoxelizer.world.IDimension;

import java.util.UUID;

public interface IEntity extends INBTSerializable
{
    UUID getId();

    IDimension getDimension();
}
