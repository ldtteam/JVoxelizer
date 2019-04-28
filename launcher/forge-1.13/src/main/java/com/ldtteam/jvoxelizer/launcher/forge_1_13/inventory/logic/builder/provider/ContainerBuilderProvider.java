package com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.logic.builder.provider;

import com.ldtteam.jvoxelizer.inventory.IContainer;
import com.ldtteam.jvoxelizer.inventory.logic.builder.IContainerBuilder;
import com.ldtteam.jvoxelizer.inventory.logic.builder.IContainerBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.logic.builder.ContainerBuilder;

public class ContainerBuilderProvider implements IContainerBuilderProvider
{
    private static ContainerBuilderProvider ourInstance = new ContainerBuilderProvider();

    public static ContainerBuilderProvider getInstance()
    {
        return ourInstance;
    }

    private ContainerBuilderProvider()
    {
    }

    @Override
    public <I> IContainerBuilder<?, I, IContainer<I>> provide()
    {
        return new ContainerBuilder<>();
    }
}
