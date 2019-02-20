package com.ldtteam.jvoxelizer.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.*;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts.*;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.ldtteam.jvoxelizer.core.logic.*;

public abstract class AbstractGuiButtonBuilder<C extends AbstractGuiButtonBuilder<C, I>, I> extends AbstractGuiBuilder<C, I> {

    public C MouseReleased(Consumer<VoidPipelineElementContext<MouseReleasedContext>>... components) {
        this.MouseReleasedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<MouseReleasedContext>>> MouseReleasedPipeline = new ArrayList<>();

    public C IsMouseOver(Function<TypedPipelineElementContext<IsMouseOverContext, Boolean>, Boolean>... components) {
        this.IsMouseOverPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<IsMouseOverContext, Boolean>, Boolean>> IsMouseOverPipeline = new ArrayList<>();

    public C MouseDragged(Consumer<VoidPipelineElementContext<MouseDraggedContext>>... components) {
        this.MouseDraggedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<MouseDraggedContext>>> MouseDraggedPipeline = new ArrayList<>();

    public C GetHoverState(Function<TypedPipelineElementContext<GetHoverStateContext, Integer>, Integer>... components) {
        this.GetHoverStatePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetHoverStateContext, Integer>, Integer>> GetHoverStatePipeline = new ArrayList<>();

    public C PlayPressSound(Consumer<VoidPipelineElementContext<PlayPressSoundContext>>... components) {
        this.PlayPressSoundPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<PlayPressSoundContext>>> PlayPressSoundPipeline = new ArrayList<>();

    public C DrawButtonForegroundLayer(Consumer<VoidPipelineElementContext<DrawButtonForegroundLayerContext>>... components) {
        this.DrawButtonForegroundLayerPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawButtonForegroundLayerContext>>> DrawButtonForegroundLayerPipeline = new ArrayList<>();

    public C GetButtonWidth(Function<TypedPipelineElementContext<GetButtonWidthContext, Integer>, Integer>... components) {
        this.GetButtonWidthPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetButtonWidthContext, Integer>, Integer>> GetButtonWidthPipeline = new ArrayList<>();

    public C SetWidth(Consumer<VoidPipelineElementContext<SetWidthContext>>... components) {
        this.SetWidthPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<SetWidthContext>>> SetWidthPipeline = new ArrayList<>();

    public C DrawButton(Consumer<VoidPipelineElementContext<DrawButtonContext>>... components) {
        this.DrawButtonPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawButtonContext>>> DrawButtonPipeline = new ArrayList<>();

    public C MousePressed(Function<TypedPipelineElementContext<MousePressedContext, Boolean>, Boolean>... components) {
        this.MousePressedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<MousePressedContext, Boolean>, Boolean>> MousePressedPipeline = new ArrayList<>();
}
