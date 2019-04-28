package com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui.logic.builder.provider;

import com.ldtteam.jvoxelizer.client.gui.IGui;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.IGuiBuilder;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.IGuiBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui.logic.builder.JVoxForgeGuiBuilder;

public class GuiBuilderProvider implements IGuiBuilderProvider
{
    private static GuiBuilderProvider ourInstance = new GuiBuilderProvider();

    public static GuiBuilderProvider getInstance()
    {
        return ourInstance;
    }

    private GuiBuilderProvider()
    {
    }

    @Override
    public <I> IGuiBuilder<?, I, IGui<I>> provide(final I instanceData)
    {
        return new JVoxForgeGuiBuilder<>(instanceData);
    }
}
