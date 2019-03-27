package com.ldtteam.jvoxelizer.item;

public interface IItemStackProvider
{

    IItemStack provide();

    boolean areItemStackTagsEqual(IItemStack pItemStack1, IItemStack pItemStack2);
}
