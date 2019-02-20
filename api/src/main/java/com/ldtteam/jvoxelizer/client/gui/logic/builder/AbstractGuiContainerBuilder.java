package com.ldtteam.jvoxelizer.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.*;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts.*;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.ldtteam.jvoxelizer.core.logic.*;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;

public abstract class AbstractGuiContainerBuilder<C extends AbstractGuiContainerBuilder<C, I>, I> extends AbstractGuiScreenBuilder<C, I> {

    public C DoesGuiPauseGame(Function<TypedPipelineElementContext<DoesGuiPauseGameContext, Boolean>, Boolean>... components) {
        this.DoesGuiPauseGamePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<DoesGuiPauseGameContext, Boolean>, Boolean>> DoesGuiPauseGamePipeline = new ArrayList<>();

    public C DrawGuiContainerForegroundLayer(Consumer<VoidPipelineElementContext<DrawGuiContainerForegroundLayerContext>>... components) {
        this.DrawGuiContainerForegroundLayerPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawGuiContainerForegroundLayerContext>>> DrawGuiContainerForegroundLayerPipeline = new ArrayList<>();

    public C MouseClickMove(Consumer<VoidPipelineElementContext<MouseClickMoveContext>>... components) {
        this.MouseClickMovePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<MouseClickMoveContext>>> MouseClickMovePipeline = new ArrayList<>();

    public C DrawGuiContainerBackgroundLayer(Consumer<VoidPipelineElementContext<DrawGuiContainerBackgroundLayerContext>>... components) {
        this.DrawGuiContainerBackgroundLayerPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawGuiContainerBackgroundLayerContext>>> DrawGuiContainerBackgroundLayerPipeline = new ArrayList<>();

    public C HandleMouseClick(Consumer<VoidPipelineElementContext<HandleMouseClickContext>>... components) {
        this.HandleMouseClickPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<HandleMouseClickContext>>> HandleMouseClickPipeline = new ArrayList<>();

    public C GetYSize(Function<TypedPipelineElementContext<GetYSizeContext, Integer>, Integer>... components) {
        this.GetYSizePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetYSizeContext, Integer>, Integer>> GetYSizePipeline = new ArrayList<>();

    public C InitGui(Consumer<VoidPipelineElementContext<InitGuiContext>>... components) {
        this.InitGuiPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<InitGuiContext>>> InitGuiPipeline = new ArrayList<>();

    public C GetGuiTop(Function<TypedPipelineElementContext<GetGuiTopContext, Integer>, Integer>... components) {
        this.GetGuiTopPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetGuiTopContext, Integer>, Integer>> GetGuiTopPipeline = new ArrayList<>();

    public C GetGuiLeft(Function<TypedPipelineElementContext<GetGuiLeftContext, Integer>, Integer>... components) {
        this.GetGuiLeftPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetGuiLeftContext, Integer>, Integer>> GetGuiLeftPipeline = new ArrayList<>();

    public C OnGuiClosed(Consumer<VoidPipelineElementContext<OnGuiClosedContext>>... components) {
        this.OnGuiClosedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<OnGuiClosedContext>>> OnGuiClosedPipeline = new ArrayList<>();

    public C KeyTyped(Consumer<VoidPipelineElementContext<KeyTypedContext>>... components) {
        this.KeyTypedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<KeyTypedContext>>> KeyTypedPipeline = new ArrayList<>();

    public C RenderHoveredToolTip(Consumer<VoidPipelineElementContext<RenderHoveredToolTipContext>>... components) {
        this.RenderHoveredToolTipPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<RenderHoveredToolTipContext>>> RenderHoveredToolTipPipeline = new ArrayList<>();

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

    public C HasClickedOutside(Function<TypedPipelineElementContext<HasClickedOutsideContext, Boolean>, Boolean>... components) {
        this.HasClickedOutsidePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<HasClickedOutsideContext, Boolean>, Boolean>> HasClickedOutsidePipeline = new ArrayList<>();

    public C GetSlotUnderMouse(Function<TypedPipelineElementContext<GetSlotUnderMouseContext, ISlot>, ISlot>... components) {
        this.GetSlotUnderMousePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetSlotUnderMouseContext, ISlot>, ISlot>> GetSlotUnderMousePipeline = new ArrayList<>();

    public C MouseClicked(Consumer<VoidPipelineElementContext<MouseClickedContext>>... components) {
        this.MouseClickedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<MouseClickedContext>>> MouseClickedPipeline = new ArrayList<>();

    public C IsPointInRegion(Function<TypedPipelineElementContext<IsPointInRegionContext, Boolean>, Boolean>... components) {
        this.IsPointInRegionPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<IsPointInRegionContext, Boolean>, Boolean>> IsPointInRegionPipeline = new ArrayList<>();

    public C DrawScreen(Consumer<VoidPipelineElementContext<DrawScreenContext>>... components) {
        this.DrawScreenPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawScreenContext>>> DrawScreenPipeline = new ArrayList<>();

    public C CheckHotbarKeys(Function<TypedPipelineElementContext<CheckHotbarKeysContext, Boolean>, Boolean>... components) {
        this.CheckHotbarKeysPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<CheckHotbarKeysContext, Boolean>, Boolean>> CheckHotbarKeysPipeline = new ArrayList<>();

    public C GetXSize(Function<TypedPipelineElementContext<GetXSizeContext, Integer>, Integer>... components) {
        this.GetXSizePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetXSizeContext, Integer>, Integer>> GetXSizePipeline = new ArrayList<>();
}
