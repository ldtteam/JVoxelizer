package com.ldtteam.jvoxelizer.inventory.slot.logic.builder;

import com.ldtteam.jvoxelizer.core.logic.TypedPipelineElementContext;
import com.ldtteam.jvoxelizer.inventory.slot.ISlotItemHandler;
import com.ldtteam.jvoxelizer.inventory.slot.logic.builder.contexts.GetItemHandlerContext;
import com.ldtteam.jvoxelizer.item.handling.IItemHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public abstract class AbstractSlotItemHandlerBuilder<C extends AbstractSlotItemHandlerBuilder<C, I, O>, I, O extends ISlotItemHandler<I>> extends AbstractSlotBuilder<C, I, O> implements ISlotItemHandlerBuilder<C, I, O>
{

    @Override
    public C GetItemHandler(final Function<TypedPipelineElementContext<GetItemHandlerContext, IItemHandler, O, I>, IItemHandler>... components)
    {
        this.GetItemHandlerPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetItemHandlerContext, IItemHandler, O, I>, IItemHandler>> GetItemHandlerPipeline = new ArrayList<>();

}
