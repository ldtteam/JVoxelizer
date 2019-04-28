package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.IGuiContainer;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.AbstractGuiContainerBuilder;
import com.ldtteam.jvoxelizer.inventory.IContainer;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.JVoxForgeGuiContainer;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.pipeline.ForgeGuiContainerPipeline;

public class JVoxForgeGuiContainerBuilder<I> extends AbstractGuiContainerBuilder<JVoxForgeGuiContainerBuilder<I>, I, IGuiContainer<I>>
{

    private final IContainer<?> container;
    private final I             instanceData;

    public JVoxForgeGuiContainerBuilder(final IContainer<?> container, final I instanceData)
    {
        this.container = container;
        this.instanceData = instanceData;
    }

    @Override
    public IGuiContainer<I> build()
    {
        return new JVoxForgeGuiContainer<>(
          container,
          instanceData,
          new ForgeGuiContainerPipeline<>(
            DrawCenteredStringPipeline,
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
            SetTextPipeline,
            DrawGuiContainerForegroundLayerPipeline,
            DrawGuiContainerBackgroundLayerPipeline,
            DrawSlotPipeline,
            HandleMouseClickPipeline,
            GetYSizePipeline,
            GetGuiTopPipeline,
            GetGuiLeftPipeline,
            RenderHoveredToolTipPipeline,
            HasClickedOutsidePipeline,
            GetSlotUnderMousePipeline,
            IsPointInRegionPipeline,
            CheckHotbarKeysPipeline,
            GetXSizePipeline,
            IsMouseOverSlotPipeline
          )
        );
    }
}
