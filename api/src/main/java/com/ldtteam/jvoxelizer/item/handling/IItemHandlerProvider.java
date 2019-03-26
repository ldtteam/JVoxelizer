package com.ldtteam.jvoxelizer.item.handling;

public interface IItemHandlerProvider
{

    IItemHandler provideEmpty();

    IItemHandler provideRanged(IItemHandler other, int minSlot, int maxSlotExlcuding);
}
