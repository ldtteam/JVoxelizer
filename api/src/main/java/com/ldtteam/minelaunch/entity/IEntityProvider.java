package com.ldtteam.minelaunch.entity;

import java.util.UUID;

public interface IEntityProvider
{

    IEntity provide(UUID id);

    IEntity provide();
}
