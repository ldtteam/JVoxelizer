package com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui.logic.builder.provider;

import com.ldtteam.jvoxelizer.client.gui.IGuiScreen;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.IGuiScreenBuilder;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.IGuiScreenBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui.logic.builder.JVoxForgeGuiScreenBuilder;

public class GuiScreenBuilderProvider implements IGuiScreenBuilderProvider
{
    private static GuiScreenBuilderProvider ourInstance = new GuiScreenBuilderProvider();

    public static GuiScreenBuilderProvider getInstance()
    {
        return ourInstance;
    }

    private GuiScreenBuilderProvider()
    {
    }

    @Override
    public <I> IGuiScreenBuilder<?, I, IGuiScreen<I>> provide(final I instanceData)
    {
        return new JVoxForgeGuiScreenBuilder<>(instanceData);
    }
}
