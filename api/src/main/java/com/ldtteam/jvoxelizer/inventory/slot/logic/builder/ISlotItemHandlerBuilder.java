package com.ldtteam.jvoxelizer.inventory.slot.logic.builder;

import com.ldtteam.jvoxelizer.core.logic.TypedPipelineElementContext;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;
import com.ldtteam.jvoxelizer.inventory.slot.ISlotItemHandler;
import com.ldtteam.jvoxelizer.inventory.slot.logic.builder.contexts.GetItemHandlerContext;
import com.ldtteam.jvoxelizer.item.handling.IItemHandler;

import java.util.function.Function;

public interface ISlotItemHandlerBuilder<C extends ISlotItemHandlerBuilder<C, I, O>, I, O extends ISlotItemHandler<I>> extends ISlotBuilder<C, I, O>
{
    static <T extends ISlotItemHandlerBuilder<T, S, R>, S, R extends ISlotItemHandler<S>> T create()
    {
        return ISlotItemHandlerProviderHolder.getInstance().provide();
    }

    C GetItemHandler(Function<TypedPipelineElementContext<GetItemHandlerContext, IItemHandler, O, I>, IItemHandler>... components);
}
