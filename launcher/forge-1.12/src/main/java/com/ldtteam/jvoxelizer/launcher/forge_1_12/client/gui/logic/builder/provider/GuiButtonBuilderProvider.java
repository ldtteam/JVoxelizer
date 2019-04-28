package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.builder.provider;

import com.ldtteam.jvoxelizer.client.gui.IGuiButton;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.IGuiButtonBuilder;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.IGuiButtonBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.builder.JVoxForgeGuiButtonBuilder;

public class GuiButtonBuilderProvider implements IGuiButtonBuilderProvider
{
    private static GuiButtonBuilderProvider ourInstance = new GuiButtonBuilderProvider();

    public static GuiButtonBuilderProvider getInstance()
    {
        return ourInstance;
    }

    private GuiButtonBuilderProvider()
    {
    }

    @Override
    public <I> IGuiButtonBuilder<?, I, IGuiButton<I>> provide(
      final int buttonId, final int x, final int y, final String buttonText, final I instanceData)
    {
        return new JVoxForgeGuiButtonBuilder<>(buttonId, x, y, buttonText, instanceData);
    }
}
