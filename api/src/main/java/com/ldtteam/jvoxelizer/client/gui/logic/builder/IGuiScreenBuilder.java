package com.ldtteam.jvoxelizer.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.IGuiButton;
import com.ldtteam.jvoxelizer.client.gui.IGuiScreen;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.core.logic.TypedPipelineElementContext;
import com.ldtteam.jvoxelizer.core.logic.VoidPipelineElementContext;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public interface IGuiScreenBuilder<C extends IGuiScreenBuilder<C, I, O>, I, O extends IGuiScreen<I>> extends IGuiBuilder<C, I, O>
{
    static <I> IGuiScreenBuilder<?, I, IGuiScreen<I>> create(I instanceData)
    {
        return IGuiScreenBuilderProviderHolder.getInstance().provide(instanceData);
    }

    C DrawHoveringText(Consumer<VoidPipelineElementContext<DrawHoveringTextContext, O, I>>... components);

    C DrawHoveringTextWithTextLinesAsStringList(Consumer<VoidPipelineElementContext<DrawHoveringTextWithTextLinesAsStringListContext, O, I>>... components);

    C DrawHoveringTextWithFontAsFontRenderer(Consumer<VoidPipelineElementContext<DrawHoveringTextWithFontAsFontRendererContext, O, I>>... components);

    C RenderToolTip(Consumer<VoidPipelineElementContext<RenderToolTipContext, O, I>>... components);

    C ConfirmClicked(Consumer<VoidPipelineElementContext<ConfirmClickedContext, O, I>>... components);

    C HandleKeyboardInput(Consumer<VoidPipelineElementContext<HandleKeyboardInputContext, O, I>>... components);

    C DrawWorldBackground(Consumer<VoidPipelineElementContext<DrawWorldBackgroundContext, O, I>>... components);

    C HandleComponentClick(Function<TypedPipelineElementContext<HandleComponentClickContext, Boolean, O, I>, Boolean>... components);

    C HandleInput(Consumer<VoidPipelineElementContext<HandleInputContext, O, I>>... components);

    C KeyTyped(Consumer<VoidPipelineElementContext<KeyTypedContext, O, I>>... components);

    C MouseReleased(Consumer<VoidPipelineElementContext<MouseReleasedContext, O, I>>... components);

    C UpdateScreen(Consumer<VoidPipelineElementContext<UpdateScreenContext, O, I>>... components);

    C ActionPerformed(Consumer<VoidPipelineElementContext<ActionPerformedContext, O, I>>... components);

    C GetItemToolTip(Function<TypedPipelineElementContext<GetItemToolTipContext, List<String>, O, I>, List<String>>... components);

    C HandleMouseInput(Consumer<VoidPipelineElementContext<HandleMouseInputContext, O, I>>... components);

    C DrawBackground(Consumer<VoidPipelineElementContext<DrawBackgroundContext, O, I>>... components);

    C DrawDefaultBackground(Consumer<VoidPipelineElementContext<DrawDefaultBackgroundContext, O, I>>... components);

    C DrawScreen(Consumer<VoidPipelineElementContext<DrawScreenContext, O, I>>... components);

    C DoesGuiPauseGame(Function<TypedPipelineElementContext<DoesGuiPauseGameContext, Boolean, O, I>, Boolean>... components);

    C HandleComponentHover(Consumer<VoidPipelineElementContext<HandleComponentHoverContext, O, I>>... components);

    C MouseClickMove(Consumer<VoidPipelineElementContext<MouseClickMoveContext, O, I>>... components);

    <T extends IGuiButton> C AddButton(Function<TypedPipelineElementContext<AddButtonContext<? extends IGuiButton>, ? extends IGuiButton, O, I>, T>... components);

    C SendChatMessage(Consumer<VoidPipelineElementContext<SendChatMessageContext, O, I>>... components);

    C SendChatMessageWithAddToChatAsboolean(Consumer<VoidPipelineElementContext<SendChatMessageWithAddToChatAsbooleanContext, O, I>>... components);

    C InitGui(Consumer<VoidPipelineElementContext<InitGuiContext, O, I>>... components);

    C SetGuiSize(Consumer<VoidPipelineElementContext<SetGuiSizeContext, O, I>>... components);

    C IsFocused(Function<TypedPipelineElementContext<IsFocusedContext, Boolean, O, I>, Boolean>... components);

    C OnGuiClosed(Consumer<VoidPipelineElementContext<OnGuiClosedContext, O, I>>... components);

    C OnResize(Consumer<VoidPipelineElementContext<OnResizeContext, O, I>>... components);

    C MouseClicked(Consumer<VoidPipelineElementContext<MouseClickedContext, O, I>>... components);

    C SetWorldAndResolution(Consumer<VoidPipelineElementContext<SetWorldAndResolutionContext, O, I>>... components);

    C SetFocused(Consumer<VoidPipelineElementContext<SetFocusedContext, O, I>>... components);

    C SetText(Consumer<VoidPipelineElementContext<SetTextContext, O, I>>... components);
}
