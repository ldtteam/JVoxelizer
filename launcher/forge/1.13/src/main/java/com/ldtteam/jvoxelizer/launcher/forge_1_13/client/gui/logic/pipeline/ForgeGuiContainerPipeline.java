package com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui.logic.pipeline;

import com.ldtteam.jvoxelizer.client.gui.IGuiContainer;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.core.logic.TypedPipelineElementContext;
import com.ldtteam.jvoxelizer.core.logic.VoidPipelineElementContext;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ForgeGuiContainerPipeline<O extends IGuiContainer<I>, I> extends ForgeGuiScreenPipeline<O, I>
{
    private final List<Consumer<VoidPipelineElementContext<DrawGuiContainerForegroundLayerContext, O, I>>> DrawGuiContainerForegroundLayerPipeline;

    private final List<Consumer<VoidPipelineElementContext<DrawGuiContainerBackgroundLayerContext, O, I>>> DrawGuiContainerBackgroundLayerPipeline;

    private final List<Consumer<VoidPipelineElementContext<DrawSlotContext, O, I>>> DrawSlotPipeline;

    private final List<Consumer<VoidPipelineElementContext<HandleMouseClickContext, O, I>>> HandleMouseClickPipeline;

    private final List<Function<TypedPipelineElementContext<GetYSizeContext, Integer, O, I>, Integer>> GetYSizePipeline;

    private final List<Function<TypedPipelineElementContext<GetGuiTopContext, Integer, O, I>, Integer>> GetGuiTopPipeline;

    private final List<Function<TypedPipelineElementContext<GetGuiLeftContext, Integer, O, I>, Integer>> GetGuiLeftPipeline;

    private final List<Consumer<VoidPipelineElementContext<RenderHoveredToolTipContext, O, I>>> RenderHoveredToolTipPipeline;

    private final List<Function<TypedPipelineElementContext<HasClickedOutsideContext, Boolean, O, I>, Boolean>> HasClickedOutsidePipeline;

    private final List<Function<TypedPipelineElementContext<GetSlotUnderMouseContext, ISlot, O, I>, ISlot>> GetSlotUnderMousePipeline;

    private final List<Function<TypedPipelineElementContext<IsPointInRegionContext, Boolean, O, I>, Boolean>> IsPointInRegionPipeline;

    private final List<Function<TypedPipelineElementContext<CheckHotbarKeysContext, Boolean, O, I>, Boolean>> CheckHotbarKeysPipeline;

    private final List<Function<TypedPipelineElementContext<GetXSizeContext, Integer, O, I>, Integer>> GetXSizePipeline;

    private final List<Function<TypedPipelineElementContext<IsMouseOverSlotContext, Boolean, O, I>, Boolean>> IsMouseOverSlotPipeline;

    public ForgeGuiContainerPipeline(
      final List<Consumer<VoidPipelineElementContext<DrawCenteredStringContext, O, I>>> drawCenteredStringPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawGradientRectContext, O, I>>> drawGradientRectPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawTexturedModalRectContext, O, I>>> drawTexturedModalRectPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntContext, O, I>>> drawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntContext, O, I>>> drawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawHorizontalLineContext, O, I>>> drawHorizontalLinePipeline,
      final List<Consumer<VoidPipelineElementContext<DrawStringContext, O, I>>> drawStringPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawVerticalLineContext, O, I>>> drawVerticalLinePipeline,
      final List<Consumer<VoidPipelineElementContext<DrawHoveringTextContext, O, I>>> drawHoveringTextPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawHoveringTextWithTextLinesAsStringListContext, O, I>>> drawHoveringTextWithTextLinesAsStringListPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawHoveringTextWithFontAsFontRendererContext, O, I>>> drawHoveringTextWithFontAsFontRendererPipeline,
      final List<Consumer<VoidPipelineElementContext<RenderToolTipContext, O, I>>> renderToolTipPipeline,
      final List<Consumer<VoidPipelineElementContext<ConfirmClickedContext, O, I>>> confirmClickedPipeline,
      final List<Consumer<VoidPipelineElementContext<HandleKeyboardInputContext, O, I>>> handleKeyboardInputPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawWorldBackgroundContext, O, I>>> drawWorldBackgroundPipeline,
      final List<Function<TypedPipelineElementContext<HandleComponentClickContext, Boolean, O, I>, Boolean>> handleComponentClickPipeline,
      final List<Consumer<VoidPipelineElementContext<HandleInputContext, O, I>>> handleInputPipeline,
      final List<Consumer<VoidPipelineElementContext<KeyTypedContext, O, I>>> keyTypedPipeline,
      final List<Consumer<VoidPipelineElementContext<MouseReleasedContext, O, I>>> mouseReleasedPipeline,
      final List<Consumer<VoidPipelineElementContext<UpdateScreenContext, O, I>>> updateScreenPipeline,
      final List<Consumer<VoidPipelineElementContext<ActionPerformedContext, O, I>>> actionPerformedPipeline,
      final List<Function<TypedPipelineElementContext<GetItemToolTipContext, List<String>, O, I>, List<String>>> getItemToolTipPipeline,
      final List<Consumer<VoidPipelineElementContext<HandleMouseInputContext, O, I>>> handleMouseInputPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawBackgroundContext, O, I>>> drawBackgroundPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawDefaultBackgroundContext, O, I>>> drawDefaultBackgroundPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawScreenContext, O, I>>> drawScreenPipeline,
      final List<Function<TypedPipelineElementContext<DoesGuiPauseGameContext, Boolean, O, I>, Boolean>> doesGuiPauseGamePipeline,
      final List<Consumer<VoidPipelineElementContext<HandleComponentHoverContext, O, I>>> handleComponentHoverPipeline,
      final List<Consumer<VoidPipelineElementContext<MouseClickMoveContext, O, I>>> mouseClickMovePipeline,
      final List<Consumer<VoidPipelineElementContext<SendChatMessageContext, O, I>>> sendChatMessagePipeline,
      final List<Consumer<VoidPipelineElementContext<SendChatMessageWithAddToChatAsbooleanContext, O, I>>> sendChatMessageWithAddToChatAsbooleanPipeline,
      final List<Consumer<VoidPipelineElementContext<InitGuiContext, O, I>>> initGuiPipeline,
      final List<Consumer<VoidPipelineElementContext<SetGuiSizeContext, O, I>>> setGuiSizePipeline,
      final List<Function<TypedPipelineElementContext<IsFocusedContext, Boolean, O, I>, Boolean>> isFocusedPipeline,
      final List<Consumer<VoidPipelineElementContext<OnGuiClosedContext, O, I>>> onGuiClosedPipeline,
      final List<Consumer<VoidPipelineElementContext<OnResizeContext, O, I>>> onResizePipeline,
      final List<Consumer<VoidPipelineElementContext<MouseClickedContext, O, I>>> mouseClickedPipeline,
      final List<Consumer<VoidPipelineElementContext<SetWorldAndResolutionContext, O, I>>> setWorldAndResolutionPipeline,
      final List<Consumer<VoidPipelineElementContext<SetFocusedContext, O, I>>> setFocusedPipeline,
      final List<Consumer<VoidPipelineElementContext<SetTextContext, O, I>>> setTextPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawGuiContainerForegroundLayerContext, O, I>>> drawGuiContainerForegroundLayerPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawGuiContainerBackgroundLayerContext, O, I>>> drawGuiContainerBackgroundLayerPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawSlotContext, O, I>>> drawSlotPipeline,
      final List<Consumer<VoidPipelineElementContext<HandleMouseClickContext, O, I>>> handleMouseClickPipeline,
      final List<Function<TypedPipelineElementContext<GetYSizeContext, Integer, O, I>, Integer>> getYSizePipeline,
      final List<Function<TypedPipelineElementContext<GetGuiTopContext, Integer, O, I>, Integer>> getGuiTopPipeline,
      final List<Function<TypedPipelineElementContext<GetGuiLeftContext, Integer, O, I>, Integer>> getGuiLeftPipeline,
      final List<Consumer<VoidPipelineElementContext<RenderHoveredToolTipContext, O, I>>> renderHoveredToolTipPipeline,
      final List<Function<TypedPipelineElementContext<HasClickedOutsideContext, Boolean, O, I>, Boolean>> hasClickedOutsidePipeline,
      final List<Function<TypedPipelineElementContext<GetSlotUnderMouseContext, ISlot, O, I>, ISlot>> getSlotUnderMousePipeline,
      final List<Function<TypedPipelineElementContext<IsPointInRegionContext, Boolean, O, I>, Boolean>> isPointInRegionPipeline,
      final List<Function<TypedPipelineElementContext<CheckHotbarKeysContext, Boolean, O, I>, Boolean>> checkHotbarKeysPipeline,
      final List<Function<TypedPipelineElementContext<GetXSizeContext, Integer, O, I>, Integer>> getXSizePipeline,
      final List<Function<TypedPipelineElementContext<IsMouseOverSlotContext, Boolean, O, I>, Boolean>> isMouseOverSlotPipeline)
    {
        super(drawCenteredStringPipeline,
          drawGradientRectPipeline,
          drawTexturedModalRectPipeline,
          drawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntPipeline,
          drawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntPipeline,
          drawHorizontalLinePipeline,
          drawStringPipeline,
          drawVerticalLinePipeline,
          drawHoveringTextPipeline,
          drawHoveringTextWithTextLinesAsStringListPipeline,
          drawHoveringTextWithFontAsFontRendererPipeline,
          renderToolTipPipeline,
          confirmClickedPipeline,
          handleKeyboardInputPipeline,
          drawWorldBackgroundPipeline,
          handleComponentClickPipeline,
          handleInputPipeline,
          keyTypedPipeline,
          mouseReleasedPipeline,
          updateScreenPipeline,
          actionPerformedPipeline,
          getItemToolTipPipeline,
          handleMouseInputPipeline,
          drawBackgroundPipeline,
          drawDefaultBackgroundPipeline,
          drawScreenPipeline,
          doesGuiPauseGamePipeline,
          handleComponentHoverPipeline,
          mouseClickMovePipeline,
          sendChatMessagePipeline,
          sendChatMessageWithAddToChatAsbooleanPipeline,
          initGuiPipeline,
          setGuiSizePipeline,
          isFocusedPipeline,
          onGuiClosedPipeline,
          onResizePipeline,
          mouseClickedPipeline,
          setWorldAndResolutionPipeline,
          setFocusedPipeline,
          setTextPipeline);
        DrawGuiContainerForegroundLayerPipeline = drawGuiContainerForegroundLayerPipeline;
        DrawGuiContainerBackgroundLayerPipeline = drawGuiContainerBackgroundLayerPipeline;
        DrawSlotPipeline = drawSlotPipeline;
        HandleMouseClickPipeline = handleMouseClickPipeline;
        GetYSizePipeline = getYSizePipeline;
        GetGuiTopPipeline = getGuiTopPipeline;
        GetGuiLeftPipeline = getGuiLeftPipeline;
        RenderHoveredToolTipPipeline = renderHoveredToolTipPipeline;
        HasClickedOutsidePipeline = hasClickedOutsidePipeline;
        GetSlotUnderMousePipeline = getSlotUnderMousePipeline;
        IsPointInRegionPipeline = isPointInRegionPipeline;
        CheckHotbarKeysPipeline = checkHotbarKeysPipeline;
        GetXSizePipeline = getXSizePipeline;
        IsMouseOverSlotPipeline = isMouseOverSlotPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<DrawGuiContainerForegroundLayerContext, O, I>>> getDrawGuiContainerForegroundLayerPipeline()
    {
        return DrawGuiContainerForegroundLayerPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<DrawGuiContainerBackgroundLayerContext, O, I>>> getDrawGuiContainerBackgroundLayerPipeline()
    {
        return DrawGuiContainerBackgroundLayerPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<DrawSlotContext, O, I>>> getDrawSlotPipeline()
    {
        return DrawSlotPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<HandleMouseClickContext, O, I>>> getHandleMouseClickPipeline()
    {
        return HandleMouseClickPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetYSizeContext, Integer, O, I>, Integer>> getGetYSizePipeline()
    {
        return GetYSizePipeline;
    }

    public List<Function<TypedPipelineElementContext<GetGuiTopContext, Integer, O, I>, Integer>> getGetGuiTopPipeline()
    {
        return GetGuiTopPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetGuiLeftContext, Integer, O, I>, Integer>> getGetGuiLeftPipeline()
    {
        return GetGuiLeftPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<RenderHoveredToolTipContext, O, I>>> getRenderHoveredToolTipPipeline()
    {
        return RenderHoveredToolTipPipeline;
    }

    public List<Function<TypedPipelineElementContext<HasClickedOutsideContext, Boolean, O, I>, Boolean>> getHasClickedOutsidePipeline()
    {
        return HasClickedOutsidePipeline;
    }

    public List<Function<TypedPipelineElementContext<GetSlotUnderMouseContext, ISlot, O, I>, ISlot>> getGetSlotUnderMousePipeline()
    {
        return GetSlotUnderMousePipeline;
    }

    public List<Function<TypedPipelineElementContext<IsPointInRegionContext, Boolean, O, I>, Boolean>> getIsPointInRegionPipeline()
    {
        return IsPointInRegionPipeline;
    }

    public List<Function<TypedPipelineElementContext<CheckHotbarKeysContext, Boolean, O, I>, Boolean>> getCheckHotbarKeysPipeline()
    {
        return CheckHotbarKeysPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetXSizeContext, Integer, O, I>, Integer>> getGetXSizePipeline()
    {
        return GetXSizePipeline;
    }

    public List<Function<TypedPipelineElementContext<IsMouseOverSlotContext, Boolean, O, I>, Boolean>> getIsMouseOverSlotPipeline()
    {
        return IsMouseOverSlotPipeline;
    }
}
