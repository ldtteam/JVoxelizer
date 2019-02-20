package com.ldtteam.jvoxelizer.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.IGuiContainer;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.core.logic.TypedPipelineElementContext;
import com.ldtteam.jvoxelizer.core.logic.VoidPipelineElementContext;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class AbstractGuiContainerBuilder<C extends AbstractGuiContainerBuilder<C, I, O>, I, O extends IGuiContainer<I>> extends AbstractGuiScreenBuilder<C, I, O> implements IGuiContainerBuilder<C, I, O>
{

    @Override
    public C DrawGuiContainerForegroundLayer(Consumer<VoidPipelineElementContext<DrawGuiContainerForegroundLayerContext, O, I>>... components) {
        this.DrawGuiContainerForegroundLayerPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawGuiContainerForegroundLayerContext, O, I>>> DrawGuiContainerForegroundLayerPipeline = new ArrayList<>();

    @Override
    public C DrawGuiContainerBackgroundLayer(Consumer<VoidPipelineElementContext<DrawGuiContainerBackgroundLayerContext, O, I>>... components) {
        this.DrawGuiContainerBackgroundLayerPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawGuiContainerBackgroundLayerContext, O, I>>> DrawGuiContainerBackgroundLayerPipeline = new ArrayList<>();

    @Override
    public C DrawSlot(final Consumer<VoidPipelineElementContext<DrawSlotContext, O, I>>... components)
    {
        this.DrawSlotPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawSlotContext, O, I>>> DrawSlotPipeline = new ArrayList<>();

    @Override
    public C HandleMouseClick(Consumer<VoidPipelineElementContext<HandleMouseClickContext, O, I>>... components) {
        this.HandleMouseClickPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<HandleMouseClickContext, O, I>>> HandleMouseClickPipeline = new ArrayList<>();

    @Override
    public C GetYSize(Function<TypedPipelineElementContext<GetYSizeContext, Integer>, Integer>... components) {
        this.GetYSizePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetYSizeContext, Integer>, Integer>> GetYSizePipeline = new ArrayList<>();

    @Override
    public C GetGuiTop(Function<TypedPipelineElementContext<GetGuiTopContext, Integer>, Integer>... components) {
        this.GetGuiTopPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetGuiTopContext, Integer>, Integer>> GetGuiTopPipeline = new ArrayList<>();

    @Override
    public C GetGuiLeft(Function<TypedPipelineElementContext<GetGuiLeftContext, Integer>, Integer>... components) {
        this.GetGuiLeftPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetGuiLeftContext, Integer>, Integer>> GetGuiLeftPipeline = new ArrayList<>();

    @Override
    public C RenderHoveredToolTip(Consumer<VoidPipelineElementContext<RenderHoveredToolTipContext, O, I>>... components) {
        this.RenderHoveredToolTipPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<RenderHoveredToolTipContext, O, I>>> RenderHoveredToolTipPipeline = new ArrayList<>();

    @Override
    public C HasClickedOutside(Function<TypedPipelineElementContext<HasClickedOutsideContext, Boolean>, Boolean>... components) {
        this.HasClickedOutsidePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<HasClickedOutsideContext, Boolean>, Boolean>> HasClickedOutsidePipeline = new ArrayList<>();

    @Override
    public C GetSlotUnderMouse(Function<TypedPipelineElementContext<GetSlotUnderMouseContext, ISlot>, ISlot>... components) {
        this.GetSlotUnderMousePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetSlotUnderMouseContext, ISlot>, ISlot>> GetSlotUnderMousePipeline = new ArrayList<>();

    @Override
    public C IsPointInRegion(Function<TypedPipelineElementContext<IsPointInRegionContext, Boolean>, Boolean>... components) {
        this.IsPointInRegionPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<IsPointInRegionContext, Boolean>, Boolean>> IsPointInRegionPipeline = new ArrayList<>();

    @Override
    public C CheckHotbarKeys(Function<TypedPipelineElementContext<CheckHotbarKeysContext, Boolean>, Boolean>... components) {
        this.CheckHotbarKeysPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<CheckHotbarKeysContext, Boolean>, Boolean>> CheckHotbarKeysPipeline = new ArrayList<>();

    @Override
    public C GetXSize(Function<TypedPipelineElementContext<GetXSizeContext, Integer>, Integer>... components) {
        this.GetXSizePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetXSizeContext, Integer>, Integer>> GetXSizePipeline = new ArrayList<>();
}
