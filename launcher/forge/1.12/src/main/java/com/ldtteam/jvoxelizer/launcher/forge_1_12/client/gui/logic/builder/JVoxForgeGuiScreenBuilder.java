package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.IGuiScreen;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.AbstractGuiScreenBuilder;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.JVoxForgeGuiScreen;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.pipeline.ForgeGuiScreenPipeline;

public class JVoxForgeGuiScreenBuilder<I> extends AbstractGuiScreenBuilder<JVoxForgeGuiScreenBuilder<I>, I, IGuiScreen<I>>
{

    private final I instanceData;

    public JVoxForgeGuiScreenBuilder(final I instanceData) {this.instanceData = instanceData;}

    @Override
    public IGuiScreen<I> build()
    {
        return new JVoxForgeGuiScreen<>(instanceData,
          new ForgeGuiScreenPipeline<>(DrawCenteredStringPipeline,
            DrawGradientRectPipeline,
            DrawTexturedModalRectPipeline,
            DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntPipeline,
            DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntPipeline,
            DrawHorizontalLinePipeline,
            DrawStringPipeline,
            DrawVerticalLinePipeline,
            DrawHoveringTextPipeline,
            DrawHoveringTextWithTextLinesAsStringListPipeline,
            DrawHoveringTextWithFontAsFontRendererPipeline,
            RenderToolTipPipeline,
            ConfirmClickedPipeline,
            HandleKeyboardInputPipeline,
            DrawWorldBackgroundPipeline,
            HandleComponentClickPipeline,
            HandleInputPipeline,
            KeyTypedPipeline,
            MouseReleasedPipeline,
            UpdateScreenPipeline,
            ActionPerformedPipeline,
            GetItemToolTipPipeline,
            HandleMouseInputPipeline,
            DrawBackgroundPipeline,
            DrawDefaultBackgroundPipeline,
            DrawScreenPipeline,
            DoesGuiPauseGamePipeline,
            HandleComponentHoverPipeline,
            MouseClickMovePipeline,
            SendChatMessagePipeline,
            SendChatMessageWithAddToChatAsbooleanPipeline,
            InitGuiPipeline,
            SetGuiSizePipeline,
            IsFocusedPipeline,
            OnGuiClosedPipeline,
            OnResizePipeline,
            MouseClickedPipeline,
            SetWorldAndResolutionPipeline,
            SetFocusedPipeline,
            SetTextPipeline
            ));
    }
}
