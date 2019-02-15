package com.ldtteam.minelaunch;

import com.ldtteam.minelaunch.block.state.IBlockStateProvider;
import com.ldtteam.minelaunch.entity.IEntity;
import com.ldtteam.minelaunch.entity.IEntityProvider;
import com.ldtteam.minelaunch.item.IItemStackProvider;
import com.ldtteam.minelaunch.util.math.ICoordinate;
import com.ldtteam.minelaunch.util.math.ICoordinateProvider;
import com.ldtteam.minelaunch.util.nbt.INBTProvider;

public class ProviderHolder
{
    private static ProviderHolder      ourInstance = new ProviderHolder();
    private        IEntityProvider     iEntityProvider;
    private        IBlockStateProvider iBlockStateProvider;
    private        IItemStackProvider  iItemStackProvider;
    private        ICoordinateProvider iCoordinateProvider;
    private        INBTProvider        inbtProvider;

    private ProviderHolder()
    {
    }

    public static ProviderHolder getInstance()
    {
        return ourInstance;
    }

    public void setup(
      IEntityProvider iEntityProvider,
      IBlockStateProvider iBlockStateProvider,
      IItemStackProvider iItemStackProvider,
      ICoordinateProvider iCoordinateProvider,
      INBTProvider inbtProvider
    )
    {
        this.iEntityProvider = iEntityProvider;
        this.iBlockStateProvider = iBlockStateProvider;
        this.iItemStackProvider = iItemStackProvider;
        this.iCoordinateProvider = iCoordinateProvider;
        this.inbtProvider = inbtProvider;
    }

    public IEntityProvider getiEntityProvider()
    {
        return iEntityProvider;
    }

    public IBlockStateProvider getiBlockStateProvider() { return iBlockStateProvider; }

    public IItemStackProvider getiItemStackProvider()
    {
        return iItemStackProvider;
    }

    public ICoordinateProvider getiCoordinateProvider()
    {
        return iCoordinateProvider;
    }

    public INBTProvider getInbtProvider()
    {
        return inbtProvider;
    }
}
