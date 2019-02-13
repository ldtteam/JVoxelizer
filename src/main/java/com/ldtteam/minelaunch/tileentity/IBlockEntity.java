package com.ldtteam.minelaunch.tileentity;

import com.ldtteam.minelaunch.util.math.IInWorldCoordinate;
import com.ldtteam.minelaunch.world.IDimension;

public interface IBlockEntity
{

    IDimension getDimension();

    IInWorldCoordinate getPosition();
}
