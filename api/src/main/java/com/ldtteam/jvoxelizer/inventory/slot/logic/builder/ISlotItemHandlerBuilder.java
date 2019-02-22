package com.ldtteam.jvoxelizer.inventory.slot.logic.builder;

import com.ldtteam.jvoxelizer.core.logic.TypedPipelineElementContext;
import com.ldtteam.jvoxelizer.inventory.slot.ISlotItemHandler;
import com.ldtteam.jvoxelizer.inventory.slot.logic.builder.contexts.GetItemHandlerContext;
import com.ldtteam.jvoxelizer.item.handling.IItemHandler;

import java.util.function.Function;

public interface ISlotItemHandlerBuilder<C extends ISlotItemHandlerBuilder<C, I, O>, I, O extends ISlotItemHandler<I>> extends ISlotBuilder<C, I, O>
{
    C GetItemHandler(Function<TypedPipelineElementContext<GetItemHandlerContext, IItemHandler, O, I>, IItemHandler>... components);
}
