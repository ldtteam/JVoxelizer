package com.ldtteam.jvoxelizer.inventory.slot.logic.builder;

import com.ldtteam.jvoxelizer.core.logic.TypedPipelineElementContext;
import com.ldtteam.jvoxelizer.inventory.slot.ISlotItemHandler;
import com.ldtteam.jvoxelizer.inventory.slot.logic.builder.contexts.GetItemHandlerContext;
import com.ldtteam.jvoxelizer.item.handling.IItemHandler;

import java.util.function.Function;

public interface ISlotItemHandlerBuilder<C extends ISlotItemHandlerBuilder<C, I, O>, I, O extends ISlotItemHandler<I>> extends ISlotBuilder<C, I, O>
{
    static <I> ISlotItemHandlerBuilder<?, I, ISlotItemHandler<I>> create(final IItemHandler inventory, final int index, final int x, final int y, final I instanceData)
    {
        return ISlotItemHandlerBuilderProviderHolder.getInstance().provide(inventory, index, x, y, instanceData);
    }

    C GetItemHandler(Function<TypedPipelineElementContext<GetItemHandlerContext, IItemHandler, O, I>, IItemHandler>... components);
}
