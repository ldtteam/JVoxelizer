package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.IGui;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.AbstractGuiBuilder;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.JVoxForgeGui;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.pipeline.ForgeGuiPipeline;

public class JVoxForgeGuiBuilder<I> extends AbstractGuiBuilder<JVoxForgeGuiBuilder<I>, I, IGui<I>>
{

    private final I instanceData;

    public JVoxForgeGuiBuilder(final I instanceData) {this.instanceData = instanceData;}

    @Override
    public IGui<I> build()
    {
        return new JVoxForgeGui<>(instanceData, new ForgeGuiPipeline<>(
          DrawCenteredStringPipeline,
          DrawGradientRectPipeline,
          DrawTexturedModalRectPipeline,
          DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntPipeline,
          DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntPipeline,
          DrawHorizontalLinePipeline,
          DrawStringPipeline,
          DrawVerticalLinePipeline));
    }
}
