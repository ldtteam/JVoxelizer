package com.ldtteam.jvoxelizer.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.IGuiContainer;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.core.logic.TypedPipelineElementContext;
import com.ldtteam.jvoxelizer.core.logic.VoidPipelineElementContext;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;

import java.util.function.Consumer;
import java.util.function.Function;

public interface IGuiContainerBuilder<C extends IGuiContainerBuilder<C, I, O>, I, O extends IGuiContainer<I>> extends IGuiScreenBuilder<C, I, O>
{
    static <T, S extends IGuiContainer<T>> IGuiContainerBuilder<?, T, S> create(T instanceData)
    {
        return IGuiContainerBuilderProviderHolder.getInstance().provide(instanceData);
    }

    C DrawGuiContainerForegroundLayer(Consumer<VoidPipelineElementContext<DrawGuiContainerForegroundLayerContext, O, I>>... components);

    C DrawGuiContainerBackgroundLayer(Consumer<VoidPipelineElementContext<DrawGuiContainerBackgroundLayerContext, O, I>>... components);

    C DrawSlot(Consumer<VoidPipelineElementContext<DrawSlotContext, O, I>>... components);

    C HandleMouseClick(Consumer<VoidPipelineElementContext<HandleMouseClickContext, O, I>>... components);

    C GetYSize(Function<TypedPipelineElementContext<GetYSizeContext, Integer, O, I>, Integer>... components);

    C GetGuiTop(Function<TypedPipelineElementContext<GetGuiTopContext, Integer, O, I>, Integer>... components);

    C GetGuiLeft(Function<TypedPipelineElementContext<GetGuiLeftContext, Integer, O, I>, Integer>... components);

    C RenderHoveredToolTip(Consumer<VoidPipelineElementContext<RenderHoveredToolTipContext, O, I>>... components);

    C HasClickedOutside(Function<TypedPipelineElementContext<HasClickedOutsideContext, Boolean, O, I>, Boolean>... components);

    C GetSlotUnderMouse(Function<TypedPipelineElementContext<GetSlotUnderMouseContext, ISlot, O, I>, ISlot>... components);

    C IsPointInRegion(Function<TypedPipelineElementContext<IsPointInRegionContext, Boolean, O, I>, Boolean>... components);

    C CheckHotbarKeys(Function<TypedPipelineElementContext<CheckHotbarKeysContext, Boolean, O, I>, Boolean>... components);

    C GetXSize(Function<TypedPipelineElementContext<GetXSizeContext, Integer, O, I>, Integer>... components);

    C IsMouseOverSlot(Function<TypedPipelineElementContext<IsMouseOverSlotContext, Boolean , O, I>, Boolean>... components);
}
