package com.ldtteam.jvoxelizer.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.*;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts.*;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.ldtteam.jvoxelizer.core.logic.*;

public abstract class AbstractGuiScreenBuilder<C extends AbstractGuiScreenBuilder<C, I>, I> extends AbstractGuiBuilder<C, I> {

    public C DrawHoveringText(Consumer<VoidPipelineElementContext<DrawHoveringTextContext>>... components) {
        this.DrawHoveringTextPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawHoveringTextContext>>> DrawHoveringTextPipeline = new ArrayList<>();

    public C DrawHoveringTextWithTextLinesAsStringList(Consumer<VoidPipelineElementContext<DrawHoveringTextWithTextLinesAsStringListContext>>... components) {
        this.DrawHoveringTextWithTextLinesAsStringListPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawHoveringTextWithTextLinesAsStringListContext>>> DrawHoveringTextWithTextLinesAsStringListPipeline = new ArrayList<>();

    public C DrawHoveringTextWithFontAsFontRenderer(Consumer<VoidPipelineElementContext<DrawHoveringTextWithFontAsFontRendererContext>>... components) {
        this.DrawHoveringTextWithFontAsFontRendererPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawHoveringTextWithFontAsFontRendererContext>>> DrawHoveringTextWithFontAsFontRendererPipeline = new ArrayList<>();

    public C RenderToolTip(Consumer<VoidPipelineElementContext<RenderToolTipContext>>... components) {
        this.RenderToolTipPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<RenderToolTipContext>>> RenderToolTipPipeline = new ArrayList<>();

    public C ConfirmClicked(Consumer<VoidPipelineElementContext<ConfirmClickedContext>>... components) {
        this.ConfirmClickedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<ConfirmClickedContext>>> ConfirmClickedPipeline = new ArrayList<>();

    public C HandleKeyboardInput(Consumer<VoidPipelineElementContext<HandleKeyboardInputContext>>... components) {
        this.HandleKeyboardInputPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<HandleKeyboardInputContext>>> HandleKeyboardInputPipeline = new ArrayList<>();

    public C DrawWorldBackground(Consumer<VoidPipelineElementContext<DrawWorldBackgroundContext>>... components) {
        this.DrawWorldBackgroundPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawWorldBackgroundContext>>> DrawWorldBackgroundPipeline = new ArrayList<>();

    public C HandleComponentClick(Function<TypedPipelineElementContext<HandleComponentClickContext, Boolean>, Boolean>... components) {
        this.HandleComponentClickPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<HandleComponentClickContext, Boolean>, Boolean>> HandleComponentClickPipeline = new ArrayList<>();

    public C HandleInput(Consumer<VoidPipelineElementContext<HandleInputContext>>... components) {
        this.HandleInputPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<HandleInputContext>>> HandleInputPipeline = new ArrayList<>();

    public C KeyTyped(Consumer<VoidPipelineElementContext<KeyTypedContext>>... components) {
        this.KeyTypedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<KeyTypedContext>>> KeyTypedPipeline = new ArrayList<>();

    public C MouseReleased(Consumer<VoidPipelineElementContext<MouseReleasedContext>>... components) {
        this.MouseReleasedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<MouseReleasedContext>>> MouseReleasedPipeline = new ArrayList<>();

    public C UpdateScreen(Consumer<VoidPipelineElementContext<UpdateScreenContext>>... components) {
        this.UpdateScreenPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<UpdateScreenContext>>> UpdateScreenPipeline = new ArrayList<>();

    public C ActionPerformed(Consumer<VoidPipelineElementContext<ActionPerformedContext>>... components) {
        this.ActionPerformedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<ActionPerformedContext>>> ActionPerformedPipeline = new ArrayList<>();

    public C GetItemToolTip(Function<TypedPipelineElementContext<GetItemToolTipContext, List<String>>, List<String>>... components) {
        this.GetItemToolTipPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetItemToolTipContext, List<String>>, List<String>>> GetItemToolTipPipeline = new ArrayList<>();

    public C HandleMouseInput(Consumer<VoidPipelineElementContext<HandleMouseInputContext>>... components) {
        this.HandleMouseInputPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<HandleMouseInputContext>>> HandleMouseInputPipeline = new ArrayList<>();

    public C DrawBackground(Consumer<VoidPipelineElementContext<DrawBackgroundContext>>... components) {
        this.DrawBackgroundPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawBackgroundContext>>> DrawBackgroundPipeline = new ArrayList<>();

    public C DrawDefaultBackground(Consumer<VoidPipelineElementContext<DrawDefaultBackgroundContext>>... components) {
        this.DrawDefaultBackgroundPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawDefaultBackgroundContext>>> DrawDefaultBackgroundPipeline = new ArrayList<>();

    public C DrawScreen(Consumer<VoidPipelineElementContext<DrawScreenContext>>... components) {
        this.DrawScreenPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawScreenContext>>> DrawScreenPipeline = new ArrayList<>();

    public C DoesGuiPauseGame(Function<TypedPipelineElementContext<DoesGuiPauseGameContext, Boolean>, Boolean>... components) {
        this.DoesGuiPauseGamePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<DoesGuiPauseGameContext, Boolean>, Boolean>> DoesGuiPauseGamePipeline = new ArrayList<>();

    public C HandleComponentHover(Consumer<VoidPipelineElementContext<HandleComponentHoverContext>>... components) {
        this.HandleComponentHoverPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<HandleComponentHoverContext>>> HandleComponentHoverPipeline = new ArrayList<>();

    public C MouseClickMove(Consumer<VoidPipelineElementContext<MouseClickMoveContext>>... components) {
        this.MouseClickMovePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<MouseClickMoveContext>>> MouseClickMovePipeline = new ArrayList<>();

    public <T extends IGuiButton> C AddButton(Function<TypedPipelineElementContext<AddButtonContext<? extends IGuiButton>, ? extends IGuiButton>, T>... components) {
        this.AddButtonPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<AddButtonContext<? extends IGuiButton>, ? extends IGuiButton>, ? extends IGuiButton>> AddButtonPipeline = new ArrayList<>();

    public C SendChatMessage(Consumer<VoidPipelineElementContext<SendChatMessageContext>>... components) {
        this.SendChatMessagePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<SendChatMessageContext>>> SendChatMessagePipeline = new ArrayList<>();

    public C SendChatMessageWithAddToChatAsboolean(Consumer<VoidPipelineElementContext<SendChatMessageWithAddToChatAsbooleanContext>>... components) {
        this.SendChatMessageWithAddToChatAsbooleanPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<SendChatMessageWithAddToChatAsbooleanContext>>> SendChatMessageWithAddToChatAsbooleanPipeline = new ArrayList<>();

    public C InitGui(Consumer<VoidPipelineElementContext<InitGuiContext>>... components) {
        this.InitGuiPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<InitGuiContext>>> InitGuiPipeline = new ArrayList<>();

    public C SetGuiSize(Consumer<VoidPipelineElementContext<SetGuiSizeContext>>... components) {
        this.SetGuiSizePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<SetGuiSizeContext>>> SetGuiSizePipeline = new ArrayList<>();

    public C IsFocused(Function<TypedPipelineElementContext<IsFocusedContext, Boolean>, Boolean>... components) {
        this.IsFocusedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<IsFocusedContext, Boolean>, Boolean>> IsFocusedPipeline = new ArrayList<>();

    public C OnGuiClosed(Consumer<VoidPipelineElementContext<OnGuiClosedContext>>... components) {
        this.OnGuiClosedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<OnGuiClosedContext>>> OnGuiClosedPipeline = new ArrayList<>();

    public C OnResize(Consumer<VoidPipelineElementContext<OnResizeContext>>... components) {
        this.OnResizePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<OnResizeContext>>> OnResizePipeline = new ArrayList<>();

    public C MouseClicked(Consumer<VoidPipelineElementContext<MouseClickedContext>>... components) {
        this.MouseClickedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<MouseClickedContext>>> MouseClickedPipeline = new ArrayList<>();

    public C SetWorldAndResolution(Consumer<VoidPipelineElementContext<SetWorldAndResolutionContext>>... components) {
        this.SetWorldAndResolutionPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<SetWorldAndResolutionContext>>> SetWorldAndResolutionPipeline = new ArrayList<>();

    public C SetFocused(Consumer<VoidPipelineElementContext<SetFocusedContext>>... components) {
        this.SetFocusedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<SetFocusedContext>>> SetFocusedPipeline = new ArrayList<>();

    public C SetText(Consumer<VoidPipelineElementContext<SetTextContext>>... components) {
        this.SetTextPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<SetTextContext>>> SetTextPipeline = new ArrayList<>();
}
