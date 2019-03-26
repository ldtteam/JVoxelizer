package com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory.logic.pipeline;

import com.ldtteam.jvoxelizer.core.logic.TypedPipelineElementContext;
import com.ldtteam.jvoxelizer.core.logic.VoidPipelineElementContext;
import com.ldtteam.jvoxelizer.inventory.IContainer;
import com.ldtteam.jvoxelizer.inventory.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;
import com.ldtteam.jvoxelizer.item.IItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ForgeContainerPipeline<O extends IContainer<I>, I>
{
        private final List<Consumer<VoidPipelineElementContext<SlotChangedCraftingGridContext, O, I>>> SlotChangedCraftingGridPipeline;

        private final List<Consumer<VoidPipelineElementContext<ClearContainerContext, O, I>>> ClearContainerPipeline;

        private final List<Consumer<VoidPipelineElementContext<PutStackInSlotContext, O, I>>> PutStackInSlotPipeline;

        private final List<Consumer<VoidPipelineElementContext<SetCanCraftContext, O, I>>> SetCanCraftPipeline;

        private final List<Function<TypedPipelineElementContext<SlotClickContext, IItemStack, O, I>, IItemStack>> SlotClickPipeline;

        private final List<Consumer<VoidPipelineElementContext<OnContainerClosedContext, O, I>>> OnContainerClosedPipeline;

        private final List<Function<TypedPipelineElementContext<GetInventoryContext, List<IItemStack>, O, I>, List<IItemStack>>> GetInventoryPipeline;

        private final List<Consumer<VoidPipelineElementContext<SetAllContext, O, I>>> SetAllPipeline;

        private final List<Consumer<VoidPipelineElementContext<AddListenerContext, O, I>>> AddListenerPipeline;

        private final List<Consumer<VoidPipelineElementContext<UpdateProgressBarContext, O, I>>> UpdateProgressBarPipeline;

        private final List<Consumer<VoidPipelineElementContext<DetectAndSendChangesContext, O, I>>> DetectAndSendChangesPipeline;

        private final List<Function<TypedPipelineElementContext<GetCanCraftContext, Boolean, O, I>, Boolean>> GetCanCraftPipeline;

        private final List<Function<TypedPipelineElementContext<TransferStackInSlotContext, IItemStack, O, I>, IItemStack>> TransferStackInSlotPipeline;

        private final List<Consumer<VoidPipelineElementContext<OnCraftMatrixChangedContext, O, I>>> OnCraftMatrixChangedPipeline;

        private final List<Consumer<VoidPipelineElementContext<RemoveListenerContext, O, I>>> RemoveListenerPipeline;

        private final List<Function<TypedPipelineElementContext<CanInteractWithContext, Boolean, O, I>, Boolean>> CanInteractWithPipeline;

        private final List<Function<TypedPipelineElementContext<CanDragIntoSlotContext, Boolean, O, I>, Boolean>> CanDragIntoSlotPipeline;

        private final List<Function<TypedPipelineElementContext<GetSlotContext, ISlot, O, I>, ISlot>> GetSlotPipeline;

        private final List<Function<TypedPipelineElementContext<GetSlotFromInventoryContext, ISlot, O, I>, ISlot>> GetSlotFromInventoryPipeline;

        private final List<Function<TypedPipelineElementContext<AddSlotToContainerContext, ISlot, O, I>, ISlot>> AddSlotToContainerPipeline;

        private final List<Function<TypedPipelineElementContext<CanMergeSlotContext, Boolean, O, I>, Boolean>> CanMergeSlotPipeline;

        private final List<Consumer<VoidPipelineElementContext<ResetDragContext, O, I>>> ResetDragPipeline;

        private final List<Function<TypedPipelineElementContext<EnchantItemContext, Boolean, O, I>, Boolean>> EnchantItemPipeline;

        private final List<Function<TypedPipelineElementContext<GetNextTransactionIDContext, Short, O, I>, Short>> GetNextTransactionIDPipeline;

        private final List<Function<TypedPipelineElementContext<MergeItemStackContext, Boolean, O, I>, Boolean>> MergeItemStackPipeline;

    public ForgeContainerPipeline(
      final List<Consumer<VoidPipelineElementContext<SlotChangedCraftingGridContext, O, I>>> slotChangedCraftingGridPipeline,
      final List<Consumer<VoidPipelineElementContext<ClearContainerContext, O, I>>> clearContainerPipeline,
      final List<Consumer<VoidPipelineElementContext<PutStackInSlotContext, O, I>>> putStackInSlotPipeline,
      final List<Consumer<VoidPipelineElementContext<SetCanCraftContext, O, I>>> setCanCraftPipeline,
      final List<Function<TypedPipelineElementContext<SlotClickContext, IItemStack, O, I>, IItemStack>> slotClickPipeline,
      final List<Consumer<VoidPipelineElementContext<OnContainerClosedContext, O, I>>> onContainerClosedPipeline,
      final List<Function<TypedPipelineElementContext<GetInventoryContext, List<IItemStack>, O, I>, List<IItemStack>>> getInventoryPipeline,
      final List<Consumer<VoidPipelineElementContext<SetAllContext, O, I>>> setAllPipeline,
      final List<Consumer<VoidPipelineElementContext<AddListenerContext, O, I>>> addListenerPipeline,
      final List<Consumer<VoidPipelineElementContext<UpdateProgressBarContext, O, I>>> updateProgressBarPipeline,
      final List<Consumer<VoidPipelineElementContext<DetectAndSendChangesContext, O, I>>> detectAndSendChangesPipeline,
      final List<Function<TypedPipelineElementContext<GetCanCraftContext, Boolean, O, I>, Boolean>> getCanCraftPipeline,
      final List<Function<TypedPipelineElementContext<TransferStackInSlotContext, IItemStack, O, I>, IItemStack>> transferStackInSlotPipeline,
      final List<Consumer<VoidPipelineElementContext<OnCraftMatrixChangedContext, O, I>>> onCraftMatrixChangedPipeline,
      final List<Consumer<VoidPipelineElementContext<RemoveListenerContext, O, I>>> removeListenerPipeline,
      final List<Function<TypedPipelineElementContext<CanInteractWithContext, Boolean, O, I>, Boolean>> canInteractWithPipeline,
      final List<Function<TypedPipelineElementContext<CanDragIntoSlotContext, Boolean, O, I>, Boolean>> canDragIntoSlotPipeline,
      final List<Function<TypedPipelineElementContext<GetSlotContext, ISlot, O, I>, ISlot>> getSlotPipeline,
      final List<Function<TypedPipelineElementContext<GetSlotFromInventoryContext, ISlot, O, I>, ISlot>> getSlotFromInventoryPipeline,
      final List<Function<TypedPipelineElementContext<AddSlotToContainerContext, ISlot, O, I>, ISlot>> addSlotToContainerPipeline,
      final List<Function<TypedPipelineElementContext<CanMergeSlotContext, Boolean, O, I>, Boolean>> canMergeSlotPipeline,
      final List<Consumer<VoidPipelineElementContext<ResetDragContext, O, I>>> resetDragPipeline,
      final List<Function<TypedPipelineElementContext<EnchantItemContext, Boolean, O, I>, Boolean>> enchantItemPipeline,
      final List<Function<TypedPipelineElementContext<GetNextTransactionIDContext, Short, O, I>, Short>> getNextTransactionIDPipeline,
      final List<Function<TypedPipelineElementContext<MergeItemStackContext, Boolean, O, I>, Boolean>> mergeItemStackPipeline)
    {
        SlotChangedCraftingGridPipeline = slotChangedCraftingGridPipeline;
        ClearContainerPipeline = clearContainerPipeline;
        PutStackInSlotPipeline = putStackInSlotPipeline;
        SetCanCraftPipeline = setCanCraftPipeline;
        SlotClickPipeline = slotClickPipeline;
        OnContainerClosedPipeline = onContainerClosedPipeline;
        GetInventoryPipeline = getInventoryPipeline;
        SetAllPipeline = setAllPipeline;
        AddListenerPipeline = addListenerPipeline;
        UpdateProgressBarPipeline = updateProgressBarPipeline;
        DetectAndSendChangesPipeline = detectAndSendChangesPipeline;
        GetCanCraftPipeline = getCanCraftPipeline;
        TransferStackInSlotPipeline = transferStackInSlotPipeline;
        OnCraftMatrixChangedPipeline = onCraftMatrixChangedPipeline;
        RemoveListenerPipeline = removeListenerPipeline;
        CanInteractWithPipeline = canInteractWithPipeline;
        CanDragIntoSlotPipeline = canDragIntoSlotPipeline;
        GetSlotPipeline = getSlotPipeline;
        GetSlotFromInventoryPipeline = getSlotFromInventoryPipeline;
        AddSlotToContainerPipeline = addSlotToContainerPipeline;
        CanMergeSlotPipeline = canMergeSlotPipeline;
        ResetDragPipeline = resetDragPipeline;
        EnchantItemPipeline = enchantItemPipeline;
        GetNextTransactionIDPipeline = getNextTransactionIDPipeline;
        MergeItemStackPipeline = mergeItemStackPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<SlotChangedCraftingGridContext, O, I>>> getSlotChangedCraftingGridPipeline()
    {
        return SlotChangedCraftingGridPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<ClearContainerContext, O, I>>> getClearContainerPipeline()
    {
        return ClearContainerPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<PutStackInSlotContext, O, I>>> getPutStackInSlotPipeline()
    {
        return PutStackInSlotPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<SetCanCraftContext, O, I>>> getSetCanCraftPipeline()
    {
        return SetCanCraftPipeline;
    }

    public List<Function<TypedPipelineElementContext<SlotClickContext, IItemStack, O, I>, IItemStack>> getSlotClickPipeline()
    {
        return SlotClickPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<OnContainerClosedContext, O, I>>> getOnContainerClosedPipeline()
    {
        return OnContainerClosedPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetInventoryContext, List<IItemStack>, O, I>, List<IItemStack>>> getGetInventoryPipeline()
    {
        return GetInventoryPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<SetAllContext, O, I>>> getSetAllPipeline()
    {
        return SetAllPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<AddListenerContext, O, I>>> getAddListenerPipeline()
    {
        return AddListenerPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<UpdateProgressBarContext, O, I>>> getUpdateProgressBarPipeline()
    {
        return UpdateProgressBarPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<DetectAndSendChangesContext, O, I>>> getDetectAndSendChangesPipeline()
    {
        return DetectAndSendChangesPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetCanCraftContext, Boolean, O, I>, Boolean>> getGetCanCraftPipeline()
    {
        return GetCanCraftPipeline;
    }

    public List<Function<TypedPipelineElementContext<TransferStackInSlotContext, IItemStack, O, I>, IItemStack>> getTransferStackInSlotPipeline()
    {
        return TransferStackInSlotPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<OnCraftMatrixChangedContext, O, I>>> getOnCraftMatrixChangedPipeline()
    {
        return OnCraftMatrixChangedPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<RemoveListenerContext, O, I>>> getRemoveListenerPipeline()
    {
        return RemoveListenerPipeline;
    }

    public List<Function<TypedPipelineElementContext<CanInteractWithContext, Boolean, O, I>, Boolean>> getCanInteractWithPipeline()
    {
        return CanInteractWithPipeline;
    }

    public List<Function<TypedPipelineElementContext<CanDragIntoSlotContext, Boolean, O, I>, Boolean>> getCanDragIntoSlotPipeline()
    {
        return CanDragIntoSlotPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetSlotContext, ISlot, O, I>, ISlot>> getGetSlotPipeline()
    {
        return GetSlotPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetSlotFromInventoryContext, ISlot, O, I>, ISlot>> getGetSlotFromInventoryPipeline()
    {
        return GetSlotFromInventoryPipeline;
    }

    public List<Function<TypedPipelineElementContext<AddSlotToContainerContext, ISlot, O, I>, ISlot>> getAddSlotToContainerPipeline()
    {
        return AddSlotToContainerPipeline;
    }

    public List<Function<TypedPipelineElementContext<CanMergeSlotContext, Boolean, O, I>, Boolean>> getCanMergeSlotPipeline()
    {
        return CanMergeSlotPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<ResetDragContext, O, I>>> getResetDragPipeline()
    {
        return ResetDragPipeline;
    }

    public List<Function<TypedPipelineElementContext<EnchantItemContext, Boolean, O, I>, Boolean>> getEnchantItemPipeline()
    {
        return EnchantItemPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetNextTransactionIDContext, Short, O, I>, Short>> getGetNextTransactionIDPipeline()
    {
        return GetNextTransactionIDPipeline;
    }

    public List<Function<TypedPipelineElementContext<MergeItemStackContext, Boolean, O, I>, Boolean>> getMergeItemStackPipeline()
    {
        return MergeItemStackPipeline;
    }
}
