package com.ldtteam.jvoxelizer.inventory.logic.builder;

import com.ldtteam.jvoxelizer.core.logic.TypedPipelineElementContext;
import com.ldtteam.jvoxelizer.core.logic.VoidPipelineElementContext;
import com.ldtteam.jvoxelizer.inventory.IContainer;
import com.ldtteam.jvoxelizer.inventory.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;
import com.ldtteam.jvoxelizer.item.IItemStack;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public interface IContainerBuilder<C extends IContainerBuilder<C, I, O>, I, O extends IContainer<I>>
{

    static <S extends IContainerBuilder<S, T, R>, T, R extends IContainer<T>> IContainerBuilder<S, T ,R> create()
    {
        return IContainerBuilderProviderHolder.getInstance().provide();
    }

    C SlotChangedCraftingGrid(Consumer<VoidPipelineElementContext<SlotChangedCraftingGridContext, O, I>>... components);

    C ClearContainer(Consumer<VoidPipelineElementContext<ClearContainerContext, O, I>>... components);

    C PutStackInSlot(Consumer<VoidPipelineElementContext<PutStackInSlotContext, O, I>>... components);

    C SetCanCraft(Consumer<VoidPipelineElementContext<SetCanCraftContext, O, I>>... components);

    C SlotClick(Function<TypedPipelineElementContext<SlotClickContext, IItemStack, O, I>, IItemStack>... components);

    C OnContainerClosed(Consumer<VoidPipelineElementContext<OnContainerClosedContext, O, I>>... components);

    C GetInventory(Function<TypedPipelineElementContext<GetInventoryContext, List<IItemStack>, O, I>, List<IItemStack>>... components);

    C SetAll(Consumer<VoidPipelineElementContext<SetAllContext, O, I>>... components);

    C AddListener(Consumer<VoidPipelineElementContext<AddListenerContext, O, I>>... components);

    C UpdateProgressBar(Consumer<VoidPipelineElementContext<UpdateProgressBarContext, O, I>>... components);

    C DetectAndSendChanges(Consumer<VoidPipelineElementContext<DetectAndSendChangesContext, O, I>>... components);

    C GetCanCraft(Function<TypedPipelineElementContext<GetCanCraftContext, Boolean, O, I>, Boolean>... components);

    C TransferStackInSlot(Function<TypedPipelineElementContext<TransferStackInSlotContext, IItemStack, O, I>, IItemStack>... components);

    C OnCraftMatrixChanged(Consumer<VoidPipelineElementContext<OnCraftMatrixChangedContext, O, I>>... components);

    C RemoveListener(Consumer<VoidPipelineElementContext<RemoveListenerContext, O, I>>... components);

    C CanInteractWith(Function<TypedPipelineElementContext<CanInteractWithContext, Boolean, O, I>, Boolean>... components);

    C CanDragIntoSlot(Function<TypedPipelineElementContext<CanDragIntoSlotContext, Boolean, O, I>, Boolean>... components);

    C GetSlot(Function<TypedPipelineElementContext<GetSlotContext, ISlot, O, I>, ISlot>... components);

    C GetSlotFromInventory(Function<TypedPipelineElementContext<GetSlotFromInventoryContext, ISlot, O, I>, ISlot>... components);

    C AddSlotToContainer(Function<TypedPipelineElementContext<AddSlotToContainerContext, ISlot, O, I>, ISlot>... components);

    C CanMergeSlot(Function<TypedPipelineElementContext<CanMergeSlotContext, Boolean, O, I>, Boolean>... components);

    C ResetDrag(Consumer<VoidPipelineElementContext<ResetDragContext, O, I>>... components);

    C EnchantItem(Function<TypedPipelineElementContext<EnchantItemContext, Boolean, O, I>, Boolean>... components);

    C GetNextTransactionID(Function<TypedPipelineElementContext<GetNextTransactionIDContext, Short, O, I>, Short>... components);

    C MergeItemStack(Function<TypedPipelineElementContext<MergeItemStackContext, Boolean, O, I>, Boolean>... components);

    IContainer<I> build(I guiContext);
}
