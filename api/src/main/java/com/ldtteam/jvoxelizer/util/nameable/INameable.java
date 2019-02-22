package com.ldtteam.jvoxelizer.util.nameable;

import com.ldtteam.jvoxelizer.util.textcomponent.ITextComponent;

public interface INameable
{
    String getName();

    boolean hasCustomName();

    ITextComponent getDisplayName();
}
