package com.ldtteam.minelaunch.tileentity;

import com.ldtteam.minelaunch.util.math.ICoordinate;
import com.ldtteam.minelaunch.world.IDimension;

public interface IBlockEntity
{

    IDimension getDimension();

    ICoordinate getPosition();
}
