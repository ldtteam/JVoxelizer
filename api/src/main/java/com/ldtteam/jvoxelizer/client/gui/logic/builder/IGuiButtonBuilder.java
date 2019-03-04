package com.ldtteam.jvoxelizer.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.IGuiButton;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.core.logic.TypedPipelineElementContext;
import com.ldtteam.jvoxelizer.core.logic.VoidPipelineElementContext;

import java.util.function.Consumer;
import java.util.function.Function;

public interface IGuiButtonBuilder<C extends IGuiButtonBuilder<C, I, O>, I, O extends IGuiButton<I>> extends IGuiBuilder<C, I, O>
{
    C MouseReleased(Consumer<VoidPipelineElementContext<MouseReleasedContext, O, I>>... components);

    C IsMouseOver(Function<TypedPipelineElementContext<IsMouseOverContext, Boolean, O, I>, Boolean>... components);

    C MouseDragged(Consumer<VoidPipelineElementContext<MouseDraggedContext, O, I>>... components);

    C GetHoverState(Function<TypedPipelineElementContext<GetHoverStateContext, Integer, O, I>, Integer>... components);

    C PlayPressSound(Consumer<VoidPipelineElementContext<PlayPressSoundContext, O, I>>... components);

    C DrawButtonForegroundLayer(Consumer<VoidPipelineElementContext<DrawButtonForegroundLayerContext, O, I>>... components);

    C GetButtonWidth(Function<TypedPipelineElementContext<GetButtonWidthContext, Integer, O, I>, Integer>... components);

    C SetWidth(Consumer<VoidPipelineElementContext<SetWidthContext, O, I>>... components);

    C DrawButton(Consumer<VoidPipelineElementContext<DrawButtonContext, O, I>>... components);

    C MousePressed(Function<TypedPipelineElementContext<MousePressedContext, Boolean, O, I>, Boolean>... components);
}
