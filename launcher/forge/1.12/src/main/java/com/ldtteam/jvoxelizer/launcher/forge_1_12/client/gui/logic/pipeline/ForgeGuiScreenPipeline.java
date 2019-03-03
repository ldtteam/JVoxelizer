package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.pipeline;

import com.ldtteam.jvoxelizer.client.gui.IGui;
import com.ldtteam.jvoxelizer.client.gui.IGuiButton;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.core.logic.TypedPipelineElementContext;
import com.ldtteam.jvoxelizer.core.logic.VoidPipelineElementContext;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ForgeGuiScreenPipeline<O extends IGui<I>, I> extends ForgeGuiPipeline<O, I>
{
    private final List<Consumer<VoidPipelineElementContext<DrawHoveringTextContext, O, I>>> DrawHoveringTextPipeline;

    private final List<Consumer<VoidPipelineElementContext<DrawHoveringTextWithTextLinesAsStringListContext, O, I>>> DrawHoveringTextWithTextLinesAsStringListPipeline;

    private final List<Consumer<VoidPipelineElementContext<DrawHoveringTextWithFontAsFontRendererContext, O, I>>> DrawHoveringTextWithFontAsFontRendererPipeline;

    private final List<Consumer<VoidPipelineElementContext<RenderToolTipContext, O, I>>> RenderToolTipPipeline;

    private final List<Consumer<VoidPipelineElementContext<ConfirmClickedContext, O, I>>> ConfirmClickedPipeline;

    private final List<Consumer<VoidPipelineElementContext<HandleKeyboardInputContext, O, I>>> HandleKeyboardInputPipeline;

    private final List<Consumer<VoidPipelineElementContext<DrawWorldBackgroundContext, O, I>>> DrawWorldBackgroundPipeline;

    private final List<Function<TypedPipelineElementContext<HandleComponentClickContext, Boolean, O, I>, Boolean>> HandleComponentClickPipeline;

    private final List<Consumer<VoidPipelineElementContext<HandleInputContext, O, I>>> HandleInputPipeline;

    private final List<Consumer<VoidPipelineElementContext<KeyTypedContext, O, I>>> KeyTypedPipeline;

    private final List<Consumer<VoidPipelineElementContext<MouseReleasedContext, O, I>>> MouseReleasedPipeline;

    private final List<Consumer<VoidPipelineElementContext<UpdateScreenContext, O, I>>> UpdateScreenPipeline;

    private final List<Consumer<VoidPipelineElementContext<ActionPerformedContext, O, I>>> ActionPerformedPipeline;

    private final List<Function<TypedPipelineElementContext<GetItemToolTipContext, List<String>, O, I>, List<String>>> GetItemToolTipPipeline;

    private final List<Consumer<VoidPipelineElementContext<HandleMouseInputContext, O, I>>> HandleMouseInputPipeline;

    private final List<Consumer<VoidPipelineElementContext<DrawBackgroundContext, O, I>>> DrawBackgroundPipeline;

    private final List<Consumer<VoidPipelineElementContext<DrawDefaultBackgroundContext, O, I>>> DrawDefaultBackgroundPipeline;

    private final List<Consumer<VoidPipelineElementContext<DrawScreenContext, O, I>>> DrawScreenPipeline;

    private final List<Function<TypedPipelineElementContext<DoesGuiPauseGameContext, Boolean, O, I>, Boolean>> DoesGuiPauseGamePipeline;

    private final List<Consumer<VoidPipelineElementContext<HandleComponentHoverContext, O, I>>> HandleComponentHoverPipeline;

    private final List<Consumer<VoidPipelineElementContext<MouseClickMoveContext, O, I>>> MouseClickMovePipeline;

    private final List<Consumer<VoidPipelineElementContext<SendChatMessageContext, O, I>>> SendChatMessagePipeline;

    private final List<Consumer<VoidPipelineElementContext<SendChatMessageWithAddToChatAsbooleanContext, O, I>>> SendChatMessageWithAddToChatAsbooleanPipeline;

    private final List<Consumer<VoidPipelineElementContext<InitGuiContext, O, I>>> InitGuiPipeline;

    private final List<Consumer<VoidPipelineElementContext<SetGuiSizeContext, O, I>>> SetGuiSizePipeline;

    private final List<Function<TypedPipelineElementContext<IsFocusedContext, Boolean, O, I>, Boolean>> IsFocusedPipeline;

    private final List<Consumer<VoidPipelineElementContext<OnGuiClosedContext, O, I>>> OnGuiClosedPipeline;

    private final List<Consumer<VoidPipelineElementContext<OnResizeContext, O, I>>> OnResizePipeline;

    private final List<Consumer<VoidPipelineElementContext<MouseClickedContext, O, I>>> MouseClickedPipeline;

    private final List<Consumer<VoidPipelineElementContext<SetWorldAndResolutionContext, O, I>>> SetWorldAndResolutionPipeline;

    private final List<Consumer<VoidPipelineElementContext<SetFocusedContext, O, I>>> SetFocusedPipeline;

    private final List<Consumer<VoidPipelineElementContext<SetTextContext, O, I>>> SetTextPipeline;

    public ForgeGuiScreenPipeline(
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
      final List<Consumer<VoidPipelineElementContext<SetTextContext, O, I>>> setTextPipeline)
    {
        super(drawCenteredStringPipeline,
          drawGradientRectPipeline,
          drawTexturedModalRectPipeline,
          drawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntPipeline,
          drawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntPipeline,
          drawHorizontalLinePipeline,
          drawStringPipeline,
          drawVerticalLinePipeline);
        DrawHoveringTextPipeline = drawHoveringTextPipeline;
        DrawHoveringTextWithTextLinesAsStringListPipeline = drawHoveringTextWithTextLinesAsStringListPipeline;
        DrawHoveringTextWithFontAsFontRendererPipeline = drawHoveringTextWithFontAsFontRendererPipeline;
        RenderToolTipPipeline = renderToolTipPipeline;
        ConfirmClickedPipeline = confirmClickedPipeline;
        HandleKeyboardInputPipeline = handleKeyboardInputPipeline;
        DrawWorldBackgroundPipeline = drawWorldBackgroundPipeline;
        HandleComponentClickPipeline = handleComponentClickPipeline;
        HandleInputPipeline = handleInputPipeline;
        KeyTypedPipeline = keyTypedPipeline;
        MouseReleasedPipeline = mouseReleasedPipeline;
        UpdateScreenPipeline = updateScreenPipeline;
        ActionPerformedPipeline = actionPerformedPipeline;
        GetItemToolTipPipeline = getItemToolTipPipeline;
        HandleMouseInputPipeline = handleMouseInputPipeline;
        DrawBackgroundPipeline = drawBackgroundPipeline;
        DrawDefaultBackgroundPipeline = drawDefaultBackgroundPipeline;
        DrawScreenPipeline = drawScreenPipeline;
        DoesGuiPauseGamePipeline = doesGuiPauseGamePipeline;
        HandleComponentHoverPipeline = handleComponentHoverPipeline;
        MouseClickMovePipeline = mouseClickMovePipeline;
        SendChatMessagePipeline = sendChatMessagePipeline;
        SendChatMessageWithAddToChatAsbooleanPipeline = sendChatMessageWithAddToChatAsbooleanPipeline;
        InitGuiPipeline = initGuiPipeline;
        SetGuiSizePipeline = setGuiSizePipeline;
        IsFocusedPipeline = isFocusedPipeline;
        OnGuiClosedPipeline = onGuiClosedPipeline;
        OnResizePipeline = onResizePipeline;
        MouseClickedPipeline = mouseClickedPipeline;
        SetWorldAndResolutionPipeline = setWorldAndResolutionPipeline;
        SetFocusedPipeline = setFocusedPipeline;
        SetTextPipeline = setTextPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<DrawHoveringTextContext, O, I>>> getDrawHoveringTextPipeline()
    {
        return DrawHoveringTextPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<DrawHoveringTextWithTextLinesAsStringListContext, O, I>>> getDrawHoveringTextWithTextLinesAsStringListPipeline()
    {
        return DrawHoveringTextWithTextLinesAsStringListPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<DrawHoveringTextWithFontAsFontRendererContext, O, I>>> getDrawHoveringTextWithFontAsFontRendererPipeline()
    {
        return DrawHoveringTextWithFontAsFontRendererPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<RenderToolTipContext, O, I>>> getRenderToolTipPipeline()
    {
        return RenderToolTipPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<ConfirmClickedContext, O, I>>> getConfirmClickedPipeline()
    {
        return ConfirmClickedPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<HandleKeyboardInputContext, O, I>>> getHandleKeyboardInputPipeline()
    {
        return HandleKeyboardInputPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<DrawWorldBackgroundContext, O, I>>> getDrawWorldBackgroundPipeline()
    {
        return DrawWorldBackgroundPipeline;
    }

    public List<Function<TypedPipelineElementContext<HandleComponentClickContext, Boolean, O, I>, Boolean>> getHandleComponentClickPipeline()
    {
        return HandleComponentClickPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<HandleInputContext, O, I>>> getHandleInputPipeline()
    {
        return HandleInputPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<KeyTypedContext, O, I>>> getKeyTypedPipeline()
    {
        return KeyTypedPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<MouseReleasedContext, O, I>>> getMouseReleasedPipeline()
    {
        return MouseReleasedPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<UpdateScreenContext, O, I>>> getUpdateScreenPipeline()
    {
        return UpdateScreenPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<ActionPerformedContext, O, I>>> getActionPerformedPipeline()
    {
        return ActionPerformedPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetItemToolTipContext, List<String>, O, I>, List<String>>> getGetItemToolTipPipeline()
    {
        return GetItemToolTipPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<HandleMouseInputContext, O, I>>> getHandleMouseInputPipeline()
    {
        return HandleMouseInputPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<DrawBackgroundContext, O, I>>> getDrawBackgroundPipeline()
    {
        return DrawBackgroundPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<DrawDefaultBackgroundContext, O, I>>> getDrawDefaultBackgroundPipeline()
    {
        return DrawDefaultBackgroundPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<DrawScreenContext, O, I>>> getDrawScreenPipeline()
    {
        return DrawScreenPipeline;
    }

    public List<Function<TypedPipelineElementContext<DoesGuiPauseGameContext, Boolean, O, I>, Boolean>> getDoesGuiPauseGamePipeline()
    {
        return DoesGuiPauseGamePipeline;
    }

    public List<Consumer<VoidPipelineElementContext<HandleComponentHoverContext, O, I>>> getHandleComponentHoverPipeline()
    {
        return HandleComponentHoverPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<MouseClickMoveContext, O, I>>> getMouseClickMovePipeline()
    {
        return MouseClickMovePipeline;
    }

    public List<Consumer<VoidPipelineElementContext<SendChatMessageContext, O, I>>> getSendChatMessagePipeline()
    {
        return SendChatMessagePipeline;
    }

    public List<Consumer<VoidPipelineElementContext<SendChatMessageWithAddToChatAsbooleanContext, O, I>>> getSendChatMessageWithAddToChatAsbooleanPipeline()
    {
        return SendChatMessageWithAddToChatAsbooleanPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<InitGuiContext, O, I>>> getInitGuiPipeline()
    {
        return InitGuiPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<SetGuiSizeContext, O, I>>> getSetGuiSizePipeline()
    {
        return SetGuiSizePipeline;
    }

    public List<Function<TypedPipelineElementContext<IsFocusedContext, Boolean, O, I>, Boolean>> getIsFocusedPipeline()
    {
        return IsFocusedPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<OnGuiClosedContext, O, I>>> getOnGuiClosedPipeline()
    {
        return OnGuiClosedPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<OnResizeContext, O, I>>> getOnResizePipeline()
    {
        return OnResizePipeline;
    }

    public List<Consumer<VoidPipelineElementContext<MouseClickedContext, O, I>>> getMouseClickedPipeline()
    {
        return MouseClickedPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<SetWorldAndResolutionContext, O, I>>> getSetWorldAndResolutionPipeline()
    {
        return SetWorldAndResolutionPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<SetFocusedContext, O, I>>> getSetFocusedPipeline()
    {
        return SetFocusedPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<SetTextContext, O, I>>> getSetTextPipeline()
    {
        return SetTextPipeline;
    }
}
