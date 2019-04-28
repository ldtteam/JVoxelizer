package com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.IGuiButton;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.AbstractGuiButtonBuilder;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui.JVoxForgeGuiButton;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui.logic.pipeline.ForgeGuiButtonPipeline;

public class JVoxForgeGuiButtonBuilder<I> extends AbstractGuiButtonBuilder<JVoxForgeGuiButtonBuilder<I>, I, IGuiButton<I>>
{

    private final int    buttonId;
    private final int    x;
    private final int    y;
    private final String buttonText;

    private final I instanceData;

    public JVoxForgeGuiButtonBuilder(final int buttonId, final int x, final int y, final String buttonText, final I instanceData)
    {
        this.buttonId = buttonId;
        this.x = x;
        this.y = y;
        this.buttonText = buttonText;
        this.instanceData = instanceData;
    }

    @Override
    public IGuiButton<I> build()
    {
        return new JVoxForgeGuiButton<>(
          buttonId,
          x,
          y,
          buttonText,
          instanceData,
          new ForgeGuiButtonPipeline<>(
            DrawCenteredStringPipeline,
            DrawGradientRectPipeline,
            DrawTexturedModalRectPipeline,
            DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntPipeline,
            DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntPipeline,
            DrawHorizontalLinePipeline,
            DrawStringPipeline,
            DrawVerticalLinePipeline,
            MouseReleasedPipeline,
            IsMouseOverPipeline,
            MouseDraggedPipeline,
            GetHoverStatePipeline,
            PlayPressSoundPipeline,
            DrawButtonForegroundLayerPipeline,
            GetButtonWidthPipeline,
            SetWidthPipeline,
            DrawButtonPipeline,
            MousePressedPipeline)
        );
    }
}
