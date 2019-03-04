package com.ldtteam.jvoxelizer.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.*;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts.*;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.ldtteam.jvoxelizer.core.logic.*;

public abstract class AbstractGuiButtonBuilder<C extends IGuiButtonBuilder<C, I, O>, I, O extends IGuiButton<I>> extends AbstractGuiBuilder<C, I, O> implements
  IGuiButtonBuilder<C, I, O>
{

    @Override
    public C MouseReleased(Consumer<VoidPipelineElementContext<MouseReleasedContext, O, I>>... components) {
        this.MouseReleasedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<MouseReleasedContext, O, I>>> MouseReleasedPipeline = new ArrayList<>();

    @Override
    public C IsMouseOver(Function<TypedPipelineElementContext<IsMouseOverContext, Boolean, O, I>, Boolean>... components) {
        this.IsMouseOverPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<IsMouseOverContext, Boolean, O, I>, Boolean>> IsMouseOverPipeline = new ArrayList<>();

    @Override
    public C MouseDragged(Consumer<VoidPipelineElementContext<MouseDraggedContext, O, I>>... components) {
        this.MouseDraggedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<MouseDraggedContext, O, I>>> MouseDraggedPipeline = new ArrayList<>();

    @Override
    public C GetHoverState(Function<TypedPipelineElementContext<GetHoverStateContext, Integer, O, I>, Integer>... components) {
        this.GetHoverStatePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetHoverStateContext, Integer, O, I>, Integer>> GetHoverStatePipeline = new ArrayList<>();

    @Override
    public C PlayPressSound(Consumer<VoidPipelineElementContext<PlayPressSoundContext, O, I>>... components) {
        this.PlayPressSoundPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<PlayPressSoundContext, O, I>>> PlayPressSoundPipeline = new ArrayList<>();

    @Override
    public C DrawButtonForegroundLayer(Consumer<VoidPipelineElementContext<DrawButtonForegroundLayerContext, O, I>>... components) {
        this.DrawButtonForegroundLayerPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<DrawButtonForegroundLayerContext, O, I>>> DrawButtonForegroundLayerPipeline = new ArrayList<>();

    @Override
    public C GetButtonWidth(Function<TypedPipelineElementContext<GetButtonWidthContext, Integer, O, I>, Integer>... components) {
        this.GetButtonWidthPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetButtonWidthContext, Integer, O, I>, Integer>> GetButtonWidthPipeline = new ArrayList<>();

    @Override
    public C SetWidth(Consumer<VoidPipelineElementContext<SetWidthContext, O, I>>... components) {
        this.SetWidthPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<SetWidthContext, O, I>>> SetWidthPipeline = new ArrayList<>();

    @Override
    public C DrawButton(Consumer<VoidPipelineElementContext<DrawButtonContext, O, I>>... components) {
        this.DrawButtonPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<DrawButtonContext, O, I>>> DrawButtonPipeline = new ArrayList<>();

    @Override
    public C MousePressed(Function<TypedPipelineElementContext<MousePressedContext, Boolean, O, I>, Boolean>... components) {
        this.MousePressedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<MousePressedContext, Boolean, O, I>, Boolean>> MousePressedPipeline = new ArrayList<>();
}
