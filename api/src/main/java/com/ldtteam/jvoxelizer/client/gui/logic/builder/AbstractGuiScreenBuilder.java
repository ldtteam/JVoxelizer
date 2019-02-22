package com.ldtteam.jvoxelizer.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.*;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts.*;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.ldtteam.jvoxelizer.core.logic.*;

public abstract class AbstractGuiScreenBuilder<C extends AbstractGuiScreenBuilder<C, I, O>, I, O extends IGuiScreen<I>> extends AbstractGuiBuilder<C, I, O> implements IGuiScreenBuilder<C, I, O>
{

    @Override
    public C DrawHoveringText(Consumer<VoidPipelineElementContext<DrawHoveringTextContext, O, I>>... components) {
        this.DrawHoveringTextPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawHoveringTextContext, O, I>>> DrawHoveringTextPipeline = new ArrayList<>();

    @Override
    public C DrawHoveringTextWithTextLinesAsStringList(Consumer<VoidPipelineElementContext<DrawHoveringTextWithTextLinesAsStringListContext, O, I>>... components) {
        this.DrawHoveringTextWithTextLinesAsStringListPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawHoveringTextWithTextLinesAsStringListContext, O, I>>> DrawHoveringTextWithTextLinesAsStringListPipeline = new ArrayList<>();

    @Override
    public C DrawHoveringTextWithFontAsFontRenderer(Consumer<VoidPipelineElementContext<DrawHoveringTextWithFontAsFontRendererContext, O, I>>... components) {
        this.DrawHoveringTextWithFontAsFontRendererPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawHoveringTextWithFontAsFontRendererContext, O, I>>> DrawHoveringTextWithFontAsFontRendererPipeline = new ArrayList<>();

    @Override
    public C RenderToolTip(Consumer<VoidPipelineElementContext<RenderToolTipContext, O, I>>... components) {
        this.RenderToolTipPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<RenderToolTipContext, O, I>>> RenderToolTipPipeline = new ArrayList<>();

    @Override
    public C ConfirmClicked(Consumer<VoidPipelineElementContext<ConfirmClickedContext, O, I>>... components) {
        this.ConfirmClickedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<ConfirmClickedContext, O, I>>> ConfirmClickedPipeline = new ArrayList<>();

    @Override
    public C HandleKeyboardInput(Consumer<VoidPipelineElementContext<HandleKeyboardInputContext, O, I>>... components) {
        this.HandleKeyboardInputPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<HandleKeyboardInputContext, O, I>>> HandleKeyboardInputPipeline = new ArrayList<>();

    @Override
    public C DrawWorldBackground(Consumer<VoidPipelineElementContext<DrawWorldBackgroundContext, O, I>>... components) {
        this.DrawWorldBackgroundPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawWorldBackgroundContext, O, I>>> DrawWorldBackgroundPipeline = new ArrayList<>();

    @Override
    public C HandleComponentClick(Function<TypedPipelineElementContext<HandleComponentClickContext, Boolean, O, I>, Boolean>... components) {
        this.HandleComponentClickPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<HandleComponentClickContext, Boolean, O, I>, Boolean>> HandleComponentClickPipeline = new ArrayList<>();

    @Override
    public C HandleInput(Consumer<VoidPipelineElementContext<HandleInputContext, O, I>>... components) {
        this.HandleInputPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<HandleInputContext, O, I>>> HandleInputPipeline = new ArrayList<>();

    @Override
    public C KeyTyped(Consumer<VoidPipelineElementContext<KeyTypedContext, O, I>>... components) {
        this.KeyTypedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<KeyTypedContext, O, I>>> KeyTypedPipeline = new ArrayList<>();

    @Override
    public C MouseReleased(Consumer<VoidPipelineElementContext<MouseReleasedContext, O, I>>... components) {
        this.MouseReleasedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<MouseReleasedContext, O, I>>> MouseReleasedPipeline = new ArrayList<>();

    @Override
    public C UpdateScreen(Consumer<VoidPipelineElementContext<UpdateScreenContext, O, I>>... components) {
        this.UpdateScreenPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<UpdateScreenContext, O, I>>> UpdateScreenPipeline = new ArrayList<>();

    public C ActionPerformed(Consumer<VoidPipelineElementContext<ActionPerformedContext, O, I>>... components) {
        this.ActionPerformedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<ActionPerformedContext, O, I>>> ActionPerformedPipeline = new ArrayList<>();

    @Override
    public C GetItemToolTip(Function<TypedPipelineElementContext<GetItemToolTipContext, List<String>, O, I>, List<String>>... components) {
        this.GetItemToolTipPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetItemToolTipContext, List<String>, O, I>, List<String>>> GetItemToolTipPipeline = new ArrayList<>();

    @Override
    public C HandleMouseInput(Consumer<VoidPipelineElementContext<HandleMouseInputContext, O, I>>... components) {
        this.HandleMouseInputPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<HandleMouseInputContext, O, I>>> HandleMouseInputPipeline = new ArrayList<>();

    @Override
    public C DrawBackground(Consumer<VoidPipelineElementContext<DrawBackgroundContext, O, I>>... components) {
        this.DrawBackgroundPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawBackgroundContext, O, I>>> DrawBackgroundPipeline = new ArrayList<>();

    @Override
    public C DrawDefaultBackground(Consumer<VoidPipelineElementContext<DrawDefaultBackgroundContext, O, I>>... components) {
        this.DrawDefaultBackgroundPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawDefaultBackgroundContext, O, I>>> DrawDefaultBackgroundPipeline = new ArrayList<>();

    @Override
    public C DrawScreen(Consumer<VoidPipelineElementContext<DrawScreenContext, O, I>>... components) {
        this.DrawScreenPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawScreenContext, O, I>>> DrawScreenPipeline = new ArrayList<>();

    @Override
    public C DoesGuiPauseGame(Function<TypedPipelineElementContext<DoesGuiPauseGameContext, Boolean, O, I>, Boolean>... components) {
        this.DoesGuiPauseGamePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<DoesGuiPauseGameContext, Boolean, O, I>, Boolean>> DoesGuiPauseGamePipeline = new ArrayList<>();

    @Override
    public C HandleComponentHover(Consumer<VoidPipelineElementContext<HandleComponentHoverContext, O, I>>... components) {
        this.HandleComponentHoverPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<HandleComponentHoverContext, O, I>>> HandleComponentHoverPipeline = new ArrayList<>();

    @Override
    public C MouseClickMove(Consumer<VoidPipelineElementContext<MouseClickMoveContext, O, I>>... components) {
        this.MouseClickMovePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<MouseClickMoveContext, O, I>>> MouseClickMovePipeline = new ArrayList<>();

    @Override
    public <T extends IGuiButton> C AddButton(Function<TypedPipelineElementContext<AddButtonContext<? extends IGuiButton>, ? extends IGuiButton, O, I>, T>... components) {
        this.AddButtonPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<AddButtonContext<? extends IGuiButton>, ? extends IGuiButton, O, I>, ? extends IGuiButton>> AddButtonPipeline = new ArrayList<>();

    @Override
    public C SendChatMessage(Consumer<VoidPipelineElementContext<SendChatMessageContext, O, I>>... components) {
        this.SendChatMessagePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<SendChatMessageContext, O, I>>> SendChatMessagePipeline = new ArrayList<>();

    @Override
    public C SendChatMessageWithAddToChatAsboolean(Consumer<VoidPipelineElementContext<SendChatMessageWithAddToChatAsbooleanContext, O, I>>... components) {
        this.SendChatMessageWithAddToChatAsbooleanPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<SendChatMessageWithAddToChatAsbooleanContext, O, I>>> SendChatMessageWithAddToChatAsbooleanPipeline = new ArrayList<>();

    @Override
    public C InitGui(Consumer<VoidPipelineElementContext<InitGuiContext, O, I>>... components) {
        this.InitGuiPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<InitGuiContext, O, I>>> InitGuiPipeline = new ArrayList<>();

    @Override
    public C SetGuiSize(Consumer<VoidPipelineElementContext<SetGuiSizeContext, O, I>>... components) {
        this.SetGuiSizePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<SetGuiSizeContext, O, I>>> SetGuiSizePipeline = new ArrayList<>();

    @Override
    public C IsFocused(Function<TypedPipelineElementContext<IsFocusedContext, Boolean, O, I>, Boolean>... components) {
        this.IsFocusedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<IsFocusedContext, Boolean, O, I>, Boolean>> IsFocusedPipeline = new ArrayList<>();

    @Override
    public C OnGuiClosed(Consumer<VoidPipelineElementContext<OnGuiClosedContext, O, I>>... components) {
        this.OnGuiClosedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<OnGuiClosedContext, O, I>>> OnGuiClosedPipeline = new ArrayList<>();

    @Override
    public C OnResize(Consumer<VoidPipelineElementContext<OnResizeContext, O, I>>... components) {
        this.OnResizePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<OnResizeContext, O, I>>> OnResizePipeline = new ArrayList<>();

    @Override
    public C MouseClicked(Consumer<VoidPipelineElementContext<MouseClickedContext, O, I>>... components) {
        this.MouseClickedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<MouseClickedContext, O, I>>> MouseClickedPipeline = new ArrayList<>();

    @Override
    public C SetWorldAndResolution(Consumer<VoidPipelineElementContext<SetWorldAndResolutionContext, O, I>>... components) {
        this.SetWorldAndResolutionPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<SetWorldAndResolutionContext, O, I>>> SetWorldAndResolutionPipeline = new ArrayList<>();

    @Override
    public C SetFocused(Consumer<VoidPipelineElementContext<SetFocusedContext, O, I>>... components) {
        this.SetFocusedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<SetFocusedContext, O, I>>> SetFocusedPipeline = new ArrayList<>();

    @Override
    public C SetText(Consumer<VoidPipelineElementContext<SetTextContext, O, I>>... components) {
        this.SetTextPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<SetTextContext, O, I>>> SetTextPipeline = new ArrayList<>();
}
