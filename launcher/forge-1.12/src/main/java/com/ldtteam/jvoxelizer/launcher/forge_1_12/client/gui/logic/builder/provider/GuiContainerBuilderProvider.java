package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.builder.provider;

import com.ldtteam.jvoxelizer.client.gui.IGuiContainer;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.IGuiContainerBuilder;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.IGuiContainerBuilderProvider;
import com.ldtteam.jvoxelizer.inventory.IContainer;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.builder.JVoxForgeGuiContainerBuilder;

public class GuiContainerBuilderProvider implements IGuiContainerBuilderProvider
{
    private static GuiContainerBuilderProvider ourInstance = new GuiContainerBuilderProvider();

    public static GuiContainerBuilderProvider getInstance()
    {
        return ourInstance;
    }

    private GuiContainerBuilderProvider()
    {
    }

    @Override
    public <I> IGuiContainerBuilder<?, I, IGuiContainer<I>> provide(
      final I instanceData, final IContainer<?> container)
    {
        return new JVoxForgeGuiContainerBuilder<>(container, instanceData);
    }
}
